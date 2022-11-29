/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemple01_2022_11_15;

import Dao.DaoStudent;
import Dao.DaoStudentImp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Student;

/**
 *
 * @author Olivier
 */
public class Exemple0120221115 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Id : ");
        int id = sc.nextInt();
        System.out.println("Nom : ");
        String nom= sc.next();
        System.out.println("prenom");
        
        String prenom = sc.next();
        
        Student student1 = new Student(10,"Christtiano","Ronaldo");
        Student student2 = new Student (20, "Beauchamp", "Marc");
        //System.out.println("Id : " + student1.getId());
        DaoStudentImp dao = new DaoStudentImp();
        dao.create(student1);
        dao.create (student2);
        
        List<Student> l = dao.findAll();
        
        for(Student s:l){
            System.out.println("student Info" + s);
        }
        
        String name1 = "Burt";
        String name2 = "Ernie";
        List<String> listeStudents = new ArrayList<String>();
        
        listeStudents.add(name1);
        listeStudents.add(name2);
        
        
        for(String s:listeStudents){
            System.out.println("name : " + s);
        }
               
        
        
        /*DaoStudentImp dao = new DaoStudentImp();
        DaoStudent dao2 = new DaoStudentImp();
        
        dao.create(student1);
        Course cours1 = new Course ("Mathématiques");
        Course cours2 = new Course ("Francais");
        Course cours3 = new Course ("Physed");
        Course cours4 = new Course ("Philo");
        
        System.out.println("cours1:" + cours1.getTitle());
        System.out.println("cours2:" + cours2.getTitle());
        System.out.println("cours3:" + cours3.getTitle());
        System.out.println("cours4:" + cours4.getTitle());
        */
        
    }
    
}
