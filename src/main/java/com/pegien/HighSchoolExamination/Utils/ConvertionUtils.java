package com.pegien.HighSchoolExamination.Utils;

public class ConvertionUtils {


    public static Double getDouble(String str)
    {
        Double fine=0.0;
        try{
            fine=Double.parseDouble(str);
        }catch (Exception es)
        {

        }
        return fine;
    }

    public static int getInt(String str)
    {
        int fine=0;
        try{
            fine=Integer.parseInt(str);
        }catch (Exception es)
        {

        }
        return fine;
    }

    public static Long getLong(String str)
    {
        Long val=0L;
        try{
            val=Long.parseLong(str);
        }catch (Exception es){

        }
        return val;
    }



}
