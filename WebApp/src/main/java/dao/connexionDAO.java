package dao;

import model.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connexionDAO {
    private Connection connexion;
    
    public connexionDAO(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean authentifier(Compte compte) {
        String sql = "SELECT * FROM compte WHERE login = ? AND password = ?";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, compte.getLogin());
            statement.setString(2, compte.getPassword());
            
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean creerCompte(Compte compte) {
        String sql = "INSERT INTO compte (login, password) VALUES (?, ?)";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, compte.getLogin());
            statement.setString(2, compte.getPassword());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean supprimerCompte(String login) {
        String sql = "DELETE FROM compte WHERE login = ?";
        
        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            statement.setString(1, login);
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}