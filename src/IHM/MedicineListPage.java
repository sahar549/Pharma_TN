package IHM;

import DAO.CrudMedicamentImpl;
import DAO.CrudPharmacieImpl;
import POO.Medicament;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import static IHM.Pharmacielogin.idp;

public class MedicineListPage extends JFrame {
    private JButton addButton;
    private JButton deleteButton;
    private JButton modifyStockButton;
    private JTable medicineTable;
    private DefaultTableModel tableModel;

    public MedicineListPage(int idp) {
        setTitle("Medicine List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des boutons
        addButton = new JButton("Add Medicine");
        deleteButton = new JButton("Delete Medicine");
        modifyStockButton = new JButton("Modify Stock");

        // Création du modèle de tableau avec des colonnes
        String[] columns = {"ID", "Name", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columns, 0);

        // Création du tableau avec le modèle
        medicineTable = new JTable(tableModel);
        medicineTable.setBackground(new Color(230, 255, 230)); // Vert clair pour la couleur de fond de la table
        medicineTable.getTableHeader().setBackground(new Color(34, 139, 34)); // Vert foncé pour la couleur de fond de l'en-tête
        medicineTable.getTableHeader().setForeground(Color.WHITE); // Texte blanc pour l'en-tête
        medicineTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14)); // Police de caractères pour l'en-tête
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1); // Bold border with thickness 2
        medicineTable.setBorder(border); // Add bold border


        // Création du panneau de boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);

        buttonPanel.add(modifyStockButton);
        buttonPanel.add(deleteButton);
        addButton.setBackground(new Color(34, 139, 34)); // Vert foncé
        addButton.setForeground(Color.WHITE); // Texte blanc
        deleteButton.setBackground(new Color(220, 20, 60)); // Rouge
        deleteButton.setForeground(Color.WHITE); // Texte blanc
        modifyStockButton.setBackground(Color.black); // Vert
        modifyStockButton.setForeground(Color.WHITE); // Texte blanc

        // Création du panneau principal avec le tableau et les boutons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(medicineTable), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajout du panneau principal à la fenêtre
        add(mainPanel);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter details of the new medicine
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID of the medicine:"));
                String name = JOptionPane.showInputDialog(null, "Enter name of the medicine:");

                String description = JOptionPane.showInputDialog(null, "Enter description of the medicine:");
                String priceStr = JOptionPane.showInputDialog(null, "Enter price of the medicine:");
                double price = Double.parseDouble(priceStr);
                String quantityStr = JOptionPane.showInputDialog(null, "Enter quantity of the medicine:");
                int quantity = Integer.parseInt(quantityStr);

                // Create a new Medicament object with the entered details
                Medicament newMedicine = new Medicament(id,name, description, price, quantity,idp);

                // Add the new medicine to the database using the DAO
                CrudMedicamentImpl medicamentDao = new CrudMedicamentImpl();
                boolean success = medicamentDao.ajouter(newMedicine);

                // Check if the medicine was successfully added
                if (success) {
                    JOptionPane.showMessageDialog(null, "Medicine added successfully.");

                    // Refresh the table to reflect the changes
                    tableModel.addRow(new Object[]{newMedicine.getId(),id, name, description, price, quantity});
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add medicine.");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Demander à l'utilisateur d'entrer l'ID du médicament à supprimer
                String idStr = JOptionPane.showInputDialog(null, "Enter ID of the medicine to delete:");
                int id = Integer.parseInt(idStr);

                // Appeler la méthode de suppression appropriée dans la classe DAO
                CrudMedicamentImpl medicamentDao = new CrudMedicamentImpl();
                boolean success = medicamentDao.supprimer(id);

                // Afficher un message à l'utilisateur en fonction du résultat de la suppression
                if (success) {
                    JOptionPane.showMessageDialog(null, "Medicine deleted successfully.");
                    // Actualiser la table pour refléter les modifications
                    tableModel.setRowCount(0);
                    loadMedicineData();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete medicine.");
                }
            }
        });
        modifyStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Demander à l'utilisateur d'entrer l'ID et la quantité à ajouter au stock du médicament
                String idStr = JOptionPane.showInputDialog(null, "Enter ID of the medicine to modify stock:");
                int id = Integer.parseInt(idStr);
                String quantityStr = JOptionPane.showInputDialog(null, "Enter quantity to add to stock:");
                int quantity = Integer.parseInt(quantityStr);

                // Appeler la méthode pour ajouter la quantité au stock du médicament dans la classe DAO
                CrudMedicamentImpl medicamentDao = new CrudMedicamentImpl();
                boolean success = medicamentDao.ajouterStockMedicament(id, quantity);

                // Afficher un message à l'utilisateur en fonction du résultat de l'ajout de stock
                if (success) {
                    JOptionPane.showMessageDialog(null, "Stock modified successfully.");
                    // Actualiser la table pour refléter les modifications
                    tableModel.setRowCount(0);
                    loadMedicineData();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to modify stock.");
                }
            }
        });


        // Load medicine data from database
        loadMedicineData();
    }

    // Method to load medicine data from database
    private void loadMedicineData() {
        // Retrieve medicine data from database using DAO
         CrudPharmacieImpl PH = new CrudPharmacieImpl();
        List<Medicament> medicines = PH.listerMedicamentsParPharmacie(idp);

        // Populate table with medicine data
        for (Medicament medicine : medicines) {
            Object[] rowData = {medicine.getId(), medicine.getNom(), medicine.getPrix(), medicine.getQuantiteStock()};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedicineListPage(idp).setVisible(true);
            }
        });
    }
}
