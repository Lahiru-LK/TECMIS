package com.tecmis.project.Lecturer;

public class MarksInformation {
    private String user_id ;
    private String first_name;
    private String last_name;
    private String course_name;
    private String Subject_code;
    private String e_type;
    private float marks;
    private String exam_Id;
    private int marks_Id;
    private float quiz_1;
    private float quiz_2;
    private float quiz_3;
    private float assessment_1;
    private float assessment_2;
    private float mid_term;
    private float final_theory;
    private float final_practical;



    public MarksInformation(String userId, String firstName, String Subject_code, String etype, float marks) {
        this.user_id=userId;
        this.first_name=firstName;
        this.Subject_code=Subject_code;
        this.e_type=etype;
        this.marks=marks;
    }

    public String getSubject_code() {
        return Subject_code;
    }

    public void setSubject_code(String subject_code) {
        Subject_code = subject_code;
    }

    public String getSubjectCode() {
        return Subject_code;
    }

    public void setSubjectCode(String subjectCode) {
        this.Subject_code = Subject_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getExam_Id() {
        return exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        this.exam_Id = exam_Id;
    }

    public int getMarks_Id() {
        return marks_Id;
    }

    public void setMarks_Id(int marks_Id) {
        this.marks_Id = marks_Id;
    }

    public float getQuiz_1() {
        return quiz_1;
    }

    public void setQuiz_1(float quiz1) {
        this.quiz_1 = quiz1;
    }

    public float getQuiz_2() {
        return quiz_2;
    }

    public void setQuiz_2(float quiz2) {
        this.quiz_2 = quiz2;
    }

    public float getQuiz_3() {
        return quiz_3;
    }

    public void setQuiz_3(float quiz3) {
        this.quiz_3 = quiz3;
    }

    public float getAssessment_1() {
        return assessment_1;
    }

    public void setAssessment_1(float assessment1) {
        this.assessment_1 = assessment1;
    }

    public float getAssessment_2() {
        return assessment_2;
    }

    public void setAssessment_2(float assessment2) {
        this.assessment_2 = assessment2;
    }

    public float getMid_term() {
        return mid_term;
    }

    public void setMid_term(float midTerm) {
        this.mid_term = midTerm;
    }

    public float getFinal_theory() {
        return final_theory;
    }

    public void setFinal_theory(float finalTheory) {
        this.final_theory = finalTheory;
    }

    public float getFinal_practical() {
        return final_practical;
    }

    public void setFinal_practical(float finalPractical) {
        this.final_practical = finalPractical;
    }
}
