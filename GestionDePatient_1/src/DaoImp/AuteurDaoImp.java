/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImp;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Auteur;

/**
 *
 * @author Olivier
 */
import java.util.List;
import interfaceDao.AuteurDao;
public class AuteurDaoImp implements AuteurDao{
    Connection connection = ConnectionFactory.getConnection();
    @Override
    public void create (Auteur auteur) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO AUTEUR(id, nom, prenom, genre) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            
            preparedStatement.setInt(1, auteur.getId());
            preparedStatement.setString(2, auteur.getNom());
            preparedStatement.setString(3, auteur.getPrenom());
            preparedStatement.setString(4, auteur.getGenre());
            
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    
    @Override 
    public void delete(int id){
                PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM AUTEUR WHERE ID =" + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Override
    public List<Auteur> findAll() {

        List<Auteur> patients = new ArrayList<>();
        Auteur auteur = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM AUTEUR ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                auteur = new Auteur();
                auteur.setId(resultSet.getInt("id"));
                auteur.setNom(resultSet.getString("nom"));
                auteur.setPrenom(resultSet.getString("prenom"));
                auteur.setGenre(resultSet.getString("genre"));
                patients.add(auteur);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return patients;
    }

    @Override
    public Auteur findById(int id){
        Auteur auteur = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM AUTEUR where id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            auteur = new Auteur();
            auteur.setId(resultSet.getInt("id"));
            auteur.setNom(resultSet.getString("nom"));
            auteur.setPrenom(resultSet.getString("prenom"));
            auteur.setGenre(resultSet.getString("genre"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return auteur;
    }
    @Override
    public void update(Auteur auteur) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE AUTEUR SET NOM = ?, PRENOM= ?, GENRE= ?  WHERE ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, auteur.getNom());
            preparedStatement.setString(2, auteur.getPrenom());
            preparedStatement.setString(3, auteur.getGenre());
            
            preparedStatement.setInt(4, auteur.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
