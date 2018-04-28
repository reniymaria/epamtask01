package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Newspaper;
import by.tc.task01.entity.criteria.SearchCriteria;

public class NewspaperParser implements Parser {
    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        Newspaper newspaper = new Newspaper();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.Newspaper criteria = SearchCriteria.Newspaper.valueOf(splitCriteria[0]);
            switch (criteria) {
                case TITLE:
                    newspaper.setTitle(splitCriteria[1]);
                    break;
                case PERIODICITY:
                    newspaper.setPeriodicity(splitCriteria[1]);
                    break;
                case PAID_OR_FREE:
                    newspaper.setPaidFree(splitCriteria[1]);
                    break;
            }

        }
        return newspaper;
    }
}
