package com.pegien.HighSchoolExamination.Reports.MeritList.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.pegien.HighSchoolExamination.Examination.Examination;
import com.pegien.HighSchoolExamination.Examination.ExaminationRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.Marks;
import com.pegien.HighSchoolExamination.Examination.Marks.MarksRepository;
import com.pegien.HighSchoolExamination.Examination.Marks.service.MarksService;
import com.pegien.HighSchoolExamination.Examination.service.ExaminationService;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLine;
import com.pegien.HighSchoolExamination.Reports.MeritList.MeritListItem.MeritListLineRepository;
import com.pegien.HighSchoolExamination.Reports.ReportCards.service.ReportCardService;
import com.pegien.HighSchoolExamination.Students.Student;
import com.pegien.HighSchoolExamination.Students.StudentRepository;
import com.pegien.HighSchoolExamination.Students.service.StudentsService;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.SubjectGrading;
import com.pegien.HighSchoolExamination.StudySubjects.SubjectGrade.service.SubjectGradingService;
import com.pegien.HighSchoolExamination.Utils.GradingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.List;

@Service
public class MeritListService {

    @Autowired
    private MarksService marksService;

    @Autowired
    private MeritListLineRepository meritListLineRepository;

    @Autowired
    private SubjectGradingService subjectGradingService;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudySubjectsRepository studySubjectsRepository;





    @Autowired
    private ExaminationService examinationService;





    @Autowired
    private MarksRepository marksRepository;



    public List<MeritListLine> generateMeritList(Long examination,Double stage)
    {
        meritListLineRepository.deleteByStageAndExaminationOrderByClassRankAsc(stage,examination);
        List<SubjectGrading> subjectGradings=subjectGradingService.viewGradings();
        List<Integer> pointsList=new ArrayList<>();
        List<MeritListLine> meritListLines=new ArrayList<>();
        List<Integer> comPulsorysubjects= Arrays.asList(101, 102, 121);

        for(Student student:studentRepository.findByStage(stage))
        {
            MeritListLine meritListLine=getMeritLine(student,examination,stage);
            //feed grades and subjects marks
            HashMap<Integer,Double> subjectMarks=new HashMap<>();
            HashMap<Integer,String> subjectGrades=new HashMap<>();
            int points=0;
            int pos=0;
            List<Integer> choices=new ArrayList<>();
            for(SubjectGrading subjectGrading:subjectGradings)
            {
                pos++;
                Marks marks=marksService.getMark(student.getNum(),examination,subjectGrading.getSubjectCode());
                Double mark=marks.getMarks();
                int grad= GradingUtils.getGrade(subjectGrading.getAMarks(),subjectGrading.getEMarks(),mark);
                subjectMarks.put(subjectGrading.getSubjectCode(),mark);
                subjectGrades.put(subjectGrading.getSubjectCode(),GradingUtils.gradeChar(grad));
                if(comPulsorysubjects.contains(subjectGrading.getSubjectCode()))
                    points+=grad;
                else
                    choices.add(grad);
            }
            //add max 4 among subject choices
            choices.sort(Collections.reverseOrder());
            for(int i=0;i<4;i++)
                points+=choices.get(i);

            meritListLine.setPoints(points);
            meritListLine.setAggregateGrade(GradingUtils.gradeChar(GradingUtils.agregateGrading(points)));
            meritListLine.setSubjectGrades(subjectGrades);
            meritListLine.setSubjectMarks(subjectMarks);
            pointsList.add(points);
            meritListLine.setExamination(examination);
            meritListLine.setStage(stage);
            meritListLines.add(meritListLine);
        }
        setRanks(pointsList,meritListLines);
        meritListLineRepository.saveAllAndFlush(meritListLines);
        return viewMeritList(examination,stage);
    }

