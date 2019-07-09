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
        Employee employee = new Employee("John", "Finance", "Manager");
        assertEquals(true, employee instanceof Employee );
    }
}