package DAO;

import POO.Medicament;
import POO.Pharmacie;
import DB.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class CrudPharmacieImpl implements CrudPharmacieInterface {
    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet res = null;

    public static int id_pharmacie;
  @Override
    public boolean login(int id , String password)  {
        String query = "SELECT id,password FROM pharmacie WHERE id = ?";
        con = Connect.getConnection();

        // Préparer la requête SQL
        try {
            pre = con.prepareStatement(query);
            pre.setInt(1, id);
            // Exécuter la requête
            ResultSet res = pre.executeQuery();

            // Vérifier si l'opération a réussi
            while (res.next()) {
                int ID = res.getInt("id");
                String PASSWORD = res.getString("password");
                if(PASSWORD.equals(password)){
                    System.out.println("verified successfully ");
                    id_pharmacie=ID;
                    return true;
                }

                else {
                    System.out.println("Password incorrect ");

                    return false;}
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      System.out.println("Can't connect ");

        return false ;
    }
    @Override
    public boolean ajouter(Pharmacie pharmacie) {
        String query = "INSERT INTO pharmacie (id, nom, adresse, telephone,password) VALUES (?, ?, ?, ?,?)";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setInt(1, pharmacie.getId());
            pre.setString(2, pharmacie.getNom());
            pre.setString(3, pharmacie.getAdresse());
            pre.setString(4, pharmacie.getTelephone());
            pre.setString(5, pharmacie.getPassword());

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
    public List<Medicament> listerMedicamentsParPharmacie(int idPharmacie) {
        List<Medicament> medicaments = new ArrayList<>();
        String query = "SELECT * FROM medicament WHERE pharmacie_id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setInt(1, idPharmacie);

            // Exécuter la requête
            res = pre.executeQuery();

            // Parcourir les résultats
            while (res.next()) {
                int id = res.getInt("id");
                idPharmacie = res.getInt("pharmacie_id");
                String nom = res.getString("nom");
                String description = res.getString("description");
                double prix = res.getDouble("prix");
                int stock = res.getInt("quantite");

                medicaments.add(new Medicament(id, nom, description, prix, stock , idPharmacie));
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
    public boolean supprimer(int id) {
        String query = "DELETE FROM pharmacie WHERE id = ?";

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
    public boolean modifier(Pharmacie pharmacie) {
        String query = "UPDATE pharmacie SET nom = ?, adresse = ?,telephone = ? WHERE id = ?";

        try {
            // Établir la connexion à la base de données
            con = Connect.getConnection();

            // Préparer la requête SQL
            pre = con.prepareStatement(query);
            pre.setString(1, pharmacie.getNom());
            pre.setString(2, pharmacie.getAdresse());
            pre.setString(3, pharmacie.getTelephone());
            pre.setInt(4, pharmacie.getId());

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
    public List<Pharmacie> lister() {
        List<Pharmacie> pharmacies = new ArrayList<>();
        String query = "SELECT * FROM pharmacies";

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
                String adresse = res.getString("adresse");
                String telephone = res.getString("telephone");


                pharmacies.add(new Pharmacie(id, nom, adresse,telephone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return pharmacies;
    }

    @Override
    public Pharmacie chercherParId(int id) {
        Pharmacie pharmacie = null;
        String query = "SELECT * FROM pharmacie WHERE id = ?";

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
                String adresse = res.getString("adresse");
                String telephone = res.getString("telephone");

                pharmacie = new Pharmacie(id, nom, adresse,telephone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            closeResources();
        }
        return pharmacie;
    }

    // Méthode utilitaire pour fermer les ressources

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

