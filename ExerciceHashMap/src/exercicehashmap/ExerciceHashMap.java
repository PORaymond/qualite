/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicehashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Olivier
 */
public class ExerciceHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map <String, String> listeVilles = new HashMap<>();
        listeVilles.put("Cuba","Havanna");
        listeVilles.put("Canada", "Ottawa");
        listeVilles.put("Ecuador", "Quito");
        
        
        for(Map.Entry ville  : listeVilles.entrySet()){
            System.out.println(ville.getKey() + ": " + ville.getValue());
    
    }
        
    }
    
}
