import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class System_Users extends JPanel{
	private static final long serialVersionUID = -1273345243218224300L;
	
	Connection conn=null;
    ResultSet rs =null;
    ResultSet sr =null;
    
	public JTextField SystemUserIDText;
	public JTextField UserNameText;
	public JTextField LibraryNameText;
	public JTextField EmailText;
	public JTextField SearchText;
	public JRadioButton rdbtnManual;
	public JRadioButton rdbtnAutomatic;
	public JTable TableSystemUser;
	private JPasswordField PasswdText;
	private JPasswordField ConfirmPasswdText;
	
	//Method for establishing connection with MySQL Database
	public  void connection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library",Access.Username, Access.Password); 
			
		}catch(Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}

	//Using Constructor to initialize components in JPanel
	public System_Users() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(100, 100, 1311, 704);
		setLayout(null);
		
		JLabel lblSystemUserID = new JLabel("System User ID:");
		lblSystemUserID.setBounds(34, 50, 144, 24);
		lblSystemUserID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblSystemUserID);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(34, 100, 144, 16);
		lblUserName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblUserName);
		
		JLabel lblIDType = new JLabel("ID Type:");
		lblIDType.setBounds(34, 149, 144, 24);
		lblIDType.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblIDType);
		
		JLabel lblLibraryName = new JLabel("Library Name:");
		lblLibraryName.setBounds(34, 199, 144, 24);
		lblLibraryName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblLibraryName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblEmail.setBounds(34, 251, 144, 16);
		add(lblEmail);
		
		JLabel lblPasswd = new JLabel("Password:");
		lblPasswd.setBounds(34, 299, 144, 16);
		lblPasswd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblPasswd);
		
		JLabel lblConfirmPasswd = new JLabel("Confirm Password:");
		lblConfirmPasswd.setBounds(34, 349, 158, 16);
		lblConfirmPasswd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(lblConfirmPasswd);
		
		JLabel lblColon = new JLabel(":");
		lblColon.setBounds(163, 561, 7, 30);
		lblColon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblColon);
		
		SystemUserIDText = new JTextField();
		SystemUserIDText.setBounds(201, 51, 158, 22);
		SystemUserIDText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SystemUserIDText.setColumns(10);
		add(SystemUserIDText);
		
		UserNameText = new JTextField();
		UserNameText.setBounds(201, 99, 158, 22);
		UserNameText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		UserNameText.setColumns(10);
		add(UserNameText);
		
		LibraryNameText = new JTextField();
		LibraryNameText.setBounds(201, 202, 158, 22);
		LibraryNameText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		LibraryNameText.setColumns(10);
		add(LibraryNameText);
		
		EmailText = new JTextField();
		EmailText.setBounds(201, 250, 158, 22);
		EmailText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		EmailText.setColumns(10);
		add(EmailText);
		
		PasswdText = new JPasswordField();
		PasswdText.setBounds(201, 297, 158, 22);
		add(PasswdText);
		
		ConfirmPasswdText = new JPasswordField();
		ConfirmPasswdText.setBounds(201, 347, 158, 22);
		add(ConfirmPasswdText);
		
		SearchText = new JTextField();
		SearchText.setBounds(182, 565, 158, 22);
		SearchText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SearchText.setColumns(10);
		add(SearchText);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setBounds(34, 396, 93, 25);
		btnAdd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFocusPainted(false);
		btnSave.setBounds(139, 396, 103, 25);
		btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusPainted(false);
		btnDelete.setBounds(139, 434, 105, 25);
		btnDelete.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false);
		btnReset.setBounds(34, 434, 97, 25);
		btnReset.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnReset);
		
		JButton btnView = new JButton("View");
		btnView.setFocusPainted(false);
		btnView.setBounds(254, 396, 105, 25);
		btnView.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnView);
		
		JButton btnShowDatabase = new JButton("Table");
		btnShowDatabase.setFocusPainted(false);
		btnShowDatabase.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnShowDatabase.setBounds(256, 434, 105, 25);
		add(btnShowDatabase);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFocusPainted(false);
		btnSearch.setBounds(53, 564, 99, 25);
		btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnSearch);
		
		rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setBackground(new Color(255, 250, 232));
		rdbtnManual.setBounds(163, 151, 69, 25);
		rdbtnManual.setSelected(true);
		add(rdbtnManual);
		
		rdbtnAutomatic = new JRadioButton("Automatic");
		rdbtnAutomatic.setBackground(new Color(255, 250, 232));
		rdbtnAutomatic.setBounds(262, 151, 97, 25);
		add(rdbtnAutomatic);
		
		ButtonGroup bg1 = new ButtonGroup( );
        bg1.add(rdbtnManual);
		bg1.add(rdbtnAutomatic);
		rdbtnManual.setSelected(true);
		
		JScrollPane ScrollPaneSystemUser = new JScrollPane();
		ScrollPaneSystemUser.setBounds(390, 23, 903, 657);
		ScrollPaneSystemUser.getViewport().setBackground(new Color(255, 250, 232));
		add(ScrollPaneSystemUser);
		
		TableSystemUser = new JTable();
		TableSystemUser.setBackground(new Color(255, 255, 255));
		TableSystemUser.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		TableSystemUser.setRowHeight(TableSystemUser.getRowHeight() + 10);
		JTableHeader header = TableSystemUser.getTableHeader();
        header.setBackground(new Color(255, 250, 232));
        header.setForeground(Color.BLACK);
		ScrollPaneSystemUser.setViewportView(TableSystemUser);
		
		//All action listeners
		btnReset.addActionListener(actionevent -> reset());
	    btnDelete.addActionListener(actionevent ->remove());
	    btnSearch.addActionListener(actionevent -> searche());
	    btnView.addActionListener(actionevent -> look());
	    btnAdd.addActionListener(actionevent -> addition());
	    btnSave.addActionListener(actionevent -> saved());
	    btnShowDatabase.addActionListener(actionevent -> table());
	    rdbtnManual.addActionListener(actionevent ->textedit());
	    rdbtnAutomatic.addActionListener(actionevent ->notextedit());
		
		setVisible(true);
		
	}
	
	public void reset() {
		//Setting all JTextFields empty
		SystemUserIDText.setText("");
		UserNameText.setText("");
		LibraryNameText.setText("");
		EmailText.setText("");
		PasswdText.setText("");
		ConfirmPasswdText.setText("");
		SearchText.setText("");
	}
	
	public void notextedit() {
		/*This method sets SystemUserIDText JTextField empty
		 *and makes it non-editable when ID Type:Automatic option
		 *is selected as there is no need to insert an id number for
		 *system_user in SQL because the id will be assigned
		 *automatically upon insertion
		 */
		SystemUserIDText.setText(null);
		SystemUserIDText.setEditable(false);
		SystemUserIDText.setBackground(new Color(255, 250, 232));
	}
	
	public void textedit() {
		/*This method makes SystemUserIDText JTextField editable 
		 *i.e. a number can be entered in that JTextField
		 *for the purpose of adding an id to system_user table
		 *when ID Type:Manual is selected 
		 */
		SystemUserIDText.setEditable(true);
		SystemUserIDText.setBackground(Color.WHITE);
	}
	
	public void manualaddition() {
		 try {
			 /*This method is for manual insertion upon clicking "Add" button 
			  *which means the id in system_users table needs to be entered by 
			  *the system admin
			  */
		     connection();
		     textedit();
			 String sql="insert into system_users (id,username,library_name,email,password) values (?,?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,SystemUserIDText.getText());
			 pst.setString(2,firstLetterCapital(UserNameText.getText()));
			 pst.setString(3,firstLetterCapital(LibraryNameText.getText()));
			 pst.setString(4,EmailText.getText().toLowerCase());
			 
			 /*Before inserting password, this code checks if the password entered in
			  *PasswdText and ConfirmPasswdText is same. If the two values do match only 
			  *then the password will be saved along with the above details in system_user
			  *table otherwise an error message will be displayed
			  */
			 String passwd = String.valueOf(PasswdText.getPassword());
			 String confirmpasswd = String.valueOf(ConfirmPasswdText.getPassword());
			 if(passwd.equals(confirmpasswd)) {
				 pst.setString(5,passwd);
				 pst.executeUpdate();
			 }else{
				 JOptionPane.showMessageDialog(null, "Password and confirm password are not the same!","error",JOptionPane.ERROR_MESSAGE);
			 }
			 
			 //This SQL and Java code is for displaying the table after the new insertion
			 String ser = "select id,username,library_name,email from system_users";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	public void automaticaddition() {
		try {
			 /*This method is for automatic insertion upon clicking add button
			  *which means that there is no need to insert a user id. The system_user
			  *table will automatically assign one upon insertion because of auto_increment
			  *constraint on system_user table
			  */
		     connection();
		     notextedit();
			 String sql="insert into system_users (username,library_name,email,password) values (?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(UserNameText.getText()));
			 pst.setString(2,firstLetterCapital(LibraryNameText.getText()));
			 pst.setString(3,EmailText.getText().toLowerCase());
			 
			 /*Before inserting password, this code checks if the password entered in
			  *PasswdText and ConfirmPasswdText is same. If the two values do match only 
			  *then the password will be saved along with the above details in system_user
			  *table otherwise an error message will be displayed
			  */
			 String passwd = String.valueOf(PasswdText.getPassword());
			 String confirmpasswd = String.valueOf(ConfirmPasswdText.getPassword());
			 if(passwd.equals(confirmpasswd)) {
				 pst.setString(4,passwd);
				 pst.executeUpdate();
			 }else{
				 JOptionPane.showMessageDialog(null, "Password and confirm password are not the same!","error",JOptionPane.ERROR_MESSAGE);
			 }
			 
			 //This SQL and Java code is for displaying the table after the new insertion
			 String ser = "select id,username,library_name,email from system_users";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}
	public void addition() {
		try {
			/*This method decides which way the insertion will take place based on whether 
			 *manual option is selected or automatic is selected for ID Type
			 */
			if(rdbtnAutomatic.isSelected()) {
				automaticaddition();
			}else{
				manualaddition();
			}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
		}
	
	
	public void remove() {
		try {
			 /*This method deletes a row from the system_user table associated with the 
			  *user id entered in in SystemUserIDText JTextField
			  */
		     connection();
			 String sql="delete from system_users where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,SystemUserIDText.getText());
			 pst.executeUpdate();
			 
			 //The below SQL and Java code displays the table after the deletion
			 String ser = "select id,username,library_name,email from system_users";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}

	public void searche() {
		try {
		 //This method searches the whole table for the string which will be entered in the SearchText JTextField
		 connection();
		 String sql="select id,username,library_name,email from system_users where CONCAT(id,username,library_name,email) like '%"+SearchText.getText()+"%';";
		 PreparedStatement pst = conn.prepareStatement(sql);
		 rs=pst.executeQuery();
	     TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
	}catch(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
	}
	}
	
	public void look() {
		try {
			 /*This method does two things: 
			  *1) It displays the whole table if the SystemUserIDText JTextField is empty
			  *2) It displays all the values of a particular row in their respective JTextFields
			  *   based on the User ID entered in SystemUserIDText JTextField 
			  *The purpose of this method is not only for viewing but also to make 
			  *updating more convenient for the user
			  */
			 connection();
			 if(SystemUserIDText.getText().equals("") && UserNameText.getText().equals("") && LibraryNameText.getText().equals("") && EmailText.getText().equals("")) {
				 String ser = "select id,username,library_name,email from system_users";
				 PreparedStatement sat = conn.prepareStatement(ser);
				 rs=sat.executeQuery();
				 TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
			 }else if(SystemUserIDText.getText().equals(SystemUserIDText.getText())) {
				 String sql = "select id,username,library_name,email from system_users where id = ?";
			     PreparedStatement pst=conn.prepareStatement(sql);
			       pst.setString(1,SystemUserIDText.getText());
                   rs = pst.executeQuery();
			    while(rs.next()) { 
			        SystemUserIDText.setText(rs.getString("id"));
			        UserNameText.setText(rs.getString("username"));
			        LibraryNameText.setText(rs.getString("library_name"));
			        EmailText.setText(rs.getString("email"));
			    }
			         //The below Java code only displays the row in the table whose User ID is entered
				     PreparedStatement stmt=conn.prepareStatement(sql);
				     stmt.setString(1,SystemUserIDText.getText());
				     sr=stmt.executeQuery();
				     TableSystemUser.setModel(DbUtils.resultSetToTableModel(sr));
			 }}
	      catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
			 }
	}
	
	public void table() {
		try {
			 //This method displays the whole table regardless of any JTextField being non-empty
			 connection();
			 String ser = "select id,username,library_name,email from system_users";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableSystemUser.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saved() {
		try {
			 //This method is used to update values in system_user table 
			 connection();
			 String sql="update system_users set username = ?,library_name = ?,email = ? where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(UserNameText.getText()));
			 pst.setString(2,firstLetterCapital(LibraryNameText.getText()));
			 pst.setString(3,EmailText.getText().toLowerCase());
			 pst.setString(4,SystemUserIDText.getText());
			 pst.executeUpdate();
			 //The below SQL and Java code displays the table after the updating values
			 String sql1 ="select id,username,library_name,email from system_users where id = ?";
			 PreparedStatement stmt=conn.prepareStatement(sql1);
		     stmt.setString(1,SystemUserIDText.getText());
		     sr=stmt.executeQuery();
		     TableSystemUser.setModel(DbUtils.resultSetToTableModel(sr));
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String firstLetterCapital(String sentence) {
		/*This method makes first letter capital of any sentence
		 *The purpose of this method is to maintain case sensitivity for all 
		 *SQL varchar data types across all tables so that strings like "joel khosla", 
		 *"JOEL KHOSLA","jOeL kHoSlA" and "JoEl KhOsLa" will all be saved as "Joel Khosla" 
		 */
		StringBuilder st = new StringBuilder();
		int start = 0;
		String str = "";
		char upper = 'a';
		char first = 'a';
		
		//If sentence is empty then it returns an empty String
		if(sentence.equals("")) {
			return sentence;
		}else {
			/*If first letter of sentence does not start with a whitespace 
			 *then the first letter will be saved as a character in Java and
			 *converted to UpperCase and appended in String Builder st
			 */
			if(sentence.charAt(start) != ' ') {
				first = Character.toUpperCase(sentence.charAt(start));
				st.append(first);
				}
		}
		
		for(; ;)  
		{ 
		/*After making the first letter capital, the rest of sentence will be searched 
		 *for whitespace because each word starts after a whitespace. Then the index of 
		 *the whitespace will be saved in the variable index
		 */
		int index = sentence.indexOf(" ", start);  
		  
		if(index >= 0)  
		{  
		    /*If index is greater than zero which means there is more then one word 
		     * in a sentence (after a whitespace) then the first letter of the next word
		     * (which comes after whitespace,hence index + 1 will be changed to UpperCase and 
		     * saved in variable upper while the rest of the word after the first letter will 
		     * be converted to LowerCase and appended to st
		     */
			st.append(sentence.substring(start+1, index+1).toLowerCase());
			upper = Character.toUpperCase(sentence.charAt(index + 1));  
			st.append(upper);
		    /*Then again change the start from 0 to the letter after the first whitespace so that 
		     *the loop can run again and find the next whitespace with a new start index  
		     */
			start = index + 1;  
		}
		  
		else  
		{  
		    /*If there is no more whitespace i.e. no new word in the sentence after say ten words
		     * then this code will convert the rest of the portion of the last word after the first letter 
		     * to LowerCase and append it to st
		     */
			st.append(sentence.substring(start+1, sentence.length()).toLowerCase());
			break;
		}  
		}
		// Converting string builder st to String and returning it
		str = st.toString();
		return(str);
	}
  
	
	public static void main(String args[]) {
		new System_Users();
	}
}
