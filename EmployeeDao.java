package com.mondee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	
	/*@Autowired
	private SessionFactory sessionFactory;
	
	 public void insert(Employee ee) {
		Session se=sessionFactory.openSession();
		Transaction tx=se.beginTransaction();
		se.save(ee);
		tx.commit(); 
		
	}*/ 
	@Autowired
	private Session se;
	public void insert(Employee e)
	{
		Transaction tx = se.beginTransaction();
		se.save(e);

		tx.commit();
	}



	public void delete(int id)
	{
		Transaction tx = se.beginTransaction();

		Employee e=se.find(Employee.class, id); 
		se.remove(e);  

		tx.commit();
	}

	public void select()
	{
		//Session se=sessionFactory.openSession();
		Query qr=se.createQuery("from Employee s");

		List li=qr.list();
		Iterator i=li.iterator();

		while(i.hasNext())
		{
			Employee e=(Employee) i.next();
			// System.out.println(s.getId()+" "+s.getName()+" "+s.getSalary());
			System.out.println(e);
		}

//		Transaction tx=se.beginTransaction();
//		tx.commit();
	}
	
	

}
