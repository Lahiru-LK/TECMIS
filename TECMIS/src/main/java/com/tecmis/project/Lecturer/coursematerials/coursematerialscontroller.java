package com.tecmis.project.Lecturer.coursematerials;

public class coursematerialscontroller {

    private String course_material_no;
    private String user_id;

    private String material_name;

    private String course_material;



    public coursematerialscontroller(String course_material_no,String user_id, String material_name, String course_material) {
        this.course_material_no = course_material_no;
        this.user_id = user_id;
        this.material_name = material_name;
        this.course_material = course_material;

    }

    public String getCourse_material_no() {
        return course_material_no;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getCourse_material() {
        return course_material;
    }

}