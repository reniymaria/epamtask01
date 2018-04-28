package by.tc.task01.dao;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	<E> void find(Criteria<E> criteria);
	List<Appliance> getFindProducts();
	Appliance getFind();
}
