package com.example.domain;

import java.text.NumberFormat;

public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }
    public Employee() {
	}
	public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty() || !name.isBlank())
                 this.name = name;
    }

    public double getSalary() {
        return salary;
    }


    public String getSsn() {
        return ssn;
    }

    public void raiseSalary(double increase)
    {
        if (increase > 0)
         salary += increase;
    }

    public void printEmployee()
    {
        System.out.println("ID: "+getEmpId()+"\n name: "+getName()+"\n SSN: "+getSsn()+ "\n Salary: "+NumberFormat.getCurrencyInstance().format((double)getSalary()));
    }
	public void setEmpId(int i) {
	}

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   

}
