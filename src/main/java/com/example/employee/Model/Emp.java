package com.example.employee.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//This is a POJO class
@Document//Annotation for considering the class to be a document
public class Emp {
    @Id
    private long empId;
    private String empname;
    private String empEmail;
    private String empLocation;


    public Emp() {
    }

    public Emp(long empId, String empname, String empEmail, String empLocation) {
        this.empId = empId;
        this.empname = empname;
        this.empEmail = empEmail;
        this.empLocation = empLocation;
    }

    public long getEmpId() {
        return empId;
    }

    public String getEmpname() {
        return empname;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }
}
