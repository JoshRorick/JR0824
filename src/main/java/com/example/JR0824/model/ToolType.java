package com.example.JR0824.model;

public enum ToolType {
    LADDER("ladder", 1.99, true, true, false),
    CHAINSAW("chainsaw", 1.49, true, false, true),
    JACKHAMMER("jackhammer", 2.99, true, false, false);


    private String type;

    private Double dailyCost;

    private Boolean weekDayCharge;

    private Boolean weekendCharge;

    private Boolean holidayCharge;

    ToolType(String type, Double dailyCost, Boolean weekDayCharge, Boolean weekendCharge, Boolean holidayCharge) {
        this.type = type;
        this.dailyCost = dailyCost;
        this.weekDayCharge = weekDayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(Double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public Boolean getWeekDayCharge() {
        return weekDayCharge;
    }

    public void setWeekDayCharge(Boolean weekDayCharge) {
        this.weekDayCharge = weekDayCharge;
    }

    public Boolean getWeekendCharge() {
        return weekendCharge;
    }

    public void setWeekendCharge(Boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public Boolean getHolidayCharge() {
        return holidayCharge;
    }

    public void setHolidayCharge(Boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }
}
