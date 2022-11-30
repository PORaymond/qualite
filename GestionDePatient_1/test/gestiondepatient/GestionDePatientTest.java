/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gestiondepatient;

import gestiondauteur.GestionDAuteur;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Olivier
 */
public class GestionDePatientTest {
    
    public GestionDePatientTest() {
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
     * Test of main method, of class GestionDePatient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GestionDAuteur.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creer method, of class GestionDePatient.
     */
    @Test
    public void testCreer() {
        Scanner unScanner = new Scanner(System.in);
        System.out.println("creer");
        GestionDAuteur.creer(unScanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of  method, of class GestionDePatient.
     * @param scanner
     */
    @Test
    public void testSupprimer(Scanner scanner) {
        System.out.println("supprimer");
        GestionDAuteur.supprimer(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of  method, of class GestionDePatient.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        //GestionDAuteur.afficherUnAuteur(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class GestionDePatient.
     * @param scanner
     */
    @Test
    public void testModifier(Scanner scanner) {
        System.out.println("modifier");
        GestionDAuteur.modifier(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitter method, of class GestionDePatient.
     */
    @Test
    public void testQuitter() {
        System.out.println("quitter");
        GestionDAuteur.quitter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherMenuModifier method, of class GestionDePatient.
     */
    @Test
    public void testAfficherMenuModifier() {
        System.out.println("afficherMenuModifier");
        GestionDAuteur.afficherMenuModifier();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choisirModifier method, of class GestionDePatient.
     */
    @Test
    public void testChoisirModifier() {
        System.out.println("choisirModifier");
        GestionDAuteur.choisirModifier();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
