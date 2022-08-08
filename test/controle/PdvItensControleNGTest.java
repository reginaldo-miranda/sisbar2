/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package controle;

import java.util.List;
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
public class PdvItensControleNGTest {
    
    public PdvItensControleNGTest() {
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
     * Test of carregaVendaId method, of class PdvItensControle.
     */
    @Test
    public void testCarregaVendaId() {
        System.out.println("carregaVendaId");
        Integer idpd = null;
        PdvItensControle instance = new PdvItensControle();
        List expResult = null;
        List result = instance.carregaVendaId(idpd);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carregaVendaItenTd method, of class PdvItensControle.
     */
    @Test
    public void testCarregaVendaItenTd() {
        System.out.println("carregaVendaItenTd");
        PdvItensControle instance = new PdvItensControle();
        List expResult = null;
        List result = instance.carregaVendaItenTd();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
