package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

/**
 * Created by user on 2017-08-14.
 */

public class StudentModel {
    private static final StudentModel ourInstance = new StudentModel();
    String studentname;
    String schoolname;
    String regionn1;
    String regionn2;
    String shooladdress;


    public static StudentModel getInstance() {
        return ourInstance;
    }

    private StudentModel() {
    }
}
