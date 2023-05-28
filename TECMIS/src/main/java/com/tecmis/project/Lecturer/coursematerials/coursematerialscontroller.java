package com.tecmis.project.Lecturer.coursematerials;

public class coursematerialscontroller {

    private String course_material_no;

    private String material_name;

    private String course_material;

    public coursematerialscontroller(String course_material_no, String material_name, String course_material) {
        this.course_material_no = course_material_no;
        this.material_name = material_name;
        this.course_material = course_material;
    }

    public String getCourse_material_no() {
        return course_material_no;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public String getCourse_material() {
        return course_material;
    }
}