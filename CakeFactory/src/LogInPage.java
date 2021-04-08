import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;

public class LogInPage extends JFrame implements ActionListener{

	JButton nextButton;
	JButton signUpButton;
	JTextField  usernameTextField;
	JPasswordField passwordTextField;
	static final int FRAME_WIDTH=400;
	static final int FRAME_HEIGHT=300;
	String url;
	String username;
	String password;
	SQLinfo info1;
	
	LogInPage(SQLinfo info){
		
		info1=new SQLinfo();
		info1.copy(info);
		url=info1.getServer();
		username=info1.getUsername();
		password=info1.getPassword();
		
		this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("LogIn page");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		Image background=new ImageIcon("wall.jpg").getImage();
		this.setContentPane(new JPanel() {
		   public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			 g.drawImage(background,0,0,null);
		}
	});
		nextButton=new JButton("Next");
	    nextButton.setBounds(266, 207, 80, 30);
		nextButton.setFocusable(false);
		nextButton.setFont(new Font(null,Font.PLAIN,15));
		nextButton.addActionListener(this);
		this.add(nextButton);
		
		signUpButton=new JButton("SignUp");
		signUpButton.setBounds(150, 207,100, 30);
		signUpButton.setFocusable(false);
		signUpButton.setFont(new Font(null,Font.PLAIN,15));
		signUpButton.addActionListener(this);
		this.add(signUpButton);
		
		JLabel usernameLabel= new JLabel("Username:");
		usernameLabel.setFont(new Font(null,Font.BOLD,25));
		usernameLabel.setBounds(30,FRAME_HEIGHT/4, 300, 25);
		this.add(usernameLabel);
		
		JLabel passwordLabel= new JLabel("Password:");
		passwordLabel.setBounds(30,FRAME_HEIGHT/2, 300, 25);
		passwordLabel.setFont(new Font(null,Font.BOLD,25));
		this.add(passwordLabel);
		
		usernameTextField=new JTextField();
		usernameTextField.setBounds(FRAME_WIDTH/2,FRAME_HEIGHT/4,150,30);
		this.add(usernameTextField);
		
		passwordTextField=new JPasswordField();
		passwordTextField.setBounds(FRAME_WIDTH/2,FRAME_HEIGHT/2,150,30);
		this.add(passwordTextField);
		
		this.setLayout(null);
		this.setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==nextButton) {
			try {
				Connection connection=DriverManager.getConnection(url,username,password);
				String sql="SELECT*FROM admintable";
				Statement statement=connection.createStatement();
				ResultSet rs= statement.executeQuery(sql);
				int k=0;
		        while(rs.next()) {
				if(rs.getString("username").equals(usernameTextField.getText())  &&  rs.getString("password").equals(passwordTextField.getText())){
					k=1;
					new LobyPage(info1);
					this.dispose();
				 }
		        }
				if(k==0) {
					JOptionPane.showMessageDialog(null, "Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
				}
				rs.close();
				statement.close();
				connection.close();
			 } catch (SQLException e1) {
				e1.printStackTrace();
			 }
		}else if(e.getSource()==signUpButton) {
			new SignUpPage(info1);
		}
	}	
}
