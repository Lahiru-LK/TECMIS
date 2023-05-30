package com.tecmis.project.Technical_Officer.Medical;

import java.util.Date;

public class medicalController {


    private String user_id;

    private String Medical_id;

    private String Description;

    private String date;

    private String Document;


    public medicalController(String user_id, String medical_id, String description, Date date, String document) {
        this.user_id = String.valueOf(user_id);
        Medical_id = medical_id;
        Description = description;
        this.date = String.valueOf(date);
        Document = document;

    }

    public String getUser_id() {
        return user_id;
    }


    public String getMedical_id() {
        return Medical_id;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return date;
    }

    public String getDocument() {
        return Document;
    }


}