package com.tecmis.project.Admin.Courses;

import java.util.Date;

public class courseController {


    private String course_name;
    private String description;
    private String degree;
    private Date date;

    public courseController(String course_name, String description, String degree, Date date) {
        this.course_name = course_name;
        this.description = description;
        this.degree = degree;
        this.date = date;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getDescription() {
        return description;
    }

    public String getDegree() {
        return degree;
    }
    public Date getDate() {
        return date;
    }
}
