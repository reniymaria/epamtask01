package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

public class RefrigeratorParser implements Parser {

    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        Refrigerator friger = new Refrigerator();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.Refrigerator criteria = SearchCriteria.Refrigerator.valueOf(splitCriteria[0]);
            switch (criteria) {
                case POWER_CONSUMPTION:
                    friger.setPowerConsumption(Integer.parseInt(splitCriteria[1]));
                    break;
                case WEIGHT:
                    friger.setWeight(Integer.parseInt(splitCriteria[1]));
                    break;
                case FREEZER_CAPACITY:
                    friger.setFreezerCopacity(Integer.parseInt(splitCriteria[1]));
                    break;
                case OVERALL_CAPACITY:
                    friger.setOverallCapacity(Double.parseDouble(splitCriteria[1]));
                    break;
                case HEIGHT:
                    friger.setHeight(Integer.parseInt(splitCriteria[1]));
                    break;
                case WIDTH:
                    friger.setWidth(Integer.parseInt(splitCriteria[1]));
                    break;
            }
        }
        return friger;
    }
}
