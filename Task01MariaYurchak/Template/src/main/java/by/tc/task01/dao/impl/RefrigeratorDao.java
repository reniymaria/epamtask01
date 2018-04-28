package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RefrigeratorDao {

    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String WEIGHT = "WEIGHT";
    public static final String FREEZER_CAPACITY = "FREEZER_CAPACITY";
    public static final String OVERALL_CAPACITY = "OVERALL_CAPACITY";
    public static final String HEIGHT = "HEIGHT";
    public static final String WIDTH = "WIDTH";

    public List<Refrigerator> find(Map<SearchCriteria.Refrigerator, Object> criteriaRefrigerator) {

        List<Refrigerator> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<Refrigerator> refrigerators = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Refrigerator) {
                Refrigerator frig = (Refrigerator) appliance;
                refrigerators.add(frig);
            }
        }
        for (Refrigerator refry : refrigerators) {
            for (Map.Entry<SearchCriteria.Refrigerator, Object> item : criteriaRefrigerator.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case POWER_CONSUMPTION:
                        if (asInteger(item.getValue()) == refry.getPowerConsumption()) {
                            resultSearch.add(refry);
                        }
                        break;
                    case WEIGHT:
                        if (asInteger(item.getValue()) == refry.getWeight()) {
                            resultSearch.add(refry);
                        }
                        break;
                    case FREEZER_CAPACITY:
                        if (asInteger(item.getValue()) == refry.getFreezerCopacity()) {
                            resultSearch.add(refry);
                        }
                        break;
                    case OVERALL_CAPACITY:
                        if (asDouble(item.getValue()) == refry.getOverallCapacity()) {
                            resultSearch.add(refry);
                        }
                        break;
                    case HEIGHT:
                        if (asInteger(item.getValue()) == refry.getHeight()) {
                            resultSearch.add(refry);
                        }
                        break;
                    case WIDTH:
                        if (asInteger(item.getValue()) == refry.getWidth()) {
                            resultSearch.add(refry);
                        }
                        break;
                }
            }

        }

        return resultSearch;
    }

    private Double asDouble(Object o) {
        Double val = null;
        if (o instanceof Number) {
            val = ((Number) o).doubleValue();
        }
        return val;
    }

    private Integer asInteger(Object o) {
        Integer val = null;
        if (o instanceof Number) {
            val = ((Number) o).intValue();
        }
        return val;
    }

}
