//package com.ats;
//
//import com.ats.controller.PlaneController;
//import com.ats.entity.Plane;
//import com.ats.service.PlaneService;
//import org.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class PlaneControllerTest {
//
//    @Mock
//    private PlaneService planeService;
//
//    @InjectMocks
//    private PlaneController planeController;
//
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllPlanes() {
//        List<Plane> planes = List.of(new Plane(), new Plane());
//
//        when(planeService.getAllPlanes()).thenReturn(planes);
//
//        ResponseEntity<List<Plane>> response = planeController.getAllPlanes();
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(2, response.getBody().size());
//    }
//
//    @Test
//    void testAddPlane() {
//        Plane plane = new Plane();
//        plane.setModel("Boeing 747");
//
//        when(planeService.getPlaneById(Long)).thenReturn(Long);
//
//        ResponseEntity<Plane> response = planeController.addPlane(plane);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals("Boeing 747", response.getBody().getModel());
//    }
//}
