import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class SignUpPage extends JFrame implements ActionListener{
	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	JButton saveButton;
	SQLinfo info1;
	String url;
	String username;
	String password;

	SignUpPage(SQLinfo info){
		
		info1=new SQLinfo();
		info1.copy(info);
	    url=info1.getServer();
		username=info1.getUsername();
		password=info1.getPassword();
		
		this.setSize(new Dimension(300,200));
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	    usernameLabel.setBounds(25, 35, 80, 14);
		this.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(115, 34, 141, 20);
		this.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(25, 73, 88, 14);
		this.add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(115, 72, 141, 20);
		this.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saveButton.setBounds(185, 119, 89, 23);
		saveButton.addActionListener(this);
		this.add(saveButton);
		
		this.setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveButton) {
		  try {
			Connection connection=DriverManager.getConnection(url,username,password);
			String sql2="SELECT*FROM admintable;";
			Statement statement1=connection.createStatement();
			ResultSet rs= statement1.executeQuery(sql2);
			int i=0;
			while(rs.next()) {
				i++;
			}
			statement1.close();
			rs.close();
			String sql="INSERT INTO admintable (idNumber,username,password) VALUES (?,?,?)";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, i+1);
			statement.setString(2, usernameTextField.getText());
			statement.setString(3, passwordTextField.getText());
			statement.executeUpdate();
			statement.close();
			connection.close();
			this.dispose();
		  }catch(SQLException er) {}
		}	
	}
}
