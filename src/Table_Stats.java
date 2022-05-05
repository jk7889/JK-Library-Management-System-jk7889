import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.JTableHeader;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class Table_Stats extends JPanel{
	private static final long serialVersionUID = -1273345243218224300L;
	
	Connection conn=null;
    	ResultSet rs =null;
    	ResultSet sr =null;
    	public JTable TableBooksPerCustomer;
    	public JTable TableBooksRentedPerCustomer;
    	public JTable TableBooksPurchasedPerCustomer;
    	public JTable TableBooksPerAuthor;
	
    //Method for establishing connection with MySQL Database
	public  void connection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library",Access.Username, Access.Password); 
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	//Using Constructor to initialize components in JPanel
	public Table_Stats() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(100, 100, 1311, 704);
		setLayout(null);
		
		JScrollPane scrollPaneBooksPerCustomer = new JScrollPane();
		scrollPaneBooksPerCustomer.setBounds(12, 54, 605, 278); //(305, 13, 1142, 805);
		scrollPaneBooksPerCustomer.getViewport().setBackground(new Color(255, 218, 185));
		add(scrollPaneBooksPerCustomer);
		
		TableBooksPerCustomer = new JTable();
		TableBooksPerCustomer.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableBooksPerCustomer.setRowHeight(TableBooksPerCustomer.getRowHeight() + 10);
		JTableHeader header = TableBooksPerCustomer.getTableHeader();
        	header.setBackground(new Color(255, 218, 185));
        	header.setForeground(Color.BLACK);
		scrollPaneBooksPerCustomer.setViewportView(TableBooksPerCustomer);
		
		JScrollPane scrollPaneBooksRentedPerCustomer = new JScrollPane();
		scrollPaneBooksRentedPerCustomer.setBounds(694, 54, 605, 278);
		scrollPaneBooksRentedPerCustomer.getViewport().setBackground(new Color(255, 250, 205));
		add(scrollPaneBooksRentedPerCustomer);
		
		TableBooksRentedPerCustomer = new JTable();
		TableBooksRentedPerCustomer.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableBooksRentedPerCustomer.setRowHeight(TableBooksRentedPerCustomer.getRowHeight() + 10);
		JTableHeader header1 = TableBooksRentedPerCustomer.getTableHeader();
		header1.setBackground(new Color(255, 250, 205));
		header1.setForeground(Color.BLACK);
        	scrollPaneBooksRentedPerCustomer.setViewportView(TableBooksRentedPerCustomer);
		
		JButton btnShowAllDatabases = new JButton("Show ALL");
		btnShowAllDatabases.setFocusPainted(false);
		btnShowAllDatabases.setBounds(607, 339, 97, 25);
		add(btnShowAllDatabases);
		
		JPanel panelBooksPerCustomer = new JPanel();
		panelBooksPerCustomer.setBackground(new Color(255, 218, 185));
		panelBooksPerCustomer.setBounds(0, 0, 655, 352);
		add(panelBooksPerCustomer);
		panelBooksPerCustomer.setLayout(null);
		
		JLabel lblBooksPerCustomer = new JLabel("                                Number of books rented or purchased by each customer");
		lblBooksPerCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBooksPerCustomer.setForeground(new Color(0, 0, 0));
		lblBooksPerCustomer.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBooksPerCustomer.setBounds(12, 28, 605, 32);
		panelBooksPerCustomer.add(lblBooksPerCustomer);
		
		JPanel panelBooksRentedPerCustomer = new JPanel();
		panelBooksRentedPerCustomer.setBackground(new Color(255, 250, 205));
		panelBooksRentedPerCustomer.setBounds(655, 0, 656, 352);
		add(panelBooksRentedPerCustomer);
		panelBooksRentedPerCustomer.setLayout(null);
		
		JLabel lblBooksRentedPerCustomer = new JLabel("                                            Number of books rented by each customer");
		lblBooksRentedPerCustomer.setForeground(Color.BLACK);
		lblBooksRentedPerCustomer.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBooksRentedPerCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBooksRentedPerCustomer.setBounds(39, 28, 605, 32);
		panelBooksRentedPerCustomer.add(lblBooksRentedPerCustomer);
		
		JPanel panelBooksPurchasedPerCustomer = new JPanel();
		panelBooksPurchasedPerCustomer.setBackground(new Color(204, 255, 153));
		panelBooksPurchasedPerCustomer.setBounds(0, 352, 655, 352);
		add(panelBooksPurchasedPerCustomer);
		panelBooksPurchasedPerCustomer.setLayout(null);
		
		JScrollPane scrollPaneBooksPurchasedPerCustomer = new JScrollPane();
		scrollPaneBooksPurchasedPerCustomer.setBounds(12, 50, 605, 278);
		panelBooksPurchasedPerCustomer.add(scrollPaneBooksPurchasedPerCustomer);
		scrollPaneBooksPurchasedPerCustomer.getViewport().setBackground(new Color(204, 255, 153));
		
		TableBooksPurchasedPerCustomer = new JTable();
		TableBooksPurchasedPerCustomer.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableBooksPurchasedPerCustomer.setRowHeight(TableBooksPurchasedPerCustomer.getRowHeight() + 10);
		JTableHeader header2 = TableBooksPurchasedPerCustomer.getTableHeader();
		header2.setBackground(new Color(204, 255, 153));
		header2.setForeground(Color.BLACK);
		scrollPaneBooksPurchasedPerCustomer.setViewportView(TableBooksPurchasedPerCustomer);
		
		JLabel lblBooksPurchasedPerCustomer = new JLabel("                                      Number of books purchased by each customer");
		lblBooksPurchasedPerCustomer.setForeground(Color.BLACK);
		lblBooksPurchasedPerCustomer.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBooksPurchasedPerCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBooksPurchasedPerCustomer.setBounds(12, 24, 605, 32);
		panelBooksPurchasedPerCustomer.add(lblBooksPurchasedPerCustomer);
		
		JPanel panelBooksPerAuthor = new JPanel();
		panelBooksPerAuthor.setBackground(new Color(175, 238, 238));
		panelBooksPerAuthor.setBounds(655, 352, 656, 352);
		add(panelBooksPerAuthor);
		panelBooksPerAuthor.setLayout(null);
		
		JScrollPane scrollPaneBooksPerAuthor = new JScrollPane();
		scrollPaneBooksPerAuthor.setBounds(39, 50, 605, 278);
		panelBooksPerAuthor.add(scrollPaneBooksPerAuthor);
		scrollPaneBooksPerAuthor.getViewport().setBackground(new Color(175, 238, 238));
		
		TableBooksPerAuthor = new JTable();
		TableBooksPerAuthor.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableBooksPerAuthor.setRowHeight(TableBooksPerAuthor.getRowHeight() + 10);
		JTableHeader header3 = TableBooksPerAuthor.getTableHeader();
		header3.setBackground(new Color(175, 238, 238));
		header3.setForeground(Color.BLACK);
		scrollPaneBooksPerAuthor.setViewportView(TableBooksPerAuthor);
		
		JLabel lblBooksPerAuthor = new JLabel("                                            Number of books written by each author");
		lblBooksPerAuthor.setForeground(Color.BLACK);
		lblBooksPerAuthor.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBooksPerAuthor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBooksPerAuthor.setBounds(39, 24, 605, 32);
		panelBooksPerAuthor.add(lblBooksPerAuthor);
		
		//Action Listener
		btnShowAllDatabases.addActionListener(actionevent ->tables());
		setVisible(true);
	}
		
	public void tables() {
		try {
			 /*This method displays all the 4 views when btnShowAllDatabases
			  *1) number_of_books_rented_bought_each_customer
			  *2) number_of_books_rented_each_customer
			  *3) number_of_books_bought_each_customer
			  *4) number_of_books_by_each_author
			  */
			 connection();
			 String ser = "select * from number_of_books_rented_bought_each_customer";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableBooksPerCustomer.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 String sel = "select * from number_of_books_rented_each_customer";
			 PreparedStatement pel = conn.prepareStatement(sel);
			 rs=pel.executeQuery();
			 TableBooksRentedPerCustomer.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 String srm = "select * from number_of_books_bought_each_customer";
			 PreparedStatement mrs = conn.prepareStatement(srm);
			 rs=mrs.executeQuery();
			 TableBooksPurchasedPerCustomer.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 String mrbos = "select * from number_of_books_by_each_author";
			 PreparedStatement mrbosd = conn.prepareStatement(mrbos);
			 rs=mrbosd.executeQuery();
			 TableBooksPerAuthor.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String args[]) {
		new Table_Stats();
	}
}
