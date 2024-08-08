package com.example.JR0824.service;

import com.example.JR0824.model.RentalAgreement;
import com.example.JR0824.model.Tool;
import com.example.JR0824.utils.CheckoutUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
public class RentalAgreementProducer {

    /**
     * Based on input from the checkout endpoint, create the Rental Agreement to return
     *
     * @param tool The tool to be rented
     * @param checkoutDate The date to be checked out
     * @param dayCount The number of days the tool is to be rented
     * @param discount The percentage of cost to discount, as an integer
     * @return
     */
    public RentalAgreement produce(Tool tool, Date checkoutDate, Integer dayCount, Integer discount){
        RentalAgreement rentalAgreement = new RentalAgreement();

        rentalAgreement.setToolBrand(tool.getBrand());
        rentalAgreement.setToolCode(tool.getCode().toUpperCase(Locale.ROOT));
        rentalAgreement.setToolType(tool.getToolType().getType());
        rentalAgreement.setDailyCharge(tool.getToolType().getDailyCost());
        rentalAgreement.setDiscountPercentage(discount);
        rentalAgreement.setCheckoutDate(checkoutDate);
        rentalAgreement.setRentalDays(dayCount);

        calculateTotalCharge(rentalAgreement, tool);

        rentalAgreement.setDiscountAmount(calculateDiscount(rentalAgreement.getPreDiscountCharge(), rentalAgreement.getDiscountPercentage()));

        rentalAgreement.setFinalCharge(CheckoutUtils.roundToTwoDecimalPlaces(rentalAgreement.getPreDiscountCharge() - rentalAgreement.getDiscountAmount()));

        return rentalAgreement;
    }


    /**
     * Based on the information in the rental agreement and the tool, count the days after the checkout date up to the
     * number of total days to calculate the due date. For each date between the two, count if we should charge, and
     * then calculate the total charge.
     * @param rentalAgreement the rental agreement currently being created
     * @param tool the tool that is being rented
     */
    public void calculateTotalCharge(RentalAgreement rentalAgreement, Tool tool){
        Date dateToCheck = rentalAgreement.getCheckoutDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToCheck);
        Double charge = 0.0;
        Boolean chargeWeekdays = tool.getToolType().getWeekDayCharge();
        Boolean chargeWeekends = tool.getToolType().getWeekendCharge();
        Boolean chargeHolidays = tool.getToolType().getHolidayCharge();
        Double dailyCharge = tool.getToolType().getDailyCost();
        Integer daysToCountTowardsCharge = 0;
        int dayCount = 1;
        while(dayCount <= rentalAgreement.getRentalDays()){
            calendar.add(Calendar.DATE, 1);
            dayCount++;
            Boolean isWeekend = CheckoutUtils.calendarIsWeekend(calendar);
            Boolean isHoliday = CheckoutUtils.calendarIsHoliday(calendar);

            if((isWeekend && chargeWeekends) || (!isWeekend && chargeWeekdays && !isHoliday) || (isHoliday && chargeHolidays)){
                daysToCountTowardsCharge++;
                charge += dailyCharge;
            }
        }
        rentalAgreement.setChargedDays(daysToCountTowardsCharge);
        rentalAgreement.setPreDiscountCharge(CheckoutUtils.roundToTwoDecimalPlaces(charge));
        rentalAgreement.setDueDate(calendar.getTime());
    }

    /**
     * Based on the amount that should be charged, and the discount percentage, calculate the dollar amount of the discount
     * @param charge the total charge
     * @param discountPercentage the percentage to be discounted as an integer
     * @return
     */
    private Double calculateDiscount(Double charge, Integer discountPercentage) {
        Double percentageToDiscount = (double) (discountPercentage)/100.0;
        return CheckoutUtils.roundToTwoDecimalPlaces(charge * percentageToDiscount);
    }
}
