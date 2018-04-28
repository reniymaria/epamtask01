package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC extends Appliance {

    private int batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private String color;

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return batteryCapacity == tabletPC.batteryCapacity &&
                displayInches == tabletPC.displayInches &&
                memoryRom == tabletPC.memoryRom &&
                flashMemoryCapacity == tabletPC.flashMemoryCapacity &&
                Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return "TabletPC: " +
                "batteryCapacity = " + batteryCapacity +
                ", displayInches = " + displayInches +
                ", memoryRom = " + memoryRom +
                ", flashMemoryCapacity = " + flashMemoryCapacity +
                ", color = " + color;
    }
}
