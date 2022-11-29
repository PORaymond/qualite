/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package toufikseance2;

/**
 *
 * @author Olivier
 */
public class ToufikSeance2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Artiste artiste = new Artiste(0, "Mona");
    }
    
}

class Artiste{
    int id;
    String nom;

    public Artiste(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
            
}