    private void setRanks(List<Integer> pointsList, List<MeritListLine> meritListLines) {
//        pointsList.sort();
//        Collections.sort(pointsList, Collections.reverseOrder());
//        Collections.sort(meritListLines, Comparator.comparing(MeritListLine::getPoints));
        meritListLines.sort(Comparator.comparing(MeritListLine::getPoints, Collections.reverseOrder()));

        HashMap<String,Integer> lastStreamPosition=new HashMap<>();
        HashMap<String,Integer> lastStreamPoints=new HashMap<>();
        HashMap<String,Integer> streamCounts=new HashMap<>();

        //set last positions
//        lastStreamPosition.put("A",0);
//        lastStreamPosition.put("B",0);
//        lastStreamPosition.put("C",0);
//        //set last stream points
//        lastStreamPoints.put("A",0);
//        lastStreamPoints.put("B",0);
//        lastStreamPoints.put("C",0);

        //set positions
        int lastPosition=0;
        int lastPoints=0;
        int count=0;

        for(MeritListLine meritListLine:meritListLines)
        {
            if(meritListLine.getPoints()<1)
            {
                meritListLine.setStreamRank(99999);
                meritListLine.setClassRank(99999);
                return;
            }
            count++;
            //set class position
            if(meritListLine.getPoints()!=lastPoints)
            {
                lastPoints=meritListLine.getPoints();
                lastPosition=count;
            }
            meritListLine.setClassRank(lastPosition);
            //streamWise Rank
            String stream=meritListLine.getStream().toUpperCase().trim();
            if(!lastStreamPoints.containsKey(stream)) {
                lastStreamPoints.put(stream, 0);
                lastStreamPosition.put(stream, 0);
                streamCounts.put(stream,0);
            }


            {
                int streamCount=streamCounts.get(stream);
                streamCount++;
                int strlPoints = lastStreamPoints.get(stream);
                int strlPos=lastStreamPosition.get(stream);
                if(meritListLine.getPoints()!=strlPoints) {
                    strlPos=streamCount;
                    lastStreamPoints.put(stream,meritListLine.getPoints());
                    lastStreamPosition.put(stream,strlPos);
                    streamCounts.put(stream,streamCount);
                }
                meritListLine.setStreamRank(strlPos);
            }



        }


    }

    public MeritListLine getMeritLine(Student student, Long examination, Double stage) {

        MeritListLine meritListLine1;
        Optional<MeritListLine> meritListLine = meritListLineRepository.findByStudentIdAndExamination(student.getNum(),examination);
        if(meritListLine.isPresent())
           meritListLine1= meritListLine.get();
        else {
        meritListLine1=MeritListLine.builder()
                    .admNo(student.getAdmNo())
                    .stream(student.getStream())
                    .studentId(student.getNum())
                    .stage(stage)
                    .classRank(99999).streamRank(99999).points(0).kcpeMarks(0).build();
        }
        meritListLine1.setStage(student.getStage());
        meritListLine1.setStream(student.getStream());
        meritListLine1.setKcpeMarks(student.getKcpeMarks());
        meritListLine1.setAdmNo(student.getAdmNo());

        return meritListLine1;
    }


    public List<MeritListLine> viewMeritList(Long examination,Double stage)
    {

        List<MeritListLine> fullList=new ArrayList<>();
        for(MeritListLine l:meritListLineRepository.findByStageAndExaminationOrderByClassRankAsc(stage,examination))
        {
            Optional<Student> student=studentRepository.findById(l.getStudentId());
            if(student.isPresent())
            {
                Student cStudent=student.get();
                l.setStudentName(cStudent.getName());
                l.setKcpeMarks(cStudent.getKcpeMarks());
            }
            fullList.add(l);
        }

        return fullList;
    }

    public List<MeritListLine> viewMeritList(Long examination,Double stage,String stream)
    {
        List<MeritListLine> fullList=new ArrayList<>();
        for(MeritListLine l:meritListLineRepository.findByStageAndExaminationAndStreamOrderByClassRankAsc(stage,examination,stream))
        {
            Optional<Student> student=studentRepository.findById(l.getStudentId());
            if(student.isPresent())
            {
                Student cStudent=student.get();
                l.setStudentName(cStudent.getName());
                l.setKcpeMarks(cStudent.getKcpeMarks());
            }
            fullList.add(l);
        }

        return fullList;
    }


