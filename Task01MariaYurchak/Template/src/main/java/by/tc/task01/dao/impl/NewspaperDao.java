package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Newspaper;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewspaperDao {

    public static final String TITLE = "TITLE";
    public static final String PERIODICITY = "PERIODICITY";
    public static final String PAID_OR_FREE = "PAID_OR_FREE";

    public List<Newspaper> find(Map<SearchCriteria.Newspaper, Object> criteriaNewspaper) {

        List<Newspaper> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<Newspaper> newspapers = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) appliance;
                newspapers.add(newspaper);
            }
        }
        for (Newspaper newspaper : newspapers) {
            for (Map.Entry<SearchCriteria.Newspaper, Object> item : criteriaNewspaper.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case TITLE:
                        if (item.getValue().toString().equalsIgnoreCase(newspaper.getTitle())) {
                            resultSearch.add(newspaper);
                        }
                        break;
                    case PERIODICITY:
                        if (item.getValue().toString().equalsIgnoreCase(newspaper.getPeriodicity())) {
                            resultSearch.add(newspaper);
                        }
                        break;
                    case PAID_OR_FREE:
                        if (item.getValue().toString().equalsIgnoreCase(newspaper.getPaidFree())) {
                            resultSearch.add(newspaper);
                        }
                        break;
                }
            }

        }
        return resultSearch;
    }

}
