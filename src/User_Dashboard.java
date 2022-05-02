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

public class User_Dashboard extends JFrame{
	private static final long serialVersionUID = 1L;
    
	public JFrame UserDashboardFrame;
	
	public JPanel UserDashboardPanel;
	public JLabel lbliconrecord;
	public JLabel lbliconcustomer;
	public JLabel lbliconbooks;
	public JLabel lbliconnumbers;
	public JLabel lbliconstatistics;
	public JLabel lbliconlogout;
	public JLabel lblLibraryLogo;
	public JLabel lblLibraryName;
	
	public Border emptyBorder;
	public JButton btnRecord;
	public JButton btnCustomers;
	public JButton btnBooks;
	public JButton btnNumbers;
	public JButton btnStatistics;
	public JButton btnLogout;
	
	public JPanel UserDashboardDataPanel;
	public JPanel SystemUserPanel;
	public JPanel RecordsPanel;
	public JPanel CustomersPanel;
	public JPanel BooksPanel;
	public JPanel NumbersPanel;
	public JPanel StatisticsPanel;
	
	//Using Constructor to initialize components in JFrame UserDashboardFrame
	public User_Dashboard() {
		userdashboard();
	}
	
	//initialization method userdashboard()
	public void userdashboard() {
		//Settings of JFrame and all other components
		UserDashboardFrame = new JFrame();
		UserDashboardFrame.setLocationByPlatform(true);
		UserDashboardFrame.setBounds(100, 100, 1549, 737);
		UserDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserDashboardFrame.getContentPane().setLayout(null);
		
		//UserDashboardPanel implementing card layout acting as a stack of cards
		UserDashboardPanel = new JPanel()
		{
			private static final long serialVersionUID = 1L;
			
			//Enabling components to be painted in the order they are below
			@Override
		    public boolean isOptimizedDrawingEnabled()
		    {
		        return false;
		    }
		};
		UserDashboardPanel.setBackground(new Color(21, 22, 23));
		UserDashboardPanel.setBounds(0, 0, 232, 723);
		UserDashboardPanel.setLayout(null);
		UserDashboardFrame.getContentPane().add(UserDashboardPanel);
		
		lbliconrecord = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("lib-record.png")).getImage();
		lbliconrecord.setIcon(new ImageIcon(img));
		lbliconrecord.setBounds(53, 173, 30, 30);
		UserDashboardPanel.add(lbliconrecord);
		
