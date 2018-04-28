package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance {
    private int powerConsumption;
    private int weight;
    private int freezerCopacity;
    private double overallCapacity;
    private int height;
    private int width;

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezerCopacity() {
        return freezerCopacity;
    }

    public void setFreezerCopacity(int freezerCopacity) {
        this.freezerCopacity = freezerCopacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption &&
                weight == that.weight &&
                freezerCopacity == that.freezerCopacity &&
                Double.compare(that.overallCapacity, overallCapacity) == 0 &&
                height == that.height &&
                width == that.width;
    }

    @Override
    public int hashCode() {

        return Objects.hash(powerConsumption, weight, freezerCopacity, overallCapacity, height, width);
    }

    @Override
    public String toString() {
        return "Refrigerator: " +
                "powerConsumption = " + powerConsumption +
                ", weight = " + weight +
                ", freezerCopacity = " + freezerCopacity +
                ", overallCapacity = " + overallCapacity +
                ", height=" + height +
                ", width=" + width;
    }
}
