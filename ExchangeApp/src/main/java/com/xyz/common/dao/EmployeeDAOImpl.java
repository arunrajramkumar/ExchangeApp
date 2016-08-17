package com.xyz.common.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.common.model.Employee;

 

public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {
   
    
		public EmployeeDAOImpl(){
	    
	}
   
 
    @Override
    @Transactional
    public List<Employee> list() {
        @SuppressWarnings("unchecked")
        List<Employee> listUser = (List<Employee>) getHibernateTemplate().find("from Employee ");
                /*.createCriteria(Employee.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
 
        return listUser;
    }
 
    @Override
    @Transactional
    public void saveOrUpdate(Employee user) {
       /* sessionFactory.getCurrentSession().saveOrUpdate(user);*/
    }
 
    @Override
    @Transactional
    public void delete(int id) {
    	/*Employee userToDelete = new Employee();
        userToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(userToDelete);*/
    }
 
    @Override
    @Transactional
    public Employee get(int id) {
       /* String hql = "from User where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Employee> listUser = (List<Employee>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        } */
         
        return null;
   }
}