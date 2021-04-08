
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddCostumer extends JFrame implements ActionListener{
	
	JTextField firstName;
	JTextField lastName;
	JTextField idNumber;
	JTextField contactNumber;
	JButton createButton;
	JButton cancelButton;
	static final int PANEL_WIDTH=450;
	static final int PANEL_HEIGHT=260;
	String url;
	String username;
	String password;
	SQLinfo info1;
	Costumer costumer;
	
	AddCostumer(SQLinfo info){
	
		info1=new SQLinfo();
		info1.copy(info);
	    url=info1.getServer();
		username=info1.getUsername();
		password=info1.getPassword();
	    
    	this.setResizable(false);
	    this.setTitle("Add a costumer");
		this.setBounds(0,0,PANEL_WIDTH,PANEL_HEIGHT);
	    
	    Image background=new ImageIcon("wall.jpg").getImage();
		this.setContentPane(new JPanel() {		
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background,0,0,null);
			}
		});
		
		Font font=new Font("Dialog",Font.BOLD,20);
		
		firstName=new JTextField();
   	    lastName=new JTextField();
		idNumber=new JTextField();
		contactNumber=new JTextField();
		
		firstName.setBounds(PANEL_WIDTH/2,10,200,25);
		lastName.setBounds(PANEL_WIDTH/2,45,200,25);
		idNumber.setBounds(PANEL_WIDTH/2,80,200,25);
		contactNumber.setBounds(PANEL_WIDTH/2,115,200,25);
		
		this.add(firstName);
		this.add(lastName);
	    this.add(idNumber);
		this.add(contactNumber);
		
		JLabel firstNameLabel=new JLabel("First name:");
		JLabel lastNameLabel=new JLabel("Last name:");
		JLabel idNumberLabel=new JLabel("ID number:");
		JLabel contactNumberLabel=new JLabel("Contact number:"); 
		
		firstNameLabel.setBounds(30,3,400,50);
		lastNameLabel.setBounds(30,35,400,50);
		idNumberLabel.setBounds(30,70,400,50);
		contactNumberLabel.setBounds(30,105,400,50);
		
		firstNameLabel.setFont(font);
		lastNameLabel.setFont(font);
		idNumberLabel.setFont(font);
		contactNumberLabel.setFont(font);
		
		this.add(firstNameLabel);
		this.add(lastNameLabel);
		this.add(idNumberLabel);
		this.add(contactNumberLabel);
			
		createButton=new JButton("Create");
		cancelButton=new JButton("Cancel");
		
		createButton.setBounds(PANEL_WIDTH/2, 160, 100, 30);
		cancelButton.setBounds(335, 160, 100, 30);
		
		createButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		this.add(createButton);
		this.add(cancelButton);
		this.setLayout(null);
	    this.setLocationRelativeTo(null);   
	    this.setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==createButton) {
			if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || idNumber.getText().isEmpty() || contactNumber.getText().isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Fill all fields","error",JOptionPane.ERROR_MESSAGE);
			}else {
		  try {
		    Connection connection=DriverManager.getConnection(url,username,password);
			String sql2="SELECT*FROM costumerstable;";
			Statement statement1=connection.createStatement();
			ResultSet rs= statement1.executeQuery(sql2);
			int i=0;
			while(rs.next()) {
				i++;
			}	
			statement1.close();
			rs.close();
			String sql="INSERT INTO costumerstable (costumer_Number,firstName,lastName,idNumber,contactNumber) VALUES (?,?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, i+1);
			statement.setString(2, firstName.getText());
			statement.setString(3, lastName.getText());
			statement.setString(4, idNumber.getText());
			statement.setString(5,contactNumber.getText());
			statement.executeUpdate();
			statement.close();
			connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				costumer=new Costumer("",firstName.getText(),lastName.getText(),idNumber.getText(),contactNumber.getText());
			    new CostumersOrder(costumer,info1);
				this.dispose();
			} catch (ClassNotFoundException e1){
				e1.printStackTrace();
			}
		}
		} else if(e.getSource()==cancelButton) {
			new LobyPage(info1);
			this.dispose();
		}	
	}
}