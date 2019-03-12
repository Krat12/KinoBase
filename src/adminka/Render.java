/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */
public class Render extends DefaultTableCellRenderer {
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	boolean hasFocus, int row, int column) {
	
       Component call = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
	
       
       
	return call;
		}
} 
    

