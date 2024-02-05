package com.cg.WasherService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.WasherService.controller.WasherController;
import com.cg.WasherService.entity.WasherModel;
import com.cg.WasherService.exception.WasherException;
import com.cg.WasherService.service.WasherServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WasherServiceControllerApplicationTests {

    private WasherController washerController;
    private WasherServiceImpl washerService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        washerService = mock(WasherServiceImpl.class);
        washerController = new WasherController();
        mockMvc = MockMvcBuilders.standaloneSetup(washerController).build();
    }

    @Test
    void testInsertWasherInfo() throws Exception {
        WasherModel washerModel = new WasherModel();
        washerModel.setId(1);
        washerModel.setWasherName("John");
        washerModel.setWasherEmail("john@example.com");
        washerModel.setWasherPassword("password");

        when(washerService.insertWasherInfo(any(WasherModel.class))).thenReturn(washerModel);

        mockMvc.perform(post("/washer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(washerModel)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllWashers() throws Exception {
        List<WasherModel> washerList = new ArrayList<>();
        WasherModel washer1 = new WasherModel();
        washer1.setId(1);
        washer1.setWasherName("John");
        washer1.setWasherEmail("john@example.com");
        washer1.setWasherPassword("password");
        washerList.add(washer1);

        when(washerService.getAllWashers()).thenReturn(washerList);

        mockMvc.perform(get("/washer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].washerName", is("John")));
    }

    @Test
    void testUpdateWasherInfo() throws Exception {
        int washerId = 1;
        WasherModel washerModel = new WasherModel();
        washerModel.setId(washerId);
        washerModel.setWasherName("UpdatedName");
        washerModel.setWasherEmail("updated@example.com");
        washerModel.setWasherPassword("updatedPassword");

        when(washerService.updateWasherInfo(any(WasherModel.class), eq(washerId))).thenReturn(washerModel);

        mockMvc.perform(put("/washer/edit/{washerId}", washerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(washerModel)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteWasherInfo() throws Exception {
        int washerId = 1;

        mockMvc.perform(delete("/washer/delete/{washerId}", washerId))
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        int washerId = 1;
        WasherModel washerModel = new WasherModel();
        washerModel.setId(washerId);
        washerModel.setWasherName("John");
        washerModel.setWasherEmail("john@example.com");
        washerModel.setWasherPassword("password");

        when(washerService.getById(eq(washerId))).thenReturn(washerModel);

        mockMvc.perform(get("/washer/{washerId}", washerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.washerName", is("John")));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
