/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceDao;

import java.util.List;
import model.Patient;

/**
 *
 * @author Olivier
 */
public interface PatientDao {
    void create(Patient p);// abstract
    
    void update(Patient p);
    
    void delete(int id);

    List<Patient> findAll();

    Patient findById(int id);
}
