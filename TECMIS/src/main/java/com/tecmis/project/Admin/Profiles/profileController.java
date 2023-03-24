package com.tecmis.project.Admin.Profiles;

import java.util.Date;

public class profileController{

    private String user_role;
    private String user_id;
    private String user_password;
    private String course_id;

    private String department_id;
    private String first_name;
    private String last_name;
    private String email;
    private Date dob;
    private String sex;
    private String address;
    private String tp_number;
    private String profile_image;
    private Date date;
    private String upnonupuserIMG;


    public profileController(String user_role, String user_id, String user_password,String course_id, String department_id, String first_name, String last_name, String email, Date dob, String sex, String address, String tp_number, String profile_image, Date date, String upnonupuserIMG  )
    {
        this.user_role = user_role;
        this.user_id = user_id;
        this.user_password = user_password;
        this.course_id = course_id;
        this.department_id = department_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.tp_number = tp_number;
        this.profile_image = profile_image;
        this.date = date;
        this.upnonupuserIMG = upnonupuserIMG;
    }
    public String getUser_role(){return user_role;    }
    public String getUser_id(){
        return user_id;
    }
    public String getUser_password(){
        return user_password;
    }
    public String getCourse_id(){
        return course_id;
    }
    public String getDepartment_id() {
        return department_id;
    }

    public String getFirst_name(){
        return first_name;
    }
    public String getLast_name(){
        return last_name;
    }
    public String getEmail(){
        return email;
    }
    public Date getDob(){
        return dob;
    }
    public String getSex(){
        return sex;
    }
    public String getAddress(){
        return address;
    }
    public String getTp_number(){
        return tp_number;
    }
    public String getProfile_image(){
        return profile_image;
    }
    public Date getDate(){return date; }

    public String getUpnonupuserIMG() {
        return upnonupuserIMG;
    }
}
