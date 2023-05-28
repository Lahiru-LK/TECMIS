package com.tecmis.project.Student;

public class CourseController {
    private String course_id;
    private String Course_Code;
    private String Course_Name;
    private String Course_Type;

    public CourseController(String course_id, String course_Code, String course_Name, String course_Type) {
        this.course_id = course_id;
        Course_Code = course_Code;
        Course_Name = course_Name;
        Course_Type = course_Type;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_Code() {
        return Course_Code;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public String getCourse_Type() {
        return Course_Type;
    }
}
