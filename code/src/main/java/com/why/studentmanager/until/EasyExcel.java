package com.why.studentmanager.until;

import java.util.ArrayList;
import java.util.List;

public class EasyExcel {
    private static List<List<String>> head(){
        List<List<String>> list  = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("学号");
        List<String> head1 = new ArrayList<String>();
        head1.add("姓名");
        List<String> head2 = new ArrayList<String>();
        head2.add("班级名");
        List<String> head3 = new ArrayList<String>();
        head3.add("课程名");
        List<String> head4 = new ArrayList<String>();
        head4.add("成绩");
        List<String> head5 = new ArrayList<String>();
        head5.add("备注");
        return list;
    }

}
