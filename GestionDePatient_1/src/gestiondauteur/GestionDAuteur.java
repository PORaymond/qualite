/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondauteur;

import DaoImp.AuteurDaoImp;
import java.util.List;
import java.util.Scanner;
import model.Auteur;

/**
 *
 * @author Olivier Raymond
 */
public class GestionDAuteur {
    /**
     * @param args the command line arguments
     */
    static boolean boucle = true;
    static AuteurDaoImp monDao = new AuteurDaoImp();
    
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
                afficherUnAuteur(entrees);
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
        System.out.println("3. Affichage d'un auteur");
        System.out.println("4. Modification");
        System.out.println("5. Sortie");
    }
    public  static void creer(Scanner infosDao){
        System.out.println("Entrez l'id de l'auteur :");
        int idAuteur = infosDao.nextInt();
        infosDao.nextLine();
        System.out.println("Entrez le nom de l'auteur :");
        String nomAuteur = infosDao.nextLine();
        System.out.println("Entrez le prenom de l'auteur :");
        String prenomAuteur = infosDao.nextLine();
        System.out.println("Entrez le genre de l'auteur :");
        String genreAuteur = infosDao.nextLine();
        
        Auteur nouveauAuteur = new Auteur (
                idAuteur,
                nomAuteur,
                prenomAuteur,
                genreAuteur);
        monDao.create(nouveauAuteur);
    }
    public  static void supprimer(Scanner scanner){
        System.out.println("Entrez l'id de l'auteur que vous voulez Éliminer: ");
        int identite = scanner.nextInt();
        scanner.nextLine();
        
        monDao.delete(identite);    
    }
    public  static void afficherUnAuteur(Scanner scanner){
        System.out.println("Entrez l'id de l'auteur que vous voulez afficher: ");
        int i = scanner.nextInt();
        scanner.nextLine();
        Auteur auteur = monDao.findById(i);
        System.out.println("Nom complet: " + auteur.getPrenom()+" "+ auteur.getNom());
        System.out.println("Genre de roman : " + auteur.getGenre());
    }
    
    
    public  static void modifier(Scanner scanner){
        boolean boucleModifier = true;
        System.out.println("Entrez l'id de l'auteur que vous voulez modifier :");
        int ident =  scanner.nextInt();
        scanner.nextLine();
        try{
            Auteur auteurAChanger = monDao.findById(ident);
            while(boucleModifier){
                afficherMenuModifier();
                int maReponse = scanner.nextInt();
                scanner.nextLine();

                switch (maReponse) {
                    case 1:
                        System.out.println("Entrer le nom : ");
                        String nom = scanner.nextLine();
                        auteurAChanger.setNom(nom);
                        break;
                    case 2:
                        System.out.println("Entrer le prenom : ");
                        String prenom = scanner.nextLine();
                        auteurAChanger.setNom(prenom);
                        break;
                    case 3:
                        System.out.println("Entrer le genre : ");
                        String genre = scanner.nextLine();
                        auteurAChanger.setNom(genre);
                        break;
                    case 4:                    
                        monDao.update(auteurAChanger);
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
