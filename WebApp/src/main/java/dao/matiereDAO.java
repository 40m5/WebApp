package dao;

import model.Matiere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import model.Matiere;

public class matiereDAO {
	private String strClassName;
    private String dbName;
    private String login;
    private String motdepasse;
    private String strUrl;
    private Connection connexion;
    private Statement statement;

    public matiereDAO() throws SQLException, ClassNotFoundException{
        this.strClassName = "com.mysql.cj.jdbc.Driver";
        this.dbName= "gestion_educative";
        this.login= "root";
        this.motdepasse= "";
        this.strUrl = "jdbc:mysql://localhost:3306/" + this.dbName;
        Class.forName(strClassName);
        this.connexion = DriverManager.getConnection(this.strUrl, this.login, this.motdepasse);
        this.statement = (Statement) connexion.createStatement();
    }

    public void fermerConnexion() throws SQLException {
        this.connexion.close();
    }
    
    public boolean ajouterMatiere(Matiere matiere) {
        String sql = "INSERT INTO matiere (nom, nb_heures) VALUES (?, ?)";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, matiere.getNom());
            statement.setInt(2, matiere.getNbHeures());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modifierMatiere(Matiere matiere) {
        String sql = "UPDATE matiere SET nom = ?, nb_heures = ? WHERE id = ?";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, matiere.getNom());
            statement.setInt(2, matiere.getNbHeures());
            statement.setInt(3, matiere.getId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean supprimerMatiere(int id) {
        String sql = "DELETE FROM matiere WHERE id = ?";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Matiere> listerMatieres() {
        List<Matiere> matieres = new ArrayList<>();
        String sql = "SELECT * FROM matiere";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Matiere matiere = new Matiere();
                matiere.setId(resultSet.getInt("id"));
                matiere.setNom(resultSet.getString("nom"));
                matiere.setNbHeures(resultSet.getInt("nb_heures"));
                
                matieres.add(matiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return matieres;
    }
}