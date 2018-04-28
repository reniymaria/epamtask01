package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

public class VacuumCleanerParser implements Parser {

    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.VacuumCleaner criteria = SearchCriteria.VacuumCleaner.valueOf(splitCriteria[0]);
            switch (criteria) {
                case POWER_CONSUMPTION:
                    vacuumCleaner.setPowerConsumption(Integer.parseInt(splitCriteria[1]));
                    break;
                case FILTER_TYPE:
                    vacuumCleaner.setFilterType(splitCriteria[1]);
                    break;
                case BAG_TYPE:
                    vacuumCleaner.setBagType(splitCriteria[1]);
                    break;
                case WAND_TYPE:
                    vacuumCleaner.setWandType(splitCriteria[1]);
                    break;
                case MOTOR_SPEED_REGULATION:
                    vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(splitCriteria[1]));
                    break;
                case CLEANING_WIDTH:
                    vacuumCleaner.setCleaningWidth(Integer.parseInt(splitCriteria[1]));
                    break;
            }
        }
        return vacuumCleaner;
    }
}
