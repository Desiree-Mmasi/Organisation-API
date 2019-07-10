//import Dao.Sql2oDepartmentDao;
//import Dao.Sql2oNewsDao;
//import models.Department;
//import models.Employees;
//import models.News;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.*;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import java.util.BitSet;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class Sql2oNewsDaoTest {
//    private static Connection conn;
//    private static Sql2oNewsDao newsDao;
//    private static Sql2oDepartmentDao departmentDao;
//
//    @BeforeClass
//    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postresql://localhost:5432/organisationapi";
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234");
//        newsDao = new Sql2oNewsDao(sql2o)
//        {
//            @Override
//            public void addNewsToDepartments (News news, Department department) {
//
//            }
//        };
//        departmentDao = new Sql2oDepartmentDao(sql2o) {
//            @Override
//            public List<Employees> getAllEmployeesForDepartments (int id) {
//                return null;
//            }
//        };
//        conn = sql2o.open();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        newsDao.clearAll();
//        departmentDao.clearAll();
//    }
//    @AfterClass
//    public static void shutDown() throws Exception{
//        conn.close();
//    }
//
//    @Test
//    public void addingNewsSetsId() throws Exception {
//        News testNews = setupNews();
//        assertEquals(1, testNews.getId());
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        News news1 = setupNews();
//        News news2 = setupNews();
//        assertEquals(2, newsDao.getAll().size());
//    }
//
//    @Test
//    public void getAllNewssByDepartment() throws Exception {
//        Department testDepartment = setupDepartment();
//        Department otherDepartment = setupDepartment();
//        News news1 = setupNewsForDepartment(testDepartment);
//        News news2 = setupNewsForDepartment(testDepartment);
//        News newsForOtherDepartment = setupNewsForDepartment(otherDepartment);
//        assertEquals(2, newsDao.getAll(testDepartment.getId()).size());
//    }
//
//    @Test
//    public void deleteById() throws Exception {
//        News testNews = setupNews();
//        News otherNews = setupNews();
//        assertEquals(2, newsDao.getAll().size());
//        newsDao.deleteById(testNews.getId());
//        assertEquals(1, newsDao.getAll().size());
//    }
//
//    @Test
//    public void clearAll() throws Exception {
//        News testNews = setupNews();
//        News otherNews = setupNews();
//        newsDao.clearAll();
//        assertEquals(0, newsDao.getAll().size());
//    }
//
//    //helpers
//
//    public News setupNews() {
//        News news = new News("Kim", "Finance", "All the finance workers are required for a meeting");
//        newsDao.add(news);
//        return news;
//    }
//
//    public News setupNewsForDepartment(Department department) {
//        News news = new News("Kim", "Human Resource", "The department is expected for a brief meet up");
//        newsDao.add(news);
//        return news;
//    }
//
//    public Department setupDepartment() {
//        Department department = new Department("Human Resource", 13, "Everyone is expected to be in the boardroom");
//        departmentDao.add(department);
//        return department;
//    }
//}
