package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OvenDao {

    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String WEIGHT = "WEIGHT";
    public static final String CAPACITY = "CAPACITY";
    public static final String DEPTH = "DEPTH";
    public static final String HEIGHT = "HEIGHT";
    public static final String WIDTH = "WIDTH";

    public List<Oven> find(Map<SearchCriteria.Oven, Object> criteriaOven) {

        List<Oven> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<Oven> ovens = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Oven) {
                Oven oven = (Oven) appliance;
                ovens.add(oven);
            }
        }
        for (Oven oven : ovens) {
            for (Map.Entry<SearchCriteria.Oven, Object> item : criteriaOven.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case POWER_CONSUMPTION:
                        if (asInteger(item.getValue()) == oven.getPowerConsumption()) {
                            resultSearch.add(oven);
                        }
                        break;
                    case WEIGHT:
                        if (asInteger(item.getValue()) == oven.getWeight()) {
                            resultSearch.add(oven);
                        }
                        break;
                    case CAPACITY:
                        if (asInteger(item.getValue()) == oven.getCapacity()) {
                            resultSearch.add(oven);
                        }
                        break;
                    case DEPTH:
                        if (asInteger(item.getValue()) == oven.getDepth()) {
                            resultSearch.add(oven);
                        }
                        break;
                    case HEIGHT:
                        if (asDouble(item.getValue()) == oven.getHeight()) {
                            resultSearch.add(oven);
                        }
                        break;
                    case WIDTH:
                        if (asDouble(item.getValue()) == oven.getWidth()) {
                            resultSearch.add(oven);
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
