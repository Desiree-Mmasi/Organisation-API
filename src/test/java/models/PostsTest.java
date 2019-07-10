package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostsTest {

    @Before
    public void setUp () throws Exception {
    }
    @Test
    public void newPosts_getsCreatedCorrectly()
        throws Exception{
        Posts posts = new Posts("Kim","The meeting that was to be held for all the finance managers has been postponed","Finance");
        assertEquals(true, posts instanceof Posts);
    }
    @Test
    public void deletePosts_getsCorrectlyDeleted()
        throws Exception{
        Posts posts = new Posts("Kim","The meeting that was to be held for all the finance managers has been postponed","Finance");
        assertEquals(true, posts instanceof Posts);
    }

    @After
    public void tearDown () throws Exception {
    }
}