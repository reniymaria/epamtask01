package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LaptopDao {


    public static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    public static final String OS = "OS";
    public static final String MEMORY_ROM = "MEMORY_ROM";
    public static final String CPU = "CPU";
    public static final String DISPLAY_INCHES = "DISPLAY_INCHES";

    public List<Laptop> find(Map<SearchCriteria.Laptop, Object> criteriaLaptop) {

        List<Laptop> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        ArrayList<Laptop> laptops = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Laptop) {
                Laptop laptop = (Laptop) appliance;
                laptops.add(laptop);
            }
        }
        for (Laptop laptop : laptops) {
            for (Map.Entry<SearchCriteria.Laptop, Object> item : criteriaLaptop.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case BATTERY_CAPACITY:
                        if (asDouble(item.getValue()) == laptop.getBatteryCapacity()) {
                            resultSearch.add(laptop);
                        }
                        break;
                    case OS:
                        if (item.getValue().toString().equalsIgnoreCase(laptop.getOs())) {
                            resultSearch.add(laptop);
                        }
                        break;
                    case MEMORY_ROM:
                        if (asInteger(item.getValue()) == laptop.getMemoryRom()) {
                            resultSearch.add(laptop);
                        }
                        break;
                    case CPU:
                        if (asDouble(item.getValue()) == laptop.getCpu()) {
                            resultSearch.add(laptop);
                        }
                        break;
                    case DISPLAY_INCHES:
                        if (asInteger(item.getValue()) == laptop.getDisplayInches()) {
                            resultSearch.add(laptop);
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
