package dao;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

@jakarta.servlet.annotation.WebListener
public class AppContextListener implements ServletContextListener {
    /*@Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Connection connexion = DatabaseConnection.getInstance().getConnection();
            sce.getServletContext().setAttribute("connexion", connexion);
            System.out.println("Connexion à la base de données établie.");
        } catch ( SQLException e) {
            System.err.println("Erreur lors de la connexion à la base : " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection connexion = (Connection) sce.getServletContext().getAttribute("connexion");
        try {
            if (connexion != null && !connexion.isClosed()) {
                connexion.close();
                System.out.println("Connexion à la base de données fermée.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }
*/}