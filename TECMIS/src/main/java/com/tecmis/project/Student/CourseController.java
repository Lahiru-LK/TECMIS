package com.tecmis.project.Student;

public class CourseController {
    private String course_id;
    private String Subject_id;
    private String Subject_Name;
    private String Course_Type;

    public CourseController(String course_id, String subject_id, String subject_Name, String course_Type) {
        this.course_id = course_id;
        Subject_id = subject_id;
        Subject_Name = subject_Name;
        Course_Type = course_Type;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getSubject_id() {
        return Subject_id;
    }

    public String getSubject_Name() {
        return Subject_Name;
    }

    public String getCourse_Type() {
        return Course_Type;
    }
}
