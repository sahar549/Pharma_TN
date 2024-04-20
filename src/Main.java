import DAO.CrudMedicamentImpl;
import DAO.CrudPharmacieImpl;
import POO.Medicament;
import POO.Pharmacie;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        CrudMedicamentImpl medicament=new CrudMedicamentImpl();
        CrudPharmacieImpl pharmacie=new CrudPharmacieImpl();
       //  Pharmacie ph=new Pharmacie(21,"Pharmacie zytouna", "sfax","25135999");
        //pharmacie.ajouter(ph);
        //Medicament med=new Medicament(1,"Aspirine", "Antalgique, anti-inflammatoire et antipyrétique", 3.49, 80, 21);
        // Medicament med=new Medicament(249,"panadol", "Antidouleur, anti-inflammatoire et antipyrétique", 3.49, 50, 21);
        //Medicament med=new Medicament(249,"panadol", "Antidouleur, anti-inflammatoire et antipyrétique", 3.49, 0, 21);
        //Medicament med2 = new Medicament(250, "Aspirin", "Antidouleur, anti-inflammatoire et antipyrétique", 2.99, 30,21);
        //Medicament med3 = new Medicament(251,  "Amoxicilline", "Antibiotique", 5.49, 20,21);
       // Medicament med4 = new Medicament(252,  "Loratadine", "Antihistaminique", 3.79, 40,21);
       // Medicament med5 = new Medicament(253,  "Ibuprofène", "Antidouleur, anti-inflammatoire et antipyrétique", 4.29, 25,21);
       // Medicament med6 = new Medicament(254,  "Paracétamol", "Antidouleur, antipyrétique", 3.29, 50,21);
      //  Medicament med7 = new Medicament(255,  "Cetirizine", "Antihistaminique", 3.99, 35,21);
       // Medicament med8 = new Medicament(256,  "Ranitidine", "Antiulcéreux", 6.59, 15,21);
        //Medicament med9 = new Medicament(257,  "Diazépam", "Anxiolytique, sédatif, hypnotique", 7.49, 10,21);
        //Medicament med10 = new Medicament(258,  "Omeprazole", "Antiulcéreux", 5.79, 20,21);
        //medicament.ajouter(med);
     // medicament.ajouter(med2);medicament.ajouter(med3);medicament.ajouter(med4);medicament.ajouter(med5);

//medicament.supprimer(22);
       List<Medicament> medicaments = new ArrayList<>();
        medicaments=pharmacie.listerMedicamentsParPharmacie(45);
        System.out.println(medicaments);
        boolean a=medicament.supprimerStockMedicament(21, 2);
        System.out.println(a);
        System.out.println(medicaments);

        // medicament.modifier(med);
    }
}