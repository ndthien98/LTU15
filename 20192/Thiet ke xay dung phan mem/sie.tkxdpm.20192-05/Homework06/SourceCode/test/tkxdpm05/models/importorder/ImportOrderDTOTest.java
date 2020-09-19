/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.importorder;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tkxdpm05.ImportOrder.ImportOrderController;

/**
 *
 * @author Nhokxayda
 */
public class ImportOrderDTOTest {
    ArrayList<ImportOrderDTO> listImportOrderDTOs;
    
    public ImportOrderDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSaleOrderId method, of class ImportOrderDTO.
     */
    @Test
    public void testGetSaleOrderId() {
        System.out.println("getSaleOrderId");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        int expResult = 40001;
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(1));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleOrderId method, of class ImportOrderDTO.
     
    @Test
    public void testSetSaleOrderId() {
        System.out.println("setSaleOrderId");
        int saleOrderId = 0;
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setSaleOrderId(saleOrderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSiteId method, of class ImportOrderDTO.
     */
    @Test
    public void testGetSiteId() {
        System.out.println("getSiteId");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        int expResult = 20001;
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(4));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSiteId method, of class ImportOrderDTO.
     
    @Test
    public void testSetSiteId() {
        System.out.println("setSiteId");
        int siteId = 0;
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setSiteId(siteId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMerchandiseId method, of class ImportOrderDTO.
     */
    @Test
    public void testGetMerchandiseId() {
        System.out.println("getMerchandiseId");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        int expResult = 10001;
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(5));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMerchandiseId method, of class ImportOrderDTO.
     
    @Test
    public void testSetMerchandiseId() {
        System.out.println("setMerchandiseId");
        int merchandiseId = 0;
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setMerchandiseId(merchandiseId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ImportOrderDTO.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        int expResult = 4;
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(6));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class ImportOrderDTO.
     
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImportOrderId method, of class ImportOrderDTO.
     */
    @Test
    public void testGetImportOrderId() {
        System.out.println("getImportOrderId");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        int expResult = 60001;
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(0));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImportOrderId method, of class ImportOrderDTO.
     
    @Test
    public void testSetImportOrderId() {
        System.out.println("setImportOrderId");
        int importOrderId = 0;
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setImportOrderId(importOrderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class ImportOrderDTO.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        String expResult = "NEW";
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(2));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class ImportOrderDTO.
     
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveryMean method, of class ImportOrderDTO.
     */
    @Test
    public void testGetDeliveryMean() {
        System.out.println("getDeliveryMean");
        ArrayList<ImportOrderDTO> instance = ImportOrderController.getInstance().readAll();
        String expResult = "1970-09-14";
        //int result = instance.get(0);
        assertEquals(expResult, instance.get(3));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeliveryMean method, of class ImportOrderDTO.
     
    @Test
    public void testSetDeliveryMean() {
        System.out.println("setDeliveryMean");
        String deliveryMean = "";
        ImportOrderDTO instance = new ImportOrderDTO();
        instance.setDeliveryMean(deliveryMean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ImportOrderDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ImportOrderDTO instance = new ImportOrderDTO();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ImportOrderDTOTest.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
