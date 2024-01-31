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
            ReportCardService.addSchoolHeader(document);

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


}