		lbliconcustomer = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("customer.png")).getImage();
		lbliconcustomer.setIcon(new ImageIcon(image));
		lbliconcustomer.setBounds(53, 240, 35, 31);
		UserDashboardPanel.add(lbliconcustomer);
		
		lbliconbooks = new JLabel("");
		Image picture = new ImageIcon(this.getClass().getResource("book.png")).getImage();
		lbliconbooks.setIcon(new ImageIcon(picture));
		lbliconbooks.setBounds(53, 306, 32, 32);
		UserDashboardPanel.add(lbliconbooks);
		
		lbliconnumbers = new JLabel("");
		Image ico = new ImageIcon(this.getClass().getResource("numbers.png")).getImage();
		lbliconnumbers.setIcon(new ImageIcon(ico));
		lbliconnumbers.setBounds(53, 368, 40, 40);
		UserDashboardPanel.add(lbliconnumbers);
		
		lbliconstatistics = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("stats.png")).getImage();
		lbliconstatistics.setIcon(new ImageIcon(icon));
		lbliconstatistics.setBounds(53, 435, 41, 41);
		UserDashboardPanel.add(lbliconstatistics);
		
		lbliconlogout = new JLabel("");
		Image pic = new ImageIcon(this.getClass().getResource("logout.png")).getImage();
		lbliconlogout.setIcon(new ImageIcon(pic));
		lbliconlogout.setBounds(53, 502, 43, 43);
		UserDashboardPanel.add(lbliconlogout);
		
		emptyBorder = BorderFactory.createEmptyBorder();
		
		btnRecord = new JButton("  Record");
		btnRecord.setBackground(new Color(21, 22, 23));
		btnRecord.setForeground(Color.WHITE);
		btnRecord.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRecord.setBorder(emptyBorder);
		btnRecord.setBounds(-15, 161, 247, 54);
		btnRecord.setFocusPainted(false);
		UserDashboardPanel.add(btnRecord);
		
		btnCustomers = new JButton("       Customers");
		btnCustomers.setBackground(new Color(99, 99, 98));
		btnCustomers.setForeground(Color.WHITE);
		btnCustomers.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnCustomers.setBorder(emptyBorder);
		btnCustomers.setBounds(-15, 228, 247, 54);
		btnCustomers.setFocusPainted(false);
		UserDashboardPanel.add(btnCustomers);
		
		btnBooks = new JButton("Books");
		btnBooks.setForeground(Color.WHITE);
		btnBooks.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnBooks.setBorder(emptyBorder);
		btnBooks.setBackground(new Color(21, 22, 23));
		btnBooks.setBounds(-5, 295, 237, 54);
		btnBooks.setFocusPainted(false);
		UserDashboardPanel.add(btnBooks);
		
		btnNumbers = new JButton("     Numbers");
		btnNumbers.setFocusPainted(false);
		btnNumbers.setForeground(Color.WHITE);
		btnNumbers.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNumbers.setBorder(emptyBorder);
		btnNumbers.setBackground(new Color(21, 22, 23));
		btnNumbers.setBounds(-15, 362, 247, 54);
		UserDashboardPanel.add(btnNumbers);
		
		btnStatistics = new JButton("      Statistics");
		btnStatistics.setForeground(Color.WHITE);
		btnStatistics.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnStatistics.setFocusPainted(false);
		btnStatistics.setBorder(emptyBorder);
		btnStatistics.setBackground(new Color(21, 22, 23));
		btnStatistics.setBounds(-15, 429, 247, 54);
		UserDashboardPanel.add(btnStatistics);
		
		btnLogout = new JButton("   Logout");
		btnLogout.setBackground(new Color(21, 22, 23));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnLogout.setBorder(emptyBorder);
		btnLogout.setBounds(-15, 496, 247, 54);
		btnLogout.setFocusPainted(false);
		UserDashboardPanel.add(btnLogout);
		
		//JLabel for Library Logo
		lblLibraryLogo = new JLabel("");
		lblLibraryLogo.setBounds(12, 65, 57, 32);
		Image imu = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		lblLibraryLogo.setIcon(new ImageIcon(imu));
		UserDashboardPanel.add(lblLibraryLogo);
		
		//JLabel for Library Name
		lblLibraryName = new JLabel("JK Library");
		lblLibraryName.setForeground(new Color(255, 222, 77));
		lblLibraryName.setFont(new Font("Calibri", Font.BOLD, 31));
		lblLibraryName.setBounds(78, 65, 154, 39);
		UserDashboardPanel.add(lblLibraryName);
		
		//Panel implementing card layout which changes based on which button is selected in AdminDashboardPanel
		UserDashboardDataPanel = new JPanel();
		UserDashboardDataPanel.setBackground(new Color(21, 22, 23));
		UserDashboardDataPanel.setBounds(232, 0, 1311, 704);
		UserDashboardFrame.getContentPane().add(UserDashboardDataPanel);
		UserDashboardDataPanel.setLayout(new CardLayout(0, 0));
		
		//Panels to display all classes
		CustomersPanel = new JPanel();
		Customers customer = new Customers();
		customer.setLocation(0, 0);
		CustomersPanel.setLayout(null);
		CustomersPanel.add(customer);
		UserDashboardDataPanel.add(CustomersPanel, "name_295412199382600");
		
		RecordsPanel = new JPanel();
		Records record = new Records();
		record.setLocation(0, 0);
		RecordsPanel.setLayout(null);
		RecordsPanel.add(record);
		UserDashboardDataPanel.add(RecordsPanel, "name_295504773789900");
		
		BooksPanel = new JPanel();
		Books book = new Books();
		book.setLocation(0, 0);
		BooksPanel.setLayout(null);
		BooksPanel.add(book);
		UserDashboardDataPanel.add(BooksPanel, "name_369711435243100");
		
		NumbersPanel = new JPanel();
		Table_Stats number = new Table_Stats();
		number.setLocation(0, 0);
		NumbersPanel.setLayout(null);
		NumbersPanel.add(number);
		UserDashboardDataPanel.add(NumbersPanel, "name_469711435300");
		
		StatisticsPanel = new JPanel();
		Statistics statistic = new Statistics();
		statistic.setLocation(0, 0);
		StatisticsPanel.setLayout(null);
		StatisticsPanel.add(statistic);
		UserDashboardDataPanel.add(StatisticsPanel, "name_469711435243300");
		
		btnRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeButtonColor(btnRecord, btnCustomers, btnBooks, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnCustomers, btnRecord, btnBooks, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnBooks, btnRecord, btnCustomers, btnLogout, btnStatistics, btnNumbers);
			}
		});
		
		btnNumbers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnNumbers, btnRecord, btnCustomers, btnLogout, btnBooks, btnStatistics);
			}
		});
		
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnStatistics, btnRecord, btnCustomers, btnLogout, btnBooks, btnNumbers);
			}
		});
		
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeButtonColor(btnLogout, btnRecord, btnCustomers, btnBooks, btnStatistics, btnNumbers);
			}
		});
		
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboardDataPanel.removeAll();
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
				
				UserDashboardDataPanel.add(RecordsPanel);
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
			}
		});
		
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboardDataPanel.removeAll();
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
				
				UserDashboardDataPanel.add(CustomersPanel);
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
			}
		});
		
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboardDataPanel.removeAll();
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
				
				UserDashboardDataPanel.add(BooksPanel);
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
			}
		});
		
		btnNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboardDataPanel.removeAll();
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
				
				UserDashboardDataPanel.add(NumbersPanel);
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
			}
		});
		
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboardDataPanel.removeAll();
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
				
				UserDashboardDataPanel.add(StatisticsPanel);
				UserDashboardDataPanel.repaint();
				UserDashboardDataPanel.revalidate();
			}
		});
		
		btnLogout.addActionListener(actionevent -> logout());
		
		UserDashboardFrame.setVisible(true);
		UserDashboardFrame.setResizable(false);
	}
	
	/* This method changes the color of the button in the first parameter to grey
	 * and changes other button colors to the color of UserDashboardPanel therefore
	 * highlighting ONLY the clicked button
	 */
	public void changeButtonColor(JButton button, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
		button.setBackground(new Color(99, 99, 98));
		button1.setBackground(new Color(21, 22, 23));
		button2.setBackground(new Color(21, 22, 23));
		button3.setBackground(new Color(21, 22, 23));
		button4.setBackground(new Color(21, 22, 23));
		button5.setBackground(new Color(21, 22, 23));
	}
	
	//Opens User_Login class
	public void logout() {
		UserDashboardFrame.dispose();
		new User_Login();
	}
	public static void main(String args[]) {
	 	new User_Dashboard();
	 }
}
