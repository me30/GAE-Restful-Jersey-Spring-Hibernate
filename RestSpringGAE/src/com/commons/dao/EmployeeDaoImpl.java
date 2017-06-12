package com.commons.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commons.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployeeModel(EmployeeModel employeeModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(employeeModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> viewEmployee() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeModel.class);
		return criteria.list();
	}

	@Override
	public EmployeeModel getEmployeeByEmail(String email) {
		System.out.println("in dao 1");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeModel.class);
		criteria.add(Restrictions.eq("email", email));
		return (EmployeeModel) criteria.uniqueResult();
	}

	@Override
	public void deleteEmployee(int id) {
		EmployeeModel userModel =getEmployeeById(id);
		sessionFactory.getCurrentSession().delete(userModel);
	}

	@Override
	public EmployeeModel getEmployeeById(int id) {
		return (EmployeeModel)sessionFactory.getCurrentSession().get(EmployeeModel.class, id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from EmployeeModel").executeUpdate();
	}

	@Override
	public void saveAllEmployeeModel(List<EmployeeModel> employeeModel) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for(EmployeeModel model:employeeModel)
		{
			session.saveOrUpdate(model);
			session.flush();
			session.clear();
		}
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getActive() {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeModel.class);
		criteria.add(Restrictions.eq("status","Active"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getDeactive() {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeModel.class);
		criteria.add(Restrictions.eq("status","Deactive"));
		return criteria.list();
	}
}
