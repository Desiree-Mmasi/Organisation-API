package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp () throws Exception {
    }

    @Test
    public void newNews_getsCorrectlyCreated()
        throws Exception{
        News news = new News("Kim",2,"All the workers are needed for the luncheon");
        assertEquals(true, news instanceof News);
    }

    @Test
    public void deleteNews_getsCorrectlyDeleted()
        throws Exception{
        News news = new News("Kim",2,"All workers are needed for the luncheon");
    }
    @After
    public void tearDown () throws Exception {
    }
}