package com.shop.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shop.repositories.LogRepository;
import com.shop.repositories.SneakerQuestionRepository;
import com.shop.repositories.SneakerRepository;
import com.shop.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureTestDatabase
//public class SneakersRestControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private SneakerRepository sneakerRepository;
//    @Autowired
//    private SneakerQuestionRepository sneakerQuestionRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private LogRepository logRepository;
//
//    private SneakerTestData sneakerTestData;
//
//    @BeforeEach
//    public void setUp() {
//        sneakerTestData = new SneakerTestData(sneakerQuestionRepository,
//                userRepository,
//                sneakerRepository,
//                logRepository);
//        sneakerTestData.init();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        sneakerTestData.cleanUp();
//    }

//    @Test
//    @WithMockUser(value = "ivan", roles = {"USER", "ADMIN"})
//    public void testFetchSneakers() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/sneakers/api")).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("[0].colour").value("red")).
//                andExpect(jsonPath("[0].quantity").value(1)
//
//        );
//    }

//
//}
