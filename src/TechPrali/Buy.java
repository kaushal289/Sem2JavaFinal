package TechPrali;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
public class Buy{
    DefaultTableModel model;
    JTable jt;
    Font fon,fon1;
    public Buy(JPanel panel) {
    	model= new DefaultTableModel();
    	jt= new JTable(model);
    	fon=new Font("Dialog", Font.BOLD, 22);
    	fon1=new Font("Serif", Font.BOLD, 18);
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
        	String query="select * from buysell";
        	ResultSet rs=db.select(query);
        	DefaultTableModel model=(DefaultTableModel)jt.getModel();
        	model.setRowCount(0);
            int i=0;
          
            while(rs.next()){
            	System.out.println(rs.getString(1)+" "+rs.getString(2));
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),
                		rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),
                		rs.getString(8),rs.getString(9),rs.getString(10)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jt);
        pg.setBounds(0,0,1180,400);
        panel.add(pg);
    }}


