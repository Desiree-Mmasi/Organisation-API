package models;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
    }
    @Test
    public void newDepartment_ObjectGetsCreatedCorrectly()
        throws Exception{
        Department department = new Department("Finance",15,"This is a department that deals with money matters and essentially everything that entails the economy of the company");
        assertEquals(true, department instanceof Department);
    }
}