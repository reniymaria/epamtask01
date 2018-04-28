package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;


public class LaptopParser implements Parser {


    @Override
    public Appliance addProduct(String str) {
        String critLine = str.trim();
        Laptop laptop = new Laptop();
        critLine = critLine.replaceAll(";", "");
        String[] criteriaAndValues = critLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.Laptop criteria = SearchCriteria.Laptop.valueOf(splitCriteria[0]);
            switch (criteria) {
                case BATTERY_CAPACITY:
                    laptop.setBatteryCapacity(Double.parseDouble(splitCriteria[1]));
                    break;
                case OS:
                    laptop.setOs(splitCriteria[1]);
                    break;
                case MEMORY_ROM:
                    laptop.setMemoryRom(Integer.parseInt(splitCriteria[1]));
                    break;
                case SYSTEM_MEMORY:
                    laptop.setSystemMemory(Integer.parseInt(splitCriteria[1]));
                    break;
                case CPU:
                    laptop.setCpu(Double.parseDouble(splitCriteria[1]));
                    break;
                case DISPLAY_INCHES:
                    laptop.setDisplayInches(Integer.parseInt(splitCriteria[1]));
                    break;
            }

        }
        return laptop;
    }
}
