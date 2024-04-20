package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static DB.DatabaseConfig.*;

public class Connect {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ma_base_de_donnees", "utilisateur", "mot_de_passe");
            System.out.println("Connexion à la base de données établie.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        return conn;
    }
    
    public static Connection getConnection() {
        Connection c = null;
        String nomDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(nomDriver);
            System.out.println("Driver Chargé");

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver " + e.getMessage());
        }
        try {
            c= DriverManager.getConnection(DB_URL , DB_USER , DB_PASSWORD );
            System.out.println("Connected");

        } catch (SQLException e) {
            System.out.println("Erreur de connexion " + e.getMessage());

        }
        return c;
    }
}

