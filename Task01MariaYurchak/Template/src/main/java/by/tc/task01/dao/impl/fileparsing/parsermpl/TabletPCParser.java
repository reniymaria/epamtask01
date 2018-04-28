package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;


public class TabletPCParser implements Parser {
    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        TabletPC tabletPC = new TabletPC();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.TabletPC criteria = SearchCriteria.TabletPC.valueOf(splitCriteria[0]);
            switch (criteria) {
                case BATTERY_CAPACITY:
                    tabletPC.setBatteryCapacity(Integer.parseInt(splitCriteria[1]));
                    break;
                case DISPLAY_INCHES:
                    tabletPC.setDisplayInches(Integer.parseInt(splitCriteria[1]));
                    break;
                case MEMORY_ROM:
                    tabletPC.setMemoryRom(Integer.parseInt(splitCriteria[1]));
                    break;
                case FLASH_MEMORY_CAPACITY:
                    tabletPC.setFlashMemoryCapacity(Integer.parseInt(splitCriteria[1]));
                    break;
                case COLOR:
                    tabletPC.setColor(splitCriteria[1]);
                    break;
            }
        }
        return tabletPC;
    }
}
