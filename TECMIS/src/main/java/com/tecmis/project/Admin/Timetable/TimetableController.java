package com.tecmis.project.Admin.Timetable;

import java.sql.Date;

public class TimetableController {

    private String timetable_id;

    private String department_id;
    private String timetable_name;

    private Date creat_date;

    private String upload_image;

    private String usepdf;

    private String upnonupPDF;
    private String upnonupIMG;


    public TimetableController(String timetable_id, String department_id, String timetable_name, Date creat_date, String upload_image, String usepdf, String upnonupPDF, String upnonupIMG) {
        this.timetable_id = timetable_id;
        this.department_id = department_id;
        this.timetable_name = timetable_name;
        this.creat_date = creat_date;
        this.upload_image = upload_image;
        this.usepdf = usepdf;
        this.upnonupPDF = upnonupPDF;
        this.upnonupIMG = upnonupIMG;


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

    public Date getCreat_date() {
        return creat_date;
    }

    public String getUpload_image() {return upload_image;}

    public String getUsepdf() {
        return usepdf;
    }


    public String getUpnonupPDF() {
        return upnonupPDF;
    }
    public String getUpnonupIMG() {
        return upnonupIMG;
    }
}
