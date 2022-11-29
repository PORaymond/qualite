/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondepatient;

import DaoImp.PatientDaoImp;
import java.util.List;
import java.util.Scanner;
import model.Patient;

/**
 *
 * @author Olivier Raymond
 */
public class GestionDePatient {
    /**
     * @param args the command line arguments
     */
    static boolean boucle = true;
    static PatientDaoImp monDao = new PatientDaoImp();
    
    public static void main(String[] args) {
        
        Scanner entrees = new Scanner(System.in);
        while (boucle) {            
            afficherMenu ();
            try{
                if (entrees.hasNextInt()){
                    int reponse = entrees.nextInt();
                    entrees.nextLine();
                    choisirOption(reponse, entrees);
                } else {
                    System.out.println("bark bark");
                }
            } catch(Exception ex){
                System.out.println("Erreur. Votre réponse ne correspond pas au format demandé");
            }
        }
        entrees.close();  
    }

    private static void choisirOption(int reponse, Scanner entrees) throws AssertionError {
        switch (reponse) {
            case 1:
                creer(entrees);
                break;
            case 2:
                supprimer(entrees);
                break;
            case 3:
                afficher();
                break;
            case 4:
                modifier(entrees);
                break;
            case 5:
                quitter();
                break;
                
            default:
                throw new AssertionError();
        }
    }

    private static void afficherMenu() {
        System.out.println ("Menu:");
        System.out.println("1. Creation");
        System.out.println("2. Suppression");
        System.out.println("3. Affichage");
        System.out.println("4. Modification");
        System.out.println("5. Sortie");
    }
    public  static void creer(Scanner infosDao){
        System.out.println("Entrez l'id du patient :");
        int idPatient = infosDao.nextInt();
        infosDao.nextLine();
        System.out.println("Entrez le nom du patient :");
        String nomPatient = infosDao.nextLine();
        System.out.println("Entrez le prenom du patient :");
        String prenomPatient = infosDao.nextLine();
        System.out.println("Entrez le genre du patient :");
        String genrePatient = infosDao.nextLine();
        
        Patient nouveauPatient = new Patient (
                idPatient,
                nomPatient,
                prenomPatient,
                genrePatient);
        monDao.create(nouveauPatient);
    }
    public  static void supprimer(Scanner scanner){
        System.out.println("Entrez l'id du patient que vous voulez Éliminer: ");
        int identite = scanner.nextInt();
        scanner.nextLine();
        
        monDao.delete(identite);    
    }
    public  static void afficher(){
        List<Patient> tousLesPatients = monDao.findAll();
        tousLesPatients.forEach(n -> System.out.println(n.getNom()));
    }
    
    
    public  static void modifier(Scanner scanner){
        boolean boucleModifier = true;
        System.out.println("Entrez l'id du patient que vous voulez modifier :");
        int ident =  scanner.nextInt();
        scanner.nextLine();
        try{
            Patient patientAChanger = monDao.findById(ident);
            while(boucleModifier){
                afficherMenuModifier();
                int maReponse = scanner.nextInt();
                scanner.nextLine();

                switch (maReponse) {
                    case 1:
                        System.out.println("Entrer le nom : ");
                        String nom = scanner.nextLine();
                        patientAChanger.setNom(nom);
                        break;
                    case 2:
                        System.out.println("Entrer le prenom : ");
                        String prenom = scanner.nextLine();
                        patientAChanger.setNom(prenom);
                        break;
                    case 3:
                        System.out.println("Entrer le genre : ");
                        String genre = scanner.nextLine();
                        patientAChanger.setNom(genre);
                        break;
                    case 4:                    
                        monDao.update(patientAChanger);
                    case 5:
                        boucleModifier = false;
                        break;
                    default:
                        throw new AssertionError();
                }  
            }
        }
        catch(Exception e){
            System.out.println("Quelque chose n’a pas fonctionner");
        }
    }
    public  static void quitter(){
        boucle = false;
    }
    
    public static void afficherMenuModifier(){
        String[] options = {
            "Modifier:",
            "1. nom",
            "2. prenom",
            "3. genre",
            "4. enregistrer les modification",
            "5. annuler les modification"
        }; 
        for (String option : options){
            System.out.println (option);
        }
        System.out.println("Entrez votre choix :");
    }
    public static void choisirModifier(){
        
    }
    
        
    
    
}
