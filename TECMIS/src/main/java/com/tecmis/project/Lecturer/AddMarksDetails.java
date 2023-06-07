package com.tecmis.project.Lecturer;

public class AddMarksDetails {
    String exam_id;
    public AddMarksDetails(String examid) {
        this.exam_id=examid;
    }

    public String getExamid() {
        return exam_id;
    }

    public void setExam_id(String examid) {
        this.exam_id = exam_id;
    }
}
