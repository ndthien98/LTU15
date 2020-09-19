/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.provide;

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
public class ProvideDTOTest {
    
    public ProvideDTOTest() {
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
     * Test of toString method, of class ProvideDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
         assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProvideId method, of class ProvideDTO.
     */
    @Test
    public void testGetProvideId() {
        System.out.println("getProvideId");
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        int expResult = 28;
        int result = instance.getProvideId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProvideId method, of class ProvideDTO.
     */
    @Test
    public void testSetProvideId() {
        System.out.println("setProvideId");
        int provideId = 30;
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        instance.setProvideId(provideId);
        assertEquals(provideId, instance.getProvideId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSiteId method, of class ProvideDTO.
     */
    @Test
    public void testGetSiteId() {
        System.out.println("getSiteId");
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        int expResult = 2;
        int result = instance.getSiteId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSiteId method, of class ProvideDTO.
     */
    @Test
    public void testSetSiteId() {
        System.out.println("setSiteId");
        int siteId = 5;
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        instance.setSiteId(siteId);
        assertEquals(siteId, instance.getSiteId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMerchandiseId method, of class ProvideDTO.
     */
    @Test
    public void testGetMerchandiseId() {
        System.out.println("getMerchandiseId");
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        int expResult = 30;
        int result = instance.getMerchandiseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMerchandiseId method, of class ProvideDTO.
     */
    @Test
    public void testSetMerchandiseId() {
        System.out.println("setMerchandiseId");
        int merchandiseId = 28;
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        instance.setMerchandiseId(merchandiseId);
        assertEquals(merchandiseId, instance.getMerchandiseId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstock method, of class ProvideDTO.
     */
    @Test
    public void testGetInstock() {
        System.out.println("getInstock");
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        int expResult = 5;
        int result = instance.getInstock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInstock method, of class ProvideDTO.
     */
    @Test
    public void testSetInstock() {
        System.out.println("setInstock");
        int instock = 2;
        ProvideDTO instance = new ProvideDTO(28, 2, 30, 5);
        instance.setInstock(instock);
        assertEquals(instock, instance.getInstock());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ProvideDTOTest.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
