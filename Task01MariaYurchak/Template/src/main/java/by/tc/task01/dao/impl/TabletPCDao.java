package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabletPCDao {

    public static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    public static final String DISPLAY_INCHES = "DISPLAY_INCHES";
    public static final String MEMORY_ROM = "MEMORY_ROM";
    public static final String FLASH_MEMORY_CAPACITY = "FLASH_MEMORY_CAPACITY";
    public static final String COLOR = "COLOR";

    public List<TabletPC> find(Map<SearchCriteria.TabletPC, Object> criteriaTabletPC) {
        List<TabletPC> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<TabletPC> tabletPCS = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof TabletPC) {
                TabletPC tabletPC = (TabletPC) appliance;
                tabletPCS.add(tabletPC);
            }
        }
        for (TabletPC tabletPC : tabletPCS) {
            for (Map.Entry<SearchCriteria.TabletPC, Object> item : criteriaTabletPC.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case BATTERY_CAPACITY:
                        if (asInteger(item.getValue()) == tabletPC.getBatteryCapacity()) {
                            resultSearch.add(tabletPC);
                        }
                        break;
                    case DISPLAY_INCHES:
                        if (asInteger(item.getValue()) == tabletPC.getDisplayInches()) {
                            resultSearch.add(tabletPC);
                        }
                        break;
                    case MEMORY_ROM:
                        if (asInteger(item.getValue()) == tabletPC.getMemoryRom()) {
                            resultSearch.add(tabletPC);
                        }
                        break;
                    case FLASH_MEMORY_CAPACITY:
                        if (asInteger(item.getValue()) == tabletPC.getFlashMemoryCapacity()) {
                            resultSearch.add(tabletPC);
                        }
                        break;
                    case COLOR:
                        if (item.getValue().toString().equalsIgnoreCase(tabletPC.getColor())) {
                            resultSearch.add(tabletPC);
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