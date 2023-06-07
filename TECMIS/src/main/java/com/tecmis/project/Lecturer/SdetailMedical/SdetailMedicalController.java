package com.tecmis.project.Lecturer.SdetailMedical;

import java.util.Date;

public class SdetailMedicalController {
private String user_id;
private String Description;


    public SdetailMedicalController(String user_id, String description) {
        this.user_id = user_id;
        Description = description;
    }



    public String getUser_id() {
        return user_id;
    }

    public String getDescription() {
        return Description;
    }
}
