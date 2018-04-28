package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    private static final String CATEGORY_NOT_FOUND = "Category Not found";
    private List<Appliance> findProducts = new ArrayList<>();

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        applianceDAO.find(criteria);
        if (Validator.criteriaValidator(criteria) != null) {
            findProducts = applianceDAO.getFindProducts();
        } else {
            System.out.println(CATEGORY_NOT_FOUND);
            return null;
        }
        return applianceDAO.getFind();
    }

    @Override
    public <E> void printFindProduct(Criteria<E> criteria) {
        String nameOfCategory = criteria.getGroupSearchName().getSimpleName();
        new PrintProduct(findProducts).printByCategoryName(nameOfCategory);
    }

}

