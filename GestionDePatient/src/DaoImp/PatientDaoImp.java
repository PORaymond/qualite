/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.PatientDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

/**
 *
 * @author Olivier
 */
import java.util.List;
public class PatientDaoImp implements PatientDao{
    Connection connection = ConnectionFactory.getConnection();
    @Override
    public void create (Patient monPatient) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO PATIENTS(id, nom, prenom, genre) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            
            preparedStatement.setInt(1, monPatient.getId());
            preparedStatement.setString(2, monPatient.getNom());
            preparedStatement.setString(3, monPatient.getPrenom());
            preparedStatement.setString(4, monPatient.getGenre());
            
            
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
            String deleteQuery = "DELETE FROM PATIENTS WHERE ID =" + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Override
    public List<Patient> findAll() {

        List<Patient> patients = new ArrayList<>();
        Patient patient = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM PATIENTS ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setNom(resultSet.getString("nom"));
                patient.setPrenom(resultSet.getString("prenom"));
                patient.setGenre(resultSet.getString("genre"));
                patients.add(patient);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient findById(int id){
        Patient patient = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM patients where id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setNom(resultSet.getString("nom"));
            patient.setPrenom(resultSet.getString("prenom"));
            patient.setGenre(resultSet.getString("genre"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return patient;
    }
    @Override
    public void update(Patient patient) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE PATIENTS SET NOM = ?, PRENOM= ?, GENRE= ?  WHERE ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, patient.getNom());
            preparedStatement.setString(2, patient.getPrenom());
            preparedStatement.setString(3, patient.getGenre());
            
            preparedStatement.setInt(4, patient.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
