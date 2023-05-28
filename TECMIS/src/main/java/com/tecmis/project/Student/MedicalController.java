package com.tecmis.project.Student;

public class MedicalController {
    private String Title;
    private String Description;
    private String date;
    private String document;
    private String user_id;

    public MedicalController(String title, String description, String date, String document, String user_id) {
        this.Title = title;
        this.Description = description;
        this.date = date;
        this.document = document;
        this.user_id = user_id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return date;
    }

    public String getDocument() {
        return document;
    }

    public String getUser_id() {
        return user_id;
    }
}
