package com.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tiffin_menu")
public class TiffinMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long providerId;

    private String mondayLunch;
    private String mondayDinner;

    private String tuesdayLunch;
    private String tuesdayDinner;

    private String wednesdayLunch;
    private String wednesdayDinner;

    private String thursdayLunch;
    private String thursdayDinner;

    private String fridayLunch;
    private String fridayDinner;

    private String saturdayLunch;
    private String saturdayDinner;

    private String sundayLunch;
    private String sundayDinner;

    // ----------- Getters & Setters -------------

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getProviderId() { return providerId; }

    public void setProviderId(Long providerId) { this.providerId = providerId; }

    public String getMondayLunch() { return mondayLunch; }

    public void setMondayLunch(String mondayLunch) { this.mondayLunch = mondayLunch; }

    public String getMondayDinner() { return mondayDinner; }

    public void setMondayDinner(String mondayDinner) { this.mondayDinner = mondayDinner; }

    public String getTuesdayLunch() { return tuesdayLunch; }

    public void setTuesdayLunch(String tuesdayLunch) { this.tuesdayLunch = tuesdayLunch; }

    public String getTuesdayDinner() { return tuesdayDinner; }

    public void setTuesdayDinner(String tuesdayDinner) { this.tuesdayDinner = tuesdayDinner; }

    public String getWednesdayLunch() { return wednesdayLunch; }

    public void setWednesdayLunch(String wednesdayLunch) { this.wednesdayLunch = wednesdayLunch; }

    public String getWednesdayDinner() { return wednesdayDinner; }

    public void setWednesdayDinner(String wednesdayDinner) { this.wednesdayDinner = wednesdayDinner; }

    public String getThursdayLunch() { return thursdayLunch; }

    public void setThursdayLunch(String thursdayLunch) { this.thursdayLunch = thursdayLunch; }

    public String getThursdayDinner() { return thursdayDinner; }

    public void setThursdayDinner(String thursdayDinner) { this.thursdayDinner = thursdayDinner; }

    public String getFridayLunch() { return fridayLunch; }

    public void setFridayLunch(String fridayLunch) { this.fridayLunch = fridayLunch; }

    public String getFridayDinner() { return fridayDinner; }

    public void setFridayDinner(String fridayDinner) { this.fridayDinner = fridayDinner; }

    public String getSaturdayLunch() { return saturdayLunch; }

    public void setSaturdayLunch(String saturdayLunch) { this.saturdayLunch = saturdayLunch; }

    public String getSaturdayDinner() { return saturdayDinner; }

    public void setSaturdayDinner(String saturdayDinner) { this.saturdayDinner = saturdayDinner; }

    public String getSundayLunch() { return sundayLunch; }

    public void setSundayLunch(String sundayLunch) { this.sundayLunch = sundayLunch; }

    public String getSundayDinner() { return sundayDinner; }

    public void setSundayDinner(String sundayDinner) { this.sundayDinner = sundayDinner; }
}
