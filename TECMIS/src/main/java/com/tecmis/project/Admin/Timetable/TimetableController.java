package com.tecmis.project.Admin.Timetable;

import java.util.Date;

public class TimetableController {

    private String timetable_id;
    private String timetable_name;

    private Date creat_date;

    private String upload_image;


    public TimetableController(String timetable_id, String timetable_name, Date creat_date, String upload_image) {
        this.timetable_id = timetable_id;
        this.timetable_name = timetable_name;
        this.creat_date = creat_date;
        this.upload_image = upload_image;

    }

    public String getTimetable_id() {
        return timetable_id;
    }

    public String getTimetable_name() {
        return timetable_name;
    }

    public Date getCreat_date() {
        return creat_date;
    }

    public String getUpload_image() {
        return upload_image;
    }
}
