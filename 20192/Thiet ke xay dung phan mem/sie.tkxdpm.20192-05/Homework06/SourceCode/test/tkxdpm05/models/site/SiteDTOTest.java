/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.site;

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
public class SiteDTOTest {
    
    public SiteDTOTest() {
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
     * Test of getSiteId method, of class SiteDTO.
     */
    @Test
    public void testGetSiteId() {
        System.out.println("getSiteId");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        int expResult = 282;
        int result = instance.getSiteId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSiteId method, of class SiteDTO.
     */
    @Test
    public void testSetSiteId() {
        System.out.println("setSiteId");
        int siteId = 305;
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setSiteId(siteId);
        assertEquals(siteId, instance.getSiteId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDispName method, of class SiteDTO.
     */
    @Test
    public void testGetDispName() {
        System.out.println("getDispName");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        String expResult = "LA";
        String result = instance.getDispName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDispName method, of class SiteDTO.
     */
    @Test
    public void testSetDispName() {
        System.out.println("setDispName");
        String dispName = "HA";
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setDispName(dispName);
        assertEquals(dispName, instance.getDispName());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class SiteDTO.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        String expResult = "LuA";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class SiteDTO.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "DN";
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setAddress(address);
        assertEquals(address, instance.getAddress());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShipDay method, of class SiteDTO.
     */
    @Test
    public void testGetShipDay() {
        System.out.println("getShipDay");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        int expResult = 28;
        int result = instance.getShipDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShipDay method, of class SiteDTO.
     */
    @Test
    public void testSetShipDay() {
        System.out.println("setShipDay");
        int shipDay = 30;
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setShipDay(shipDay);
        assertEquals(shipDay, instance.getShipDay());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAirDay method, of class SiteDTO.
     */
    @Test
    public void testGetAirDay() {
        System.out.println("getAirDay");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        int expResult = 2;
        int result = instance.getAirDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAirDay method, of class SiteDTO.
     */
    @Test
    public void testSetAirDay() {
        System.out.println("setAirDay");
        int airDay = 5;
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setAirDay(airDay);
        assertEquals(airDay, instance.getAirDay());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOther method, of class SiteDTO.
     */
    @Test
    public void testGetOther() {
        System.out.println("getOther");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        String expResult = "sth";
        String result = instance.getOther();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOther method, of class SiteDTO.
     */
    @Test
    public void testSetOther() {
        System.out.println("setOther");
        String other = "noth";
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        instance.setOther(other);
        assertEquals(other, instance.getOther());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SiteDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SiteDTO instance = new SiteDTO(282, "LA", "LuA", 28, 2, "sth");
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SiteDTOTest.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
