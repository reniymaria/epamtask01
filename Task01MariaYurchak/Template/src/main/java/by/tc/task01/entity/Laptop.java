package by.tc.task01.entity;

import java.util.Objects;

public class Laptop extends Appliance{


    private double batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.batteryCapacity, batteryCapacity) == 0 &&
                memoryRom == laptop.memoryRom &&
                systemMemory == laptop.systemMemory &&
                Double.compare(laptop.cpu, cpu) == 0 &&
                displayInches == laptop.displayInches &&
                os.equalsIgnoreCase(laptop.os);
    }

    @Override
    public int hashCode() {

        return Objects.hash(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
    }

    @Override
    public String toString() {
        return "Laptop: " +
                "Battery Capacity = " + batteryCapacity +
                ", os = '" + os + '\'' +
                ", memory Rom = " + memoryRom +
                ", system Memory = " + systemMemory +
                ", cpu = " + cpu +
                ", display Inches = " + displayInches;
    }
}
