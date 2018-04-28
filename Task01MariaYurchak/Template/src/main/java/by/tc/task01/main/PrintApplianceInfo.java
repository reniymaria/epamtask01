package by.tc.task01.main;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;


public class PrintApplianceInfo {

    public static <E> void print(Criteria<E> criteria, ApplianceService service) {
        service.printFindProduct(criteria);
    }

}
