package com.tecmis.project.Admin.Profiles;

import java.util.Date;

public class profileController{

    private String user_role;
    private Integer user_no;
    private String user_id;
    private String user_password;
    private String first_name;
    private String last_name;
    private String email;
    private Date dob;
    private String sex;
    private String address;
    private String tp_number;
    private String profile_image;


    public profileController(String user_role, Integer user_no, String user_id, String user_password, String first_name, String last_name, String email, Date dob, String sex, String address, String tp_number, String profile_image  )
    {
        this.user_role = user_role;
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_password = user_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.tp_number = tp_number;
        this.profile_image = profile_image;
    }
    public String getUser_role(){
        return user_role;
    }
    public Integer getUser_no(){
        return user_no;
    }
    public String getUser_id(){
        return user_id;
    }
    public String getUser_password(){
        return user_password;
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

}
