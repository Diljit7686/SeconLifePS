package com.example.seconlifeps.model;

import java.io.Serializable;

public class Appointments implements Serializable {
    private Integer ap_id;
    private Integer bu_id;
    private Integer us_id;
    private String ap_date;
    private String ap_hour;

    public Appointments(Integer ap_id, Integer bu_id, Integer us_id, String ap_date, String ap_hour) {
        this.ap_id = ap_id;
        this.bu_id = bu_id;
        this.us_id = us_id;
        this.ap_date = ap_date;
        this.ap_hour = ap_hour;
    }

    public Appointments() {

    }

    public Integer getAp_id() {
        return ap_id;
    }

    public void setAp_id(Integer ap_id) {
        this.ap_id = ap_id;
    }

    public Integer getBu_id() {
        return bu_id;
    }

    public void setBu_id(Integer bu_id) {
        this.bu_id = bu_id;
    }

    public Integer getUs_id() {
        return us_id;
    }

    public void setUs_id(Integer us_id) {
        this.us_id = us_id;
    }

    public String getAp_date() {
        return ap_date;
    }

    public void setAp_date(String ap_date) {
        this.ap_date = ap_date;
    }

    public String getAp_hour() {
        return ap_hour;
    }

    public void setAp_hour(String ap_hour) {
        this.ap_hour = ap_hour;
    }
}
