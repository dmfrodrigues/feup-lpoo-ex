package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public Date plantedAt;
    public String locationLatitude;
    public String locationLongitude;
    public String locationName;
    private final List<Date> appraisalDates;

    public Tree(Date plantedAt, String lat, String lon, String name){
        this.plantedAt = plantedAt;
        this.setLocation(lat, lon, name);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(String lat, String lon, String name){
        this.locationLatitude = lat;
        this.locationLongitude = lon;
        this.locationName = name;
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }

    void addAppraisal(Date d) {
        this.appraisalDates.add(d);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latest = today;

        if (this.appraisalDates.size() > 0) {
            latest = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latest.before(appraisalDate)) {
                latest = appraisalDate;
            }
        }

        // Calculate next appraisal date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latest);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        Date nextAppraisalDate = calendar.getTime();
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.before(today);
    }
}
