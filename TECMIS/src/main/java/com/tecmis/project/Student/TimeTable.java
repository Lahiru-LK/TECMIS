package com.tecmis.project.Student;

public class TimeTable {

    private String timetable_id;
    private String department_id;
    private String timetable_name;
    private String creat_date;
    private String upnonupPDF;

    public TimeTable(String timetable_id, String department_id, String timetable_name, String creat_date, String upnonupPDF) {
        this.timetable_id = timetable_id;
        this.department_id = department_id;
        this.timetable_name = timetable_name;
        this.creat_date = creat_date;
        this.upnonupPDF = upnonupPDF;
    }

    public String getTimetable_id() {
        return timetable_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public String getTimetable_name() {
        return timetable_name;
    }

    public String getCreat_date() {
        return creat_date;
    }

    public String getUpnonupPDF() {
        return upnonupPDF;
    }
}
