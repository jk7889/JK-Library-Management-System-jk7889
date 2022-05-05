import java.awt.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
public class Books extends JPanel{
	private static final long serialVersionUID = 1L;

	Connection conn=null;
    	ResultSet rs =null;
    	ResultSet sr =null;
    	ResultSet sr1 =null;

    	ResultSet nr =null;
    	ResultSet mn =null;
    	Statement pst =null;

	public JTextField BookIDText;
	public JTextField TitleText;
	public JTextField AuthorText;
	public JTextField PublisherText;
	public JTextField PublicationYearText;
    	public JTextField PagesText;
    	public JTextField SearchText;
	public JRadioButton rdbtnManual;
	public JRadioButton rdbtnAutomatic;
    	public JTable TableBooks;
    
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
	public Books() {
		//Settings of JPanel and all other components
		setBackground(new Color(255, 250, 232));
		setBounds(0, 0, 1311, 704);
		setLayout(null);

        	JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblBookID.setBounds(39, 70, 116, 16);
		add(lblBookID);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblTitle.setBounds(39, 117, 149, 22);
		add(lblTitle);
		
		JLabel lblIDType = new JLabel("ID Type:");
		lblIDType.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblIDType.setBounds(39, 174, 84, 22);
		add(lblIDType);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblAuthor.setBounds(39, 235, 97, 16);
		add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblPublisher.setBounds(39, 284, 127, 16);
		add(lblPublisher);
		
		JLabel lblPublicationYear = new JLabel("Publication Year:");
		lblPublicationYear.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblPublicationYear.setBounds(42, 328, 146, 30);
		add(lblPublicationYear);
		
		JLabel lblPages = new JLabel("Pages:");
	   	lblPages.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	    	lblPages.setBounds(39, 375, 146, 30);
	    	add(lblPages);
	    
	    	JLabel label = new JLabel(":");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(148, 607, 7, 30);
		add(label);
		
		BookIDText = new JTextField();
		BookIDText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		BookIDText.setBounds(200, 67, 116, 22);
		add(BookIDText);
		BookIDText.setColumns(10);
		
		TitleText = new JTextField();
		TitleText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		TitleText.setBounds(200, 117, 116, 22);
		add(TitleText);
		TitleText.setColumns(10);
		
		AuthorText = new JTextField();
		AuthorText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		AuthorText.setBounds(200, 232, 116, 22);
		add(AuthorText);
		AuthorText.setColumns(10);
		
		PublisherText = new JTextField();
		PublisherText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		PublisherText.setBounds(200, 281, 116, 22);
		add(PublisherText);
		PublisherText.setColumns(10);
		
		PublicationYearText = new JTextField();
		PublicationYearText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		PublicationYearText.setBounds(200, 332, 116, 22);
		add(PublicationYearText);
		PublicationYearText.setColumns(10);
		
		PagesText = new JTextField();
	    	PagesText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	    	PagesText.setColumns(10);
	    	PagesText.setBounds(200, 379, 116, 22);
	    	add(PagesText);
		
		SearchText = new JTextField();
		SearchText.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		SearchText.setBounds(167, 610, 116, 25);
		add(SearchText);
		SearchText.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setBounds(24, 449, 86, 25);
		btnAdd.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFocusPainted(false);
		btnSave.setBounds(122, 449, 97, 25);
		btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusPainted(false);
		btnDelete.setBounds(132, 487, 87, 25);
		btnDelete.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false);
		btnReset.setBounds(24, 487, 97, 25);
		btnReset.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		add(btnReset);
		
		JButton btnView = new JButton("View");
		btnView.setFocusPainted(false);
		btnView.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnView.setBounds(231, 449, 85, 25);
		add(btnView);
		
		JButton btnShowDatabase = new JButton("Table");
	    	btnShowDatabase.setFocusPainted(false);
	    	btnShowDatabase.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	    	btnShowDatabase.setBounds(230, 487, 86, 25);
	    	add(btnShowDatabase);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFocusPainted(false);
		btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnSearch.setBounds(37, 610, 99, 25);
		add(btnSearch);
		
		JScrollPane ScrollPaneBooks = new JScrollPane();
		ScrollPaneBooks.setBounds(349, 13, 939, 678); //setBounds(333, 13, 1110, 800);
		ScrollPaneBooks.getViewport().setBackground(new Color(255, 250, 232));
		add(ScrollPaneBooks);
	
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
	 
