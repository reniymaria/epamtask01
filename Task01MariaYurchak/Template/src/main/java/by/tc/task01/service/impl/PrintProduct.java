package by.tc.task01.service.impl;

import by.tc.task01.entity.*;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class PrintProduct {
    private List<Appliance> products;

    public PrintProduct(List<Appliance> products) {
        this.products = products;
    }

    public void printByCategoryName(String categoryName) {
        List<Appliance> smthToPrint = new ArrayList<>();

        for (Appliance product : products) {
            if (categoryName.equalsIgnoreCase(product.getProductName())) {
                smthToPrint.add(product);
            }
        }
        System.out.println(Validator.messageNothingFound(smthToPrint));
        System.out.println(smthToPrint.toString());
    }
}
