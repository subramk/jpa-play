package integration.com.jpa.play;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.PostgreSQLContainer;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductIntegrationTest {
//
//    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");

//    @Autowired
//    private MockMvc mockMvc;
//
//    static MyPostgres mySQLContainer = new MySQLContainer("mysql:latest");
//
//
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//    }
//
//    @BeforeAll
//    static void beforeAll() {
//        mySQLContainer.start();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        mySQLContainer.stop();
//    }
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders
//                .standaloneSetup(CourseController.class)
//                .build();
//    }
//
//
//    @Test
//    public void addNewCourseTest() throws Exception {
//        //build request body
//        Course course = Course.builder()
//                .name("test-course")
//                .price(100)
//                .duration("0 month")
//                .build();
//        //call controller endpoints
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/courses")
//                        .contentType("application/json")
//                        .content(asJsonString(course))
//                        .accept("application/json"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//    }
//
//
//    @Test
//    public void getAllTheCoursesTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/courses")
//                        .accept("application/json")
//                        .contentType("application/json"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.*").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1));
//    }
//
//    private String asJsonString(Object object) {
//        try {
//            return new ObjectMapper().writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
