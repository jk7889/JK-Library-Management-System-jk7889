import java.awt.*;
import javax.swing.*;

public class Firstpage extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame FirstPageFrame =new JFrame();
	JLabel lblWelcome = new JLabel("WELCOME ! ");
	
	JButton btnAdminLogin = new JButton("Administrator Login");
    	JButton btnUserLogin = new JButton("User Login");
    
    	JLabel lblLibraryImage = new JLabel("");
    
    //Constructor to initialize components in JFrame FirstPageFrame
	public Firstpage() {
		firstpage();
	}
	
	//initialization method firstpage()
	public void firstpage() {
		 //Settings of JFrame and all other components
		 FirstPageFrame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		 FirstPageFrame.getContentPane().setForeground(UIManager.getColor("ScrollBar.trackHighlight"));
		 FirstPageFrame.getContentPane().setBackground(new Color(102, 0, 0));
		 FirstPageFrame.setBounds(100, 100, 981, 621);
		 FirstPageFrame.setLocation(500,100);
		 FirstPageFrame.setResizable(false);
	     	 FirstPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	 FirstPageFrame.getContentPane().setLayout(null);

		 lblWelcome.setBackground(SystemColor.controlHighlight);
		 lblWelcome.setForeground(SystemColor.window);
		 lblWelcome.setFont(new Font("Dialog", Font.BOLD, 51));
		 lblWelcome.setBounds(51, 170, 322, 55);

		 btnAdminLogin.setForeground(Color.BLACK);
		 btnAdminLogin.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		 btnAdminLogin.setBounds(94, 289, 200, 33);
		 btnAdminLogin.setFocusPainted(false);
		 
		 btnUserLogin.setForeground(Color.BLACK);
		 btnUserLogin.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		 btnUserLogin.setBounds(94, 375, 200, 33);
		 btnUserLogin.setFocusPainted(false);
		 
		 //JLabel containing Library Image
		 lblLibraryImage.setBackground(SystemColor.infoText);
		 lblLibraryImage.setBounds(0, 0, 975, 586);
		 Image imgg = new ImageIcon(this.getClass().getResource("lib_image.PNG")).getImage();
		 lblLibraryImage.setIcon(new ImageIcon(imgg));
		 
		 //Adding all components to JFrame
		 FirstPageFrame.getContentPane().add(lblWelcome);
		 FirstPageFrame.getContentPane().add(btnAdminLogin);
		 FirstPageFrame.getContentPane().add(btnUserLogin);
		 FirstPageFrame.getContentPane().add(lblLibraryImage);
		 
		 //Action Listeners for all JButtons
		 btnAdminLogin.addActionListener(event -> adminlogin());
		 btnUserLogin.addActionListener(event -> userlogin());
		
		 FirstPageFrame.setVisible(true);
		 FirstPageFrame.setResizable(false);
	 }
	 
	
	private void userlogin() {
		//To open User_Login class
		FirstPageFrame.dispose();
		new User_Login();
	}
	
	private void adminlogin() {
		//To open Admin_Login class
		FirstPageFrame.dispose();
		new Admin_Login();
	}
	
	public static void main(String args[]) {
	 	new Firstpage();
	}
}
