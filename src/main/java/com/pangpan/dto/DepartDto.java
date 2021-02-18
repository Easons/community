package com.pangpan.dto;

public class DepartDto {
    private int id;
    private String departmentName;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public DepartDto(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DepartDto{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
