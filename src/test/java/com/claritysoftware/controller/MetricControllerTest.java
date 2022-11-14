package com.claritysoftware.controller;

import com.claritysoftware.service.MetricService;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MetricController.class})
@ExtendWith(SpringExtension.class)
class MetricControllerTest {
    @Autowired
    private MetricController metricController;

    @MockBean
    private MetricService metricService;

    /**
     * Method under test: {@link MetricController#getMetrics(String, String, Instant, Instant)}
     */
    @Test
    void testGetMetrics() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/metrics");
        MockHttpServletRequestBuilder paramResult = getResult.param("from", String.valueOf((Object) null))
                .param("name", "foo")
                .param("system", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("to", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(metricController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

