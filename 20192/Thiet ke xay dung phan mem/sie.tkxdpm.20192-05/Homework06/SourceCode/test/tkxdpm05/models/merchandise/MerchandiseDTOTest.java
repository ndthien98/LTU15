/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  Nguyen Hai Anh aka HAD all right reserved.
 */
package tkxdpm05.models.merchandise;

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
import tkxdpm05.Merchandise.MerchandiseController;

/**
 *
 * @author Nhokxayda
 */
public class MerchandiseDTOTest {
     public ArrayList<MerchandiseDTO> testMerch;
    
    public MerchandiseDTOTest() {
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
     * Test of getMerchandiseId method, of class MerchandiseDTO.
     */
    @Test
    public void testGetMerchandiseId() {
        //testMerch = MerchandiseController.getInstance().readAll();
        System.out.println("getMerchandiseId");
        ArrayList<MerchandiseDTO> instance = MerchandiseController.getInstance().readAll();;
        int expResult = 10001;
        assertEquals(expResult, instance.get(0));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMerchandiseId method, of class MerchandiseDTO.
     */
    @Test
    public void testSetMerchandiseId() {
        System.out.println("setMerchandiseId");
        int merchandiseId = 305;
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setMerchandiseId(merchandiseId);
        assertEquals(merchandiseId, instance.getMerchandiseId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDispName method, of class MerchandiseDTO.
     */
    @Test
    public void testGetDispName() {
        System.out.println("getDispName");
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        String expResult = "Love";
        String result = instance.getDispName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDispName method, of class MerchandiseDTO.
     */
    @Test
    public void testSetDispName() {
        System.out.println("setDispName");
        String dispName = "Heart";
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setDispName(dispName);
        assertEquals(dispName, instance.getDispName());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescribe method, of class MerchandiseDTO.
     */
    @Test
    public void testGetDescribe() {
        System.out.println("getDescribe");
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        String expResult = "Done'";
        String result = instance.getDescribe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescribe method, of class MerchandiseDTO.
     */
    @Test
    public void testSetDescribe() {
        System.out.println("setDescribe");
        String describe = "Doin'";
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setDescribe(describe);
        assertEquals(describe, instance.getDescribe());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnit method, of class MerchandiseDTO.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        String expResult = "Piece";
        String result = instance.getUnit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnit method, of class MerchandiseDTO.
     */
    @Test
    public void testSetUnit() {
        System.out.println("setUnit");
        String unit = "Ones";
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setUnit(unit);
        assertEquals(unit, instance.getUnit());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNote method, of class MerchandiseDTO.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        String expResult = "Shipping";
        String result = instance.getNote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNote method, of class MerchandiseDTO.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "Untrack";
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setNote(note);
        assertEquals(note, instance.getNote());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class MerchandiseDTO.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class MerchandiseDTO.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 282;
        MerchandiseDTO instance = new MerchandiseDTO(282, "Love", "Done", "Piece", "Shipping", 305);
        instance.setPrice(price);
        assertEquals(price, instance.getPrice());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MerchandiseDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MerchandiseDTO instance = new MerchandiseDTO();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MerchandiseDTOTest.class);
        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
