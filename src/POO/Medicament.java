package POO;

public class Medicament {
    private int id;
    private String nom;
    private String description;
    private double prix;
    private int quantiteStock;
    private int idPharmacie;

    public Medicament(int id, String nom, String description, double prix,  int quantiteStock,int idPharmacie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.idPharmacie = idPharmacie;
    }

    public Medicament(int id ,String name, String description, double price, int quantity) {
        this.id = id;
        this.nom = name;
        this.description = description;
        this.prix = price;
        this.quantiteStock = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public int getIdPharmacie() {
        return idPharmacie;
    }

    public void setIdPharmacie(int idPharmacie) {
        this.idPharmacie = idPharmacie;
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "Medicament{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantiteStock=" + quantiteStock +
                ", idPharmacie=" + idPharmacie +
                '}';
    }
}
