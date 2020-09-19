/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.saleorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Nhokxayda
 */
public class SaleOrderDTOTest {
    
    public SaleOrderDTOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSaleOrderId method, of class SaleOrderDTO.
     */
    @Test
    public void testGetSaleOrderId() {
        System.out.println("getSaleOrderId");
        SaleOrderDTO instance = new SaleOrderDTO(305, "Smbody", "Pending");
        int expResult = 305;
        int result = instance.getSaleOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleOrderId method, of class SaleOrderDTO.
    */ 
    @Test
    public void testSetSaleOrderId() {
        System.out.println("setSaleOrderId");
        int saleOrderId = 282;
        SaleOrderDTO instance = new SaleOrderDTO();
        instance.setSaleOrderId(saleOrderId);
        assertEquals(saleOrderId, instance.getSaleOrderId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class SaleOrderDTO.
    */ 
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        SaleOrderDTO instance = new SaleOrderDTO(305, "Smbody", "Pending");
        String expResult = "Pending";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class SaleOrderDTO.
    */ 
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "Arrived";
        SaleOrderDTO instance = new SaleOrderDTO(305, "Smbody", "Pending");
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    /**
     * Test of toString method, of class SaleOrderDTO.
    */ 
    @Test
    public void testToString() {
        System.out.println("toString");
        SaleOrderDTO instance = new SaleOrderDTO(305, "Smbody", "Pending");
        String result = instance.toString();
        assertNotEquals("", result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SaleOrderDTOTest.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
    
}
