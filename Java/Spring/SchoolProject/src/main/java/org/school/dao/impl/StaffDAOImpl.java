package org.school.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.school.dao.StaffDAO;
import org.school.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="staffRepo")
public class StaffDAOImpl implements StaffDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Staff addStaff(Staff staff) {
		Session session = sessionFactory.getCurrentSession();
		session.save(staff);
		return staff;
	}

	public void deleteStaff(int id) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, id);
		session.delete(staff);
	}

	public Staff getStaff(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Staff) session.get(Staff.class, id);
	}

	public Staff getStaff(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Staff> staffs = session.createCriteria(Staff.class).add(Restrictions.eq("name", name)).list();
		return staffs.isEmpty()?null:staffs.get(0);
	}
	
	public List<Staff> getStaffs() {
		Session session = sessionFactory.getCurrentSession();
		return new ArrayList<Staff>(new LinkedHashSet<Staff>(session.createCriteria(Staff.class).list()));
	}

	public boolean isStaffExists(int id) {
		return this.getStaff(id) != null;
	}

	public boolean isStaffExists(String name) {
		return getStaff(name) != null;
	}

	public Staff updateStaff(Staff staff) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(staff);
		return staff;
	}

}
