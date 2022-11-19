package com.wallace.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallace.productservice.helper.SaleHelper;
import com.wallace.productservice.helper.UserHelper;
import com.wallace.productservice.repository.SaleRepository;
import com.wallace.productservice.repository.UserRepository;
import com.wallace.productservice.service.SaleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SaleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SaleService service;

    @MockBean
    private SaleRepository saleRepository;
    @MockBean
    private UserRepository userRepository;

    @Test
    void shouldReturnUserSummarySuccess() throws Exception {

        Mockito.when(saleRepository.findTop5ByUserIdOrderBySaleDateTimeDesc(1L))
                        .thenReturn(SaleHelper.get());
        Mockito.when(userRepository.findById(1L))
                .thenReturn(UserHelper.get());

        mockMvc.perform(get("/aggregate/user/1/summary")
                        .contentType("application/json"))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void shouldReturnUserNotFound() throws Exception {

        Mockito.when(saleRepository.findTop5ByUserIdOrderBySaleDateTimeDesc(1L))
                .thenReturn(SaleHelper.get());
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/aggregate/user/1/summary")
                        .contentType("application/json"))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldReturnMostSoldProductSuccess() throws Exception {

        Mockito.when(saleRepository.findTop1ProductByUserCityId(1L))
                .thenReturn(SaleHelper.getMostSoldProduct());
        mockMvc.perform(post("/aggregate/most-sold-product")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(SaleHelper.getSaleDto())))
                .andExpect(status().is2xxSuccessful());

    }
}