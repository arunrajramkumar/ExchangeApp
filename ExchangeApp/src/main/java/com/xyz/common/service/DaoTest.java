package com.xyz.common.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.xyz.common.dao.EmployeeDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {
		"classpath:exchange-db.xml"
} )
public class DaoTest extends AbstractJUnit4SpringContextTests
{
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	
	@Test
	public void find() throws ParserConfigurationException, SAXException, IOException
	{
		
		System.out.println(employeeDao.list().get(0).getId());
		
	}
	
	
}
