package com.jpa.play.ui.controller;


//@AutoConfigureMockMvc
//@SpringBootTest
public class ProductIntegrationTest {

//    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;


//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//    }

//    @BeforeAll
//    static void beforeAll() {
//        postgreSQLContainer.start();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        postgreSQLContainer.stop();
//    }

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders
//                .standaloneSetup(StudentCourseController.class)
//                .build();
//    }
//
//
//    @Test
//    public void addNewCourseTest() throws Exception {
//        //build request body
//
//        Course course = Course.builder()
//                .title("test-course")
//                .fee(100.00)
//                .abbreviation("TCC")
//                .modules(3)
//                .build();
//
//        //call controller endpoints
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/courses")
//                        .contentType("application/json")
//                        .content(asJsonString(course))
//                        //.content(objectMapper.writeValueAsString(course))
//                        .accept("application/json"))
//                        .andExpect(status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//    }
//
//
//    @Test
//    public void getAllTheCoursesTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/courses")
//                        .accept("application/json")
//                        .contentType("application/json"))
//                //.andExpect(status().isOk())
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
