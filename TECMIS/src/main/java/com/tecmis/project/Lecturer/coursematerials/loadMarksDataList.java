package com.tecmis.project.Lecturer.coursematerials;

public class loadMarksDataList {
    private String user_id;
    private double GPA;
    private double ICT01;
    private double ICT02;
    private double ICT03;
    private double ICT04;


    public loadMarksDataList(String user_id, double GPA, double ICT01, double ICT02, double ICT03, double ICT04) {
        this.user_id = user_id;
        this.GPA = GPA;
        this.ICT01 = ICT01;
        this.ICT02 = ICT02;
        this.ICT03 = ICT03;
        this.ICT04 = ICT04;

    }

    public String getUser_id() {
        return user_id;
    }

    public double getGPA() {
        return GPA;
    }

    public double getICT01() {
        return ICT01;
    }

    public double getICT02() {
        return ICT02;
    }

    public double getICT03() {
        return ICT03;
    }

    public double getICT04() {
        return ICT04;
    }


}
