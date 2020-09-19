/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.Site;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class SiteControllerTest {
    
    public SiteControllerTest() {
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
     * Test of getInstance method, of class SiteController.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SiteController expResult = null;
        SiteController result = SiteController.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllSite method, of class SiteController.
     */
    @Test
    public void testReadAllSite() {
        System.out.println("readAllSite");
        SiteController instance = null;
        ArrayList<SiteDTO> expResult = null;
        ArrayList<SiteDTO> result = instance.readAllSite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSite method, of class SiteController.
     */
    @Test
    public void testCreateSite() {
        System.out.println("createSite");
        SiteDTO siteDTO = null;
        SiteController instance = null;
        boolean expResult = false;
        boolean result = instance.createSite(siteDTO);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSite method, of class SiteController.
     */
    @Test
    public void testUpdateSite() {
        System.out.println("updateSite");
        SiteDTO siteDTO = null;
        SiteController instance = null;
        boolean expResult = false;
        boolean result = instance.updateSite(siteDTO);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSite method, of class SiteController.
     */
    @Test
    public void testDeleteSite() {
        System.out.println("deleteSite");
        SiteDTO siteDTO = null;
        SiteController instance = null;
        boolean expResult = false;
        boolean result = instance.deleteSite(siteDTO);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
