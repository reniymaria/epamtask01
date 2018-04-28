package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

    public static void main(String[] args) {

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        //////////////////////////////////////////////////////////////////

        Criteria<Laptop> criteriaLaptop = new Criteria<Laptop>(Laptop.class);
        criteriaLaptop.add(Laptop.BATTERY_CAPACITY, 1);
        service.find(criteriaLaptop);

        System.out.println("Laptop: ");
        PrintApplianceInfo.print(criteriaLaptop, service);

        //////////////////////////////////////////////////////////////////
        Criteria<Newspaper> criteriaNewspaper = new Criteria<Newspaper>(Newspaper.class);
        criteriaNewspaper.add(Newspaper.TITLE, "NewYorker");
        service.find(criteriaNewspaper);

        System.out.println("Newspaper: ");
        PrintApplianceInfo.print(criteriaNewspaper, service);
        //////////////////////////////////////////////////////////////////
        Criteria<Oven> criteriaOven = new Criteria<>(Oven.class);
        criteriaOven.add(Oven.CAPACITY, 33);
        service.find(criteriaOven);

        System.out.println("Oven: ");
        PrintApplianceInfo.print(criteriaOven, service);
        //////////////////////////////////////////////////////////////////
        Criteria<Refrigerator> criteriaRefrigerator = new Criteria<>(Refrigerator.class);
        criteriaRefrigerator.add(Refrigerator.WIDTH, 70);
        service.find(criteriaRefrigerator);

        System.out.println("Refrigerator: ");
        PrintApplianceInfo.print(criteriaRefrigerator, service);
        //////////////////////////////////////////////////////////////////
        Criteria<VacuumCleaner> vacuumCleanerCriteria = new Criteria<>(VacuumCleaner.class);
        vacuumCleanerCriteria.add(VacuumCleaner.POWER_CONSUMPTION, 80);
        service.find(vacuumCleanerCriteria);

        System.out.println("Vacuum Cleaner");
        PrintApplianceInfo.print(vacuumCleanerCriteria, service);

    }

}
