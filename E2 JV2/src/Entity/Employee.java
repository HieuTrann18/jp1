package Entity;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private Department department;
    private LocalDate dateOfBirth;
    private String gender;
    private String city;
    private String province;
    private String phoneNumber;

    public Employee(int id, String name, Department department, LocalDate dateOfBirth, String gender, String city, String province, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString method for easy display
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department=" + department + ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + "', city='" + city + "', province='" + province + "', phoneNumber='" + phoneNumber + "'}";
    }
}

