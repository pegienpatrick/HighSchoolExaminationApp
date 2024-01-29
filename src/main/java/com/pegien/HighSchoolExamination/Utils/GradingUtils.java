package com.pegien.HighSchoolExamination.Utils;

import com.itextpdf.text.pdf.PdfPCell;

public class GradingUtils {


    public static int getGrade(int a,int e,Double marks)
    {
        if(marks==null)
            return 0;
        if (marks>100||marks<=0) {
            return 0;
        }else if(marks>=a)
            return 12;
        else if(marks<=e)
            return 1;


        Double range=a*1.0-e*1.0;
        Double change=(marks-e);
//        System.out.println("change is "+change+" percentage "+(change*10/range));
        int value= (int) (change*10/range+2);
        int val=value;
        return val;
    }


    public static String[] grades={
            "A","A-",
            "B+","B","B-",
            "C+","C","C-",
            "D+","D","D-",
            "E",
            "Z"
    };

    public static String gradeChar(int grade) {
        if(grade<0||grade>=grades.length)
            return "Z";
        return grades[grades.length-grade-1];
    }


    public static int agregateGrading(int points)
    {
        if(points>84||points<7)
            return 0;
        double tmp=points;
        return (int)Math.round(points/7.0);
    }

    public static String[] performanceComments = {
            "Extremely Poor",//0-9
            "Poor",//10-20
            "A bit Poor",//20-30
            "Improve",//30-40
            "Below Average",//40-50
            "Average",//50-60
            "Good",//60-70
            "Very Good",//70-80
            "Excellent",//80-90
            "Outstanding",//90-100
            "Exceptional",
            "Perfect"
    };

    public static String getComment(Double marks) {
        if(marks==null||marks==0||marks>100)
            return " ";
        else{
            int word= (int) (marks/10);
            return performanceComments[word];
        }
    }
}
