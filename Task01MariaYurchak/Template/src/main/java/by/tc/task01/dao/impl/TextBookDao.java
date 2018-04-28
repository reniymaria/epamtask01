package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TextBook;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextBookDao {

    public static final String TITLE = "TITLE";
    public static final String SUBJECT = "SUBJECT";
    public static final String AUTHOR = "AUTHOR";
    public static final String NUMBER_OF_PAGES = "Number_OF_PAGES";

    public List<TextBook> find(Map<SearchCriteria.TextBook, Object> criteriaTextBook) {
        List<TextBook> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<TextBook> textBooks = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof TextBook) {
                TextBook textBook = (TextBook) appliance;
                textBooks.add(textBook);
            }
        }
        for (TextBook textBook : textBooks) {
            for (Map.Entry<SearchCriteria.TextBook, Object> item : criteriaTextBook.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case TITLE:
                        if (item.getValue().toString().equalsIgnoreCase(textBook.getTitle())) {
                            resultSearch.add(textBook);
                        }
                        break;
                    case SUBJECT:
                        if (item.getValue().toString().equalsIgnoreCase(textBook.getSubject())) {
                            resultSearch.add(textBook);
                        }
                        break;
                    case AUTHOR:
                        if (item.getValue().toString().equalsIgnoreCase(textBook.getAuthor())) {
                            resultSearch.add(textBook);
                        }
                        break;
                    case NUMBER_OF_PAGES:
                        if (asInteger(item.getValue()) == textBook.getNumberOfPage()) {
                            resultSearch.add(textBook);
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