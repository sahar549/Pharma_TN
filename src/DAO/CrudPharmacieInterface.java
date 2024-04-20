package DAO;

import POO.Medicament;
import POO.Pharmacie;

import java.util.List;
import java.util.Map;

public interface CrudPharmacieInterface {
    boolean ajouter(Pharmacie pharmacie);


    List<Medicament> listerMedicamentsParPharmacie(int idPharmacie);

    boolean supprimer(int id);
    boolean modifier(Pharmacie pharmacie);
    List<Pharmacie> lister();
    Pharmacie chercherParId(int id);
    public boolean login(int id , String password);

}
