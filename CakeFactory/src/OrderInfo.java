import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OrderInfo extends JFrame {

	String url;
	String username;
	String password;
	JTextArea textArea;
	SQLinfo info1;
	
	OrderInfo(int i,SQLinfo info){
		
		info1=new SQLinfo();
		info1.copy(info);
		url=info1.getServer();
		username=info1.getUsername();
		password=info1.getPassword();
		
		this.setSize(new Dimension(800,550));
		
		Image background=new ImageIcon("wall.jpg").getImage();
         this.setContentPane(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background,0,0,null);
				g.drawLine(0,240 ,600,240);
				g.setColor(new Color(0,150,200));
				g.setFont(new Font("Gabriola",Font.BOLD,40));
				g.drawString("Costumer's info:", 30, 30);
				g.drawString("Costumer's order:", 30, 280);
				g.drawString("Decoration:", 567, 30);
			}
		});	
        textArea=new JTextArea();
 		textArea.setBounds(567, 60, 208, 304);
 			
 		JLabel costumerNumber = new JLabel();
		costumerNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		costumerNumber.setBounds(25, 60, 300, 20);
		
		JLabel firstNameLabel = new JLabel();
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		firstNameLabel.setBounds(25, 85, 300, 20);
		
		JLabel lastNameLabel = new JLabel();
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLabel.setBounds(25, 110, 300, 20);
		
		JLabel idNumberLabel = new JLabel();
		idNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		idNumberLabel.setBounds(25, 135, 500, 20);
		
		JLabel contactNumberLabel = new JLabel();
		contactNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactNumberLabel.setBounds(25, 160, 500, 20);
				
		JLabel shapeLabel = new JLabel();
		shapeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		shapeLabel.setBounds(25, 314, 150, 20);
	
		JLabel sizeLabel = new JLabel();
		sizeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sizeLabel.setBounds(184, 314, 130, 20);
		
		JLabel tierLabel = new JLabel();
		tierLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tierLabel.setBounds(318, 314, 200, 20);
		
		JLabel spongeLabel = new JLabel();
		spongeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		spongeLabel.setBounds(25, 344, 400, 20);
		
		JLabel creamLabel = new JLabel();
		creamLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		creamLabel.setBounds(25, 374, 500, 20);
		
		JLabel jamLabel = new JLabel("Jam:");
		jamLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		jamLabel.setBounds(25, 394, 500, 20);
	
		JLabel fruitFlavor = new JLabel("Fruit");
		fruitFlavor.setFont(new Font("Tahoma", Font.BOLD, 15));
		fruitFlavor.setBounds(25, 414, 500, 20);
		
		JLabel toppingLabel = new JLabel("Topping:");
		toppingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		toppingLabel.setBounds(25, 444, 300, 20);
		
		JLabel dateLabel = new JLabel("Date of delivery:");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		dateLabel.setBounds(25, 185, 250, 20);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		addressLabel.setBounds(26, 210, 500, 20);
		
		try {
		Connection connection=DriverManager.getConnection(url,username,password);
		String sql="SELECT*FROM costumerstable WHERE costumer_Number="+i;
		Statement statement=connection.createStatement();
		ResultSet rs= statement.executeQuery(sql);
		while(rs.next()) {
		   costumerNumber.setText("Costumer Number: "+rs.getInt("costumer_Number"));
		   firstNameLabel.setText("First Name: "+rs.getString("firstName"));
		   lastNameLabel.setText("Last Name: "+rs.getString("lastName"));
		   idNumberLabel.setText("ID Number: "+rs.getString("idNumber"));
		   contactNumberLabel.setText("Contact Number: "+rs.getString("contactNumber"));
		}
		statement.close();
		rs.close();
		
		String sql1="SELECT*FROM caketable WHERE idcake="+i;
		Statement statement1=connection.createStatement();
		ResultSet rs1= statement1.executeQuery(sql1);
		while(rs1.next()) {
			shapeLabel.setText("Shape: "+rs1.getString("shape"));
			sizeLabel.setText("Size: "+rs1.getString("size"));
			tierLabel.setText("Number of tiers: "+rs1.getString("tier"));
			spongeLabel.setText("Sponge Flavor: "+rs1.getString("sponge"));
			creamLabel.setText("Cream Flavor: "+rs1.getString("cream"));
			jamLabel.setText("Jam: "+rs1.getString("jam"));
			fruitFlavor.setText("Fruit "+rs1.getString("fruit"));
			toppingLabel.setText("Topping: "+rs1.getString("topping"));
			dateLabel.setText("Date of delivery: "+rs1.getString("day"));
			addressLabel.setText("Address: "+rs1.getString("address"));
			textArea.setText(rs1.getString("decor"));
			textArea.setEditable(false);
		}
		rs1.close();
		statement1.close();
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		this.add(textArea);
		this.add(costumerNumber);
		this.add(firstNameLabel);
		this.add(lastNameLabel);
		this.add(idNumberLabel);
		this.add(contactNumberLabel);
		this.add(shapeLabel);
		this.add(sizeLabel);
		this.add(spongeLabel);
		this.add(tierLabel);
		this.add(creamLabel);
		this.add(jamLabel);
		this.add(fruitFlavor);
		this.add(toppingLabel);
		this.add(dateLabel);
		this.add(addressLabel);
		this.setLayout(null);
		this.setVisible(true);
	}
}
