import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class FindCostumer extends JFrame implements ActionListener,MouseListener{

	String url;
	String username;
	String password;
	JButton backButton;
	JButton showButton;
    JTable table;
	JScrollPane scrollPane;
	JButton deleteButton;
	int i;
    SQLinfo info1;
	
    FindCostumer(SQLinfo info){
		
		info1=new SQLinfo();
		info1.copy(info);
		url=info1.getServer();
		username=info.getUsername();
		password=info.getPassword();
		
		this.setSize(new Dimension(500,300));
	
		Image background=new ImageIcon("wall.jpg").getImage();
		this.setContentPane(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background,0,0,null);
			}
		});
		
		showButton = new JButton("Show");
		showButton.setBounds(385, 201, 89, 25);
		showButton.addActionListener(this);
		this.add(showButton);
		
		deleteButton= new JButton("Delete");
		deleteButton.setBounds(285, 201, 89, 25);
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		backButton=new JButton("Back");
		backButton.setBounds(185, 201, 89, 25);
		backButton.addActionListener(this);
		this.add(backButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 20, 500, 150);
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
        DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Nº");
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("ID number");
		model.addColumn("Contact Number");
		try {
			Connection connection=DriverManager.getConnection(url,username,password);
			String sql="SELECT*FROM costumerstable";
			Statement statement=connection.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
		    	model.addRow(new Object[] {
						rs.getInt("costumer_Number"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("idNumber"),
						rs.getString("contactNumber")
					});
			}
			rs.close();
			statement.close();
			connection.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(140);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		table.addMouseListener(this);
        this.add(scrollPane);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
	    this.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==showButton) {
			new OrderInfo(i+1,info1);
			}
		else if(e.getSource()==deleteButton) {
			try {
			  Connection connection=DriverManager.getConnection(url,username,password);
			  String sql="DELETE FROM costumerstable WHERE costumer_Number="+(i+1);
			  String sql2="DELETE FROM caketable WHERE idcake="+(i+1);		
			  PreparedStatement statement=connection.prepareStatement(sql);
			  PreparedStatement statement2=connection.prepareStatement(sql2);
		      statement.execute();
		      statement.close();
		      statement2.execute();
		      statement2.close();
              String sql1="UPDATE costumerstable SET costumer_Number=costumer_Number-1 WHERE costumer_Number>"+i+"+1";
		      PreparedStatement statement1=connection.prepareStatement(sql1);
		      String sql4="UPDATE caketable SET idcake=idcake-1 WHERE idcake>"+i+"+1";
		      PreparedStatement statement4=connection.prepareStatement(sql4);
		      statement1.execute();
		      statement1.close();
		   	  statement4.execute();
		      statement4.close();
		      connection.close();
          	  JOptionPane.showMessageDialog(null, "Costumer deleted","info",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException er) {
			er.printStackTrace();
		}
		
		}else if(e.getSource()==backButton) {
			new LobyPage(info1);
			this.dispose();
		}
	}	
	@Override
	public void mouseClicked(MouseEvent e) {
		i=table.getSelectedRow();
		}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}

