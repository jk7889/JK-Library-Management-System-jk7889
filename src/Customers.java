import java.awt.*;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
public class Customers extends JPanel{
	private static final long serialVersionUID = 1L;

	Connection conn=null;
    ResultSet rs =null;
    ResultSet sr =null;
    ResultSet sr1 =null;

    ResultSet nr =null;
    ResultSet mn =null;
    Statement pst =null;
	
	public JTextField CustomerIDText;
	public JTextField CustomerNameText;
	public JTextField AddressText;
	public JTextField PhoneNumberText;
	public JTextField CityText;
	public JTextField SearchText;
	public JRadioButton rdbtnManual;
	public JRadioButton rdbtnAutomatic;
    public JTable TableCustomers;
    
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
	public Customers() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(0, 0, 1311, 704);
		setLayout(null);

        JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCustomerID.setBounds(39, 70, 116, 16);
		add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCustomerName.setBounds(39, 117, 149, 22);
		add(lblCustomerName);
		
		JLabel lblIDType = new JLabel("ID Type:");
		lblIDType.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblIDType.setBounds(39, 174, 84, 22);
		add(lblIDType);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblAddress.setBounds(39, 235, 97, 16);
		add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblPhoneNumber.setBounds(39, 284, 127, 16);
		add(lblPhoneNumber);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCity.setBounds(42, 328, 56, 30);
		add(lblCity);
		
		JLabel lblColon = new JLabel(":");
		lblColon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblColon.setBounds(148, 607, 7, 30);
		add(lblColon);
		
		CustomerIDText = new JTextField();
		CustomerIDText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CustomerIDText.setBounds(200, 67, 116, 22);
		add(CustomerIDText);
		CustomerIDText.setColumns(10);
		
		CustomerNameText = new JTextField();
		CustomerNameText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CustomerNameText.setBounds(200, 117, 116, 22);
		add(CustomerNameText);
		CustomerNameText.setColumns(10);
		
		AddressText = new JTextField();
		AddressText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		AddressText.setBounds(200, 232, 116, 22);
		add(AddressText);
		AddressText.setColumns(10);
		
		PhoneNumberText = new JTextField();
		PhoneNumberText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		PhoneNumberText.setBounds(200, 281, 116, 22);
		add(PhoneNumberText);
		PhoneNumberText.setColumns(10);
		
		CityText = new JTextField();
		CityText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CityText.setBounds(200, 332, 116, 22);
		add(CityText);
		CityText.setColumns(10);
		
