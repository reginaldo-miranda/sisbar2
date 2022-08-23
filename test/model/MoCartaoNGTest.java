/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package model;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author suporte11-pc
 */
public class MoCartaoNGTest {
    
    public MoCartaoNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getCartao method, of class MoCartao.
     */
    @Test
    public void testGetCartao() {
        System.out.println("getCartao");
        MoCartao instance = new MoCartao();
        String expResult = "";
        String result = instance.getCartao();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCartao method, of class MoCartao.
     */
    @Test
    public void testSetCartao() {
        System.out.println("setCartao");
        String cartao = "";
        MoCartao instance = new MoCartao();
        instance.setCartao(cartao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBandeira method, of class MoCartao.
     */
    @Test
    public void testGetBandeira() {
        System.out.println("getBandeira");
        MoCartao instance = new MoCartao();
        String expResult = "";
        String result = instance.getBandeira();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBandeira method, of class MoCartao.
     */
    @Test
    public void testSetBandeira() {
        System.out.println("setBandeira");
        String bandeira = "";
        MoCartao instance = new MoCartao();
        instance.setBandeira(bandeira);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxa method, of class MoCartao.
     */
    @Test
    public void testGetTaxa() {
        System.out.println("getTaxa");
        MoCartao instance = new MoCartao();
        Double expResult = null;
        Double result = instance.getTaxa();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaxa method, of class MoCartao.
     */
    @Test
    public void testSetTaxa() {
        System.out.println("setTaxa");
        Double taxa = null;
        MoCartao instance = new MoCartao();
        instance.setTaxa(taxa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class MoCartao.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MoCartao instance = new MoCartao();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class MoCartao.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        MoCartao instance = new MoCartao();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class MoCartao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        MoCartao instance = new MoCartao();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class MoCartao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        MoCartao instance = new MoCartao();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
