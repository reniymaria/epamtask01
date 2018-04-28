package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VacuumCleanerDao {

    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String FILTER_TYPE = "FILTER_TYPE";
    public static final String BAG_TYPE = "BAG_TYPE";
    public static final String WAND_TYPE = "WAND_TYPE";
    public static final String MOTOR_SPEED_REGULATION = "MOTOR_SPEED_REGULATION";
    public static final String CLEANING_WIDTH = "CLEANING_WIDTH";

    public List<VacuumCleaner> find(Map<SearchCriteria.VacuumCleaner, Object> criteriaVacuumCleaner) {
        List<VacuumCleaner> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof VacuumCleaner) {
                VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
                vacuumCleaners.add(vacuumCleaner);
            }
        }
        for (VacuumCleaner vacuumCleaner : vacuumCleaners) {
            for (Map.Entry<SearchCriteria.VacuumCleaner, Object> item : criteriaVacuumCleaner.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case POWER_CONSUMPTION:
                        if (asInteger(item.getValue()) == vacuumCleaner.getPowerConsumption()) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                    case FILTER_TYPE:
                        if (item.getValue().toString().equalsIgnoreCase(vacuumCleaner.getFilterType())) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                    case BAG_TYPE:
                        if (item.getValue().toString().equalsIgnoreCase(vacuumCleaner.getBagType())) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                    case WAND_TYPE:
                        if (item.getValue().toString().equalsIgnoreCase(vacuumCleaner.getWandType())) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                    case MOTOR_SPEED_REGULATION:
                        if (asInteger(item.getValue()) == vacuumCleaner.getMotorSpeedRegulation()) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                    case CLEANING_WIDTH:
                        if (asInteger(item.getValue()) == vacuumCleaner.getCleaningWidth()) {
                            resultSearch.add(vacuumCleaner);
                        }
                        break;
                }
            }

        }

        return resultSearch;
    }

    private Integer asInteger(Object o) {
        Integer val = null;
        if (o instanceof Number) {
            val = ((Number) o).intValue();
        }
        return val;
    }

}