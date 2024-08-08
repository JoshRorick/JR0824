package com.example.JR0824.model;

import com.example.JR0824.utils.CheckoutUtils;

import java.util.Date;
import java.util.Objects;

public class RentalAgreement {

    private String toolCode;

    private String toolType;

    private String toolBrand;

    private Integer rentalDays;

    private Date checkoutDate;

    private Date dueDate;

    private Double dailyCharge;

    private Integer chargedDays;

    private Double preDiscountCharge;

    private Integer discountPercentage;

    private Double discountAmount;

    private Double finalCharge;


    public RentalAgreement() {}

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public Integer getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(Double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public Integer getChargedDays() {
        return chargedDays;
    }

    public void setChargedDays(Integer chargedDays) {
        this.chargedDays = chargedDays;
    }

    public Double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(Double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(Double finalCharge) {
        this.finalCharge = finalCharge;
    }

    public String toString(){
        String output = "";

        output += "Tool code: " + toolCode;
        output += "\nTool type: " + toolType;
        output += "\nTool brand: " + toolBrand;
        output += "\nRental Days: " + rentalDays;
        output += "\nCheckout Date: " + CheckoutUtils.getDateFormatter().format(checkoutDate);
        output += "\nDue Date: " + CheckoutUtils.getDateFormatter().format(dueDate);
        output += "\nDaily Charge: " + CheckoutUtils.getCurrencyFormatter().format(dailyCharge);
        output += "\nCharged Days: " + chargedDays;
        output += "\nPre-Discount Charge: " + CheckoutUtils.getCurrencyFormatter().format(preDiscountCharge);
        output += "\nDiscount Percentage: " + discountPercentage +"%";
        output += "\nDiscount Amount: " + CheckoutUtils.getCurrencyFormatter().format(discountAmount);
        output += "\nFinal Charge: " + CheckoutUtils.getCurrencyFormatter().format(finalCharge);

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalAgreement that = (RentalAgreement) o;
        return Objects.equals(getToolCode(), that.getToolCode()) && Objects.equals(getToolType(), that.getToolType()) && Objects.equals(getToolBrand(), that.getToolBrand()) && Objects.equals(getRentalDays(), that.getRentalDays()) && Objects.equals(getCheckoutDate(), that.getCheckoutDate()) && Objects.equals(getDueDate(), that.getDueDate()) && Objects.equals(getDailyCharge(), that.getDailyCharge()) && Objects.equals(getChargedDays(), that.getChargedDays()) && Objects.equals(getPreDiscountCharge(), that.getPreDiscountCharge()) && Objects.equals(getDiscountPercentage(), that.getDiscountPercentage()) && Objects.equals(getDiscountAmount(), that.getDiscountAmount()) && Objects.equals(getFinalCharge(), that.getFinalCharge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToolCode(), getToolType(), getToolBrand(), getRentalDays(), getCheckoutDate(), getDueDate(), getDailyCharge(), getChargedDays(), getPreDiscountCharge(), getDiscountPercentage(), getDiscountAmount(), getFinalCharge());
    }
}
