import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Admin_Dashboard extends JFrame{
	private static final long serialVersionUID = 1L;
    
	public JFrame AdminDashboardFrame;
	
	public JPanel AdminDashboardPanel;
	
	public JLabel lbliconusers;
	public JLabel lbliconrecord;
	public JLabel lbliconcustomer;
	public JLabel lbliconbooks;
	public JLabel lbliconnumbers;
	public JLabel lbliconstatistics;
	public JLabel lbliconlogout;
	public JLabel lblLibraryLogo;
	public JLabel lblLibraryName;
	
	public Border emptyBorder;
	
	public JButton btnUsers;
	public JButton btnRecord;
	public JButton btnCustomers;
	public JButton btnBooks;
	public JButton btnNumbers;
	public JButton btnStatistics;
	public JButton btnLogout;
	
	public JPanel AdminDashboardDataPanel;
	public JPanel SystemUserPanel;
	public JPanel RecordsPanel;
	public JPanel CustomersPanel;
	public JPanel BooksPanel;
	public JPanel NumbersPanel;
	public JPanel StatisticsPanel;
	
	//Using Constructor to initialize components in JFrame AdminDashboardFrame
	public Admin_Dashboard() {
		admindashboard();
	}
	
	//initialization method admindashboard()
	public void admindashboard() {
		//Settings of JFrame and all other components
		AdminDashboardFrame = new JFrame();
		AdminDashboardFrame.setLocationByPlatform(true);
		AdminDashboardFrame.setBounds(100, 100, 1549, 737);
		AdminDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminDashboardFrame.getContentPane().setLayout(null);
		
		//AdminDashboardPanel implementing card layout acting as a stack of cards
		AdminDashboardPanel = new JPanel()
		{
			private static final long serialVersionUID = 1L;
			
			//Enabling components to be painted in the order they are below
			@Override
		    public boolean isOptimizedDrawingEnabled()
		    {
		        return false;
		    }
		};
		AdminDashboardPanel.setBackground(new Color(21, 22, 23));
		AdminDashboardPanel.setBounds(0, 0, 232, 723);
		AdminDashboardPanel.setLayout(null);
		AdminDashboardFrame.getContentPane().add(AdminDashboardPanel);
		
		//All JLabels
		lbliconusers = new JLabel("");
		Image imgg = new ImageIcon(this.getClass().getResource("user.png")).getImage();
		lbliconusers.setIcon(new ImageIcon(imgg));
		lbliconusers.setBounds(53, 164, 24, 24);
		AdminDashboardPanel.add(lbliconusers);
		
		lbliconrecord = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("lib-record.png")).getImage();
		lbliconrecord.setIcon(new ImageIcon(img));
		lbliconrecord.setBounds(53, 225, 30, 30);
		AdminDashboardPanel.add(lbliconrecord);
		
		lbliconcustomer = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("customer.png")).getImage();
		lbliconcustomer.setIcon(new ImageIcon(image));
		lbliconcustomer.setBounds(53, 292, 35, 31);
		AdminDashboardPanel.add(lbliconcustomer);
		
		lbliconbooks = new JLabel("");
		Image picture = new ImageIcon(this.getClass().getResource("book.png")).getImage();
		lbliconbooks.setIcon(new ImageIcon(picture));
		lbliconbooks.setBounds(53, 358, 32, 32);
		AdminDashboardPanel.add(lbliconbooks);
		
		lbliconnumbers = new JLabel("");
		Image ico = new ImageIcon(this.getClass().getResource("numbers.png")).getImage();
		lbliconnumbers.setIcon(new ImageIcon(ico));
		lbliconnumbers.setBounds(53, 420, 40, 40);
		AdminDashboardPanel.add(lbliconnumbers);
		
		lbliconstatistics = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("stats.png")).getImage();
		lbliconstatistics.setIcon(new ImageIcon(icon));
		lbliconstatistics.setBounds(53, 487, 41, 41);
		AdminDashboardPanel.add(lbliconstatistics);
		
		lbliconlogout = new JLabel("");
		Image pic = new ImageIcon(this.getClass().getResource("logout.png")).getImage();
		lbliconlogout.setIcon(new ImageIcon(pic));
		lbliconlogout.setBounds(53, 554, 43, 43);
		AdminDashboardPanel.add(lbliconlogout);
		
		emptyBorder = BorderFactory.createEmptyBorder();
		
		//All JButtons
		btnUsers = new JButton(" Users");
		btnUsers.setBackground(new Color(99, 99, 98)); 
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnUsers.setBorder(emptyBorder);
		btnUsers.setBounds(-15, 146, 247, 54);
		btnUsers.setFocusPainted(false);
		AdminDashboardPanel.add(btnUsers);
		
		btnRecord = new JButton("  Record");
		btnRecord.setBackground(new Color(21, 22, 23));
		btnRecord.setForeground(Color.WHITE);
		btnRecord.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRecord.setBorder(emptyBorder);
		btnRecord.setBounds(-15, 213, 247, 54);
		btnRecord.setFocusPainted(false);
		AdminDashboardPanel.add(btnRecord);
		
		btnCustomers = new JButton("       Customers");
		btnCustomers.setBackground(new Color(21, 22, 23));
		btnCustomers.setForeground(Color.WHITE);
		btnCustomers.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnCustomers.setBorder(emptyBorder);
		btnCustomers.setBounds(-15, 280, 247, 54);
		btnCustomers.setFocusPainted(false);
		AdminDashboardPanel.add(btnCustomers);
		
		btnBooks = new JButton("Books");
		btnBooks.setForeground(Color.WHITE);
		btnBooks.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnBooks.setBorder(emptyBorder);
		btnBooks.setBackground(new Color(21, 22, 23));
		btnBooks.setBounds(-5, 347, 237, 54);
		btnBooks.setFocusPainted(false);
		AdminDashboardPanel.add(btnBooks);
		
		btnNumbers = new JButton("     Numbers");
		btnNumbers.setFocusPainted(false);
		btnNumbers.setForeground(Color.WHITE);
		btnNumbers.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNumbers.setBorder(emptyBorder);
		btnNumbers.setBackground(new Color(21, 22, 23));
		btnNumbers.setBounds(-15, 414, 247, 54);
		AdminDashboardPanel.add(btnNumbers);
		
		btnStatistics = new JButton("      Statistics");
		btnStatistics.setForeground(Color.WHITE);
		btnStatistics.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnStatistics.setFocusPainted(false);
		btnStatistics.setBorder(emptyBorder);
		btnStatistics.setBackground(new Color(21, 22, 23));
		btnStatistics.setBounds(-15, 481, 247, 54);
		AdminDashboardPanel.add(btnStatistics);
		
		btnLogout = new JButton("   Logout");
		btnLogout.setBackground(new Color(21, 22, 23));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnLogout.setBorder(emptyBorder);
		btnLogout.setBounds(-15, 548, 247, 54);
		btnLogout.setFocusPainted(false);
		AdminDashboardPanel.add(btnLogout);
		
		//JLabel for Library Logo
		lblLibraryLogo = new JLabel("");
		lblLibraryLogo.setBounds(12, 65, 57, 32);
		Image imu = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		lblLibraryLogo.setIcon(new ImageIcon(imu));
		AdminDashboardPanel.add(lblLibraryLogo);
		
		//JLabel for Library Name
		lblLibraryName = new JLabel("JK Library");
		lblLibraryName.setForeground(new Color(255, 222, 77));
		lblLibraryName.setFont(new Font("Calibri", Font.BOLD, 31));
		lblLibraryName.setBounds(78, 65, 154, 39);
		AdminDashboardPanel.add(lblLibraryName);
		
		//Panel implementing card layout which changes based on which button is selected in AdminDashboardPanel
		AdminDashboardDataPanel = new JPanel();
		AdminDashboardDataPanel.setBackground(new Color(21, 22, 23));
		AdminDashboardDataPanel.setBounds(232, 0, 1311, 704);
		AdminDashboardFrame.getContentPane().add(AdminDashboardDataPanel);
		AdminDashboardDataPanel.setLayout(new CardLayout(0, 0));
		
		//Panels to display all classes
		SystemUserPanel = new JPanel();
		System_Users sys_user = new System_Users();
		sys_user.setLocation(0, 0);
		SystemUserPanel.setLayout(null);
		SystemUserPanel.add(sys_user);
		AdminDashboardDataPanel.add(SystemUserPanel, "name_295363340210600");
		
		CustomersPanel = new JPanel();
		Customers customer = new Customers();
		customer.setLocation(0, 0);
		CustomersPanel.setLayout(null);
		CustomersPanel.add(customer);
		AdminDashboardDataPanel.add(CustomersPanel, "name_295412199382600");
		
		RecordsPanel = new JPanel();
		Records record = new Records();
		record.setLocation(0, 0);
		RecordsPanel.setLayout(null);
		RecordsPanel.add(record);
		AdminDashboardDataPanel.add(RecordsPanel, "name_295504773789900");
		
		BooksPanel = new JPanel();
		Books book = new Books();
		book.setLocation(0, 0);
		BooksPanel.setLayout(null);
		BooksPanel.add(book);
		AdminDashboardDataPanel.add(BooksPanel, "name_369711435243100");
		
		NumbersPanel = new JPanel();
		Table_Stats number = new Table_Stats();
		number.setLocation(0, 0);
		NumbersPanel.setLayout(null);
		NumbersPanel.add(number);
		AdminDashboardDataPanel.add(NumbersPanel, "name_469711435300");
		
		StatisticsPanel = new JPanel();
		Statistics statistic = new Statistics();
		statistic.setLocation(0, 0);
		StatisticsPanel.setLayout(null);
		StatisticsPanel.add(statistic);
		AdminDashboardDataPanel.add(StatisticsPanel, "name_469711435243300");
		
		/* All Mouse Listeners implement changeButtonColor Method when mouse is clicked.
		 * This method changes the color of the button in the first parameter to grey
		 * and changes other button colors to the color of AdminDashboardPanel therefore
		 * highlighting ONLY the clicked button
		 */
		btnUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnUsers, btnRecord, btnCustomers, btnBooks, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeButtonColor(btnRecord, btnUsers, btnCustomers, btnBooks, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnCustomers, btnRecord, btnUsers, btnBooks, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnBooks, btnRecord, btnCustomers, btnUsers, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnNumbers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnNumbers, btnRecord, btnCustomers, btnUsers, btnLogout, btnBooks, btnStatistics);
			}
		});
		
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnStatistics, btnRecord, btnCustomers, btnUsers, btnLogout, btnBooks, btnNumbers);
			}
		});
		
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnLogout, btnRecord, btnCustomers, btnBooks, btnUsers, btnStatistics, btnNumbers);
			}
		});
		
		/*All Mouse Action Listeners change the AdminDashboardDataPanel to a specific panel
		 * displaying a specific class when a specific button is clicked. Eg. if btnUsers is
		 * clicked then AdminDashboardDataPanel changes to SystemUserPanel 
		 */
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(SystemUserPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(RecordsPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(CustomersPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(BooksPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(NumbersPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardDataPanel.removeAll();
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
				
				AdminDashboardDataPanel.add(StatisticsPanel);
				AdminDashboardDataPanel.repaint();
				AdminDashboardDataPanel.revalidate();
			}
		});
		
		btnLogout.addActionListener(actionevent -> logout());
		
		AdminDashboardFrame.setVisible(true);
		AdminDashboardFrame.setResizable(false);
	}
	
	/* This method changes the color of the button in the first parameter to grey
	 * and changes other button colors to the color of AdminDashboardPanel therefore
	 * highlighting ONLY the clicked button
	 */
	public void changeButtonColor(JButton button, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {
		button.setBackground(new Color(99, 99, 98));
		button1.setBackground(new Color(21, 22, 23));
		button2.setBackground(new Color(21, 22, 23));
		button3.setBackground(new Color(21, 22, 23));
		button4.setBackground(new Color(21, 22, 23));
		button5.setBackground(new Color(21, 22, 23));
		button6.setBackground(new Color(21, 22, 23));
	}
	
	//Opens Admin_Login class
	public void logout() {
		AdminDashboardFrame.dispose();
		new Admin_Login();
	}
	public static void main(String args[]) {
	 	new Admin_Dashboard();
	 }
}
