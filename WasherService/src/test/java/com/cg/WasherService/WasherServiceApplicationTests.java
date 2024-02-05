//package com.cg.WasherService;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cg.WasherService.entity.WasherModel;
//import com.cg.WasherService.exception.WasherException;
//import com.cg.WasherService.repository.WasherRepository;
//import com.cg.WasherService.service.SequenceGeneratorService;
//import com.cg.WasherService.service.WasherServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WasherServiceApplicationTests {
//
//    @InjectMocks
//    private WasherServiceImpl washerService;
//
//    @Mock
//    private WasherRepository washerRepository;
//
//    @Mock
//    private SequenceGeneratorService sequenceGeneratorService;
//
//    @SuppressWarnings("deprecation")
//	@BeforeEach
//    public void setUp() {
//        // Set up any necessary mock data or behaviors here
//    	MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testInsertWasherInfo() throws WasherException {
//        WasherModel washerModel = new WasherModel();
//        washerModel.setWasherEmail("test@example.com");
//
//        List<WasherModel> existingWashers = new ArrayList<>();
//        when(washerRepository.findAll()).thenReturn(existingWashers);
//        when(sequenceGeneratorService.getSequenceNumber(anyString())).thenReturn(1);
//        when(washerRepository.save(washerModel)).thenReturn(washerModel);
//
//        WasherModel result = washerService.insertWasherInfo(washerModel);
//
//        assertNotNull(result);
//        assertEquals(washerModel, result);
//        verify(washerRepository, times(1)).findAll();
//        verify(sequenceGeneratorService, times(1)).getSequenceNumber(anyString());
//        verify(washerRepository, times(1)).save(washerModel);
//    }
//
//    @Test
//    public void testGetAllWashers() {
//        List<WasherModel> washerList = new ArrayList<>();
//        when(washerRepository.findAll()).thenReturn(washerList);
//
//        List<WasherModel> result = washerService.getAllWashers();
//
//        assertNotNull(result);
//        assertEquals(washerList, result);
//        verify(washerRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testUpdateWasherInfo() throws WasherException {
//        int washerId = 1;
//        WasherModel washerModel = new WasherModel();
//        washerModel.set_id(washerId);
//
//        when(washerRepository.existsById(washerId)).thenReturn(true);
//        when(washerRepository.save(washerModel)).thenReturn(washerModel);
//
//        WasherModel result = washerService.updateWasherInfo(washerModel, washerId);
//
//        assertNotNull(result);
//        assertEquals(washerModel, result);
//        verify(washerRepository, times(1)).existsById(washerId);
//        verify(washerRepository, times(1)).save(washerModel);
//    }
//
//    @Test
//    public void testDeleteWasherInfo() {
//        int washerId = 1;
//
//        washerService.deleteWasherInfo(washerId);
//
//        verify(washerRepository, times(1)).deleteById(washerId);
//    }
//
//    @Test
//    public void testGetById() throws WasherException {
//        int washerId = 1;
//        WasherModel washerModel = new WasherModel();
//        washerModel.set_id(washerId);
//
//        WasherModel result = washerService.getById(washerId);
//
//        assertNotNull(result);
//        assertEquals(washerModel, result);
//    }
//}
