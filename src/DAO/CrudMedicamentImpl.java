package DAO;

import DB.Connect;
import POO.Medicament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudMedicamentImpl implements CrudMedicamentInterface {
    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet res = null;

    @Override
    public boolean ajouter(Medicament medicament) {
        String query = "INSERT INTO medicament (id,nom, description, prix, quantite, pharmacie_id) VALUES (?,?, ?, ?, ?, ?)";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setInt(1, medicament.getId());
            pre.setString(2, medicament.getNom());
            pre.setString(3, medicament.getDescription());
            pre.setDouble(4, medicament.getPrix());
            pre.setInt(5, medicament.getQuantiteStock());
            pre.setInt(6, medicament.getIdPharmacie());

            // Exécuter la requête
            int result = pre.executeUpdate();

            // Vérifier si l'opération a réussi
            if (result > 0) {
                return true; // Succès
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return false; // Échec
    }

    @Override
    public boolean supprimer(int id) {
        String query = "DELETE FROM medicament WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setInt(1, id);

            // Exécuter la requête
            int result = pre.executeUpdate();

            // Vérifier si l'opération a réussi
            if (result > 0) {
                return true; // Succès
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return false; // Échec
    }

    @Override
    public boolean modifier(Medicament medicament) {
        String query = "UPDATE medicament SET nom = ?, description = ?, prix = ?, quantite = ?, pharmacie_id = ? WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setString(1, medicament.getNom());
            pre.setString(2, medicament.getDescription());
            pre.setDouble(3, medicament.getPrix());
            pre.setInt(4, medicament.getQuantiteStock());
            pre.setInt(5, medicament.getIdPharmacie());
            pre.setInt(6, medicament.getId());

            // Exécuter la requête
            int result = pre.executeUpdate();

            // Vérifier si l'opération a réussi
            if (result > 0) {
                return true; // Succès
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return false; // Échec
    }
    @Override
    public boolean supprimerStockMedicament(int idMedicament, int quantite) {
        String updateQuery = "UPDATE medicament SET quantite = quantite - ? WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(updateQuery);
            pre.setInt(1, quantite);
            pre.setInt(2, idMedicament);

            // Exécuter la requête
            int result = pre.executeUpdate();

            // Vérifier si l'opération a réussi
            if (result > 0) {
                return true; // Succès
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return false; // Échec
    }

    @Override
    public boolean ajouterStockMedicament(int idMedicament, int quantite) {
        String updateQuery = "UPDATE medicament SET quantite = quantite + ? WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(updateQuery);
            pre.setInt(1, quantite);
            pre.setInt(2, idMedicament);

            // Exécuter la requête
            int result = pre.executeUpdate();

            // Vérifier si l'opération a réussi
            if (result > 0) {
                return true; // Succès
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return false; // Échec
    }

    @Override
    public List<Medicament> lister() {
        List<Medicament> medicaments = new ArrayList<>();
        String query = "SELECT * FROM medicament";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);

            // Exécuter la requête
            res = pre.executeQuery();

            // Parcourir les résultats
            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String description = res.getString("description");
                double prix = res.getDouble("prix");
                int quantiteStock = res.getInt("quantite");
                int idPharmacie = res.getInt("pharmacie_id");
                medicaments.add(new Medicament(id, nom, description, prix, quantiteStock, quantiteStock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return medicaments;
    }

    @Override
    public Medicament chercherParId(int id) {
        Medicament medicament = null;
        String query = "SELECT * FROM medicament WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setInt(1, id);

            // Exécuter la requête
            res = pre.executeQuery();

            // Vérifier si un résultat a été retourné
            if (res.next()) {
                String nom = res.getString("nom");
                String description = res.getString("description");
                double prix = res.getDouble("prix");
                int quantiteStock = res.getInt("quantite");
                int idPharmacie = res.getInt("pharmacie_id");
                medicament = new Medicament(id, nom, description, prix, quantiteStock, quantiteStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return medicament;
    }

    // Méthode utilitaire pour fermer les ressources
    private void closeResources() {
        try {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
