package com.jigglypuff.components.tools;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jigglypuff.globals.StaticObjects;

public class StatsFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatsFrame() {
		super("Statistics");
		JPanel panel = new JPanel();
		String[] colName = new String[] { "Product Name" ,"Price" };
        Object[][] products = new Object[][] { 
                { "Galleta" ,"$80" },
                { "Malta" ,"$40" },
                { "Nestea" ,"$120" },
                { "Tolta" ,"$140" } 
            };
		JTable table = new JTable(products, colName);
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);
		
		panel.setLayout(null);
		panel.add(table);
		panel.add(new JScrollPane(table));
		setLocationRelativeTo(null);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
