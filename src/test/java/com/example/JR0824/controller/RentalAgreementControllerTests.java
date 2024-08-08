package com.example.JR0824.controller;

import com.example.JR0824.exceptions.InvalidInputException;
import com.example.JR0824.model.RentalAgreement;
import com.example.JR0824.utils.CheckoutUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class RentalAgreementControllerTests {

    @Autowired
    RentalAgreementController rentalAgreementController;

    @Test
    public void test1(){
        InvalidInputException exception = Assertions.assertThrows(InvalidInputException.class, () -> rentalAgreementController.checkout("JAKR", 5, 101, "9/3/15"));

        Assertions.assertTrue(exception.getMessage().contains("discount"));
    }

    @Test
    public void test2() throws ParseException {
        RentalAgreement expectedRentalAgreement = new RentalAgreement();
        expectedRentalAgreement.setToolCode("LADW");
        expectedRentalAgreement.setToolType("ladder");
        expectedRentalAgreement.setToolBrand("Werner");
        expectedRentalAgreement.setRentalDays(3);
        expectedRentalAgreement.setCheckoutDate(CheckoutUtils.getDateFormatter().parse("7/2/20"));
        expectedRentalAgreement.setDueDate(CheckoutUtils.getDateFormatter().parse("7/5/20"));
        expectedRentalAgreement.setDailyCharge(1.99);
        expectedRentalAgreement.setChargedDays(2);
        expectedRentalAgreement.setPreDiscountCharge(3.98);
        expectedRentalAgreement.setDiscountPercentage(10);
        expectedRentalAgreement.setDiscountAmount(.4);
        expectedRentalAgreement.setFinalCharge(3.58);

        RentalAgreement actualRentalAgreement = rentalAgreementController.checkout("LADW", 3, 10, "7/2/20");

        Assertions.assertEquals(expectedRentalAgreement, actualRentalAgreement);
    }

    @Test
    public void test3() throws ParseException {
        RentalAgreement expectedRentalAgreement = new RentalAgreement();
        expectedRentalAgreement.setToolCode("CHNS");
        expectedRentalAgreement.setToolType("chainsaw");
        expectedRentalAgreement.setToolBrand("Stihl");
        expectedRentalAgreement.setRentalDays(5);
        expectedRentalAgreement.setCheckoutDate(CheckoutUtils.getDateFormatter().parse("7/2/15"));
        expectedRentalAgreement.setDueDate(CheckoutUtils.getDateFormatter().parse("7/7/15"));
        expectedRentalAgreement.setDailyCharge(1.49);
        expectedRentalAgreement.setChargedDays(3);
        expectedRentalAgreement.setPreDiscountCharge(4.47);
        expectedRentalAgreement.setDiscountPercentage(25);
        expectedRentalAgreement.setDiscountAmount(1.12);
        expectedRentalAgreement.setFinalCharge(3.35);

        RentalAgreement actualRentalAgreement = rentalAgreementController.checkout("CHNS", 5, 25, "7/2/15");

        Assertions.assertEquals(expectedRentalAgreement, actualRentalAgreement);
    }

    @Test
    public void test4() throws ParseException {
        RentalAgreement expectedRentalAgreement = new RentalAgreement();
        expectedRentalAgreement.setToolCode("JAKD");
        expectedRentalAgreement.setToolType("jackhammer");
        expectedRentalAgreement.setToolBrand("DeWalt");
        expectedRentalAgreement.setRentalDays(6);
        expectedRentalAgreement.setCheckoutDate(CheckoutUtils.getDateFormatter().parse("9/3/15"));
        expectedRentalAgreement.setDueDate(CheckoutUtils.getDateFormatter().parse("9/9/15"));
        expectedRentalAgreement.setDailyCharge(2.99);
        expectedRentalAgreement.setChargedDays(3);
        expectedRentalAgreement.setPreDiscountCharge(8.97);
        expectedRentalAgreement.setDiscountPercentage(0);
        expectedRentalAgreement.setDiscountAmount(0.0);
        expectedRentalAgreement.setFinalCharge(8.97);

        RentalAgreement actualRentalAgreement = rentalAgreementController.checkout("JAKD", 6, 0, "9/3/15");

        Assertions.assertEquals(expectedRentalAgreement, actualRentalAgreement);
    }

    @Test
    public void test5() throws ParseException {
        RentalAgreement expectedRentalAgreement = new RentalAgreement();
        expectedRentalAgreement.setToolCode("JAKR");
        expectedRentalAgreement.setToolType("jackhammer");
        expectedRentalAgreement.setToolBrand("Ridgid");
        expectedRentalAgreement.setRentalDays(9);
        expectedRentalAgreement.setCheckoutDate(CheckoutUtils.getDateFormatter().parse("7/2/15"));
        expectedRentalAgreement.setDueDate(CheckoutUtils.getDateFormatter().parse("7/11/15"));
        expectedRentalAgreement.setDailyCharge(2.99);
        expectedRentalAgreement.setChargedDays(5);
        expectedRentalAgreement.setPreDiscountCharge(14.95);
        expectedRentalAgreement.setDiscountPercentage(0);
        expectedRentalAgreement.setDiscountAmount(0.0);
        expectedRentalAgreement.setFinalCharge(14.95);

        RentalAgreement actualRentalAgreement = rentalAgreementController.checkout("JAKR", 9, 0, "7/2/15");

        Assertions.assertEquals(expectedRentalAgreement, actualRentalAgreement);
    }

    @Test
    public void test6() throws ParseException {
        RentalAgreement expectedRentalAgreement = new RentalAgreement();
        expectedRentalAgreement.setToolCode("JAKR");
        expectedRentalAgreement.setToolType("jackhammer");
        expectedRentalAgreement.setToolBrand("Ridgid");
        expectedRentalAgreement.setRentalDays(4);
        expectedRentalAgreement.setCheckoutDate(CheckoutUtils.getDateFormatter().parse("7/2/20"));
        expectedRentalAgreement.setDueDate(CheckoutUtils.getDateFormatter().parse("7/6/20"));
        expectedRentalAgreement.setDailyCharge(2.99);
        expectedRentalAgreement.setChargedDays(1);
        expectedRentalAgreement.setPreDiscountCharge(2.99);
        expectedRentalAgreement.setDiscountPercentage(50);
        expectedRentalAgreement.setDiscountAmount(1.50);
        expectedRentalAgreement.setFinalCharge(1.49);

        RentalAgreement actualRentalAgreement = rentalAgreementController.checkout("JAKR", 4, 50, "7/2/20");

        Assertions.assertEquals(expectedRentalAgreement, actualRentalAgreement);
    }



}
