package com.tecmis.project.Technical_Officer.Medical;

import java.util.Date;

public class medicalController {


    private String Medical_id;

    private String Description;

    private Date date;

    private String Document;

    private String user_id;

    public medicalController(String medical_id, String description, Date date, String document, String user_id) {
        Medical_id = medical_id;
        Description = description;
        this.date = date;
        Document = document;
        this.user_id = user_id;
    }

    public String getMedical_id() {
        return Medical_id;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDate() {
        return date;
    }

    public String getDocument() {
        return Document;
    }

    public String getUser_id() {
        return user_id;
    }
}
