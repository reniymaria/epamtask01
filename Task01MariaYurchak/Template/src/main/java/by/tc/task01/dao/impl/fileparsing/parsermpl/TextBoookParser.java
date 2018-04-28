package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TextBook;
import by.tc.task01.entity.criteria.SearchCriteria;

public class TextBoookParser implements Parser {

    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        TextBook textBook = new TextBook();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.TextBook criteria = SearchCriteria.TextBook.valueOf(splitCriteria[0]);
            switch (criteria) {
                case TITLE:
                    textBook.setTitle(splitCriteria[1]);
                    break;
                case SUBJECT:
                    textBook.setSubject(splitCriteria[1]);
                    break;
                case AUTHOR:
                    textBook.setAuthor(splitCriteria[1]);
                    break;
                case Number_OF_PAGES:
                    textBook.setNumberOfPage(Integer.parseInt(splitCriteria[1]));
                    break;
            }
        }
        return textBook;
    }
}
