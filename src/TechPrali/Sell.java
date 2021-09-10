package TechPrali;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Sell implements ActionListener {
	Font fon1,fon2,fon3;
	JLabel lbl_head,lbl_mobilename,lbl_company,lbl_ram,lbl_storage,lbl_price,lbl_processor,lbl_camera,lbl_contact;
	JTextField txt_mobilename,txt_company,txt_ram,txt_storage,txt_price,txt_processor,txt_camera,txt_contact;
	JButton btn_sell;
	String user;
	public Sell(JPanel panel,String user) {
		this.user=user;
		System.out.println(user);
		fon1=new Font("algerian",Font.BOLD,40);
		fon2=new Font("areal",Font.BOLD,20);
		fon3=new Font("areal",Font.BOLD,25);
		
		lbl_head=new JLabel("Sell mobile here");
		lbl_head.setFont(fon1);
		lbl_head.setBounds(180,20,400,50);
		panel.add(lbl_head);

		lbl_mobilename=new JLabel("Mobile name:");
		lbl_mobilename.setFont(fon2);
		lbl_mobilename.setBounds(20,80,300,50);
		panel.add(lbl_mobilename);
		
		txt_mobilename=new JTextField();
		txt_mobilename.setFont(fon2);
		txt_mobilename.setBackground(new Color(245,254,255));
		txt_mobilename.setBounds(150,85,170,35);
		panel.add(txt_mobilename);
		
		lbl_company=new JLabel("Company Name");
		lbl_company.setFont(fon2);
		lbl_company.setBounds(340,80,300,50);
		panel.add(lbl_company);
		
		txt_company=new JTextField();
		txt_company.setFont(fon2);
		txt_company.setBounds(500,85,170,35);
		txt_company.setBackground(new Color(245,254,255));
		panel.add(txt_company);
		
		lbl_ram=new JLabel("Ram:");
		lbl_ram.setFont(fon2);
		lbl_ram.setBounds(20,140,300,50);
		panel.add(lbl_ram);
		
		txt_ram=new JTextField();
		txt_ram.setFont(fon2);
		txt_ram.setBounds(150,145,170,35);
		txt_ram.setBackground(new Color(245,254,255));
		panel.add(txt_ram);
		
		lbl_storage=new JLabel("Storage:");
		lbl_storage.setFont(fon2);
		lbl_storage.setBounds(340,140,300,50);
		panel.add(lbl_storage);
		
		txt_storage=new JTextField();
		txt_storage.setFont(fon2);
		txt_storage.setBackground(new Color(245,254,255));
		txt_storage.setBounds(500,145,170,35);
		panel.add(txt_storage);
		
		lbl_price=new JLabel("Price:");
		lbl_price.setFont(fon2);
		lbl_price.setBounds(20,200,300,50);
		panel.add(lbl_price);
		
		txt_price=new JTextField();
		txt_price.setFont(fon2);
		txt_price.setBounds(150,205,170,35);
		txt_price.setBackground(new Color(245,254,255));
		panel.add(txt_price);
		
		lbl_processor=new JLabel("Processor:");
		lbl_processor.setFont(fon2);
		lbl_processor.setBounds(340,260,300,50);
		panel.add(lbl_processor);
		
		txt_processor=new JTextField();
		txt_processor.setFont(fon2);
		txt_processor.setBounds(500,265,170,35);
		txt_processor.setBackground(new Color(245,254,255));
		panel.add(txt_processor);
		
		
		
		
		lbl_camera=new JLabel("Camera:");
		lbl_camera.setFont(fon2);
		lbl_camera.setBounds(340,200,300,50);
		panel.add(lbl_camera);
		
		txt_camera=new JTextField();
		txt_camera.setFont(fon2);
		txt_camera.setBounds(500,205,170,35);
		txt_camera.setBackground(new Color(245,254,255));
		panel.add(txt_camera);
		
		lbl_contact=new JLabel("Contact no:");
		lbl_contact.setFont(fon2);
		lbl_contact.setBounds(20,260,300,50);
		panel.add(lbl_contact);
		
		txt_contact=new JTextField();
		txt_contact.setFont(fon2);
		txt_contact.setBounds(150,265,170,35);
		txt_contact.setBackground(new Color(245,254,255));
		panel.add(txt_contact);
		
		btn_sell =new JButton("SELL HERE");
		btn_sell.setFont(fon3);
		btn_sell.setBounds(220,330,220,45);
		btn_sell.setBackground(Color.green);
		btn_sell.setForeground(Color.white);
		btn_sell.addActionListener(this);
		panel.add(btn_sell);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_sell) {
			 String username=user;
		     String mobilename=txt_mobilename.getText();
		     String company=txt_company.getText();
		     String ram=txt_ram.getText();
		     String storage=txt_storage.getText();
		     String price=txt_price.getText();
		     String processor=txt_processor.getText();
		     String camera=txt_camera.getText();
		     String contact=txt_contact.getText();
		     JDBCoperation db=new JDBCoperation();
		     Mobiledata data = new Mobiledata(username,mobilename,company,ram,storage,price,processor,camera,contact);
		     String query="insert into buysell(username,mobilename,company,ram,storage,price,processor,camera,contact)"
	        			+ " values('"+data.getUsername()+"','"+data.getMobilename()+"',"
	        					+ "'"+data.getCompany()+"','"+data.getRam()+"',"
	        		+ "'"+data.getStorage()+"','"+data.getPrice()+"',"
	        				+ "'"+data.getProcessor()+"','"+data.getCamera()+"','"+data.getContact()+"')";
	        	int ans= db.insert(query);
	        	if (ans>0) {
	        		JOptionPane.showMessageDialog(btn_sell, "Moblie successfully added");
	        		txt_mobilename.setText("");
	   		     txt_company.setText("");
	   		     txt_ram.setText("");
	   		     txt_storage.setText("");
	   		     txt_price.setText("");
	   		     txt_processor.setText("");
	   		    txt_camera.setText("");
	   		     txt_contact.setText("");
	        	} 
	        	else  {
	        		if (data.getMobilename().length()==0 || data.getCompany().length()==0 || data.getMobilename().length()==0 || data.getRam().length()==0
	   		    		 || data.getStorage().length()==0 || data.getPrice().length()==0 || data.getProcessor().length()==0 || data.getCamera().length()==0
	   		    		 || data.getContact().length()==0 )
	   		     {
	   		    	 JOptionPane.showMessageDialog(btn_sell, "Please fill entire fields");
	   		    	 return;
	   		     }
	        		try {
	    				int val_ram=Integer.parseInt(ram);
	    			} catch (NumberFormatException e1) {
	    				JOptionPane.showMessageDialog(null,"please use integer value in ram");
	    				return;
	    			}
	    		     try {
	    					int val_storage=Integer.parseInt(storage);
	    				} catch (NumberFormatException e1) {
	    					JOptionPane.showMessageDialog(null,"please use integer value in storage");
	    					return;
	    				}
	    		     try {
	    					int val_price=Integer.parseInt(price);
	    				} catch (NumberFormatException e1) {
	    					JOptionPane.showMessageDialog(null,"please use integer value in price");
	    					return;
	    				}
	    		     try {
	    					int val_contact=Integer.parseInt(contact);
	    				} catch (NumberFormatException e1) {
	    					JOptionPane.showMessageDialog(null,"please use integer value in contact");
	    				}
	        	}
		     }
		}
	}


