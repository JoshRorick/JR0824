package com.example.JR0824.model;

public enum Tool {
    CHNS("chns", ToolType.CHAINSAW, "Stihl"),
    LADW("ladw", ToolType.LADDER, "Werner"),
    JAKD("jakd", ToolType.JACKHAMMER, "DeWalt"),
    JAKR("jakr", ToolType.JACKHAMMER, "Ridgid");


    private String code;

    private String brand;

    private ToolType toolType;

    Tool(String code, ToolType toolType, String brand) {
        this.code = code;
        this.toolType = toolType;
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }
}
