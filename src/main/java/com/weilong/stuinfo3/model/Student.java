package com.weilong.stuinfo3.model;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Student {

    private Integer spk;

    private String sname;

    private String sid;

    private String ssex;

    private Integer sage;

    private Timestamp sdate;

    public Integer getSpk() { return spk; }

    public void setSpk(Integer spk) { this.spk = spk; }

    public String getSname() { return sname; }

    public void setSname(String sname) { this.sname = sname; }

    public String getSid() { return sid; }

    public void setSid(String sid) { this.sid = sid; }

    public String getSsex() { return ssex; }

    public void setSsex(String ssex) { this.ssex = ssex; }

    public Integer getSage() { return sage; }

    public void setSage(Integer sage) {this.sage = sage; }

    public Timestamp getSdate() { return sdate; }

    public void setSdate(Timestamp sdate) { this.sdate = sdate; }
}
