package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

public class OvenParser implements Parser {
    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        Oven oven = new Oven();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.Oven criteria = SearchCriteria.Oven.valueOf(splitCriteria[0]);
            switch (criteria) {
                case POWER_CONSUMPTION:
                    oven.setPowerConsumption(Integer.parseInt(splitCriteria[1]));
                    break;
                case WEIGHT:
                    oven.setWeight(Integer.parseInt(splitCriteria[1]));
                    break;
                case CAPACITY:
                    oven.setCapacity(Integer.parseInt(splitCriteria[1]));
                    break;
                case DEPTH:
                    oven.setDepth(Integer.parseInt(splitCriteria[1]));
                    break;
                case HEIGHT:
                    oven.setHeight(Double.parseDouble(splitCriteria[1]));
                    break;
                case WIDTH:
                    oven.setWidth(Double.parseDouble(splitCriteria[1]));
            }

        }
        return oven;
    }
}