		TableBooks = new JTable();
		TableBooks.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		TableBooks.setRowHeight(TableBooks.getRowHeight() + 10);
		JTableHeader header = TableBooks.getTableHeader();
       		header.setBackground(new Color(255, 250, 232));
        	header.setForeground(Color.BLACK);
		ScrollPaneBooks.setViewportView(TableBooks);
		
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
		BookIDText.setText(null);
		BookIDText.setEditable(false);
		BookIDText.setBackground(new Color(255, 250, 232));
	}
	
	public void textedit() {
		/*This method makes CustomerIDText JTextField editable 
		 *i.e. a number can be entered in that JTextField
		 *for the purpose of adding an id to customer_info 
		 *table when ID Type:Manual is selected 
		 */
		BookIDText.setEditable(true);
		BookIDText.setBackground(Color.WHITE);
	}
	
	public void reset() {
		//Setting all JTextFields empty
		BookIDText.setText("");
		TitleText.setText("");
		AuthorText.setText("");
		PublicationYearText.setText("");
		PublisherText.setText("");
		PagesText.setText("");
		SearchText.setText("");
	}
	
	public void manualaddition() {
		 try {
			 /*This method is for manual insertion upon clicking "Add" button 
			  *which means the id in books table needs to be entered by 
			  *the system user
			  */
		    	 connection();
		     	 textedit();
			 String sql="insert into books (id,title,author,publisher,publishing_year,pages) values (?,?,?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,BookIDText.getText());
			 pst.setString(2,firstLetterCapital(TitleText.getText()));
			 pst.setString(3,firstLetterCapital(AuthorText.getText()));
			 pst.setString(4,firstLetterCapital(PublisherText.getText()));
			 
			 //Using Regex to fix the length of year in PublicationYearText to 4 digits 
			 String yearRegex = "^\\d{4}$";
			 Pattern pattern = Pattern.compile(yearRegex);
			 Matcher matcher = pattern.matcher(PublicationYearText.getText());
			 if(matcher.matches() == true) {
				 pst.setString(5,PublicationYearText.getText());
			 }else {
			 	 JOptionPane.showMessageDialog(null, "This year is not 4 digits", "Alert",JOptionPane.ERROR_MESSAGE);
		     	 }
			 pst.setString(6,PagesText.getText());
			 pst.executeUpdate();
			 
			 //Displaying books table after insertion
			 String ser = "select * from books";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableBooks.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	public void automaticaddition() {
		try {
			/*This method is for automatic insertion upon clicking add button
			 *which means that there is no need to insert a book id. The books
			 *table will automatically assign one upon insertion because of 
			 *auto_increment constraint on books table
			 */
			 connection();
			 notextedit();
			 String sql="insert into books (title,author,publisher,publishing_year,pages) values (?,?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(TitleText.getText()));
			 pst.setString(2,firstLetterCapital(AuthorText.getText()));
			 pst.setString(3,firstLetterCapital(PublisherText.getText()));
			 
			 //Using Regex to fix the length of year in PublicationYearText to 4 digits 
			 String yearRegex = "^\\d{4}$";
			 Pattern pattern = Pattern.compile(yearRegex);
			 Matcher matcher = pattern.matcher(PublicationYearText.getText());
			 if(matcher.matches() == true) {
				 pst.setString(4,PublicationYearText.getText());
		     	 }else {
		    	 	 JOptionPane.showMessageDialog(null, "This year is not 4 digits", "Alert",JOptionPane.ERROR_MESSAGE);
		     	 }
			 pst.setString(5,PagesText.getText());
			 pst.executeUpdate();
			 
			 //Displaying books table after insertion
			 String ser = "select * from books";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableBooks.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			/*This method deletes a row from the books table associated with the 
			  *book id entered in in BookIDText JTextField
			  */
		     	 connection();
			 String sql="delete from books where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,BookIDText.getText());
			 pst.executeUpdate();
			 
			 //Displaying the table after the deletion
			 String ser = "select * from books";
			 PreparedStatement sat = conn.prepareStatement(ser);
			 rs=sat.executeQuery();
			 TableBooks.setModel(DbUtils.resultSetToTableModel(rs));
			 
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		 }
	}

	public void searche() {
		try {
			//This method searches the whole table for the string which will be entered in the SearchText JTextField
			connection();
			String sql="select * from books where CONCAT(id,title,author,publisher,publishing_year,pages) like '%"+SearchText.getText()+"%';";
			PreparedStatement pst = conn.prepareStatement(sql);
			sr=pst.executeQuery();
		    	TableBooks.setModel(DbUtils.resultSetToTableModel(sr));
	    }catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
	}
	}
	
	public void look() {
		try {
			/*This method does two things: 
			  *1) It displays the whole table if the BookIDText JTextField is empty
			  *2) It displays all the values of a particular row in their respective JTextFields
			  *   based on the Book ID entered in BookIDText JTextField 
			  *The purpose of this method is not only for viewing but also to make 
			  *updating more convenient for the user
			  */
			 connection();
			 if(BookIDText.getText().equals("") && TitleText.getText().equals("") && AuthorText.getText().equals("") && PublicationYearText.getText().equals("") && PublisherText.getText().equals("")) {
				 String ser = "select * from books";
				 PreparedStatement sat = conn.prepareStatement(ser);
				 mn=sat.executeQuery();
				 TableBooks.setModel(DbUtils.resultSetToTableModel(mn));
			 }else if(BookIDText.getText().equals(BookIDText.getText())) {
				 String sql = "select id,title,author,publisher,publishing_year,pages from books where id = ?";
			        PreparedStatement pst=conn.prepareStatement(sql);
			        pst.setString(1,BookIDText.getText());
                    rs = pst.executeQuery();
			    while(rs.next()) { 
			        BookIDText.setText(rs.getString("id"));
			        TitleText.setText(rs.getString("title"));
			        AuthorText.setText(rs.getString("author"));
			        PublisherText.setText(rs.getString("publisher"));
			        PublicationYearText.setText(rs.getString("publishing_year"));
			        PagesText.setText(rs.getString("pages"));
			    }
			    	 //The below Java code only displays the row in the books table whose Book ID is entered
				     PreparedStatement stmt=conn.prepareStatement(sql);
				     stmt.setString(1,BookIDText.getText());
				     sr=stmt.executeQuery();
				     TableBooks.setModel(DbUtils.resultSetToTableModel(sr));
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
			 String sql="select * from books";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 sr=pst.executeQuery();
		     TableBooks.setModel(DbUtils.resultSetToTableModel(sr));
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saved() {
		try {
			 //This method is for updating books table
			 connection();
			 /*Saving the book ID from record table for book_name entered by the user 
			  *in BookIdText JTextField for updating it later
			  */
			 String rec_old_book_name = "";
			 String sqld = "select book_name from record where book_name like '%("+BookIDText.getText()+")%';";
		     PreparedStatement pd = conn.prepareStatement(sqld);
		     ResultSet rd =pd.executeQuery();
		     if(rd.next() == true) {
		    	 rec_old_book_name = rd.getString("book_name");
		     }
		     
		     //Updating books table
			 String sql="update books set title = ?,author = ?,publisher = ?,publishing_year = ?,pages = ? where id = ?";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setString(1,firstLetterCapital(TitleText.getText()));
			 pst.setString(2,firstLetterCapital(AuthorText.getText()));
			 pst.setString(3,firstLetterCapital(PublisherText.getText()));
			 
			 //Using Regex to fix the length of year in PublicationYearText to 4 digits 
			 String yearRegex = "^\\d{4}$";
			 Pattern pattern = Pattern.compile(yearRegex);
			 Matcher matcher = pattern.matcher(PublicationYearText.getText());
			 if(matcher.matches() == true) {
				 pst.setString(4,PublicationYearText.getText());
		     }else {
		    	 JOptionPane.showMessageDialog(null, "This year is not 4 digits", "Alert",JOptionPane.ERROR_MESSAGE);
		     }
			 pst.setString(5,PagesText.getText());
			 pst.setString(6,BookIDText.getText());
			 pst.executeUpdate();
			 
			 //Displaying the table after updating it
			 String sql1 ="select * from books where id = ?";
			 PreparedStatement stmt=conn.prepareStatement(sql1);
		     stmt.setString(1,BookIDText.getText());
		     sr=stmt.executeQuery();
		     TableBooks.setModel(DbUtils.resultSetToTableModel(sr));
		     
		     /*If an update is made in books table and book_name is changed 
			  *then the same book_name for a particular book_id needs to be 
			  *updated in record table
			  */
		     String sqlrecord = "update record set book_name = ? where book_name = ?";
		     PreparedStatement bst = conn.prepareStatement(sqlrecord);
		     bst.setString(1, TitleText.getText()+" ("+BookIDText.getText()+")");
		     bst.setString(2, rec_old_book_name);
		     bst.executeUpdate();
		     
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
		new Books();
	}
}


