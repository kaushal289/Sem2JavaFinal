package TechPrali;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Profile implements ActionListener {
	Font fon1,fon2,fon3;
	JLabel lbl_profile_topic,lbl_fullname,lbl_email,lbl_gender,lbl_pass,lbl_cpss;
	JTextField txt_fullname,txt_email,txt_gender,txt_pass,txt_cpss;
	JRadioButton rmale,rfemale;
	JButton btn_update;
	String user;
	public Profile(JPanel panel,String user) {
		this.user=user;
		fon1=new Font("algerian",Font.BOLD,50);
		fon2=new Font("areal",Font.BOLD,18);
		fon3=new Font("algerian",Font.BOLD,40);
		
		lbl_profile_topic=new JLabel("YOUR PROFILE");
		lbl_profile_topic.setBounds(255,5,450,100);
		lbl_profile_topic.setFont(fon3);
		panel.add(lbl_profile_topic);
		
		
		
		lbl_fullname=new JLabel("Full name:");
		lbl_fullname.setFont(fon2);
		lbl_fullname.setBounds(250,80,300,50);
		panel.add(lbl_fullname);
		
		
		
		lbl_email=new JLabel("Email         :");
		lbl_email.setFont(fon2);
		lbl_email.setBounds(20,140,300,50);
		panel.add(lbl_email);
		
		
		
		lbl_gender =new JLabel("Gender        :");
		lbl_gender.setFont(fon2);
		lbl_gender.setBounds(310,140,300,50);
		panel.add(lbl_gender);
		
		rmale=new JRadioButton("Male");    
		rmale.setBounds(460,150,80,30);  
		rmale.setFont(fon2);
		rmale.setBackground(new Color(210,241,245));
		rfemale=new JRadioButton("Female");    
		rfemale.setBounds(550,150,100,30);  
		rfemale.setFont(fon2);
		rfemale.setBackground(new Color(210,241,245));
		ButtonGroup bg=new ButtonGroup(); 
		bg.add(rmale);
		bg.add(rfemale);
		panel.add(rmale);
		panel.add(rfemale);
		
		
		
		lbl_pass=new JLabel("Password  :");
		lbl_pass.setFont(fon2);
		lbl_pass.setBounds(20,200,300,50);
		panel.add(lbl_pass);
		
		
		
		lbl_cpss=new JLabel("Confirm Password:");
		lbl_cpss.setFont(fon2);
		lbl_cpss.setBounds(310,200,300,50);
		panel.add(lbl_cpss);
		
		
		String username=user;
		JDBCoperation db=new JDBCoperation();
		String query="select * from register where username='"+username+"'";
		ResultSet rs=db.select(query);
		try {
			while (rs.next())
			  {
				
				txt_fullname=new JTextField(rs.getString("fullname"));
				txt_fullname.setFont(fon2);
				txt_fullname.setBounds(350,85,170,35);
				txt_fullname.setBackground(new Color(245,254,255));
				panel.add(txt_fullname);
				
				txt_email=new JTextField(rs.getString("email"));
				txt_email.setFont(fon2);
				txt_email.setBounds(130,145,170,35);
				txt_email.setBackground(new Color(245,254,255));
				panel.add(txt_email);
				
				String gender=rs.getString("gender");
				
		        if (gender.length()==4 ) {
		        	System.out.println("male");
		        	rmale.setSelected(true);
		        }
		        else{
		        	rfemale.setSelected(true);
		        	System.out.println("female");
		        	
		        }
		        txt_pass=new JTextField(rs.getString("password"));
				txt_pass.setFont(fon2);
				txt_pass.setBounds(130,205,170,35);
				txt_pass.setBackground(new Color(245,254,255));
				panel.add(txt_pass);
				
				txt_cpss=new JTextField(rs.getString("copassword"));
				txt_cpss.setFont(fon2);
				txt_cpss.setBounds(480,205,170,35);
				txt_cpss.setBackground(new Color(245,254,255));
				panel.add(txt_cpss);		
				
				
				
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn_update=new JButton("UPDATE");
		btn_update.setForeground(Color.white);
		btn_update.setBackground(new Color(11,135,15));
		btn_update.setBorder(new LineBorder(Color.green,6));
		btn_update.setFont(fon3);
		btn_update.setBounds(250,280,200,50);
		btn_update.addActionListener(this);
		panel.add(btn_update);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_update) {
			String gender="";
	        if (rmale.isSelected()) {
	        	gender=rmale.getText();
	        }
	        if(rfemale.isSelected()) {
	        	gender=rfemale.getText();
	        }
	        ;
			try {
				String query="update register set fullname='"+txt_fullname.getText()+"',"
						+ "email='"+txt_email.getText()+"',gender='"+gender+"',password='"+txt_pass.getText()+"'"
								+ ",copassword='"+txt_cpss.getText()+"' where username='"+user+"'";
				JDBCoperation db=new JDBCoperation();
				int rs=db.Update(query);
				JOptionPane.showMessageDialog(btn_update, "Update successsful");
			}
			finally{
				
			}
		}
			
		
		
	}
	
}
