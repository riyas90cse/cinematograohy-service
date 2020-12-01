package com.cinematography.api.controller;

import com.cinematography.api.TestConfig;
import com.cinematography.api.service.JsonDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = JsonDataController.class)
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@Import(TestConfig.class)
public class JsonDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    @MockBean
    private JsonDataService jsonDataService;

    private String data;

    private final String URL = "https://mgtechtest.blob.core.windows.net/files/showcase.json";

    private String testLoadMockData() {
        return this.restTemplate.getForObject(URL, String.class);
    }

    @Test
    public void testLoadData() throws Exception {
        data = testLoadMockData();
        given(jsonDataService.loadData()).willReturn(data);
        this.mockMvc.perform(get("/data/load")).andExpect(status().isOk());
    }

    @Test
    public void testloadDataWithFilters() throws Exception{
        given(jsonDataService.loadData()).willReturn(data);
        this.mockMvc.perform(get("/data/filter")).andExpect(status().isOk());
    }

    @Test
    public void testloadDetail() throws Exception{
        given(jsonDataService.loadData()).willReturn(data);
        this.mockMvc.perform(get("/data/{id}")).andExpect(status().isOk());
    }

}
