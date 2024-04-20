package IHM;

import DAO.CrudPharmacieImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pharmacielogin extends JFrame {
static int idp;
    private JPanel contentPane;
    private static JTextField textField;
    private JPasswordField passwordField;
    private JButton LoginButton;
    private JButton createButton;
    private JButton ResetButton;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pharmacielogin frame = new Pharmacielogin();

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
    public Pharmacielogin() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\msi\\Logo-Pharmacie-1.jpg"));

        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\msi\\Logo-Pharmacie-1.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("  Pharmacie Login ");


        lblNewLabel.setForeground(new Color(46,139,87));
        lblNewLabel.setBorder(new LineBorder(new Color(46,139,87)));
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewLabel.setBounds(373, 22, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
        textField.setBounds(760, 170, 200, 50);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(760, 286, 200, 50);
        contentPane.add(passwordField);

        JLabel lblPharmaciename = new JLabel("Pharmacie_name");
        lblPharmaciename.setForeground(new Color(22, 55, 25));
        lblPharmaciename.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPharmaciename.setBounds(550, 170, 200, 50);

        contentPane.add(lblPharmaciename);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(22, 55, 25));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPassword.setBounds(600, 290, 200, 50);
        contentPane.add(lblPassword);

        LoginButton = new JButton("Login");
        LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        LoginButton.setBounds(670, 387, 113, 52);
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i=0,j=0;
                String ustr=textField.getText();
                String pstr=passwordField.getText();
                CrudPharmacieImpl pharmacie=new CrudPharmacieImpl();
               boolean log= pharmacie.login(Integer.parseInt(ustr),pstr);
               if (log) {
                   idp=Integer.parseInt(ustr);
                   dispose();
                  MedicineListPage ca = new MedicineListPage(idp);
                   ca.setTitle("Pharmacie ");
                   ca.setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(LoginButton, "Cant connect ");

               }
				/*		try{
					//	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
					//	Class.forName("com.mysql.jdbc.Driver");
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book selling system","root","");
						//Statement st=con.createStatement();

						String query="Select Pharmacie1 from account";
						Statement sta=con.createStatement();
			//			resultSet x=sta.executeUpdate(query);
						while(x!=1)
						{

						}
						if(x==0)
						{
							JOptionPane.showMessageDialog(LoginButton, "Wrong Pharmacie namet");
						}
						else
						{
						//	JOptionPane.showMessageDialog(LoginButton,"Welcome, "+msg+"Your account is sucessfully created");
							dispose();
							PharmacieHost uh=new PharmacieHost();
							uh.setTitle("Book Hub");
							uh.setVisible(true);
							JOptionPane.showMessageDialog(LoginButton, "You have successfully logged in");
						}
						con.close();
					}
					catch(Exception f)
					{
						System.out.println(f.getMessage());
					}*/
                /**	for(i=0;i<2;i++)
                 {

                 if(pass[i].equals(ustr))
                 {
                 for(j=0;j<2;j++)
                 {
                 if(pass[i].equals(pstr))
                 {
                 JOptionPane.showMessageDialog(LoginButton, "You have successfully logged in");
                 break;
                 }
                 }
                 }
                 }
                 if(i==2 && j==0)
                 {

                 JOptionPane.showMessageDialog(LoginButton, "Wrong Pharmaciename");
                 }
                 else if(j==2)
                 {
                 JOptionPane.showMessageDialog(LoginButton, "Wrong Password");
                 }

                 if( ustr.equals("Soumya") && pstr.equals("1234"))
                 {
                 dispose();
                 PharmacieHost uh=new PharmacieHost();
                 uh.setTitle("Book Hub");
                 uh.setVisible(true);
                 JOptionPane.showMessageDialog(LoginButton, "You have successfully logged in");
                 }
                 else
                 {
                 JOptionPane.showMessageDialog(LoginButton, "Wrong Pharmaciename & Password");
                 }
                 /*	try
                 {
                 String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";//driver name
                 Class.forName(drivername);
                 String db="jdbc:sqlserver://PERSONAL\\SQLEXPRESS:1433;databaseName=test";//connection string
                 String Pharmacie="sa";
                 String pass="1234";
                 Connection con=DriverManager.getConnection(db,Pharmacie,pass);




                 Statement st=con.createStatement();
                 ResultSet rs=st.executeQuery("SELECT uid,Pharmaciename,password FROM Pharmacie WHERE Pharmaciename='"+ ustr +"' AND password='"+ pstr +"'");
                 while(rs.next())
                 {
                 dispose();
                 AdminLogin al=new AdminLogin();
                 al.setVisible(true);
                 }



                 }
                 catch(Exception e1)
                 {
                 System.out.println(e1);
                 }*.


                 /*try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","soumya","1234");
                 String query="select * from tlogin where Pharmacie_name='"+ustr+"' and password='"+pstr+"'";
                 Statement st=con.createStatement();
                 int x=st.executeUpdate(query);
                 if(x==1)
                 {
                 JOptionPane.showMessageDialog(LoginButton, "This is alredy exist");
                 }
                 con.close();
                 }
                 catch(Exception f)
                 {
                 System.out.println(f);
                 }		*/
            }
        });
LoginButton.setBackground(new Color(13,209,39));
        contentPane.add(LoginButton);

        createButton = new JButton("Create new account");
        createButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
                Create_ac ca = new Create_ac();
                ca.setTitle("Book Hub");
                ca.setVisible(true);
            }
        });
        createButton.setBounds(650, 470, 281, 52);
        createButton.setBackground(new Color(13,209,39));
        contentPane.add(createButton);

        ResetButton = new JButton("Reset ");
        ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ResetButton.setBackground(new Color(13,209,39));
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        ResetButton.setBounds(800, 387, 113, 52);
        contentPane.add(ResetButton);


        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("C:\\Users\\msi\\Desktop\\Logo_Pharmacie_centrale_de_Tunisie.png"));
        label_1.setBounds(-200, 0, 1218, 620);
        contentPane.add(label_1);


    }

}
