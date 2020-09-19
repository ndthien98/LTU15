/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.saleorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Nhokxayda
 */
public class SaleOrderDetailDTOTest {
    
    public SaleOrderDetailDTOTest() {
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
     * Test of toString method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaleOrderDetailId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testGetSaleOrderDetailId() {
        System.out.println("getSaleOrderDetailId");
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        int expResult = 14;
        int result = instance.getSaleOrderDetailId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleOrderDetailId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testSetSaleOrderDetailId() {
        System.out.println("setSaleOrderDetailId");
        int saleOrderDetailId = 15;
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        instance.setSaleOrderDetailId(saleOrderDetailId);
        assertEquals(saleOrderDetailId, instance.getSaleOrderDetailId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaleOrderId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testGetSaleOrderId() {
        System.out.println("getSaleOrderId");
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        int expResult = 15;
        int result = instance.getSaleOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleOrderId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testSetSaleOrderId() {
        System.out.println("setSaleOrderId");
        int saleOrderId = 28;
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        instance.setSaleOrderId(saleOrderId);
        assertEquals(saleOrderId, instance.getSaleOrderId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMerchandiseId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testGetMerchandiseId() {
        System.out.println("getMerchandiseId");
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        int expResult = 16;
        int result = instance.getMerchandiseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMerchandiseId method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testSetMerchandiseId() {
        System.out.println("setMerchandiseId");
        int merchandiseId = 30;
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        instance.setMerchandiseId(merchandiseId);
        assertEquals(merchandiseId, instance.getMerchandiseId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        int expResult = 17;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class SaleOrderDetailDTO.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 20;
        SaleOrderDetailDTO instance = new SaleOrderDetailDTO(14, 15, 16, 17);
        instance.setQuantity(quantity);
        assertEquals(quantity, instance.getQuantity());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SaleOrderDetailDTO.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
