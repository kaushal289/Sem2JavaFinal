package TechPrali;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class Details implements ActionListener {
	JLabel lbl_topic,lbl_select;
	JTextField txt_id;
	JButton btn_delete;
	Font fon,fon1,fon3;
	String user;
	JPanel panel;
	JTable jt;
	DefaultTableModel model;
	JScrollPane pg;
	public void del(JPanel panel,String user) {
		this.user=user;
		this.panel=panel;
		jt= new JTable();
		model = (DefaultTableModel) jt.getModel();
    	jt.setFont(fon1);
    	jt.setRowHeight(40);
    	jt.setBackground(new Color(211,244,252));
    	model.addColumn("Id");
        model.addColumn("User Name");
        model.addColumn("Mobile Name");
        model.addColumn("Company");
        model.addColumn("RAM");
        model.addColumn("Storage");
        model.addColumn("Price");
        model.addColumn("Processor");
        model.addColumn("Camera");
        model.addColumn("Contact");
        JTableHeader header = jt.getTableHeader();
        header.setFont(fon);
        header.setBackground(Color.black);
        header.setForeground(Color.white);
        jt.getTableHeader().setPreferredSize(new Dimension(100,50));
        try {
        	JDBCoperation db=new JDBCoperation();
        	String query="select * from buysell where username='"+user+"'";
        	ResultSet rs=db.select(query);
        	
        	
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),
                		rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),
                		rs.getString(8),rs.getString(9),rs.getString(10)});
                System.out.println(rs.getString(1));
            }
        }
		catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pg = new JScrollPane(jt);
        pg.setBounds(0,150,1180,250);
        panel.add(pg);
        }
	public Details(JPanel panel,String user) {
		this.user=user;
		this.panel=panel;
		fon=new Font("Dialog", Font.BOLD, 22);
    	fon1=new Font("Serif", Font.BOLD, 18);
    	fon3=new Font("Serif", Font.BOLD, 30);
		
		lbl_topic=new JLabel("Type id that you want to delete");
		lbl_topic.setBounds(430,0,500,50);
		lbl_topic.setFont(fon3);
		panel.add(lbl_topic);
		
		txt_id=new JTextField();
		txt_id.setFont(fon1);
		txt_id.setBounds(550,50,170,45);
		txt_id.setBackground(new Color(245,254,255));
		panel.add(txt_id);
		
		btn_delete =new JButton("DELETE");
		btn_delete.setFont(fon);
		btn_delete.setBounds(520,100,220,45);
		btn_delete.setBackground(Color.red);
		btn_delete.setForeground(Color.white);
		btn_delete.addActionListener(this);
		panel.add(btn_delete);
		del(panel,user);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_delete) {
			try {
		JDBCoperation db=new JDBCoperation();
		String sql = "DELETE FROM buysell WHERE id='"+txt_id.getText()+"'";
		int rowsDeleted = db.executeDelete(sql);
		model = (DefaultTableModel) jt.getModel();
		if (rowsDeleted > 0) {
			JOptionPane.showMessageDialog(btn_delete, "Successfully deleted");
			txt_id.setText("");
			panel.removeAll();
			panel.repaint();
			panel.revalidate();
			new Details(panel, user);
			del(panel,user);
		}
	}
		catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(btn_delete, "ID not found.");
			}
		}
	}
}



