package TechPrali;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class MainProj implements ActionListener{
	JFrame fr;
	JPanel panel,panel1,panel2,panel_buy,panel_sell,panel_profile,panel_details;
	Font fon1,fon2,fon3;
	ImageIcon image_bg,image_btn,gen_img;
	JLabel lbl_img,lbl_gender_img,lbl_topic,lbl_buy_topic,lbl_sell_topic,lbl_profile_topic,lbl_welcome;
	JButton btn_buy,btn_sell,btn_profile,btn_details;
	JScrollBar scroll_bar;
	String user;
	String gender,gender_result;
	public MainProj(String user,String gender){
		this.user=user;
		this.gender=gender;
		fr=new JFrame("Main page");
		fon1=new Font("algerian",Font.BOLD,90);
		fon2=new Font("algerian",Font.BOLD,25);
		fon3=new Font("algerian",Font.BOLD,40);
	
		panel= new JPanel();
		panel.setBounds(0,0,1370,700);
		panel.setLayout(null);
		fr.add(panel);
		System.out.println(gender);
		String male="Male";
		if (gender.equals(male)) {
			gender_result="Mr";
			gen_img=new ImageIcon(getClass().getResource("male.png"));
			lbl_gender_img=new JLabel(gen_img);
			lbl_gender_img.setBounds(930,20,100,100);
			panel.add(lbl_gender_img);
			
		}
		else {
			gender_result="Mrs";
			gen_img=new ImageIcon(getClass().getResource("female.png"));
			lbl_gender_img=new JLabel(gen_img);
			lbl_gender_img.setBounds(930,20,100,100);
			panel.add(lbl_gender_img);
		}
		
		
		lbl_welcome= new JLabel("Welcome:"+"  "+gender_result+". "+ user);
		lbl_welcome.setBounds(1010,60,500,50);
		lbl_welcome.setForeground(new Color(255,223,0));
		lbl_welcome.setFont(fon2);
		panel.add(lbl_welcome);
		
		
		lbl_topic=new JLabel("TECH PRALI");
		lbl_topic.setForeground(new Color(255,215,0));
		lbl_topic.setBounds(350,32,650,100);
		lbl_topic.setFont(fon1);
		panel.add(lbl_topic);
		
		
		image_btn=new ImageIcon(getClass().getResource("button.png"));
		btn_buy=new JButton("Buy",image_btn);
		btn_buy.setFont(fon3);
		btn_buy.setForeground(Color.green);
		btn_buy.setBounds(225,130,250,80);
		btn_buy.addActionListener(this);
		btn_buy.setHorizontalTextPosition(JButton.CENTER);
		btn_buy.setVerticalTextPosition(JButton.CENTER);
		btn_buy.setBorderPainted(false); 
		btn_buy.setContentAreaFilled(false); 
		btn_buy.setFocusPainted(false); 
		btn_buy.setOpaque(false);
		panel.add(btn_buy);
		
		
		btn_sell=new JButton("Sell",image_btn);
		btn_sell.setFont(fon3);
		btn_sell.setForeground(Color.white);
		btn_sell.setBounds(475,130,250,80);
		btn_sell.addActionListener(this);
		btn_sell.setHorizontalTextPosition(JButton.CENTER);
		btn_sell.setVerticalTextPosition(JButton.CENTER);
		btn_sell.setBorderPainted(false); 
		btn_sell.setContentAreaFilled(false); 
		btn_sell.setFocusPainted(false); 
		btn_sell.setOpaque(false);
		panel.add(btn_sell);
		
		btn_details=new JButton("Details",image_btn);
		btn_details.setFont(fon3);
		btn_details.setForeground(Color.white);
		btn_details.setBounds(725,130,250,80);
		btn_details.addActionListener(this);
		btn_details.setHorizontalTextPosition(JButton.CENTER);
		btn_details.setVerticalTextPosition(JButton.CENTER);
		btn_details.setBorderPainted(false); 
		btn_details.setContentAreaFilled(false); 
		btn_details.setFocusPainted(false); 
		btn_details.setOpaque(false);
		panel.add(btn_details);
		
		btn_profile=new JButton("Profile",image_btn);
		btn_profile.setFont(fon3);
		btn_profile.setForeground(Color.white);
		btn_profile.setBounds(975,130,250,80);
		btn_profile.addActionListener(this);
		btn_profile.setHorizontalTextPosition(JButton.CENTER);
		btn_profile.setVerticalTextPosition(JButton.CENTER);
		btn_profile.setBorderPainted(false); 
		btn_profile.setContentAreaFilled(false); 
		btn_profile.setFocusPainted(false); 
		btn_profile.setOpaque(false);
		panel.add(btn_profile);
		
		panel_buy= new JPanel();
		panel_buy.setLayout(null);
		//panel_buy.setLocation(0, 0);
		panel_buy.setBounds(90,210,1180,400);
		panel.add(panel_buy);
		new Buy(panel_buy);
		
		panel_sell= new JPanel();
		panel_sell.setBackground(new Color(210,241,245));
		panel_sell.setLayout(null);
		panel.add(panel_sell);
		
		
		
		panel_profile= new JPanel();
		panel_profile.setBackground(new Color(210,241,245));
		panel_profile.setLayout(null);
		panel.add(panel_profile);
		
		panel_details= new JPanel();
		panel_details.setBackground(new Color(210,241,245));
		panel_details.setLayout(null);
		panel.add(panel_details);
		
		image_bg=new ImageIcon(getClass().getResource("bg.jpg"));
		lbl_img=new JLabel(image_bg);
		lbl_img.setBounds(0,0,1370,700);
		panel.add(lbl_img);
		
		fr.setBounds(100, 100, 100, 1000);
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.setLayout(null);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_buy) {
			fr.repaint();
			btn_buy.setForeground(Color.green);
			btn_profile.setForeground(Color.white);
			btn_sell.setForeground(Color.white);
			btn_details.setForeground(Color.white);
			panel_sell.setBounds(0,0,0,0);
			panel_profile.setBounds(0,0,0,0);
			panel_details.setBounds(0,0,0,0);
			panel_buy.setBounds(90,210,1180,400);
			panel_buy.removeAll();
			panel_buy.repaint();
			panel_buy.revalidate();
			new Buy(panel_buy);    
			}	
		else if (e.getSource()==btn_sell) {
			fr.repaint();
			btn_buy.setForeground(Color.white);
			btn_profile.setForeground(Color.white);
			btn_sell.setForeground(Color.green);
			btn_details.setForeground(Color.white);
			panel_profile.removeAll();
			panel_buy.setBounds(0,0,0,0);
			panel_details.setBounds(0,0,0,0);
			
			panel_sell.setBounds(350,210,700,400);
			new Sell(panel_sell,user);
			}
		else if(e.getSource()==btn_profile){
			btn_buy.setForeground(Color.white);
			btn_profile.setForeground(Color.green);
			btn_sell.setForeground(Color.white);
			btn_details.setForeground(Color.white);
			panel_sell.setBounds(0,0,0,0);
			panel_buy.setBounds(0,0,0,0);
			panel_details.setBounds(0,0,0,0);
			panel_profile.setBounds(350,210,700,400);
			new Profile(panel_profile,user);
		}
		else if(e.getSource()==btn_details) {
			btn_buy.setForeground(Color.white);
			btn_profile.setForeground(Color.white);
			btn_sell.setForeground(Color.white);
			btn_details.setForeground(Color.green);
			panel_sell.setBounds(0,0,0,0);
			panel_buy.setBounds(0,0,0,0);
			panel_profile.setBounds(0,0,0,0);
			panel_details.setBounds(90,210,1180,400);
			panel_details.removeAll();
			panel_details.repaint();
			panel_details.revalidate();
			new Details(panel_details,user);
		}
	
}   	
}
