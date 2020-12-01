package com.cinematography.api.controller;

import com.cinematography.api.TestConfig;
import com.cinematography.api.model.JsonData;
import com.cinematography.api.service.JsonDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @MockBean
    private JsonDataService jsonDataService;

    @Mock
    private List<JsonData> data;

    private List<JsonData> testLoadMockData() throws Exception {
        data = jsonDataService.loadData();
        return data;
    }

    @Test
    public void testLoadData() throws Exception {
        given(testLoadMockData()).willReturn(data);
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
