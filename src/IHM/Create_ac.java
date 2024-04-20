package IHM;

import DAO.CrudPharmacieImpl;
import POO.Pharmacie;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

import static java.lang.Character.isDigit;

public class Create_ac extends JFrame {
CrudPharmacieImpl pharmacie=new CrudPharmacieImpl();
    private JPanel contentPane;
    private JTextField idp;
    private JTextField nomp;
    private JTextField adress;
    //private JTextField username;
    private JTextField telephone;
    private JPasswordField passwordField;
    private JButton registButton;
    private JButton GologinButton;
    private JButton ResetButton;
    private JLabel label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Create_ac frame = new Create_ac();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public Create_ac() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\msi\\Logo-Pharmacie-1.jpg"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);

        JLabel lblNewUserRegister = new JLabel("New pharma_Register");
        lblNewUserRegister.setBorder(new LineBorder(new Color(46,139,87)));

        lblNewUserRegister.setForeground(new Color(46,139,87));
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 400, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Id");
        lblName.setForeground(new Color(22, 55, 25));
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 151, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setForeground(new Color(22, 55, 25));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lbladressAddress = new JLabel("adress");
        lbladressAddress.setForeground(new Color(22, 55, 25));
        lbladressAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbladressAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lbladressAddress);

        idp = new JTextField();
        idp.setFont(new Font("Tahoma", Font.PLAIN, 32));
        idp.setBounds(214, 151, 228, 50);
        contentPane.add(idp);
        idp.setColumns(10);

        nomp = new JTextField();
        nomp.setFont(new Font("Tahoma", Font.PLAIN, 32));
        nomp.setBounds(214, 235, 228, 50);
        contentPane.add(nomp);
        nomp.setColumns(10);

        adress = new JTextField();
        adress.setFont(new Font("Tahoma", Font.PLAIN, 32));
        adress.setBounds(214, 320, 228, 50);
        contentPane.add(adress);
        adress.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(22, 55, 25));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 159, 99, 29);
        contentPane.add(lblPassword);

        JLabel lbltelephoneileNumber = new JLabel("phone");
        lbltelephoneileNumber.setForeground(new Color(22, 55, 25));
        lbltelephoneileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbltelephoneileNumber.setBounds(542, 245, 99, 24);
        contentPane.add(lbltelephoneileNumber);

        telephone = new JTextField();
        telephone.setFont(new Font("Tahoma", Font.PLAIN, 32));
        telephone.setBounds(707, 235, 228, 50);
        contentPane.add(telephone);
        telephone.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 151, 228, 50);
        contentPane.add(passwordField);

        registButton = new JButton("Register");
        registButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				int ID=Integer.parseInt(idp.getText());
				String NAME=nomp.getText();
				String ADRESS=adress.getText();
				String mb=telephone.getText();
				String pass1=passwordField.getText();
                Pharmacie ph=new Pharmacie(ID,NAME,ADRESS,mb,pass1);

                if ( pharmacie.chercherParId(ID)!=null){
                    JOptionPane.showMessageDialog(registButton, "ID already exists");
                }else if(mb.length()!=8){
                    JOptionPane.showMessageDialog(registButton, "Number phone must be 8 numbers");
                }else if(mb.length()!=8){

                    JOptionPane.showMessageDialog(registButton, "Number phone Contains only int ");

                }else {

                    boolean x = pharmacie.ajouter(ph);
                    if (x) {
                        JOptionPane.showMessageDialog(registButton, NAME + "ADD SUCCEDED TO DATA BASE");
                    } else JOptionPane.showMessageDialog(registButton, NAME + "Can't be ADDed TO DATA BASE");

                }

                //JOptionPane.showMessageDialog(registButton, ID +NAME+ADRESS+pass1 +mb);



				/*
				String msg=""+first;
				msg+=" \n";
				if(len==10)
				{/
					try{
						//	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
						//	Class.forName("com.mysql.jdbc.Driver");
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book selling system","root","");
							//Statement st=con.createStatement();
							
							String query="INSERT INTO account VALUES('"+first+"','"+last+"','"+user1+"','"+pass1+"','"+adressadd+"','"+mb+"')";
							Statement sta=con.createStatement(); 
							int x=sta.executeUpdate(query);
							if(x==0)
							{
								JOptionPane.showMessageDialog(registButton, "User name is alredy exist");
							}
							else
							{
								JOptionPane.showMessageDialog(registButton,"Welcome, "+msg+"Your account is sucessfully created");
							}
							con.close();
						}
						catch(Exception f)
						{
							System.out.println(f.getMessage());
						}	
				}
				else
				{
					JOptionPane.showMessageDialog(registButton, "Enter a valid telephoneile number");
				}
				
				
			/*	try{
					String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";//driver name
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String db="jdbc:sqlserver://PERSONAL\\SQLEXPRESS:1433;databaseName=test";
					String user="PERSONAL/Soumyadeep";
					String pass="";
					String query="SELECT * FROM INSERT INTO user_details('','"+first+"','"+last+"','"+user1+"','"+pass1+"','"+adressadd+"','"+mb+"')";
					Connection con=DriverManager.getConnection(db,user,pass);
					Statement st=con.createStatement();
					int x=st.executeUpdate(query);
					if(x==1)
					{
						JOptionPane.showMessageDialog(registButton, "This is alredy exist");
					}
					con.close();
				}
				catch(Exception f)
				{
					System.out.println(f.getMessage());
				}	*/
                //JOptionPane.showMessageDialog(registButton,"Welcome, "+msg+"Your account is sucessfully created");
            }
        });
        registButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        registButton.setBackground(new Color(13,209,39));
        registButton.setBounds(345, 397, 139, 40);
        contentPane.add(registButton);

        GologinButton = new JButton("Already Have Account ? Sign in");
        GologinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Pharmacielogin us=new Pharmacielogin();
                us.setTitle("Pharma_TN");
                us.setVisible(true);
            }
        });
        GologinButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        GologinButton.setBounds(297, 474, 435, 40);
        contentPane.add(GologinButton);
GologinButton.setBackground(new Color(13,209,39));
        ResetButton = new JButton("Reset");
        ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ResetButton.setBounds(542, 397, 139, 40);
        ResetButton.setBackground(new Color(13,209,39));
        contentPane.add(ResetButton);

        label = new JLabel("");
        label.setForeground(new Color(22, 55, 25));
        label.setIcon(new ImageIcon("C:\\Users\\Soumyadeep\\Desktop\\Book Hub\\3 (Custom).jpg"));
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}