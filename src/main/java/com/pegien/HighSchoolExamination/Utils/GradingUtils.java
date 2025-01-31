package com.pegien.HighSchoolExamination.Utils;

import java.util.HashMap;

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
            "X"
    };

    public static String gradeChar(int grade) {
        if(grade<0||grade>=grades.length)
            return "X";
        return grades[grades.length-grade-1];
    }


    public static int agregateGrading(Double points)
    {
        if(points>84||points<7)
            return 0;
        double tmp=points;
        return (int)Math.round(points/7.0);
    }

    public static int agregateGrading(Double points,Double subjects)
    {
        if(points>subjects*12||points<subjects)
            return 0;
        double tmp=points;
        return (int)Math.round(points/subjects);
    }

//    public static String[] performanceComments = {
//            "Extremely Poor",//0-9
//            "Poor",//10-20
//            "A bit Poor",//20-30
//            "Improve",//30-40
//            "Below Average",//40-50
//            "Average",//50-60
//            "Good",//60-70
//            "Very Good",//70-80
//            "Excellent",//80-90
//            "Outstanding",//90-100
//            "Exceptional",
//            "Perfect"
//    };

//    public static String getComment(Double marks) {
//        if(marks==null||marks==0||marks>100)
//            return " ";
//        else{
//            int word= (int) (marks/10);
//            return performanceComments[word];
//        }
//    }

    // Klass teachers' remarks
    public static HashMap<String, String> klassRemarks = new HashMap<>();
    public static HashMap<String, String> principlesRemarks = new HashMap<>();

    public static HashMap<String, String> gradingOpinions = new HashMap<>();

    public static HashMap<String,Integer> gradeInts=new HashMap<>();

    static {
        klassRemarks.put("A", "Good performance maintain that.");
        klassRemarks.put("A-", "Good. Work towards grade A.");
        klassRemarks.put("B+", "Good performance. Aim for A-.");
        klassRemarks.put("B", "Good work. Aim grade B+.");
        klassRemarks.put("B-", "Do extra to get B.");
        klassRemarks.put("C+", "You can do better. Aim higher.");
        klassRemarks.put("C", "You can achieve grade C+.");
        klassRemarks.put("C-", "Aim for top grades.");
        klassRemarks.put("D+", " Aim for grade C and above.");
        klassRemarks.put("D", "Improve your areas of weakness.");
        klassRemarks.put("D-", "Don`t loose hope keep on trying.");
        klassRemarks.put("E", "You need more remedial.");

        // Principles' remarks

        principlesRemarks.put("A", "Outstanding performance.");
        principlesRemarks.put("A-", "Quality grade aim higher.");
        principlesRemarks.put("B+", "Good performance.");
        principlesRemarks.put("B", "Good progress.");
        principlesRemarks.put("B-", "Keep on trying.");
        principlesRemarks.put("C+", "Keep aiming higher.");
        principlesRemarks.put("C", "Aim for top grades.");
        principlesRemarks.put("C-", "You can get good grade work hard.");
        principlesRemarks.put("D+", "Do more consultation. You can do better.");
        principlesRemarks.put("D", "A bit low. Put more effort.");
        principlesRemarks.put("D-", "Aim for the next grade.");
        principlesRemarks.put("E", "Create time for extra remedial.");




        // Adding entries to the HashMap
        gradingOpinions.put("A", "Excellent maintain this");
        gradingOpinions.put("A-", "Very good hit the next grade");
        gradingOpinions.put("B+", "Good target the next grade");
        gradingOpinions.put("B", "Good put more effort");
        gradingOpinions.put("B-", "Above average");
        gradingOpinions.put("C+", "Average");
        gradingOpinions.put("C", "Aim higher");
        gradingOpinions.put("C-", "Can do better");
        gradingOpinions.put("D+", "Work on improvement");
        gradingOpinions.put("D", "Put more effort");
        gradingOpinions.put("D-", "Don't lose hope you still got a chance");
        gradingOpinions.put("E", "You have potential to improve");


        for(int i=0;i<=12;i++)
            gradeInts.put(gradeChar(i),i);

    }

    public static int gradeToInt(String aggregateGrade) {
        return gradeInts.get(aggregateGrade);
    }
}