    public ResponseEntity<byte[]> printMeritList(Long examination, Double stage, String stream) {
        try {
            // Generate the PDF report
            byte[] pdfBytes = generateClassMeritList(examination,stage,stream);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            String fileName = examination + " Form" + stage + stream + " reports.pdf";
            headers.setContentDispositionFormData("attachment", fileName);


            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private byte[] generateClassMeritList(Long examination, Double stage, String stream) {

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();


            document.setMargins(20,10,10,20);
            addSchoolHeader(document);

            Optional<Examination> examination1=examinationRepository.findById(examination);
            if(examination1.isEmpty())
                return null;

            addExamTitle(document,examination1.get(),stage,stream);



            List<MeritListLine> meritListLines;
            if(stream==null||stream.length()==0||stream.trim().equalsIgnoreCase("All"))
                meritListLines=viewMeritList(examination,stage);
            else
                meritListLines=viewMeritList(examination,stage,stream);

            PdfPTable pdfPTable=new PdfPTable(20);
            pdfPTable.setWidthPercentage(100);

//            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD | Font.UNDERLINE);
//            for(MeritListLine meritListLine:meritListLines)
//            {
//                pdfPTable.addCell(meritListLine.getClassRank()+"",boldFont);
//                pdfPTable.addCell(meritListLine.getStream());
//                pdfPTable.addCell(meritListLine.getStreamRank()+"");
//                pdfPTable.addCell(meritListLine.getAdmNo()+"");
//                pdfPTable.addCell(meritListLine.getStudentName());
//
//                HashMap<Integer, String> subjectGrades=meritListLine.getSubjectGrades();
//                HashMap<Integer,Double> subjectMarks=meritListLine.getSubjectMarks();
//                for(SubjectGrading s:subjectGradingService.viewGradings())
//                {
//                    pdfPTable.addCell(subjectMarks.get(s.getSubjectCode())+" "+subjectGrades.get(s.getSubjectCode()));
//                }
//                pdfPTable.addCell(meritListLine.getPoints()+"");
//                pdfPTable.addCell(meritListLine.getAggregateGrade());
//                pdfPTable.addCell(meritListLine.getKcpeMarks()+"");
//
//            }
            // Create a PdfPTable
//            PdfPTable pdfPTable = new PdfPTable(12); // Adjust the number of columns as needed

            // Create a smaller and autosizable font
            Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 6);

            // Set properties for word wrap
//            smallFont.setHyphenation(new HyphenationAuto("en", "US", 2, 2));
            smallFont.setColor(BaseColor.BLACK);

            String[] columnTitles = {
                    "Overall Pos",
                    "Stream",
                    "Stream Pos",
                    "Adm No",
                    "Student Name",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "Aggr Points",
                    "Aggr Grade",
                    "Entry Marks"
            };


            List<SubjectGrading> gradings=subjectGradingService.viewGradings();

            for(int i=0;i<gradings.size();i++)
                columnTitles[i+5]=studySubjectsRepository.findBySubjectCode(gradings.get(i).getSubjectCode()).getSubjectRep()+" ("+gradings.get(i).getSubjectCode()+")";


            for(String i:columnTitles)
                pdfPTable.addCell(CreateHeaderCell(i));


            // Iterate through data and add cells to the table
            for (MeritListLine meritListLine : meritListLines) {
                pdfPTable.addCell(createCell(meritListLine.getClassRank(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getStream(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getStreamRank(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getAdmNo(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getStudentName(), smallFont));

                HashMap<Integer, String> subjectGrades = meritListLine.getSubjectGrades();
                HashMap<Integer, Double> subjectMarks = meritListLine.getSubjectMarks();
                for (SubjectGrading s : gradings) {
                    if(subjectMarks.get(s.getSubjectCode())==null)
                    {
                        pdfPTable.addCell(createCell(" ", smallFont));
                    }
                    else {
                        String cellContent = String.format("%s %s", subjectMarks.get(s.getSubjectCode()), subjectGrades.get(s.getSubjectCode()));
                        pdfPTable.addCell(createCell(cellContent, smallFont));
                    }
                }
                pdfPTable.addCell(createCell(meritListLine.getPoints(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getAggregateGrade(), smallFont));
                pdfPTable.addCell(createCell(meritListLine.getKcpeMarks(), smallFont));
            }


            autoSizeTable(pdfPTable);


            pdfPTable.setHeaderRows(1);
            pdfPTable.setSpacingBefore(20);
            document.add(pdfPTable);

            document.close();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void addExamTitle(Document document, Examination examination,Double stage,String stream) throws Exception{
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD | Font.UNDERLINE);
        Paragraph hh2=new Paragraph(examination.getTitle()+" Form "+((int)(stage/1))+(stream!=null&&!stream.equalsIgnoreCase("All")?stream:"")+"  Term ("+examination.getTerm()+") Year : "+examination.getYear(),boldFont);
        hh2.setAlignment(Element.ALIGN_CENTER);
//        hh2.setFont(new Font(Font.FontFamily.COURIER,30, Font.UNDERLINE | Font.BOLD,BaseColor.BLACK));

        document.add(hh2);
    }

    private PdfPCell CreateHeaderCell(String i) {
        PdfPCell headerCell = new PdfPCell();
        headerCell.addElement(new com.itextpdf.text.Paragraph(i,new Font(Font.FontFamily.TIMES_ROMAN, 5)));
        headerCell.setGrayFill(0.7f); // Set background color
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
        headerCell.setNoWrap(false);
        headerCell.setFixedHeight(20);
       if(!i.contains("ame"))
           headerCell.setRotation(90);
        return headerCell;
    }

    public static void autoSizeTable(PdfPTable table) throws DocumentException {
        int numColumns = table.getNumberOfColumns();
        float[] columnWidths = new float[numColumns];

        // Initialize column widths
        for (int i = 0; i < numColumns; i++) {
            columnWidths[i] = 0f;
        }

        // Iterate through each row and cell to find the maximum content width in each column
        for (int row = 0; row < table.getRows().size()&&row<20; row++) {
            PdfPRow pdfPRow = table.getRow(row);
            for (int col = 0; col < numColumns; col++) {
                PdfPCell cell = pdfPRow.getCells()[col];
                if (cell != null) {
                    float contentWidth = getContentWidth(cell);
                    columnWidths[col] = Math.max(columnWidths[col], contentWidth)+1;
                }
            }
        }

        // Set calculated column widths to the table
        table.setWidths(columnWidths);
    }

    private static float getContentWidth(PdfPCell cell) {
        // You may need to adjust this method based on the content type and how you calculate width
        // For simplicity, this example assumes that the content is a string
        try {
            String content = cell.getPhrase().getContent();
            float fontSize = cell.getPhrase().getFont().getSize();
            return content.length() * fontSize; // Adjust as needed
        }catch (Exception es)
        {

        }
        return 1f;
    }
    private static PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setNoWrap(true); // Disable word wrap
        return cell;
    }

    private static PdfPCell createCell(int content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content+"", font));
        cell.setNoWrap(true); // Disable word wrap
        return cell;
    }

    public static void addSchoolHeader(Document document) throws Exception {

        int ident=100;
        int identLeft=ident;

        Boolean isPortrait=true;

        if(document.getPageSize().getWidth()>document.getPageSize().getHeight()) {
            identLeft += 100;
            isPortrait=false;
        }




        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph hh=new Paragraph(ReportCardService.schoolName,boldFont);
        hh.setAlignment(Element.ALIGN_LEFT);
//        hh.setFont(new Font(Font.FontFamily.COURIER,48, Font.FontStyle.BOLD.ordinal(),BaseColor.BLACK));
        hh.setIndentationLeft(identLeft);

        document.add(hh);
//        document.setMargins(0,0,0,0);

        boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph box=new Paragraph(ReportCardService.addr,boldFont);
        box.setAlignment(Element.ALIGN_LEFT);
        box.setIndentationLeft(identLeft);
        document.add(box);

        boldFont = new Font(Font.FontFamily.COURIER, 13, Font.BOLD);
        Paragraph email=new Paragraph("E-MAIL: "+ ReportCardService.schoolEmail+"    TEL: "+ ReportCardService.schoolPhone,boldFont);
        email.setAlignment(Element.ALIGN_LEFT);
        email.setIndentationLeft(identLeft);
        document.add(email);

        boldFont = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
        Paragraph phone=new Paragraph("SCHOOL MOTTO : "+ReportCardService.schoolMotto,boldFont);
        phone.setAlignment(Element.ALIGN_LEFT);
        phone.setIndentationLeft(identLeft);
        document.add(phone);

        try{
            int width=ident;


            if(logo==null){
                logo=Image.getInstance(ReportCardService.class.getResourceAsStream("/images/logo.png").readAllBytes());

                float height=logo.getHeight()*width/logo.getWidth();
                logo.scaleAbsolute(width,height );
                logo.setAbsolutePosition(isPortrait?20:100, document.getPageSize().getHeight()-height*4/3);
            }

            document.add(logo);



        }catch (Exception es)
        {
            es.printStackTrace();
        }





    }


    public static Image logo=null;


    public ResponseEntity<byte[]> viewAnalysis(Long examination, Double stage) {

        try {
            // Generate the PDF report
            byte[] pdfBytes = generateAnalysis(examination,stage);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            String fileName = examination + " Form" + stage + stage + " Analysis.pdf";
            headers.setContentDispositionFormData("attachment", fileName);


            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    private byte[] generateAnalysis(Long examination, Double stage) throws Exception {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();



        //counting stats
        HashMap<String,HashMap<Integer,HashMap<String,Integer>>> stats=new HashMap<>();
        String[] classes={"All","A","B","C"};

        //aggr Hashmap
        HashMap<String,HashMap<String,Integer>> aggrStats=new HashMap<>();



        //counting values
        HashMap<String,HashMap<Integer,List<Integer>>> valueStats=new HashMap<>();

        //aggr Hashmap
        HashMap<String,List<Integer>> valueAggrStats=new HashMap<>();

        //feed skeleton
        for(String cc:classes)
        {
            HashMap<Integer,HashMap<String,Integer>> tmp=new HashMap<>();
            HashMap<Integer,List<Integer>> tmpV=new HashMap<>();
            for(StudySubject s:studySubjectsRepository.allAvailable())
            {
                HashMap<String,Integer> ss=new HashMap<>();
                for(String gr:GradingUtils.grades)
                    ss.put(gr,0);
                tmp.put(s.getSubjectCode(),ss);
                tmpV.put(s.getSubjectCode(),new ArrayList<>());
            }
            stats.put(cc,tmp);
            valueStats.put(cc,tmpV);
            HashMap<String,Integer> aggrTmp=new HashMap<>();
            for(String gr:GradingUtils.grades)
                aggrTmp.put(gr,0);
            aggrStats.put(cc,aggrTmp);
            valueAggrStats.put(cc,new ArrayList<>());
        }

        for(MeritListLine meritListLine:viewMeritList(examination,stage))
        {
            //for grades
            for(int grd:meritListLine.getSubjectGrades().keySet()) {
                String val=meritListLine.getSubjectGrades().get(grd);
                //increment count of all
                int initCount=stats.get("All").get(grd).get(val);
                stats.get("All").get(grd).put(val,initCount+1);

                //for values
                int grad= GradingUtils.grades.length-Arrays.asList(GradingUtils.grades).indexOf(val)-1;
                if(grad>0) {
                    valueStats.get("All").get(grd).add(grad);
                    valueStats.get(meritListLine.getStream()).get(grd).add(grad);
                }


                //increment count of Stream
                int initSCount=stats.get(meritListLine.getStream()).get(grd).get(val);
                stats.get(meritListLine.getStream()).get(grd).put(val,initSCount+1);
            }


            //increment the Aggregate points
            {
                String idn=meritListLine.getAggregateGrade();

                int aggrCount=aggrStats.get("All").get(idn);
                int aggrSCount=aggrStats.get(meritListLine.getStream()).get(idn);

                aggrStats.get("All").put(idn,aggrCount+1);
                aggrStats.get(meritListLine.getStream()).put(idn,aggrSCount+1);

                //for values
                int grad=GradingUtils.agregateGrading(meritListLine.getPoints());
                if(grad>0)
                {
                    valueAggrStats.get("All").add(grad);
                    valueAggrStats.get(meritListLine.getStream()).add(grad);
                }
            }

//            //increment count of all
//            int initCount=0;
//            int initSCount=0;
//                    try {
//                        initCount = stats.get("All").get(999).get(val);
//                    }catch (Exception es)
//            stats.get("All").get(grd).put(val,initCount+1);
//
//            //increment count of Stream
//
//            initSCount = stats.get(meritListLine.getStream()).get(grd).get(val);
//            stats.get(meritListLine.getStream()).get(grd).put(val,initSCount+1);


        }

        Optional<Examination> examinationOptional=examinationRepository.findById(examination);
        document.addTitle(examinationOptional.get().getTitle()+" Form "+stage+" Analysis");
        //draw Tables
        for(String stre:stats.keySet())
        {
            addSchoolHeader(document);

//            document.addTitle(stage+stre);
//            document.add(new Paragraph(stage+stre));
            if(examinationOptional.isPresent())
                addExamTitle(document,examinationOptional.get(),stage,stre);
            PdfPTable table=new PdfPTable(GradingUtils.grades.length+1);

            //add grades
            table.addCell("");
            for(String k:GradingUtils.grades)
                table.addCell(k);

            //for each subject
            for(StudySubject studySubject:studySubjectsRepository.allAvailable())
            {
                table.addCell(studySubject.getSubjectName());
                for(String k:GradingUtils.grades)
                    table.addCell(stats.get(stre).get(studySubject.getSubjectCode()).get(k)+"");
            }
            PdfPCell blank=new PdfPCell();
            blank.setPhrase(new Phrase("  == "));
            blank.setColspan(GradingUtils.grades.length+1);
            table.addCell(blank);

            table.addCell(" Aggr ");
            for(String k:GradingUtils.grades)
                table.addCell(aggrStats.get(stre).get(k)+"");



            table.setWidthPercentage(100);
            autoSizeTable2(table);
            table.setSpacingBefore(30);
            document.add(table);


            document.newPage();
        }

        //add page for value stats
        {
            document.newPage();
            addSchoolHeader(document);
            addExamTitle(document,examinationOptional.get(),stage," Analysis ");
            List<StudySubject> subjects=studySubjectsRepository.allAvailable();
            PdfPTable statTable=new PdfPTable(subjects.size()+2);

            statTable.addCell("");
            for(StudySubject s:subjects)
                statTable.addCell(s.getSubjectRep());
            statTable.addCell("Aggr");

            String[] strss={"A","B","C","All"};
            for(String stre:strss)
            {
                statTable.addCell(stre);
                for(StudySubject s:subjects)
                    statTable.addCell(String.format("%.3f",valueStats.get(stre).get(s.getSubjectCode()).stream().mapToDouble(Integer::doubleValue).average().orElse(0)));
                statTable.addCell(String.format("%.3f",valueAggrStats.get(stre).stream().mapToDouble(Integer::doubleValue).average().orElse(0)));
            }
            statTable.setWidthPercentage(100);
//            autoSizeTable2(statTable);
            statTable.setSpacingBefore(30);

            document.add(statTable);

        }



        document.close();

        return byteArrayOutputStream.toByteArray();

    }

    private void autoSizeTable2(PdfPTable table) throws DocumentException {

        int numColumns = table.getNumberOfColumns();
        float[] columnWidths = new float[numColumns];

        // Initialize column widths
        for (int i = 0; i < numColumns; i++) {
            columnWidths[i] = 0f;
        }

        // Iterate through each row and cell to find the maximum content width in each column
        for (int row = 0; row < table.getRows().size()&&row<3; row++) {
            PdfPRow pdfPRow = table.getRow(row);
            for (int col = 0; col < numColumns; col++) {
                PdfPCell cell = pdfPRow.getCells()[col];
                if (cell != null) {
                    float contentWidth = getContentWidth(cell);
                    columnWidths[col] = contentWidth;//Math.max(columnWidths[col], contentWidth);
                }
            }
        }

//        System.out.println(Arrays.toString(columnWidths));
        // Set calculated column widths to the table
        table.setWidths(columnWidths);
    }
}
