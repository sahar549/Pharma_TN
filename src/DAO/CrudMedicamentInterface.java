package DAO;

import POO.Medicament;

import java.util.List;

public interface CrudMedicamentInterface {
    boolean ajouter(Medicament medicament);



    boolean supprimer(int id);
    boolean modifier(Medicament medicament);

    boolean supprimerStockMedicament(int idMedicament, int quantite);
    boolean ajouterStockMedicament(int idMedicament, int quantite);


    List<Medicament> lister();
    Medicament chercherParId(int id);
}

