/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *This method is used 
 * to change the panel 
 * And to add the 2D array list to  JTable.
 */
public class AppliancesInfo {

    /**
     * @param args the command line arguments
     */
      
    public static void main(String[] args) {}
        
 
    //---- to change panel----------------------//
    public void showComponent(JPanel holderPanel,JPanel showingPanel){
        holderPanel.removeAll();
        holderPanel.add(showingPanel);
        holderPanel.revalidate();
        holderPanel.repaint();
    }
    
    
    
    
    //---------------------------display the imported values in tabel---------------------------//
    public void addToTable(JTable displayTable, ArrayList<ArrayList<String>> storeUserAllDataArray){
        // create table model importValueTable
        DefaultTableModel displayTableModel = (DefaultTableModel) displayTable.getModel();
        displayTableModel.setRowCount(0);
        displayTable.setModel(displayTableModel);
                
        
        // adding row in table
        displayTableModel.setRowCount(storeUserAllDataArray.size());
        
        // iterating and  adding value in jtable
        for (int row = 0; row < storeUserAllDataArray.size(); row++) {
            for(int column= 0; column< storeUserAllDataArray.get(row).size(); column++){
                displayTableModel.setValueAt(storeUserAllDataArray.get(row).get(column), row, column);
            }
        }
        
    }
    

}
