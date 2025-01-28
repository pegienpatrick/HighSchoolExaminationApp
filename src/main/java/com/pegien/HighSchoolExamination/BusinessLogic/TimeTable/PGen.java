package com.pegien.HighSchoolExamination.BusinessLogic.TimeTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PGen {

    private static int prevCounter=0;

    private static ArrayList<Integer> store=null;


    public static int nextInt(int spaces) {
        if(store==null||store.size()!=spaces||prevCounter>=spaces)
        {
            store=new ArrayList(spaces);
            for(int i=0;i<spaces;i++)
                store.add(i,i);
            Collections.shuffle(store);
            prevCounter=0;
        }
//        if()
//            prevCounter=new Random().nextInt(spaces);
        return store.get(prevCounter++);
//        return new Random().nextInt(spaces);
    }
}
