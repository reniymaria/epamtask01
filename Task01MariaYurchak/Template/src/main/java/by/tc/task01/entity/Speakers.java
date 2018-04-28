package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance {

    private int powerConsumption;
    private int numberOfSpeakers;
    private String freqencyRange;
    private int cordLength;

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFreqencyRange() {
        return freqencyRange;
    }

    public void setFreqencyRange(String freqencyRange) {
        this.freqencyRange = freqencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption &&
                numberOfSpeakers == speakers.numberOfSpeakers &&
                cordLength == speakers.cordLength &&
                Objects.equals(freqencyRange, speakers.freqencyRange);
    }

    @Override
    public int hashCode() {

        return Objects.hash(powerConsumption, numberOfSpeakers, freqencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers: " +
                "powerConsumption = " + powerConsumption +
                ", numberOfSpeakers = " + numberOfSpeakers +
                ", freqencyRange = '" + freqencyRange + '\'' +
                ", cordLength = " + cordLength;
    }
}
