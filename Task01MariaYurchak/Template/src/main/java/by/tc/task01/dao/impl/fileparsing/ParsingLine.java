package by.tc.task01.dao.impl.fileparsing;

import by.tc.task01.dao.impl.fileparsing.parsermpl.*;
import by.tc.task01.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParsingLine {

    private List<Appliance> products = new ArrayList<>();
    private Map<String, Parser> map = new HashMap<>();

    public ParsingLine() {
        map.put("Laptop", new LaptopParser());
        map.put("Newspaper", new NewspaperParser());
        map.put("Oven", new OvenParser());
        map.put("Refrigerator", new RefrigeratorParser());
        map.put("Speakers", new SpeakersParser());
        map.put("TabletPC", new TabletPCParser());
        map.put("TextBook", new TextBoookParser());
        map.put("VacuumCleaner", new VacuumCleanerParser());
    }

    public void parseAll(String line) {
        String[] oneLine = line.split(":");
        String tempName = oneLine[0].trim();
        Parser parser = map.get(tempName);
        Appliance appliance = parser.addProduct(oneLine[1]);
        appliance.setProductName(tempName);
        products.add(appliance);
    }

    public List<Appliance> getProducts() {
        return products;
    }
}
