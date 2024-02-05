package com.cg.WashPackService.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.WashPackService.model.WashPackEntity;
import com.cg.WashPackService.service.WashPackServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class WashPackServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private WashPackServiceController washPackServiceController;

    @Mock
    private WashPackServiceImpl washPackService;

    @BeforeEach
    public void setUp() {
        // Set up any necessary mock data or behaviors here
    }
    
    @Test
    public void testAddWashPack() throws Exception {
        WashPackEntity washPackEntity = new WashPackEntity(0, null, null, 0, 0);
        washPackEntity.setWashPackName("Test Wash Pack");
        washPackEntity.setWashPackCost(10);
        washPackEntity.setWashPackDescription("Test Description");

        Mockito.when(washPackService.addWashPack(Mockito.any(WashPackEntity.class))).thenReturn(washPackEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/washpack/add")
                .content(asJsonString(washPackEntity))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateWashPack() throws Exception {
        int washPackId = 1;
        WashPackEntity washPackEntity = new WashPackEntity(washPackId, null, null, washPackId, washPackId);
        washPackEntity.setWashPackName("Updated Wash Pack");
        washPackEntity.setWashPackCost(15);
        washPackEntity.setWashPackDescription("Updated Description");

        Mockito.when(washPackService.updateWashPack(Mockito.any(WashPackEntity.class), Mockito.eq(washPackId)))
                .thenReturn(washPackEntity);

        mockMvc.perform(MockMvcRequestBuilders.put("/washpack/edit/{id}", washPackId)
                .content(asJsonString(washPackEntity))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetWashPackById() throws Exception {
        int washPackId = 1;
        WashPackEntity washPackEntity = new WashPackEntity(washPackId, null, null, washPackId, washPackId);
        washPackEntity.setWashPackName("Test Wash Pack");
        washPackEntity.setWashPackCost(10);
        washPackEntity.setWashPackDescription("Test Description");

        Mockito.when(washPackService.getWashPackById(washPackId)).thenReturn(washPackEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/washpack/{id}", washPackId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    public void testGetAllWashPack() throws Exception {
//        // Set up a list of WashPackEntity objects and return them when calling service.getAllWashPack()
//        List<WashPackEntity> washPackList = new ArrayList<>();
//
//        // Configure the mock to return the list
//        Mockito.when(washPackService.getAllWashPack()).thenReturn(washPackList);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/washpack/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }

    @Test
    public void testDeleteWashPack() throws Exception {
        int washPackId = 1;

        // Configure the mock to perform the delete operation
        Mockito.doNothing().when(washPackService).deleteWashPack(washPackId);

        mockMvc.perform(MockMvcRequestBuilders.delete("/washpack/delete/{id}", washPackId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Utility method to convert objects to JSON string
    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
