import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LobyPage extends JFrame implements ActionListener{

    JButton addCostumerButton;
	JButton findCostumerButton;
	static final int PANEL_WIDTH=500;
	static final int PANEL_HEIGHT=500;
	SQLinfo info1;
	
	LobyPage(SQLinfo info){
		
		info1=new SQLinfo();
		info1.copy(info);

		this.setResizable(false);
		this.setTitle("Loby Page");
		this.setBounds(0,0,PANEL_WIDTH,PANEL_HEIGHT);
		this.setResizable(false);
		
		Image background=new ImageIcon("myCake.png").getImage();
		this.setContentPane(new JPanel() {
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background,0,0,null);
				g.setFont(new Font("Gabriola",Font.PLAIN,90));
				g.setColor(new Color(212,106,0));
				g.drawString("Cake Factory", 60, 70);
			}
		});
	    addCostumerButton=new JButton("Add costumer");
		addCostumerButton.setBounds(39, 224, 160, 30);
		addCostumerButton.setFocusable(false);
		addCostumerButton.setBackground(new Color(212,106,0));
		addCostumerButton.addActionListener(this);
		this.add(addCostumerButton);
		
		findCostumerButton=new JButton("Find a costumer");
		findCostumerButton.setBounds(39, 172, 160, 30);	
		findCostumerButton.setFocusable(false);
		findCostumerButton.setBackground(new Color(212,106,0));
		findCostumerButton.addActionListener(this);
		this.add(findCostumerButton);
		
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addCostumerButton) {
			new AddCostumer(info1);
			this.dispose();
		}
		if (e.getSource()==findCostumerButton){
			new FindCostumer(info1);
			this.dispose();
		}
	}
}