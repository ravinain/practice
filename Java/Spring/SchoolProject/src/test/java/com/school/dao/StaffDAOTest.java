package com.school.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.school.dao.StaffDAO;
import org.school.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/WEB-INF/config/hibernate-config.xml", "/WEB-INF/config/servlet-config.xml",
		"/WEB-INF/config/security-config.xml" })
@TransactionConfiguration(transactionManager="txManager")
public class StaffDAOTest {

	@Autowired
	StaffDAO staffDao;
	
	@Test
	@Transactional
	public void testGetAllStaffs(){
		List<Staff> staffs = staffDao.getStaffs();
		System.out.println(staffs);
	}
}
