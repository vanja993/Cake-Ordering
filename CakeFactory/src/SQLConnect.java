import java.awt.Dimension;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class SQLConnect extends JFrame implements ActionListener{
	JTextField serverTextField;
	JTextField usernameTextField;
    JPasswordField passwordTextField;
    SQLinfo info;
    JButton nextButton ;
	
    SQLConnect(){
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600,300));
		this.setTitle("MySQL connection");
		this.setLayout(null);
		
		info=new SQLinfo();
		
		JLabel serverLabel = new JLabel("Server:");
		serverLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		serverLabel.setBounds(10, 31, 79, 20);
		this.add(serverLabel);
		
	    JLabel usernameLabel= new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(10, 69, 101, 20);
		this.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(10, 112, 101, 20);
		this.add(passwordLabel);
		
		serverTextField = new JTextField();
		serverTextField.setBounds(121, 30, 453, 20);
		serverTextField.setColumns(10);
		this.add(serverTextField);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(121, 68, 453, 20);
		this.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(121, 106, 453, 20);
		this.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nextButton.addActionListener(this);
		nextButton.setBounds(485, 165, 89, 23);
		this.add(nextButton);
		
		this.setVisible(true);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextButton) {
			int in=0;
			try {
				Connection connection=DriverManager.getConnection(serverTextField.getText(),usernameTextField.getText(),passwordTextField.getText());
				connection.close();
			}catch(SQLException er) {
				JOptionPane.showMessageDialog(null, "Invalid input","error",JOptionPane.ERROR_MESSAGE);
				in=1;
			}
			info.setServer(serverTextField.getText());
			info.setUsername(usernameTextField.getText());
			info.setPassword(passwordTextField.getText());
			if(in==0) {
			new LogInPage(info);
		}
	}
}
}
