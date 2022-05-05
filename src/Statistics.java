import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Statistics extends JPanel{
	private static final long serialVersionUID = -1273345243218224300L;
	
	Connection conn=null;
    	ResultSet rs =null;
    	ResultSet sr =null;
	public JLabel lblToatlBooksValue;
	public JLabel lblTotalBooksRentedValue;
	public JLabel lblTotalBooksPurchasedValue; 
	public JLabel lblTotalMembersValue;
	public JLabel lblTotalCustomersValue;
	public JLabel lblTotalSysAdminsValue;
	public JLabel lblTotalMoneyValue;
	public JLabel lblTotalMoneyRentValue;
	public JLabel lblToatlMoneyPurchaseValue;
	
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
	public Statistics() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(100, 100, 1311, 704);
		setLayout(null);
		
		JPanel panelMoney = new JPanel();
		panelMoney.setBackground(new Color(175, 238, 238));
		panelMoney.setBorder(null);
		panelMoney.setBounds(886, 29, 380, 644);
		add(panelMoney);
		panelMoney.setLayout(null);
		
		JPanel panelPeople = new JPanel();
		panelPeople.setBackground(new Color(152, 251, 152));
		panelPeople.setBorder(null);
		panelPeople.setBounds(467, 29, 380, 644);
		add(panelPeople);
		panelPeople.setLayout(null);
		
		JPanel panelBook = new JPanel();
		panelBook.setBackground(new Color(255, 218, 185));
		panelBook.setBorder(null);
		panelBook.setBounds(42, 29, 380, 644);
		add(panelBook);
		panelBook.setLayout(null);
		
		JLabel lblBook = new JLabel("");
		Image ico = new ImageIcon(this.getClass().getResource("book_red.png")).getImage();
		lblBook.setIcon(new ImageIcon(ico));
		lblBook.setBounds(64, 341, 356, 234);
		panelBook.add(lblBook);
		
		JLabel lblTotalBooks = new JLabel("Total Books:\r\n");
		lblTotalBooks.setForeground(new Color(220, 20, 60));
		lblTotalBooks.setBounds(106, 23, 297, 64);
		panelBook.add(lblTotalBooks);
		lblTotalBooks.setFont(new Font("Dialog", Font.PLAIN, 25));
		
		JLabel lblTotalBooksRented = new JLabel("Total Books Rented:\r\n");
		lblTotalBooksRented.setForeground(new Color(220, 20, 60));
		lblTotalBooksRented.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalBooksRented.setBounds(75, 101, 332, 64);
		panelBook.add(lblTotalBooksRented);
		
		JLabel lblTotalBooksPurchased = new JLabel("Total Books Purchased:\r\n");
		lblTotalBooksPurchased.setForeground(new Color(220, 20, 60));
		lblTotalBooksPurchased.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalBooksPurchased.setBounds(58, 186, 332, 64);
		panelBook.add(lblTotalBooksPurchased);
		
		lblToatlBooksValue = new JLabel("");
		lblToatlBooksValue.setForeground(new Color(220, 20, 60));
		lblToatlBooksValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblToatlBooksValue.setBounds(147, 69, 72, 46);
		panelBook.add(lblToatlBooksValue);
		
		lblTotalBooksRentedValue = new JLabel("");
		lblTotalBooksRentedValue.setForeground(new Color(220, 20, 60));
		lblTotalBooksRentedValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalBooksRentedValue.setBounds(147, 153, 72, 46);
		panelBook.add(lblTotalBooksRentedValue);
		
		lblTotalBooksPurchasedValue = new JLabel("");
		lblTotalBooksPurchasedValue.setForeground(new Color(220, 20, 60));
		lblTotalBooksPurchasedValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalBooksPurchasedValue.setBounds(147, 241, 72, 46);
		panelBook.add(lblTotalBooksPurchasedValue);
		
		JLabel lblUsers = new JLabel("");
		Image pic = new ImageIcon(this.getClass().getResource("members.png")).getImage();
		lblUsers.setIcon(new ImageIcon(pic));
		lblUsers.setBounds(63, 335, 356, 234);
		panelPeople.add(lblUsers);
		
		JLabel lblSysAdmin = new JLabel("Total System Admins:\r\n");
		lblSysAdmin.setForeground(new Color(34, 139, 34));
		lblSysAdmin.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblSysAdmin.setBounds(63, 186, 330, 64);
		panelPeople.add(lblSysAdmin);
		
		JLabel lblTotalMembers = new JLabel("Total Members:\r\n");
		lblTotalMembers.setForeground(new Color(34, 139, 34));
		lblTotalMembers.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalMembers.setBounds(98, 23, 332, 64);
		panelPeople.add(lblTotalMembers);
		
		JLabel lblTotalCustomers = new JLabel("Total Customers:\r\n");
		lblTotalCustomers.setForeground(new Color(34, 139, 34));
		lblTotalCustomers.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalCustomers.setBounds(87, 101, 332, 64);
		panelPeople.add(lblTotalCustomers);
		
		lblTotalMembersValue = new JLabel("");
		lblTotalMembersValue.setForeground(new Color(34, 139, 34));
		lblTotalMembersValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalMembersValue.setBounds(156, 68, 72, 46);
		panelPeople.add(lblTotalMembersValue);
		
		lblTotalCustomersValue = new JLabel("");
		lblTotalCustomersValue.setForeground(new Color(34, 139, 34));
		lblTotalCustomersValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalCustomersValue.setBounds(144, 152, 72, 46);
		panelPeople.add(lblTotalCustomersValue);
		
		lblTotalSysAdminsValue = new JLabel("");
		lblTotalSysAdminsValue.setForeground(new Color(34, 139, 34));
		lblTotalSysAdminsValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalSysAdminsValue.setBounds(156, 240, 72, 46);
		panelPeople.add(lblTotalSysAdminsValue);
		
		JLabel lblMoney = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("coins.png")).getImage();
		lblMoney.setIcon(new ImageIcon(img));
		lblMoney.setBounds(60, 308, 356, 267);
		panelMoney.add(lblMoney);
		
		JLabel lblTotalMoney = new JLabel("Total Money:\r\n");
		lblTotalMoney.setForeground(new Color(0, 128, 128));
		lblTotalMoney.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalMoney.setBounds(111, 23, 332, 64);
		panelMoney.add(lblTotalMoney);
		
		JLabel lblTotalMoneyRent = new JLabel("Total Money Rent:\r\n");
		lblTotalMoneyRent.setForeground(new Color(0, 128, 128));
		lblTotalMoneyRent.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalMoneyRent.setBounds(90, 101, 332, 64);
		panelMoney.add(lblTotalMoneyRent);
		
		JLabel lblTotalMoneyPurchase = new JLabel("Total Money Purchase:\r\n");
		lblTotalMoneyPurchase.setForeground(new Color(0, 128, 128));
		lblTotalMoneyPurchase.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotalMoneyPurchase.setBounds(60, 186, 330, 64);
		panelMoney.add(lblTotalMoneyPurchase);
		
		lblTotalMoneyValue = new JLabel("");
		lblTotalMoneyValue.setForeground(new Color(0, 128, 128));
		lblTotalMoneyValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalMoneyValue.setBounds(142, 68, 179, 46);
		panelMoney.add(lblTotalMoneyValue);
		
		lblTotalMoneyRentValue = new JLabel("");
		lblTotalMoneyRentValue.setForeground(new Color(0, 128, 128));
		lblTotalMoneyRentValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblTotalMoneyRentValue.setBounds(142, 148, 213, 46);
		panelMoney.add(lblTotalMoneyRentValue);
		
		lblToatlMoneyPurchaseValue = new JLabel("");
		lblToatlMoneyPurchaseValue.setForeground(new Color(0, 128, 128));
		lblToatlMoneyPurchaseValue.setFont(new Font("Ebrima", Font.BOLD, 40));
		lblToatlMoneyPurchaseValue.setBounds(142, 240, 215, 46);
		panelMoney.add(lblToatlMoneyPurchaseValue);
		
		setVisible(true);
		valuesfromdatabase();
	}
	
	public void valuesfromdatabase() {
		/*This method displays numbers of all books, rented books, purchased books,
		 *total members, total customers, total system admins, total money earned from 
		 *issuing and selling books, total money earned only from renting books,
		 *total money earned only from selling books in their respective JLabels
		 */
		try {
		connection();
		String sqltotalbooks = "select count(*) from books";
		PreparedStatement pst = conn.prepareStatement(sqltotalbooks);
		rs=pst.executeQuery();
		while(rs.next()) {
			lblToatlBooksValue.setText(rs.getString(1));
		}
		
		String sqlbookrent = "select count(book_name) from record where type = 'Rent'";
		PreparedStatement pst1 = conn.prepareStatement(sqlbookrent);
		rs=pst1.executeQuery();
		while(rs.next()) {
			lblTotalBooksRentedValue.setText(rs.getString(1));
		}
		
		String sqlbookbought = "select count(book_name) from record where type = 'Purchase'";
		PreparedStatement pst2 = conn.prepareStatement(sqlbookbought);
		rs=pst2.executeQuery();
		while(rs.next()) {
			lblTotalBooksPurchasedValue.setText(rs.getString(1));
		}
		
		String sqltotalmembers = "select count(*) from system_users";
		PreparedStatement pst3 = conn.prepareStatement(sqltotalmembers);
		rs=pst3.executeQuery();
		while(rs.next()) {
			lblTotalMembersValue.setText(rs.getString(1));
		}
		
		String sqltotalcustomers = "select count(*) from customer_info";
		PreparedStatement pst4 = conn.prepareStatement(sqltotalcustomers);
		rs=pst4.executeQuery();
		while(rs.next()) {
			lblTotalCustomersValue.setText(rs.getString(1));
		}
		
		String sqltotalsysadmins = "select count(*) from sys_admin";
		PreparedStatement pst5 = conn.prepareStatement(sqltotalsysadmins);
		rs=pst5.executeQuery();
		while(rs.next()) {
			lblTotalSysAdminsValue.setText(rs.getString(1));
		}
		
		String sqltotalmoney = "select sum(charge) from record";
		PreparedStatement pst6 = conn.prepareStatement(sqltotalmoney);
		rs=pst6.executeQuery();
		while(rs.next()) {
			lblTotalMoneyValue.setText("$"+rs.getString(1));
		}
		
		String sqlmoneyfrombookrent = "select sum(charge) from record where type = 'Rent'";
		PreparedStatement pst7 = conn.prepareStatement(sqlmoneyfrombookrent);
		rs=pst7.executeQuery();
		while(rs.next()) {
			lblTotalMoneyRentValue.setText("$"+rs.getString(1));
		}
		
		String sqlmoneyfrombookpurchase = "select sum(charge) from record where type = 'Purchase'";
		PreparedStatement pst8 = conn.prepareStatement(sqlmoneyfrombookpurchase);
		rs=pst8.executeQuery();
		while(rs.next()) {
			lblToatlMoneyPurchaseValue.setText("$"+rs.getString(1));
		}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String args[]) {
		new Statistics();
	}
}
