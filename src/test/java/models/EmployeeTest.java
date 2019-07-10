package models;

import models.Employees;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
    }

    @Test
    public void newEmployee_ObjectGetsCorrectlyCreated()
        throws Exception{
        Employees employees = new Employees("John", "Finance", "Manager");
        assertEquals(true, employees instanceof Employees );
    }

    @Test
    public void newNewsByEmployee_ObjectGetsCorrectlyCreated()
        throws Exception{
        News news = new News("John", "Finance","There will be an annual general meeting at the end of the year on 12th");
        assertEquals(true, news instanceof News);
    }
}