package com.tecmis.project.Lecturer;

public class MarksInformation {
    private String user_id ;
    private String first_name;
    private String last_name;
    private String course_name;
    private String course_id;
    private String e_type;
    private float marks;
    private String exam_Id;
    private int marks_Id;

    public String getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getE_type() {
        return e_type;
    }

    public float getMarks() {
        return marks;
    }

    public String getExam_Id() {
        return exam_Id;
    }

    public int getMarks_Id() {
        return marks_Id;
    }

    public MarksInformation(String user_id, String first_name, String last_name, String course_name, String course_id, String e_type, float marks, String exam_Id, int marks_Id) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.course_name = course_name;
        this.course_id = course_id;
        this.e_type = e_type;
        this.marks = marks;
        this.exam_Id = exam_Id;
        this.marks_Id = marks_Id;


    }
}
