package by.tc.task01.dao.impl.fileparsing.parsermpl;

import by.tc.task01.dao.impl.fileparsing.Parser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

public class SpeakersParser implements Parser {

    @Override
    public Appliance addProduct(String str) {
        String criteriaLine = str.trim();
        Speakers speaker = new Speakers();
        criteriaLine = criteriaLine.replaceAll(";", "");
        String[] criteriaAndValues = criteriaLine.split(",");
        for (String s : criteriaAndValues) {
            String[] splitCriteria = s.trim().split("=");
            SearchCriteria.Speakers criteria = SearchCriteria.Speakers.valueOf(splitCriteria[0]);
            switch (criteria) {
                case POWER_CONSUMPTION:
                    speaker.setPowerConsumption(Integer.parseInt(splitCriteria[1]));
                    break;
                case NUMBER_OF_SPEAKERS:
                    speaker.setNumberOfSpeakers(Integer.parseInt(splitCriteria[1]));
                    break;
                case FREQENCY_RANGE:
                    speaker.setFreqencyRange(splitCriteria[1]);
                    break;
                case CORD_LENGTH:
                    speaker.setCordLength(Integer.parseInt(splitCriteria[1]));
                    break;
            }

        }
        return speaker;
    }
}
