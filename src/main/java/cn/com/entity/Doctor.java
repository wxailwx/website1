package cn.com.entity;

public class Doctor {
    private String DID;
    private String name;
    private String faculty;
    private String profession;

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHID() {
        return HID;
    }

    public void setHID(String HID) {
        this.HID = HID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String political;
    private String expertise;
    private String description;
    private String HID;
    private String status;
    private String pingying;

    public String getPingying() {
        return pingying;
    }

    public void setPingying(String pingying) {
        this.pingying = pingying;
    }

    public String getFull_surname() {
        return full_surname;
    }

    public void setFull_surname(String full_surname) {
        this.full_surname = full_surname;
    }

    public String getAbbre_surname() {
        return abbre_surname;
    }

    public void setAbbre_surname(String abbre_surname) {
        this.abbre_surname = abbre_surname;
    }

    public String getFull_firstname() {
        return full_firstname;
    }

    public void setFull_firstname(String full_firstname) {
        this.full_firstname = full_firstname;
    }

    public String getAbbre_firstname() {
        return abbre_firstname;
    }

    public void setAbbre_firstname(String abbre_firstname) {
        this.abbre_firstname = abbre_firstname;
    }

    private String full_surname;
    private String abbre_surname;
    private String full_firstname;
    private String abbre_firstname;
}
