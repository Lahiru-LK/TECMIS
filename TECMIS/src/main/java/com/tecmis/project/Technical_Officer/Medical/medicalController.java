package com.tecmis.project.Technical_Officer.Medical;

import java.util.Date;

public class medicalController {

    private String user_id;

    private String Title;

    private String Description;

    private Date date;

    private String Document;

    public medicalController(String user_id, String title, String description, Date date, String document) {
        this.user_id = user_id;
        Title = title;
        Description = description;
        this.date = date;
        Document = document;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return Title;
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
}
