/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceDao;

import java.util.List;
import model.Auteur;

/**
 *
 * @author Olivier
 */
public interface AuteurDao {
    void create(Auteur p);// abstract
    
    void update(Auteur p);
    
    void delete(int id);

    List<Auteur> findAll();

    Auteur findById(int id);
}
