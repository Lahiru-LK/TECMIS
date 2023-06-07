//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tecmis.project.Student;

public class NoticeController {
    private String notice_id;
    private String notice_name;
    private String bodyof_notice;
    private String notice_imagepdf;
    private String notice_createdate;
    private String upnonupnotice;

    public NoticeController(String notice_id, String notice_name, String bodyof_notice, String notice_imagepdf, String notice_createdate, String upnonupnotice) {
        this.notice_id = notice_id;
        this.notice_name = notice_name;
        this.bodyof_notice = bodyof_notice;
        this.notice_imagepdf = notice_imagepdf;
        this.notice_createdate = notice_createdate;
        this.upnonupnotice = upnonupnotice;
    }

    public String getNotice_id() {
        return notice_id;
    }

    public String getNotice_name() {
        return notice_name;
    }

    public String getBodyof_notice() {
        return bodyof_notice;
    }

    public String getNotice_imagepdf() {
        return notice_imagepdf;
    }

    public String getNotice_createdate() {
        return notice_createdate;
    }

    public String getUpnonupnotice() {
        return upnonupnotice;
    }
}
