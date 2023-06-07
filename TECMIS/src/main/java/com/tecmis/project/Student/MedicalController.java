package com.tecmis.project.Student;

import java.util.Date;

public class MedicalController {
    private String Medical_id;
    private String Description;
    private Date date;
    private String Document;
    private String PDF_status;
    private String user_id;

    public MedicalController(String medical_id, String description, Date date, String document, String PDF_status, String user_id) {
        Medical_id = medical_id;
        Description = description;
        this.date = date;
        Document = document;
        this.PDF_status = PDF_status;
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

    public String getPDF_status() {
        return PDF_status;
    }

    public String getUser_id() {
        return user_id;
    }
}
