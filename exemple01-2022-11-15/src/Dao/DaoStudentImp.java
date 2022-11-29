/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author Olivier
 */
public class DaoStudentImp implements DaoStudent{
    List<Student> listeStudents;
    
    public DaoStudentImp() {
        listeStudents = new ArrayList<>();
    }
           
    
    @Override
    public void create( Student student){
       listeStudents.add(student);
    }
    
    @Override 
    public List<Student> findAll(){
        return listeStudents;
    }
    @Override
    public void findById(int id){
        System.out.println("Dans findById");
    }
    @Override
    public void update (Student student){
        System.out.println( "dans update");
    }
    @Override
    public void delete (int id){
        System.out.println("dans delete");
    }    
    
}
