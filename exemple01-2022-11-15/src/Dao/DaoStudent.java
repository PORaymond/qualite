/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;
import model.Student;

/**
 *
 * @author Olivier
 */
public interface DaoStudent {
    
    
    void create (Student student);
    List<Student> findAll();
    void findById(int id);
    void update (Student student);
    void delete (int id);
    
}
