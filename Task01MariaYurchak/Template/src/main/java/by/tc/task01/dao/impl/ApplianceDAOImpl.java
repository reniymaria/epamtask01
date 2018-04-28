package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApplianceDAOImpl implements ApplianceDAO {

    private Appliance appliance = new Appliance();
    private List<Appliance> findProducts = new ArrayList<>();

    @Override
    public <E> void find(Criteria<E> criteria) {
        String categoryOfGoods = criteria.getGroupSearchName().getSimpleName();
        switch (categoryOfGoods) {
            case "Laptop":
                appliance.setProductName("Laptop");
                Map<SearchCriteria.Laptop, Object> criteriaLaptop = (Map<SearchCriteria.Laptop, Object>) criteria.getCriteria();
                LaptopDao laptopDao = new LaptopDao();
                findProducts.addAll(laptopDao.find(criteriaLaptop));
                break;
            case "Newspaper":
                appliance.setProductName("Newspaper");
                Map<SearchCriteria.Newspaper, Object> criteriaNewspaper = (Map<SearchCriteria.Newspaper, Object>) criteria.getCriteria();
                NewspaperDao newspaperDao = new NewspaperDao();
                findProducts.addAll(newspaperDao.find(criteriaNewspaper));
                break;
            case "Oven":
                appliance.setProductName("Oven");
                Map<SearchCriteria.Oven, Object> criteriaOven = (Map<SearchCriteria.Oven, Object>) criteria.getCriteria();
                OvenDao ovenDao = new OvenDao();
                findProducts.addAll(ovenDao.find(criteriaOven));
                break;
            case "Refrigerator":
                appliance.setProductName("Refrigerator");
                Map<SearchCriteria.Refrigerator, Object> criteriaRefrigerator = (Map<SearchCriteria.Refrigerator, Object>) criteria.getCriteria();
                RefrigeratorDao refrigeratorDao = new RefrigeratorDao();
                findProducts.addAll(refrigeratorDao.find(criteriaRefrigerator));
                break;
            case "Speakers":
                appliance.setProductName("Speakers");
                Map<SearchCriteria.Speakers, Object> criteriaSpeakers = (Map<SearchCriteria.Speakers, Object>) criteria.getCriteria();
                SpeakersDao speakersDao = new SpeakersDao();
                findProducts.addAll(speakersDao.find(criteriaSpeakers));
                break;
            case "TabletPC":
                appliance.setProductName("TabletPC");
                Map<SearchCriteria.TabletPC, Object> criteriaTabletPC = (Map<SearchCriteria.TabletPC, Object>) criteria.getCriteria();
                TabletPCDao tabletPCDao = new TabletPCDao();
                findProducts.addAll(tabletPCDao.find(criteriaTabletPC));
                break;
            case "TextBook":
                appliance.setProductName("TextBook");
                Map<SearchCriteria.TextBook, Object> criteriaTextBook = (Map<SearchCriteria.TextBook, Object>) criteria.getCriteria();
                TextBookDao textBookDao = new TextBookDao();
                findProducts.addAll(textBookDao.find(criteriaTextBook));
                break;
            case "VacuumCleaner":
                appliance.setProductName("VacuumCleaner");
                Map<SearchCriteria.VacuumCleaner, Object> criteriaVacuumCleaner = (Map<SearchCriteria.VacuumCleaner, Object>) criteria.getCriteria();
                VacuumCleanerDao vacuumCleanerDao = new VacuumCleanerDao();
                findProducts.addAll(vacuumCleanerDao.find(criteriaVacuumCleaner));
                break;
        }
    }

    @Override
    public List<Appliance> getFindProducts() {
        return findProducts;
    }


    @Override
    public Appliance getFind() {
        return appliance;
    }

}
