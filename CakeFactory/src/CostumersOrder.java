import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class CostumersOrder extends JFrame implements ActionListener{

	static final int PANEL_WIDTH=1280;
	static final int PANEL_HEIGHT=600;	
	JButton saveButton;
	JButton cancelButton;
	Cake myCake;
	SizePanel sizePanel;
	FlavorPanel flavorPanel;
	InfoPanel infoPanel;
	DecorationPanel decorationPanel;
	DatePanel datePanel;
	Date date;
	SimpleDateFormat sdf;
	String stringDate;
	String url;
	String username;
	String password;
	JButton backButton;
	SQLinfo info1;
	
	CostumersOrder(Costumer costumer,SQLinfo info) throws ClassNotFoundException{
    	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Add a costumer");
        this.setBounds(0,0,PANEL_WIDTH, PANEL_HEIGHT);
        
        myCake=new Cake();
        info1=new SQLinfo();
        info1.copy(info);
        url=info1.getServer();
		username=info1.getUsername();
		password=info1.getPassword();
	
		Image background=new ImageIcon("cake4.png").getImage();		
		this.setContentPane(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background,0,0,null);
			    g.setFont(new Font("Gabriola",Font.PLAIN,70));
				g.setColor(new Color(50,0,100));
				g.drawString("Shape and Size:", 10, 300);
				g.drawString("Flavor and Toping:", 460, 50);
				g.drawString("Decoration:", 915, 50);
				g.drawString("Costumer info:",15 , 50);
				g.drawString("Delivery:",530, 330);
			}
		});
		
		saveButton=new JButton("Save");
		saveButton.setBounds(970,511,80,25);
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		this.add(saveButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(1080,511,80,25);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(this);
		this.add(cancelButton);
		
		backButton=new JButton("Back");
		backButton.setBounds(860,511,80,25);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		this.add(backButton);
		
		sizePanel= new SizePanel();
		sizePanel.setLocation(10, 330);
	    this.add(sizePanel);
	    
		infoPanel= new InfoPanel(costumer);
		infoPanel.setLocation(10, 76);
		this.add(infoPanel);
		
	    flavorPanel= new FlavorPanel();
		flavorPanel.setLocation(460, 76);
		this.add(flavorPanel);
		
		datePanel= new DatePanel();
		datePanel.setLocation(494, 345);
		this.add(datePanel);
		
		decorationPanel= new DecorationPanel();
		decorationPanel.setLocation(908, 76);
		this.add(decorationPanel);
        
		this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		check : if(e.getSource()==saveButton) {
		// SHAPE-------------
			if(sizePanel.squareRadioButton.isSelected()) {
				myCake.setShape("Square");
			}else if(sizePanel.circleRadioButton.isSelected()) {
				myCake.setShape("Circle");
			}else {
				JOptionPane.showMessageDialog(null, "Select shape");
				break check;
			}		
		//SIZE--------------	
		   if(sizePanel.smallRadioButton.isSelected()) {
				myCake.setSize("Small");
			}else if(sizePanel.mediumRadioButton.isSelected()) {
				myCake.setSize("Medium");
			}else if(sizePanel.largeRadioButton.isSelected()) {
				myCake.setSize("Large");
			}else {
				JOptionPane.showMessageDialog(null, "Select size");
				break check;
			}	
	    //TEIR NUMBER----------------------		
			if(sizePanel.oneRadioButton.isSelected()) {
				myCake.setTierNumber("One");
			}else if(sizePanel.twoRadioButton.isSelected()) {
				myCake.setTierNumber("Two");
			}else if(sizePanel.threeRadioButton.isSelected()) {
				myCake.setTierNumber("Three");
			}else {
				JOptionPane.showMessageDialog(null, "Select number of tiers");
				break check;
			}	
		//SPONGE AND CREAM FLAVOR-----------------------------------------
			myCake.setSponge((String)flavorPanel.flavorComboBox.getSelectedItem());
			myCake.setCream((String)flavorPanel.fillingComboBox.getSelectedItem());
			if(flavorPanel.jamCheckBox.isSelected()) {
				myCake.setJam((String)flavorPanel.jamComboBox.getSelectedItem());
			}else {
			    myCake.setJam("no");
			}
			if(flavorPanel.fruitCheckBox.isSelected()) {
				myCake.setFruit((String)flavorPanel.fruitComboBox.getSelectedItem());
			}else {
				myCake.setFruit("no");
			}
		//TOPINGS---------------------------------------	
			if(flavorPanel.frostingRadioButton.isSelected()) {
				myCake.setTopings("Frosting");
			}else if(flavorPanel.fondantRadioButton.isSelected()){
				myCake.setTopings("Fondant");
			}else {
				JOptionPane.showMessageDialog(null, "Select toppings");
				break check;
			}	
		//DATE PANEL--------------------------		
			if(datePanel.yesRadioButton.isSelected()) {
				myCake.setAddress(datePanel.addressTextField.getText());
			}else if(datePanel.noRadioButton.isSelected()) {
				myCake.setAddress("-");
			}else {
				JOptionPane.showMessageDialog(null, "Select home delivery");
				break check;
			}	
			date = datePanel.dateChooser.getDate();                   
			sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			stringDate = sdf.format(date);    
			myCake.setDate(stringDate);
			
			try {
				Connection connection=DriverManager.getConnection(url,username,password);	
				String sql2="SELECT*FROM caketable;";
				Statement statement1=connection.createStatement();
				ResultSet rs= statement1.executeQuery(sql2);
				int i=0;
				while(rs.next()) {
					i++;
				}
				statement1.close();
				rs.close();
				String sql="INSERT INTO caketable (idcake,shape,size,tier,sponge,cream,jam,fruit,topping,day,address,decor) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setInt(1,i+1);
				statement.setString(2, myCake.getShape());
				statement.setString(3, myCake.getSize());
				statement.setString(4, myCake.getTierNumber());
				statement.setString(5, myCake.getSponge());
				statement.setString(6, myCake.getCream());
				statement.setString(7, myCake.getJam());
				statement.setString(8, myCake.getFruit());
				statement.setString(9, myCake.getTopings());
				statement.setString(10, myCake.getDate());
				statement.setString(11, myCake.getAddress());
				statement.setString(12, decorationPanel.decorationTextArea.getText());
				statement.executeUpdate();
				statement.close();
				connection.close();
				JOptionPane.showMessageDialog(null, "Order Saved","info",JOptionPane.INFORMATION_MESSAGE);		
				saveButton.setEnabled(false);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}else if(e.getSource()==cancelButton) {
			this.dispose();
		}else if(e.getSource()==backButton) {
			new LobyPage(info1);
			this.dispose();
		}	
	}		
}