		SearchText = new JTextField();
		SearchText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SearchText.setBounds(167, 610, 116, 25);
		add(SearchText);
		SearchText.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setBounds(24, 403, 86, 25);
		btnAdd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFocusPainted(false);
		btnSave.setBounds(122, 403, 97, 25);
		btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnSave);
		
		JButton btnView = new JButton("View");
		btnView.setFocusPainted(false);
		btnView.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnView.setBounds(231, 403, 85, 25);
		add(btnView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false);
		btnReset.setBounds(24, 441, 97, 25);
		btnReset.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnReset);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusPainted(false);
		btnDelete.setBounds(132, 441, 87, 25);
		btnDelete.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnDelete);
		
		JButton btnShowDatabase = new JButton("Table");
	    btnShowDatabase.setFocusPainted(false);
	    btnShowDatabase.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	    btnShowDatabase.setBounds(230, 441, 86, 25);
	    add(btnShowDatabase);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFocusPainted(false);
		btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnSearch.setBounds(37, 610, 99, 25);
		add(btnSearch);
		
		rdbtnManual = new JRadioButton("Manual");
	    rdbtnManual.setBackground(new Color(255, 250, 232));
		rdbtnManual.setBounds(142, 175, 69, 25);
		add(rdbtnManual);
		
		rdbtnAutomatic = new JRadioButton("Automatic");
		rdbtnAutomatic.setBackground(new Color(255, 250, 232));
		rdbtnAutomatic.setBounds(227, 175, 97, 25);
		add(rdbtnAutomatic);
		
		ButtonGroup bg1 = new ButtonGroup( );
        bg1.add(rdbtnManual);
		bg1.add(rdbtnAutomatic);
		
	    rdbtnManual.setSelected(true);
		
		JScrollPane ScrollPaneCustomers = new JScrollPane();
		ScrollPaneCustomers.setBounds(349, 13, 939, 678); //setBounds(333, 13, 1110, 800);
		ScrollPaneCustomers.getViewport().setBackground(new Color(255, 250, 232));
		add(ScrollPaneCustomers);
	
		TableCustomers = new JTable();
		TableCustomers.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableCustomers.setRowHeight(TableCustomers.getRowHeight() + 10);
		JTableHeader header = TableCustomers.getTableHeader();
        header.setBackground(new Color(255, 250, 232));
        header.setForeground(Color.BLACK);
		ScrollPaneCustomers.setViewportView(TableCustomers);
		
		//All action listeners
		btnReset.addActionListener(actionevent -> reset());
	    btnDelete.addActionListener(actionevent ->remove());
	    btnAdd.addActionListener(actionevent ->addition());
	    btnSave.addActionListener(actionevent ->saved());
	    btnView.addActionListener(actionevent -> look());
	    btnSearch.addActionListener(actionevent -> searche());
	    btnShowDatabase.addActionListener(actionevent -> table());
	    rdbtnManual.addActionListener(actionevent ->textedit());
	    rdbtnAutomatic.addActionListener(actionevent ->notextedit());
	     
		setVisible(true);
	}
	
	public void notextedit() {
		/*This method sets CustomerIDText JTextField empty
		 *and makes it non-editable when ID Type:Automatic option
		 *is selected as there is no need to insert an id number for
		 *customer_info in SQL because the id will be assigned
		 *automatically upon insertion
		 */
		CustomerIDText.setText(null);
		CustomerIDText.setEditable(false);
		CustomerIDText.setBackground(new Color(255, 250, 232));
	}
	
	public void textedit() {
		/*This method makes CustomerIDText JTextField editable 
		 *i.e. a number can be entered in that JTextField
		 *for the purpose of adding an id to customer_info 
		 *table when ID Type:Manual is selected 
		 */
		CustomerIDText.setEditable(true);
		CustomerIDText.setBackground(Color.WHITE);
	}
	
	public void reset() {
		//Setting all JTextFields empty
		CustomerIDText.setText("");
		CustomerNameText.setText("");
		AddressText.setText("");
		CityText.setText("");
		PhoneNumberText.setText("");
		SearchText.setText("");
	}
	
	public void manualaddition() {
		 try {
			 /*This method is for manual insertion upon clicking "Add" button 
			  *which means the id in customer_info table needs to be entered by 
			  *the system user
			  */
		     connection();
		     textedit();
			 String sql="insert into customer_info (id,name,address,city,phone_number) values (?,?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,CustomerIDText.getText());
			 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
			 pst.setString(3,firstLetterCapital(AddressText.getText()));
			 pst.setString(4,firstLetterCapital(CityText.getText()));
			 
			 //Default option for phone_number is 0
			 if(PhoneNumberText.getText().equals("")) {
				 PhoneNumberText.setText("0");
				 pst.setString(5,PhoneNumberText.getText());
			 }else {
				 //Using a Regular Expression which accepts all country codes for a phone number and in any format
				 String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
				 Pattern pattern = Pattern.compile(allCountryRegex);
				 Matcher matcher = pattern.matcher(PhoneNumberText.getText());
				 if(matcher.matches() == true) {
					 pst.setString(5,PhoneNumberText.getText());
			     }else {
			    	 JOptionPane.showMessageDialog(null, "This phone number is not 10 digits", "Alert",JOptionPane.ERROR_MESSAGE);
			     }
			 }
			 pst.executeUpdate();
			 //Displaying customer_info table after insertion
			 String ser = "select * from customer_info";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableCustomers.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	public void automaticaddition() {
		try {
			/*This method is for automatic insertion upon clicking add button
			  *which means that there is no need to insert a customer id. The customer_info
			  *table will automatically assign one upon insertion because of auto_increment
			  *constraint on customer_info table
			  */
			 connection();
			 notextedit();
			 String sql="insert into customer_info (name,address,city,phone_number) values (?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(CustomerNameText.getText()));
			 pst.setString(2,firstLetterCapital(AddressText.getText()));
			 pst.setString(3,firstLetterCapital(CityText.getText()));
			 
			 //Default option for phone_number is 0
			 if(PhoneNumberText.getText().equals("")) {
				 PhoneNumberText.setText("0");
				 pst.setString(5,PhoneNumberText.getText());
			 }else {
				 //Using a Regular Expression which accepts all country codes for a phone number and in any format
				 String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
				 Pattern pattern = Pattern.compile(allCountryRegex);
				 Matcher matcher = pattern.matcher(PhoneNumberText.getText());
				 if(matcher.matches() == true) {
					 pst.setString(4,PhoneNumberText.getText());
			     }else {
			    	 JOptionPane.showMessageDialog(null, "This phone number is not 10 digits", "Alert",JOptionPane.ERROR_MESSAGE);
			     }
			 }
			 pst.executeUpdate();
			 //Displaying customer_info table after insertion
			 String ser = "select * from customer_info";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableCustomers.setModel(DbUtils.resultSetToTableModel(rs));
			 
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
	 }
	}
	
	public void addition() {
		/*This method decides which way the insertion will take place based on whether 
		 *manual option is selected or automatic is selected for ID Type
		 */
		try {
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
			/*This method deletes a row from the customer_info table associated with the 
			  *customer id entered in in CustomerIDText JTextField
			  */
		     connection();
			 String sql="delete from customer_info where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,CustomerIDText.getText());
			 pst.executeUpdate();
			 
			 //The below SQL and Java code displays the table after the deletion
			 String ser = "select * from customer_info";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableCustomers.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}

	public void searche() {
		//This method searches the whole table for the string which will be entered in the SearchText JTextField
		try {
		 connection();
		 String sql="select * from customer_info where CONCAT(id,name,address,city,phone_number) like '%"+SearchText.getText()+"%';";
		 PreparedStatement pst = conn.prepareStatement(sql);
		 sr=pst.executeQuery();
	     TableCustomers.setModel(DbUtils.resultSetToTableModel(sr));
	}catch(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
	}
	}
	
	public void look() {
		try {
			/*This method does two things: 
			  *1) It displays the whole table if the CustomerIDText JTextField is empty
			  *2) It displays all the values of a particular row in their respective JTextFields
			  *   based on the Customer ID entered in CustomerIDText JTextField 
			  *The purpose of this method is not only for viewing but also to make 
			  *updating more convenient for the user
			  */
			 connection();
			 if(CustomerIDText.getText().equals("") && CustomerNameText.getText().equals("") && AddressText.getText().equals("") && CityText.getText().equals("") && PhoneNumberText.getText().equals("")) {
				 String ser = "select * from customer_info";
				 PreparedStatement sat = conn.prepareStatement(ser);
				 mn=sat.executeQuery();
				 TableCustomers.setModel(DbUtils.resultSetToTableModel(mn));
			 }else if(CustomerIDText.getText().equals(CustomerIDText.getText())) {
				 String sql = "select id,name,address,city,phone_number from customer_info where id = ?";
			     PreparedStatement pst=conn.prepareStatement(sql);
			        pst.setString(1,CustomerIDText.getText());
                    rs = pst.executeQuery();
			    while(rs.next()) { 
			        CustomerIDText.setText(rs.getString("id"));
			        CustomerNameText.setText(rs.getString("name"));
			        AddressText.setText(rs.getString("address"));
			        CityText.setText(rs.getString("city"));
			        PhoneNumberText.setText(rs.getString("phone_number"));
			    }
			    	 //The below Java code only displays the row in the customer_info table whose Customer ID is entered
				     PreparedStatement stmt=conn.prepareStatement(sql);
				     stmt.setString(1,CustomerIDText.getText());
				     sr=stmt.executeQuery();
				     TableCustomers.setModel(DbUtils.resultSetToTableModel(sr));
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
			 String sql="select * from customer_info";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 sr=pst.executeQuery();
		     TableCustomers.setModel(DbUtils.resultSetToTableModel(sr));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}

	

	public void saved() {
		try {
			 //This method is for updating customer_info table
			 connection();
			 String sql="update customer_info set name = ?,address = ?,city = ?,phone_number = ? where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(CustomerNameText.getText()));
			 pst.setString(2,firstLetterCapital(AddressText.getText()));
			 pst.setString(3,firstLetterCapital(CityText.getText()));
			 
			 //Default option for phone_number is 0
			 if(PhoneNumberText.getText().equals("")) {
				 PhoneNumberText.setText("0");
				 pst.setString(4,PhoneNumberText.getText());
			 }else {
				//Using a Regular Expression which accepts all country codes for a phone number and in any format
				 String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
				 Pattern pattern = Pattern.compile(allCountryRegex);
				 Matcher matcher = pattern.matcher(PhoneNumberText.getText());
				 if(matcher.matches() == true) {
					 pst.setString(4,PhoneNumberText.getText());
			     }else {
			    	 JOptionPane.showMessageDialog(null, "This phone number is not 10 digits", "Alert",JOptionPane.ERROR_MESSAGE);
			     }
			 }
			 pst.setString(5,CustomerIDText.getText());
			 pst.executeUpdate();
		     
			 /*If an update is made in customer_info table and customer name is changed 
			  *for a particular ID then the same change for that ID is made in record table
			  */
		     String sqld="update record set name = ? where customer_id = ?";
		     PreparedStatement spt = conn.prepareStatement(sqld);
		     spt.setString(1, firstLetterCapital(CustomerNameText.getText()));
		     spt.setString(2, CustomerIDText.getText());
		     spt.executeUpdate();
		     
		    //The below SQL and Java code displays the table after updating it
		     String sql1 ="select * from customer_info where id = ?";
			 PreparedStatement stmt=conn.prepareStatement(sql1);
		     stmt.setString(1,CustomerIDText.getText());
		     sr=stmt.executeQuery();
		     TableCustomers.setModel(DbUtils.resultSetToTableModel(sr));
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
		new Customers();
	}
}
	
	
