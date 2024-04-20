package POO;

import java.util.List;

public class Pharmacie {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;
    private String pasword;

    public Pharmacie(int id, String nom, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Pharmacie(int id, String nom, String adresse , String telephone, String password) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone=telephone;
        this.pasword=password;

    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "Pharmacie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' + ", telephone='" + telephone + '\''+
                '}';
    }

    public String getTelephone() { return telephone;
    }

    public String getPassword() {
        return pasword;
    }
}
