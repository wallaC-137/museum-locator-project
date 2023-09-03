package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class MuseumControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MuseumServiceInterface museumServiceInterface;

  @Test
  void test() throws Exception {
    mockMvc.perform(get("/museums/1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
