package com.pegien.HighSchoolExamination.Utils;

public class GradingUtils {


    public static int getGrade(int a,int e,int marks)
    {
        if (marks>100||marks<=0) {
            return 0;
        }else if(marks>=a)
            return 12;
        else if(marks<=e)
            return 1;


        int range=a-e;
        int change=(marks-e);
//        System.out.println("change is "+change+" percentage "+(change*10/range));
        int value=change*10/range+2;
        return value;
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
}
