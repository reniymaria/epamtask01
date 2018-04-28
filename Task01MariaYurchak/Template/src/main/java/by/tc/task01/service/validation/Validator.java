package by.tc.task01.service.validation;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public class Validator {

    private static final String NOTHING_IS_FOUND = "Nothing is found";
    private static final String RESULT_OF_SEARCH = "Result of search: ";

    public static <E> String criteriaValidator(Criteria<E> criteria) {
        String nameOfCategory = criteria.getGroupSearchName().getSimpleName();
        if (checkIfCategoryExist(nameOfCategory)) {
            return nameOfCategory;
        }
        return null;
    }

    private static boolean checkIfCategoryExist(String name) {
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> names = parsingLine.getProducts();
        for (Appliance appliance : names) {
            if (appliance.getProductName().equalsIgnoreCase(name)) {
                return true;
            }

        }
        return false;
    }

    public static <E> String messageNothingFound(List<E> product) {
        if (product.size() < 1) {
            return NOTHING_IS_FOUND;
        } else return RESULT_OF_SEARCH;
    }

}