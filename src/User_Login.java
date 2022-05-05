import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User_Login extends JPanel{
	private static final long serialVersionUID = 1L;
    	JFrame UserLoginFrame =new JFrame();
	JLabel LblUserID =new JLabel("User ID:");
	JTextField UserIDText = new JTextField(20);
	
	JButton btnSubmit = new JButton("Submit");
	JButton btnReset = new JButton("Reset");
	JButton btnBack = new JButton("Back");
	
	private final JLabel lblUserPasswd = new JLabel("User Password:");
	private JPasswordField UserPasswdText;
	private final JLabel lblLibraryImage = new JLabel("");

	Connection conn = null;
	
	//Method for establishing connection with MySQL Database
	public  void connection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", Access.Username, Access.Password); 
			
		}catch(Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	//Using Constructor to initialize components in JFrame UserLoginFrame
	public User_Login() {
		userlogin();
	}
	
	//initialization method userlogin()
	public void userlogin() {
		 //Settings of JFrame and all other components
		 UserLoginFrame.setBounds(100, 100, 981, 621);
		 UserLoginFrame.setLocation(500,100);
		 UserLoginFrame.setResizable(false);
		 UserLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 UserLoginFrame.getContentPane().setLayout(null);
		 
		 LblUserID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		 LblUserID.setBounds(25, 183, 243, 26);
		 LblUserID.setForeground(Color.WHITE);
		 
		 lblUserPasswd.setForeground(Color.WHITE);
		 lblUserPasswd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		 lblUserPasswd.setBounds(25, 245, 243, 26);
		 
		 UserIDText.setBounds(184, 185, 181, 26);
		 
		 UserPasswdText = new JPasswordField(20);
		 UserPasswdText.setBounds(184, 247, 181, 26);
		 
		 //JLabel containing Library Image
		 lblLibraryImage.setBounds(0, 0, 975, 586);
		 Image imgg = new ImageIcon(this.getClass().getResource("lib_image.PNG")).getImage();
		 lblLibraryImage.setIcon(new ImageIcon(imgg));
		 
		 btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnSubmit.setBounds(25,330,100,26);
		 btnSubmit.setFocusPainted(false);
		 
		 btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnReset.setBounds(144,330,106,26);
		 btnReset.setFocusPainted(false);
		 
		 btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnBack.setBounds(265,330,100,26);
		 btnBack.setFocusPainted(false);
		 
		 //Adding all components to JFrame
		 UserLoginFrame.getContentPane().add(LblUserID);
		 UserLoginFrame.getContentPane().add(lblUserPasswd);
		 UserLoginFrame.getContentPane().add(btnSubmit);
		 UserLoginFrame.getContentPane().add(btnReset);
		 UserLoginFrame.getContentPane().add(btnBack);
		 UserLoginFrame.getContentPane().add(UserIDText);
		 UserLoginFrame.getContentPane().add(UserPasswdText);
		 UserLoginFrame.getContentPane().add(lblLibraryImage);
		 
		 //Action Listeners for all JButtons
		 btnSubmit.addActionListener(actionevent -> submit());
	     	 btnReset.addActionListener(actionevent -> reset());
	     	 btnBack.addActionListener(actionevent -> back());
		 
		 UserLoginFrame.setVisible(true);
		 UserLoginFrame.setResizable(false);
	}
	
	public void submit() {
		try {
			 connection();
			 /*Converting Text(String) in UserIDText field to integer 
			  * To make sure the UserIDText field only contains numbers (no alphabets or special characters)
			  */
			 try 
				{ 
					Integer.parseInt(UserIDText.getText()); 
				}  
			 catch (NumberFormatException e)  
				{ 
					JOptionPane.showMessageDialog(null, "Invalid ID: The ID only contains numbers","error",JOptionPane.ERROR_MESSAGE); 
				} 
			 
			 //Alert to fill both User ID and Password details otherwise considered incomplete
			 if(UserIDText.getText().equals("") || UserPasswdText.getPassword().equals("")) {
	        	 JOptionPane.showInternalMessageDialog(btnSubmit, "Please complete your details","alert",JOptionPane.WARNING_MESSAGE);
			 }else { 
				 //Verifying User Login details including ID and Password from systen_users table
				 String user = UserIDText.getText().toString();
				 String passwd = String.valueOf(UserPasswdText.getPassword());
		
				 String sql = "select password from system_users where id = '"+user+"'";
				 PreparedStatement stmt=conn.prepareStatement(sql);
				 ResultSet exc= stmt.executeQuery(sql);
				 
				 /* If exc.next() returns a result then it means User Id exists in system_users
				  * then it will verify the password for the entered ID
				  * If exc.next() does not return anything that means the User ID does not exist
				  */
				 
				 if(exc.next()) {
					 String user_pswd = exc.getString(1);
					 //Verifying the password associated with User ID if the User ID exists
					 //If verification succeeds then User_Dashboard class is opened
					 if(passwd.equals(user_pswd)) {
						 new User_Dashboard();
						 UserLoginFrame.dispose();
					 }else {
						 JOptionPane.showMessageDialog(null, "Incorrect Password","error",JOptionPane.ERROR_MESSAGE);
					 }
				 }else {
					 JOptionPane.showMessageDialog(null, "This ID does not exist","error",JOptionPane.ERROR_MESSAGE);
				 }
				 //closing database connection
				 conn.close();
			 }
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
		 }
	}
	
	public void reset() {
		//Setting all JTextFields empty
		UserPasswdText.setText(null);
		UserIDText.setText(null);
	}
	
	public void back() {
		//Going back to Firstpage class
		UserLoginFrame.dispose();
		new Firstpage();
	}
}
