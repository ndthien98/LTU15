/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.ImportOrder;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tkxdpm05.models.importorder.ImportOrderDTO;
import tkxdpm05.models.saleorder.SaleOrderDTO;

/**
 *
 * @author thiennd
 */
public class ImportOrderControllerTest {

    public ImportOrderControllerTest() {
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
     * Test of getInstance method, of class ImportOrderController.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ImportOrderController expResult = null;
        ImportOrderController result = ImportOrderController.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllImportOrder method, of class ImportOrderController.
     */
    @Test
    public void testReadAllImportOrder() {
        System.out.println("readAllImportOrder");
        ImportOrderController instance = ImportOrderController.getInstance();
        ArrayList<ImportOrderDTO> expResult = new ArrayList<>();
        ArrayList<ImportOrderDTO> result = instance.readAllImportOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllSaleOrder method, of class ImportOrderController.
     */
    @Test
    public void testReadAllSaleOrder() {
        System.out.println("readAllSaleOrder");
        ImportOrderController instance = null;
        ArrayList<SaleOrderDTO> expResult = null;
        ArrayList<SaleOrderDTO> result = instance.readAllSaleOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createImportOrder method, of class ImportOrderController.
     */
    @Test
    public void testCreateImportOrder() {
        System.out.println("createImportOrder");
        ImportOrderDTO importOrderDTO = null;
        ImportOrderController instance = null;
        instance.createImportOrder(importOrderDTO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSaleOrder method, of class ImportOrderController.
     */
    @Test
    public void testUpdateSaleOrder() {
        System.out.println("updateSaleOrder");
        SaleOrderDTO saleOrderDTO = null;
        ImportOrderController instance = null;
        instance.updateSaleOrder(saleOrderDTO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateImportOrder method, of class ImportOrderController.
     */
    @Test
    public void testGenerateImportOrder() {
        System.out.println("generateImportOrder");
        SaleOrderDTO saleOrderDTO = null;
        ImportOrderController instance = null;
        ArrayList<ImportOrderDTO> expResult = null;
        ArrayList<ImportOrderDTO> result = instance.generateImportOrder(saleOrderDTO);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
