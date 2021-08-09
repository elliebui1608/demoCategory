package com.example.demoCategory;

public class take {

    public take(String coursename, String building) {
        this.coursename = coursename;
        this.building = building;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    private String coursename;
    private String building;

}
