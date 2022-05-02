import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Records extends JPanel {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
    ResultSet rs =null;
    
	private JTextField CustomerIDText;
	private JTextField CustomerNameText;
	private JTextField BookIDText;
	private JTextField IssueDateText;
	private JTextField ReturnDateText;
	private JTextField SearchText;
	private JTextField ChargeText;
	private JTextField SerialNumberText;
	private JTable TableRecord;
	JRadioButton rdbtnManual = new JRadioButton("Manual");
	JRadioButton rdbtnAutomatic = new JRadioButton("Automatic\r\n");
	JRadioButton rdbtnRent = new JRadioButton("Rent");
	JRadioButton rdbtnPurchase = new JRadioButton("Purchase");
	String choice = "Rent";
	
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
	public Records() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(0, 0, 1311, 708);
		setLayout(null);
		
		JLabel lblSerialNumber = new JLabel("Entry Number:");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblSerialNumber.setBounds(26, 45, 127, 24);
		add(lblSerialNumber);
		
		JLabel lblEntryType = new JLabel("Entry Type\r\n:");
		lblEntryType.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblEntryType.setBounds(26, 94, 127, 24);
		add(lblEntryType);
		
		JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCustomerID.setBounds(26, 143, 127, 24);
	    add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("Name:");
		lblCustomerName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCustomerName.setBounds(26, 192, 60, 24);
		add(lblCustomerName);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblType.setBounds(26, 242, 60, 24);
		add(lblType);

		JLabel lblCharge = new JLabel("Charge:");
		lblCharge.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCharge.setBounds(26, 293, 70, 24);
		add(lblCharge);
		
		JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblBookID.setBounds(26, 342, 107, 24);
		add(lblBookID);
		
		JLabel lblIssueDate = new JLabel("Date of Issue:");
		lblIssueDate.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblIssueDate.setBounds(26, 388, 127, 24);
		add(lblIssueDate);
		
		JLabel lblReturnDate = new JLabel("Date of Return:");
		lblReturnDate.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblReturnDate.setBounds(26, 433, 127, 24);
		add(lblReturnDate);
		
		JLabel lblColon = new JLabel(":");
		lblColon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblColon.setBounds(147, 619, 13, 24);
		add(lblColon);
		
		SerialNumberText = new JTextField();
		SerialNumberText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SerialNumberText.setColumns(10);
		SerialNumberText.setBounds(172, 46, 116, 22);
		add(SerialNumberText);
		
		CustomerIDText = new JTextField();
		CustomerIDText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CustomerIDText.setColumns(10);
		CustomerIDText.setBounds(172, 144, 116, 22);
		add(CustomerIDText);
		
		CustomerNameText = new JTextField();
		CustomerNameText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CustomerNameText.setColumns(10);
		CustomerNameText.setBounds(172, 193, 116, 22);
		add(CustomerNameText);
		
		ChargeText = new JTextField();
		ChargeText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		ChargeText.setColumns(10);
		ChargeText.setBounds(172, 294, 116, 22);
		add(ChargeText);
		
		BookIDText = new JTextField();
		BookIDText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		BookIDText.setColumns(10);
		BookIDText.setBounds(172, 343, 116, 22);
		add(BookIDText);
		
		IssueDateText = new JTextField();
		IssueDateText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		IssueDateText.setColumns(10);
		IssueDateText.setBounds(172, 389, 116, 22);
		add(IssueDateText);
		
		ReturnDateText = new JTextField();
		ReturnDateText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		ReturnDateText.setColumns(10);
		ReturnDateText.setBounds(172, 434, 116, 22);
		add(ReturnDateText);
		
		SearchText = new JTextField();
		SearchText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SearchText.setColumns(10);
		SearchText.setBounds(172, 620, 116, 22);
		add(SearchText);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnAdd.setBounds(12, 483, 80, 25);
		add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFocusPainted(false);
		btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnSave.setBounds(104, 483, 100, 25);
		add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusPainted(false);
		btnDelete.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnDelete.setBounds(104, 521, 100, 25);
		add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false);
		btnReset.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnReset.setBounds(12, 521, 80, 25);
		add(btnReset);
		
		JButton btnView = new JButton("View");
		btnView.setFocusPainted(false);
		btnView.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnView.setBounds(216, 483, 86, 25);
		add(btnView);
		
		JButton btnShowDatabase = new JButton("Table");
		btnShowDatabase.setFocusPainted(false);
	    btnShowDatabase.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	    btnShowDatabase.setBounds(216, 521, 86, 25);
	    add(btnShowDatabase);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFocusPainted(false);
		btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnSearch.setBounds(46, 619, 94, 25);
		add(btnSearch);
		
		rdbtnManual.setBounds(132, 96, 70, 25);
		rdbtnManual.setBackground(new Color(255, 250, 232));
		add(rdbtnManual);
		
		rdbtnAutomatic.setBounds(216, 96, 86, 25);
		rdbtnAutomatic.setBackground(new Color(255, 250, 232));
		add(rdbtnAutomatic);
		
		rdbtnRent.setBounds(132, 244, 60, 25);
		rdbtnRent.setBackground(new Color(255, 250, 232));
		add(rdbtnRent);
		
		rdbtnPurchase.setBounds(216, 244, 86, 25);
		rdbtnPurchase.setBackground(new Color(255, 250, 232));
		add(rdbtnPurchase);
		
		ButtonGroup bg = new ButtonGroup();
	    bg.add(rdbtnManual);
	    bg.add(rdbtnAutomatic);
	    
	    ButtonGroup bg2 = new ButtonGroup( );
        bg2.add(rdbtnRent);
		bg2.add(rdbtnPurchase);
		
		rdbtnManual.setSelected(true);
	    rdbtnRent.setSelected(true);
		
		JScrollPane ScrollPaneRecord = new JScrollPane();
		ScrollPaneRecord.setBounds(320, 13, 979, 674); 
		ScrollPaneRecord.getViewport().setBackground(new Color(255, 250, 232));
		add(ScrollPaneRecord);
		
		TableRecord = new JTable();
		TableRecord.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableRecord.setRowHeight(TableRecord.getRowHeight() + 10);
		JTableHeader header = TableRecord.getTableHeader();
        header.setBackground(new Color(255, 250, 232));
        header.setForeground(Color.BLACK);
		ScrollPaneRecord.setViewportView(TableRecord);
	    
		//All action listeners
        btnView.addActionListener(actionevent -> look());
		btnAdd.addActionListener(actionevent -> addition());
		btnReset.addActionListener(actionevent -> reset());
		btnDelete.addActionListener(actionevent -> remove());
		btnSearch.addActionListener(actionevent -> searche());
		btnSave.addActionListener(actionevent -> saved());
		btnShowDatabase.addActionListener(actionevent -> table());
		rdbtnPurchase.addActionListener(actionevent -> purchasee());
		rdbtnRent.addActionListener(actionevent -> rentt());
        rdbtnManual.addActionListener(actionevent -> textedit());
        rdbtnAutomatic.addActionListener(actinevent -> notextedit());
		
		setVisible(true);
	}
	
	public void purchasee() {
		 /*If Type:Purchase i.e. rdbtnPurchase is selected then it will turn ReturnDateText
		  *JTextField empty and non-editable and change its color to the JPanel's color 
		  *and save the text of the option in choice variable. This id done because in record 
		  *table there is a date_of_return field which is only applicable if customer is renting
		  *a book. If customer is purchasing a book then there will be no return date (the book 
		  *purchase is non-refundable) so date_of_return will be empty
		  */
		 ReturnDateText.setText("");
		 ReturnDateText.setEditable(false);
		 ReturnDateText.setBackground(new Color(255, 250, 232));
		 choice = rdbtnPurchase.getText();
	}
	public void rentt() {
		 /*If Type:Rent i.e. rdbtnRent is selected then there needs to be a return date so
		  *this method will make ReturnDateText JTextField editable and save the text "Rent"
		  *in variable choice
		  */
		 choice = rdbtnRent.getText();
		 ReturnDateText.setEditable(true);
		 ReturnDateText.setBackground(new Color(255, 255, 255));
	}
	public void textedit() {
		/*This method sets SerialNumberText JTextField empty
		 *and makes it non-editable when Entry Type:Automatic option
		 *is selected as there is no need to insert a serial number for
		 *record in SQL because the number will be assigned
		 *automatically upon insertion
		 */

		SerialNumberText.setEditable(true);
		SerialNumberText.setBackground(new Color(255, 255, 255));
	}
	public void notextedit() {
		/*This method makes SerialNumberText JTextField editable 
		 *i.e. a number can be entered in that JTextField
		 *for the purpose of adding an serial number to record table
		 *when Entry Type:Manual is selected 
		 */
		SerialNumberText.setText("");
		SerialNumberText.setEditable(false);
		SerialNumberText.setBackground(new Color(255, 250, 232));
	}
	public void automaticaddition() {
		try {
			/*This method is for automatic insertion upon clicking add button
			 *which means that there is no need to insert a serial number. The record
			 *table will automatically assign one upon insertion because of auto_increment
			 *constraint on record table. In this Java code some conditions will be checked
			 *before insertion
			 *1) The customer either already exists in customer_info table or is new
			 *2) The book being bought or rented already exists in books table
			 */
			 connection();
			 String sql = "insert into record (customer_id,name,type,charge,book_name,date_of_issue,date_of_return) values (?,?,?,?,?,?,?);";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 
			 /*Before inserting customer_id in record, this code checks if the customer_id
			  *for the name entered in CustomerNameText already exists in customer_info table
			  */
			 String sul ="select id from customer_info where name = ?";
			 PreparedStatement pul =conn.prepareStatement(sul); 
			 pul.setString(1, firstLetterCapital(CustomerNameText.getText()));
			 ResultSet sr =pul.executeQuery();
			 
			 if(sr.next() == true) {
				 /*If user enters correct name associated with correct customer_id (entered 
				  *by the user) based on customer_info table then the same cutomer_id and name 
				  *will be added to record table 
				  */
				 CustomerIDText.setText(sr.getString(1));
				 pst.setString(1,CustomerIDText.getText());
				 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
			 }else {
				 /*If the name entered by the user does not have an id in the customer_info
				  *then the code will check if the customer_id entered by the user exists in 
				  *customer_info table  
				  */
				 String pel= "select id, name from customer_info where id = ?; ";
				 PreparedStatement sw = conn.prepareStatement(pel);
				 sw.setString(1, CustomerIDText.getText());
				 ResultSet hy = sw.executeQuery();
				 
				 /*if the ID exists in customer_info table and the CustomerNameText JTextField is not empty
				  *then an alert is issued but the name associated with the customer_id (entered in CustomerIDText JTextField)
				  *will be added to record from customer_info table
				  */
				 if(hy.next() == true) {
					 if(!CustomerNameText.getText().equals("") && hy.getString("name") != CustomerNameText.getText()) {
					 JOptionPane.showMessageDialog(null, "Cannot add "+CustomerNameText.getText()+" with ID: "+CustomerIDText.getText()+ "\n This ID is already taken", "Alert",JOptionPane.ERROR_MESSAGE);
					 }
					 
					 /*if the ID exists in customer_info table and the CustomerNameText JTextField is empty
					  *then the name associated with the customer_id (entered in CustomerIDText JTextField)
					  *will be added to record from customer_info table
					  */
					 CustomerIDText.setText(hy.getString(1));
					 CustomerNameText.setText(firstLetterCapital(hy.getString(2)));
				     pst.setString(1,CustomerIDText.getText());
					 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
				 
				 }else {
					 /*If the ID does not exist in customer_info table i.e. it is a new id and 
					  *the CustomerNameText JTextField is empty then an alert is issued   
					  */
					 if(CustomerNameText.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "", "Alert",JOptionPane.ERROR_MESSAGE);
						 }
					 else {
						 /*If the ID does not exist in customer_info table i.e. it is a new id and 
						  *the CustomerNameText JTextField is not empty then the new name with new
						  *customer_id is added to record along with customer_info table to add a new
						  *customer   
						  */
						 pst.setString(1,CustomerIDText.getText());
						 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
						 String qel = "insert into customer_info(id,name) values (?,?); ";
						 PreparedStatement nsp = conn.prepareStatement(qel);
						 nsp.setString(1, CustomerIDText.getText());
						 nsp.setString(2, firstLetterCapital(CustomerNameText.getText()));
						 nsp.executeUpdate();
					 }
				 }
			 }
			 
			 //This will contain either Rent or Purchase
			 pst.setString(3, choice);
			 
			 //If ChargeText JTextField is left empty then by default $10 will be the charge
			 if(ChargeText.getText().equals("")) {
				 pst.setString(4, "10");
			 }else {
				 //Otherwise the charge will be the value entered by user in ChargeText
				 pst.setString(4, ChargeText.getText());	 
			 }
			 
			 /*It will check if the book being rented or purchased by the customer exists 
			  *in the library i.e. It will fetch the name of the book only if the id associated
			  *with the book exists in books table 
			  */
			 String sqld = "select title from books where id = ?";
			 PreparedStatement pel =conn.prepareStatement(sqld); 
			 pel.setString(1, BookIDText.getText());
			 ResultSet srt = pel.executeQuery();
			 
			 //If the book exists in books table then it is added to record otherwise an alert is issued
			 if(srt.next() == true) {
				 pst.setString(5,srt.getString("title")+" ("+BookIDText.getText()+")");
			 }else {
				 JOptionPane.showMessageDialog(null, "There is no book with this ID in our database", "Alert",JOptionPane.ERROR_MESSAGE);
			 }
			 
			 if(choice == "Rent") {
				 
				 /*If rdbtnRent is selected then it will check if IssueDateText and ReturnDateText is empty
				  *If both JTextFields are empty then it will set today's date as date_of_issue and the date 3 days
				  *after today's date as date_of_return 
				  */
				 if(IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")) {
					 String abc = "SELECT CURRENT_DATE,DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)";
					 PreparedStatement sqk = conn.prepareStatement(abc);
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(6, me.getString("CURRENT_DATE"));
					 pst.setString(7, me.getString("DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)"));
					 }
					 
				  /*If IssueDateText is not empty but ReturnDateText is empty then 
				   *the code will save date_of_return 3 days after the date_of_issue 
				   *entered by the user
				   */
				 }else if(!IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")){
					 pst.setString(6,IssueDateText.getText());
					 String xyz = "SELECT(DATE_ADD(?, INTERVAL 3 DAY))";
					 PreparedStatement sqk = conn.prepareStatement(xyz);
					 sqk.setString(1, IssueDateText.getText());
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(7, me.getString(1));
					 }
				  /*If IssueDateText is empty and ReturnDateText is not empty then the code sets 
				   *today's date as date_of_issue given date_of_return does not occur before today's date
				   *as a book can only be returned AFTER it is issued	 
				   */
				 }else if(IssueDateText.getText().equals("") && !ReturnDateText.getText().equals("")) {
				     String bcd = "SELECT CURRENT_DATE";
				     PreparedStatement sbcd = conn.prepareStatement(bcd);
					 ResultSet sme = sbcd.executeQuery();
					 while(sme.next()) {
						 String val = sme.getString("CURRENT_DATE");
						 IssueDateText.setText(val);
						 pst.setString(6, val);
					 }
					 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
						 pst.setString(7, ReturnDateText.getText());
					 }else {	
						 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE);
					 }
				 }else {
					 /*If both IssueDateText and ReturnDateText are not empty and date_of_return occurs 
					  *after date_of_issue then the dates will be added to record 
					  */
					 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
						 pst.setString(6, IssueDateText.getText());
						 pst.setString(7, ReturnDateText.getText());
					 }else {
						 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE);
					 }
				 }
			 }else {
				 /*If rdbtnPurchase is selected and IssueDateText is empty then set
				  *today's date as date_of_issue (which is date_of_purchase) in this case
				  */
				 if(IssueDateText.getText().equals("")) {
					 String abc = "SELECT CURRENT_DATE";
					 PreparedStatement sqk = conn.prepareStatement(abc);
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(6, me.getString("CURRENT_DATE"));
					 }
					 pst.setString(7,null);
			     }else {
			    	 /*If rdbtnPurchase is selected and IssueDateText is not empty then set 
			    	  *the date in IssueDateText as date_of_issue (which is date_of_purchase) 
			    	  *in this case
			    	  */
			    	 pst.setString(6, IssueDateText.getText());
			    	 pst.setString(7, null);
			     }
			 }
			 
			 pst.executeUpdate();
			 
			 //This SQL and Java code is for displaying the table after the new insertion
			 String sfr = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record";
			 PreparedStatement sat = conn.prepareStatement(sfr);
			 rs=sat.executeQuery();
			 TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void manualaddition() {
		try {
			/*This method is for manual insertion upon clicking add button
			 *which means that the user has to enter a serial number in SerialNumberText JTextField. 
			 *In this Java code some conditions will be checked before insertion
			 *1) The customer either already exists in customer_info table or is new
			 *2) The book being bought or rented already exists in books table
			 */
			 connection();
			 String sql = "insert into record (s_no,customer_id,name,type,charge,book_name,date_of_issue,date_of_return) values (?,?,?,?,?,?,?,?);";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,SerialNumberText.getText());
			 
			 /*Before inserting customer_id in record, this code checks if the customer_id
			  *for the name entered in CustomerNameText already exists in customer_info table
			  */
			 String sul ="select id from customer_info where name = ?";
			 PreparedStatement pul =conn.prepareStatement(sul); 
			 pul.setString(1, firstLetterCapital(CustomerNameText.getText()));
			 ResultSet sr =pul.executeQuery();
			 
			 if(sr.next() == true) {
				 /*If user enters correct name associated with correct customer_id (entered 
				  *by the user) based on customer_info table then the same cutomer_id and name 
				  *will be added to record table 
				  */
				 CustomerIDText.setText(sr.getString(1));
				 pst.setString(2,CustomerIDText.getText());
				 pst.setString(3,firstLetterCapital(CustomerNameText.getText()));
			 }else {
				 /*If the name entered by the user does not have an id in the customer_info
				  *then the code will check if the customer_id entered by the user exists in 
				  *customer_info table  
				  */
				 String pel= "select id, name from customer_info where id = ?; ";
				 PreparedStatement sw = conn.prepareStatement(pel);
				 sw.setString(1, CustomerIDText.getText());
				 ResultSet hy = sw.executeQuery();
				 
				 /*if the ID exists in customer_info table and the CustomerNameText JTextField is not empty
				  *then an alert is issued but the name associated with the customer_id (entered in CustomerIDText JTextField)
				  *will be added to record from customer_info table
				  */
				 if(hy.next() == true) {
					 if(!CustomerNameText.getText().equals("") && hy.getString("name") != CustomerNameText.getText()) {
					 JOptionPane.showMessageDialog(null, "Cannot add "+CustomerNameText.getText()+" with ID: "+CustomerIDText.getText()+ "\n This ID is already taken", "Alert",JOptionPane.ERROR_MESSAGE);
					 }
					 
					 /*if the ID exists in customer_info table and the CustomerNameText JTextField is empty
					  *then the name associated with the customer_id (entered in CustomerIDText JTextField)
					  *will be added to record from customer_info table
					  */
					 CustomerIDText.setText(hy.getString(1));
					 CustomerNameText.setText(firstLetterCapital(hy.getString(2)));
				     pst.setString(2,CustomerIDText.getText());
					 pst.setString(3,firstLetterCapital(CustomerNameText.getText()));
				 
				 }else {
					 /*If the ID does not exist in customer_info table i.e. it is a new id and 
					  *the CustomerNameText JTextField is empty then an alert is issued   
					  */
					 if(CustomerNameText.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "", "Alert",JOptionPane.ERROR_MESSAGE);
						 }
					 else {
						/*If the ID does not exist in customer_info table i.e. it is a new id and 
						 *the CustomerNameText JTextField is not empty then the new name with new
						 *customer_id is added to record along with customer_info table to add a new
						 *customer   
						 */
						 pst.setString(2,CustomerIDText.getText());
						 pst.setString(3,firstLetterCapital(CustomerNameText.getText()));
						 String qel = "insert into customer_info(id,name) values (?,?); ";
						 PreparedStatement nsp = conn.prepareStatement(qel);
						 nsp.setString(1, CustomerIDText.getText());
						 nsp.setString(2, firstLetterCapital(CustomerNameText.getText()));
						 nsp.executeUpdate();
					 }
				 }
			 }
			 
			 //This will contain either Rent or Purchase
			 pst.setString(4, choice);
			 
			 //If ChargeText JTextField is left empty then by default $10 will be the charge
			 if(ChargeText.getText().equals("")) {
				 pst.setString(5, "10");
			 }else {
				 //Otherwise the charge will be the value entered by user in ChargeText
				 pst.setString(5, ChargeText.getText());	 
			 }
			 
			 /*It will check if the book being rented or purchased by the customer exists 
			  *in the library i.e. It will fetch the name of the book only if the id associated
			  *with the book exists in books table 
			  */
			 String sqld = "select title from books where id = ?";
			 PreparedStatement pel =conn.prepareStatement(sqld); 
			 pel.setString(1, BookIDText.getText());
			 ResultSet srt =pel.executeQuery();
			 
			//If the book exists in books table then it is added to record otherwise an alert is issued
			 if(srt.next() == true) {
				 pst.setString(6,srt.getString("title")+" ("+BookIDText.getText()+")");
			 }else {
				 JOptionPane.showMessageDialog(null, "There is no book with this ID in our database", "Alert",JOptionPane.ERROR_MESSAGE);
			 }
			 
			 if(choice == "Rent") {
				 
				 /*If rdbtnRent is selected then it will check if IssueDateText and ReturnDateText is empty
				  *If both JTextFields are empty then it will set today's date as date_of_issue and the date 3 days
				  *after today's date as date_of_return 
				  */
				 if(IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")) {
					 String abc = "SELECT CURRENT_DATE,DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)";
					 PreparedStatement sqk = conn.prepareStatement(abc);
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(7, me.getString("CURRENT_DATE"));
					 pst.setString(8, me.getString("DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)"));
					 }
				 
				 /*If IssueDateText is not empty but ReturnDateText is empty then 
				  *the code will save date_of_return 3 days after the date_of_issue 
				  *entered by the user
				  */
				 }else if(!IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")){
					 pst.setString(7,IssueDateText.getText());
					 String xyz = "SELECT(DATE_ADD(?, INTERVAL 3 DAY))";
					 PreparedStatement sqk = conn.prepareStatement(xyz);
					 sqk.setString(1, IssueDateText.getText());
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(8, me.getString(1));
					 }
				 /*If IssueDateText is empty and ReturnDateText is not empty then the code sets 
				  *today's date as date_of_issue given date_of_return does not occur before today's date
				  *as a book can only be returned AFTER it is issued	 
				  */	 
				 }else if(IssueDateText.getText().equals("") && !ReturnDateText.getText().equals("")) {
					     String bcd = "SELECT CURRENT_DATE";
					     PreparedStatement sbcd = conn.prepareStatement(bcd);
						 ResultSet sme = sbcd.executeQuery();
						 while(sme.next()) {
							 String val = sme.getString("CURRENT_DATE");
							 IssueDateText.setText(val);
							 pst.setString(7, val);
						 }
						 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
							 pst.setString(8, ReturnDateText.getText());
						 }else {
							 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE); 
						 }
					 }else {
						 /*If both IssueDateText and ReturnDateText are not empty and date_of_return occurs 
						  *after date_of_issue then the dates will be added to record 
						  */
						 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
							 pst.setString(7, IssueDateText.getText());
							 pst.setString(8, ReturnDateText.getText());
						 }else {
							 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE);
						 }
					 }
			 }else {
				 /* If rdbtnPurchase is selected and IssueDateText is empty then set
				  * today's date as date_of_issue (which is date_of_purchase) in this case
				  */
				 if(IssueDateText.getText().equals("")) {
					 String abc = "SELECT CURRENT_DATE";
					 PreparedStatement sqk = conn.prepareStatement(abc);
					 ResultSet me = sqk.executeQuery();
					 while(me.next()) {
					 pst.setString(7, me.getString("CURRENT_DATE"));
					 }
					 pst.setString(8,null);
			     }else {
			    	 /*If rdbtnPurchase is selected and IssueDateText is not empty then set 
			    	  * the date in IssueDateText as date_of_issue (which is date_of_purchase) 
			    	  * in this case
			    	  */
			    	 pst.setString(7, IssueDateText.getText());
			    	 pst.setString(8, null);
			     }
			 }
			 
			 pst.executeUpdate();
			 
			 //This SQL and Java code is for displaying the table after the new insertion
			 String sfr = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record";
			 PreparedStatement sat = conn.prepareStatement(sfr);
			 rs=sat.executeQuery();
			 TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	 
	public void addition() {
		try {
			/*This method decides which way the insertion will take place based on whether 
			 *manual option is selected or automatic is selected for Entry Type
			 */
			connection();
			if(rdbtnAutomatic.isSelected()) {
				automaticaddition();
			}
			else {
				manualaddition();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void look() {
		/*This method does two things: 
		 *1) It displays the whole table if the SerialNumberText JTextField is empty
		 *2) It displays all the values of a particular row in their respective JTextFields
		 *   based on the s_no entered in SerialNumberText JTextField 
		 *The purpose of this method is not only for viewing but also to make 
		 *updating more convenient for the user
		 */
		connection();
		try{
		if(SerialNumberText.getText().equals("") && CustomerIDText.getText().equals("") && CustomerNameText.getText().equals("") && ChargeText.getText().equals("") && BookIDText.getText().equals("") && IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")) {
        String sql = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record";
        PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}
        else if(SerialNumberText.getText().equals(SerialNumberText.getText())) {
        String sqll = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record where s_no = ?;";
        PreparedStatement sqkk = conn.prepareStatement(sqll);
        sqkk.setString(1, SerialNumberText.getText());
        rs = sqkk.executeQuery();
        
        while(rs.next()) {
        	SerialNumberText.setText(rs.getString("s_no"));
        	CustomerIDText.setText(rs.getString("customer_id"));
        	CustomerNameText.setText(rs.getString("name"));
        	ChargeText.setText(rs.getString("charge"));
        	//Displays the book ID associated with the book_name in the record table
        	String bookname = rs.getString("book_name");
        	String bookid = bookname.substring(bookname.indexOf("(")+1, bookname.length()-1);
        	BookIDText.setText(bookid);
        	IssueDateText.setText(rs.getString("date_of_issue"));
        	ReturnDateText.setText(rs.getString("date_of_return"));
        	
        	//The below code selects Rent or Purchased JRadioButton depending on the value of date_of_return 
        	if(rs.getString("date_of_return") != null) {
        		rdbtnRent.setSelected(true);
        		rentt();
        	}else {
        		rdbtnPurchase.setSelected(true);
        		purchasee();
        	}
        }
        //The below Java code only displays the row in record table whose s_no is entered
        PreparedStatement stmt=conn.prepareStatement(sqll);
	    stmt.setString(1,SerialNumberText.getText());
	    ResultSet sr=stmt.executeQuery();
	    TableRecord.setModel(DbUtils.resultSetToTableModel(sr));
        }
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void reset() {
		//Setting all JTextFields empty
		SerialNumberText.setText("");
		CustomerIDText.setText("");
		CustomerNameText.setText("");
		ChargeText.setText("");
		BookIDText.setText("");
		IssueDateText.setText("");
		ReturnDateText.setText("");
		SearchText.setText("");
	}
	
	public void remove() {
		try {
		/*This method deletes a row from the record table associated with the 
		 *s_no entered in in SystemUserIDText JTextField
		 */
		connection();
		String sql = "delete from record where s_no = ?;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, SerialNumberText.getText());
		pst.executeUpdate();
		
		//The below SQL and Java code displays the table after the deletion
		String ser ="select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record;";
		PreparedStatement ps =conn.prepareStatement(ser);
		rs = ps.executeQuery();
		TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void searche() {
		try {
			 //This method searches the whole table for the string which will be entered in the SearchText JTextField
			 connection();
			 String sql = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record where CONCAT(s_no,customer_id,name,type,charge,book_name,date_of_issue) like '%"+SearchText.getText()+"%' OR date_of_return like '%"+SearchText.getText()+"%';";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 rs=pst.executeQuery();
		     TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void table() {
		try {
			 //This method displays the whole table regardless of any JTextField being non-empty
			 connection();
			 String sql = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 rs=pst.executeQuery();
		     TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void saved() {
		/*This method is for updating record table. It checks all the conditions 
		 *mentioned in the automaticaddition() or manualaddition() method before updating the table
		 */
		try {
		 connection();
		 String sql = "update record set customer_id=?, name=?, type=?, charge=?, book_name=?, date_of_issue=?, date_of_return=? where s_no=?;";
		 PreparedStatement pst = conn.prepareStatement(sql);
		 
		 String sul ="select id from customer_info where name = ?";
		 PreparedStatement pul =conn.prepareStatement(sul); 
		 pul.setString(1, firstLetterCapital(CustomerNameText.getText()));
		 ResultSet sr = pul.executeQuery();
		 
		 if(sr.next() == true) {
			 CustomerIDText.setText(sr.getString(1));
			 pst.setString(1,CustomerIDText.getText());
			 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
		 }else {
			 String pel= "select id, name from customer_info where id = ?; ";
			 PreparedStatement sw = conn.prepareStatement(pel);
			 sw.setString(1, CustomerIDText.getText());
			 ResultSet hy = sw.executeQuery();
			 
			 if(hy.next() == true) {
				 if(!CustomerNameText.getText().equals("") && hy.getString("name") != CustomerNameText.getText()) {
				 JOptionPane.showMessageDialog(null, "Cannot add "+CustomerNameText.getText()+" with ID: "+CustomerIDText.getText()+ "\n This ID is already taken", "Alert",JOptionPane.ERROR_MESSAGE);
				 }
				 CustomerIDText.setText(hy.getString(1));
				 CustomerNameText.setText(firstLetterCapital(hy.getString(2)));
			     pst.setString(1,CustomerIDText.getText());
				 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
			 
			 }else {
				 pst.setString(1,CustomerIDText.getText());
				 pst.setString(2,firstLetterCapital(CustomerNameText.getText()));
				 String qel = "insert into customer_info(id,name) values (?,?); ";
				 PreparedStatement nsp = conn.prepareStatement(qel);
				 nsp.setString(1, CustomerIDText.getText());
				 nsp.setString(2, firstLetterCapital(CustomerNameText.getText()));
				 nsp.executeUpdate();
			 }
		 }
		 
		 pst.setString(3, choice);
		 
		 if(ChargeText.getText().equals("")) {
			 pst.setString(4, "10");
		 }else {
			 pst.setString(4, ChargeText.getText());	 
		 }
		 
		 String sqld = "select title from books where id = ?";
		 PreparedStatement pel =conn.prepareStatement(sqld); 
		 pel.setString(1, BookIDText.getText());
		 ResultSet srt =pel.executeQuery();
		 
		 if(srt.next() == true) {
			 pst.setString(5,srt.getString("title")+" ("+BookIDText.getText()+")");
		 }else {
			 JOptionPane.showMessageDialog(null, "There is no book with this ID in our database", "Alert",JOptionPane.ERROR_MESSAGE);
		 }
		 
		 if(choice == "Rent") {
			 if(IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")) {
				 String abc = "SELECT CURRENT_DATE,DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)";
				 PreparedStatement sqk = conn.prepareStatement(abc);
				 ResultSet me = sqk.executeQuery();
				 while(me.next()) {
				 pst.setString(6, me.getString("CURRENT_DATE"));
				 pst.setString(7, me.getString("DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)"));
				 }
			 
			 }else if(!IssueDateText.getText().equals("") && ReturnDateText.getText().equals("")){
				 pst.setString(6,IssueDateText.getText());
				 String xyz = "SELECT(DATE_ADD(?, INTERVAL 3 DAY))";
				 PreparedStatement sqk = conn.prepareStatement(xyz);
				 sqk.setString(1, IssueDateText.getText());
				 ResultSet me = sqk.executeQuery();
				 while(me.next()) {
				 pst.setString(7, me.getString(1));
				 }
			 
			 }else if(IssueDateText.getText().equals("") && !ReturnDateText.getText().equals("")) {
			     String bcd = "SELECT CURRENT_DATE";
			     PreparedStatement sbcd = conn.prepareStatement(bcd);
				 ResultSet sme = sbcd.executeQuery();
				 while(sme.next()) {
					 String val = sme.getString("CURRENT_DATE");
					 IssueDateText.setText(val);
					 pst.setString(6, val);
				 }
				 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
					 pst.setString(7, ReturnDateText.getText());
				 }else {
					 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE); 
				 }
			 }else {
				 if(ReturnDateText.getText().compareTo(IssueDateText.getText()) > 0) {
					 pst.setString(6, IssueDateText.getText());
					 pst.setString(7, ReturnDateText.getText());
				 }else {
					 JOptionPane.showMessageDialog(null, "Date_of_issue is smaller than or equal to Date_of_return", "Alert",JOptionPane.ERROR_MESSAGE);
				 }
			 }
		 }else {
			 if(IssueDateText.getText().equals("")) {
				 String abc = "SELECT CURRENT_DATE";
				 PreparedStatement sqk = conn.prepareStatement(abc);
				 ResultSet me = sqk.executeQuery();
				 while(me.next()) {
				 pst.setString(6, me.getString("CURRENT_DATE"));
				 }
				 pst.setString(7,null);
		     }else {
		    	 pst.setString(6, IssueDateText.getText());
		    	 pst.setString(7, null);
		     }
		 }
		 pst.setString(8, SerialNumberText.getText());
		 pst.executeUpdate();
		 
		 String sfr = "select s_no,customer_id,name,type,charge,book_name,date(date_of_issue) as date_of_issue,date(date_of_return) as date_of_return from record where s_no=?";
		 PreparedStatement sat = conn.prepareStatement(sfr);
		 sat.setString(1, SerialNumberText.getText());
		 rs=sat.executeQuery();
		 TableRecord.setModel(DbUtils.resultSetToTableModel(rs));
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

}
