package TechPrali;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class RegistrationPage implements ActionListener {
	JFrame fr;
	JLabel lbl_heading, lbl_username, lbl_fullname, lbl_email, lbl_gender, lbl_pass, lbl_cpss, lbl_regimg;
	JTextField txt_username, txt_fullname, txt_email;
	JPasswordField txt_pass, txt_cpss;
	JButton btn_register, btn_back;
	Font fon1, fon2, fon3;
	JPanel panel, panel1;
	ImageIcon reg_bg;
	JCheckBox aggree;
	JRadioButton rmale, rfemale;


	public RegistrationPage() {
		fr = new JFrame("Registeration");
		fon1 = new Font("algerian", Font.BOLD, 50);
		fon2 = new Font("areal", Font.BOLD, 18);
		fon3 = new Font("areal", Font.BOLD, 30);

		panel = new JPanel();
		panel.setBounds(0, 0, 1370, 700);
		panel.setLayout(null);
		fr.add(panel);

		panel1 = new JPanel();
		panel1.setBounds(400, 30, 670, 400);
		panel1.setBackground(new Color(253, 253, 132));
		panel1.setLayout(null);
		panel.add(panel1);


		lbl_heading = new JLabel("USER REGISTRATION");
		lbl_heading.setFont(fon1);
		lbl_heading.setBounds(80, 10, 550, 50);
		lbl_heading.setForeground(new Color(34, 34, 247));
		panel1.add(lbl_heading);


		lbl_username = new JLabel("User name:");
		lbl_username.setFont(fon2);
		lbl_username.setBounds(20, 80, 300, 50);
		panel1.add(lbl_username);

		txt_username = new JTextField();
		txt_username.setFont(fon2);
		txt_username.setBackground(new Color(245, 254, 255));
		txt_username.setBounds(130, 85, 170, 35);
		panel1.add(txt_username);

		lbl_fullname = new JLabel("Full name              :");
		lbl_fullname.setFont(fon2);
		lbl_fullname.setBounds(310, 80, 300, 50);
		panel1.add(lbl_fullname);

		txt_fullname = new JTextField();
		txt_fullname.setFont(fon2);
		txt_fullname.setBounds(480, 85, 170, 35);
		txt_fullname.setBackground(new Color(245, 254, 255));
		panel1.add(txt_fullname);

		lbl_email = new JLabel("Email         :");
		lbl_email.setFont(fon2);
		lbl_email.setBounds(20, 140, 300, 50);
		panel1.add(lbl_email);

		txt_email = new JTextField();
		txt_email.setFont(fon2);
		txt_email.setBounds(130, 145, 170, 35);
		txt_email.setBackground(new Color(245, 254, 255));
		panel1.add(txt_email);

		lbl_gender = new JLabel("Gender        :");
		lbl_gender.setFont(fon2);
		lbl_gender.setBounds(310, 140, 300, 50);
		panel1.add(lbl_gender);

		rmale = new JRadioButton("Male");
		rmale.setBounds(460, 150, 80, 30);
		rmale.setFont(fon2);
		rmale.setBackground(new Color(253, 253, 132));
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(550, 150, 100, 30);
		rfemale.setFont(fon2);
		rfemale.setBackground(new Color(253, 253, 132));
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		panel1.add(rmale);
		panel1.add(rfemale);


		lbl_pass = new JLabel("Password  :");
		lbl_pass.setFont(fon2);
		lbl_pass.setBounds(20, 200, 300, 50);
		panel1.add(lbl_pass);

		txt_pass = new JPasswordField();
		txt_pass.setFont(fon2);
		txt_pass.setBounds(130, 205, 170, 35);
		txt_pass.setBackground(new Color(245, 254, 255));
		panel1.add(txt_pass);

		lbl_cpss = new JLabel("Confirm Password:");
		lbl_cpss.setFont(fon2);
		lbl_cpss.setBounds(310, 200, 300, 50);
		panel1.add(lbl_cpss);

		txt_cpss = new JPasswordField();
		txt_cpss.setFont(fon2);
		txt_cpss.setBounds(480, 205, 170, 35);
		txt_cpss.setBackground(new Color(245, 254, 255));
		panel1.add(txt_cpss);

		aggree = new JCheckBox("I agree all the tearms and conditions.");
		aggree.setFont(fon2);
		aggree.setBackground(new Color(253, 253, 132));
		aggree.setBounds(170, 260, 370, 30);
		panel1.add(aggree);

		btn_register = new JButton("Register");
		btn_register.setFont(fon3);
		btn_register.setForeground(new Color(5, 188, 5));
		btn_register.setBounds(250, 295, 200, 45);
		btn_register.setBackground(new Color(207, 241, 245));
		btn_register.addActionListener(this);
		panel1.add(btn_register);

		btn_back = new JButton("Go Back");
		btn_back.setForeground(Color.white);
		btn_back.setBackground(new Color(255, 0, 0));
		btn_back.setBorder(new LineBorder(new Color(243, 143, 177), 7));
		btn_back.setFont(fon2);
		btn_back.setBounds(500, 295, 100, 40);
		btn_back.addActionListener(this);
		panel1.add(btn_back);

		reg_bg = new ImageIcon(getClass().getResource("reg_bg.png"));
		lbl_regimg = new JLabel(reg_bg);
		lbl_regimg.setBounds(0, 0, 1370, 770);
		panel.add(lbl_regimg);

		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fr.setVisible(true);
		fr.setBackground(Color.YELLOW);
	}

	public boolean reg_test(String pass_t, String cpass_t) {
		String pass_test="1";
		String cpass_test="1";
		boolean result = false;
		if (pass_t == pass_test && cpass_t == cpass_test) {
			result = true;

		}
		return result;
	}

	public static void main(String[] args) {
		new RegistrationPage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_back) {
			fr.dispose();
			new LoginPage();
			
		}
		else if (e.getSource()==btn_register) {
		        
		        String fname=txt_username.getText();
		        String lname=txt_fullname.getText();
		        String email=txt_email.getText();
		        String gender="";
		        if (rmale.isSelected()) {
		        	gender=rmale.getText();
		        }
		        if(rfemale.isSelected()) {
		        	gender=rfemale.getText();
		        }
		        ;
		        
		        String pass=txt_pass.getText();
		        String cmpass=txt_cpss.getText();
		        
		        System.out.println(fname);
		        System.out.println(lname);
		        System.out.println(email);
		        System.out.println(gender);
		        System.out.println(pass);
		        System.out.println(cmpass);
		        System.out.println(fname.length());
		        Userdata user= new Userdata(fname,lname,email,gender,pass,cmpass);
		        if (user.getUsername().length()==0 || user.getFullname().length()==0 || user.getEmail().length()==0
		        		|| rmale.isSelected()==false && rfemale.isSelected()==false
		        		|| user.getPass().length()==0 || user.getConpass().length()==0) 
		        {
		        	JOptionPane.showMessageDialog(btn_register, "Enter all Fields completely");
		        }
		        else if(user.getPass().equals(user.getConpass()) != true) {
		        	JOptionPane.showMessageDialog(btn_register, "Your password and confirm password did not match."); 
		        }
		        else if(aggree.isSelected()==false) {
		        	JOptionPane.showMessageDialog(btn_register, "Please agree the tearms and condition.");
		        }
		        else  {
		        	JDBCoperation db=new JDBCoperation();
		        	String query="insert into register(username,fullname,email,gender,password,copassword)"
		        			+ " values('"+user.getUsername()+"','"+user.getFullname()+"','"+user.getEmail()+"',"
		        					+ "'"+user.getGender()+"','"+user.getPass()+"','"+user.getConpass()+"')";
		        	int ans= db.insert(query);
		        	if (ans>0) {
		        		JOptionPane.showMessageDialog(btn_register, "User successfully registered");
		        		txt_username.setText("");
		        		txt_fullname.setText("");
		        		txt_email.setText("");
		        		txt_pass.setText("");
		        		txt_cpss.setText("");
		        		aggree.setSelected(false);
		        		ButtonGroup bg=new ButtonGroup(); 
		        		bg.add(rmale);
		        		bg.add(rfemale);
		        		panel1.add(rmale);
		        		panel1.add(rfemale);
		        		bg.clearSelection();


		        	} 
		        	else {
		        		JOptionPane.showMessageDialog(btn_register, "User name already used. Please use diffrent "
		        				+ "username. ");
		        	}
		     } 
		}
	}
}
