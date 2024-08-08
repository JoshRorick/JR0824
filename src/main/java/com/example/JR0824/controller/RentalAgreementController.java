package com.example.JR0824.controller;

import com.example.JR0824.exceptions.InvalidInputException;
import com.example.JR0824.model.RentalAgreement;
import com.example.JR0824.model.Tool;
import com.example.JR0824.service.RentalAgreementProducer;
import com.example.JR0824.utils.CheckoutUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

import java.util.Date;
import java.util.Locale;

@Controller
public class RentalAgreementController {

    @Autowired
    private RentalAgreementProducer rentalAgreementProducer;

    @GetMapping("/checkout")
    public RentalAgreement checkout(@RequestParam("toolCode") String toolCode, @RequestParam("dayCount") Integer dayCount, @RequestParam("discount") Integer discount, @RequestParam("checkoutDate") String checkoutDateString){
        try{
            Tool tool = Tool.valueOf(toolCode.trim().toUpperCase(Locale.ROOT));
            Date checkoutDate = CheckoutUtils.getDateFormatter().parse(checkoutDateString);
            if(discount < 0 || discount > 100){
                throw new InvalidInputException("Invalid value for discount. Must be an integer between 0 and 100.");
            }
            if(dayCount < 1) {
                throw new InvalidInputException("Invalid value for dayCount. Must be a positive integer greater than 0.");
            }
            return rentalAgreementProducer.produce(tool, checkoutDate, dayCount, discount);
        } catch (ParseException e) {
            throw new InvalidInputException("Unable to parse the Date from the provided String. Provided String must be in the format of MM/DD/YY");
        }
    }

}
