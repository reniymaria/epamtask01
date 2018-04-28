package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.fileparsing.FileReading;
import by.tc.task01.dao.impl.fileparsing.ParsingLine;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeakersDao {


    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String NUMBER_OF_SPEAKERS = "NUMBER_OF_SPEAKERS";
    public static final String FREQENCY_RANGE = "FREQENCY_RANGE";
    public static final String CORD_LENGTH = "CORD_LENGTH";

    public List<Speakers> find(Map<SearchCriteria.Speakers, Object> criteriaSpeakers) {

        List<Speakers> resultSearch = new ArrayList<>();
        FileReading fileReading = new FileReading();
        fileReading.readFile();
        ParsingLine parsingLine = fileReading.getParsingLine();
        List<Appliance> appliances = parsingLine.getProducts();
        List<Speakers> speakerses = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Speakers) {
                Speakers speaker = (Speakers) appliance;
                speakerses.add(speaker);
            }
        }
        for (Speakers speak : speakerses) {
            for (Map.Entry<SearchCriteria.Speakers, Object> item : criteriaSpeakers.entrySet()) {
                String searchCriteria = item.getKey().toString();
                switch (searchCriteria) {
                    case POWER_CONSUMPTION:
                        if (asInteger(item.getValue()) == speak.getPowerConsumption()) {
                            resultSearch.add(speak);
                        }
                        break;
                    case NUMBER_OF_SPEAKERS:
                        if (asInteger(item.getValue()) == speak.getNumberOfSpeakers()) {
                            resultSearch.add(speak);
                        }
                        break;
                    case FREQENCY_RANGE:
                        if (item.getValue().toString().equalsIgnoreCase(speak.getFreqencyRange())) {
                            resultSearch.add(speak);
                        }
                        break;
                    case CORD_LENGTH:
                        if (asInteger(item.getValue()) == speak.getCordLength()) {
                            resultSearch.add(speak);
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