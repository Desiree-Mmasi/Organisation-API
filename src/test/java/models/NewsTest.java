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
        News news = new News("Kim","Finance","All the workers are needed for the luncheon");
        assertEquals(true, news instanceof News);
    }
    @After
    public void tearDown () throws Exception {
    }
}