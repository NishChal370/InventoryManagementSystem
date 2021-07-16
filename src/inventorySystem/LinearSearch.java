/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class LinearSearch {
    int tableRowNum;
    public int linearSearch(JComboBox searchedCateogary, ArrayList<ArrayList<String>> storeUserAllDataArray, JDialog searchDataDialog, JTable searchValueTable){
        // table row
        tableRowNum = 0;
        // creating table model
        DefaultTableModel searchValueTableModel = (DefaultTableModel) searchValueTable.getModel();
        // set model to 0
        searchValueTableModel.setNumRows(0);
        searchValueTable.setModel(searchValueTableModel);
        
        //user search cateogary
        String searchCatg = searchedCateogary.getSelectedItem().toString().toLowerCase();
        
        
        // ----------------(LINEAR Search ) ITERATING AND STORING 2D ARRAY IN jTable ----------//
        for (int row = 0; row < storeUserAllDataArray.size(); row++) {//iterating over arraylist

            String tableCatg =storeUserAllDataArray.get(row).get(1).toString().toLowerCase();
            
            //user cateogary = table cateogary
            if (searchCatg.equals(tableCatg)) {
                for (int column = 0; column < storeUserAllDataArray.get(row).size(); column++) {
                    searchValueTableModel.setRowCount(tableRowNum + 1);
                    // adding vale in table
                    searchValueTableModel.setValueAt(storeUserAllDataArray.get(row).get(column), tableRowNum, column); 
                }
                // table row index
                tableRowNum += 1;
            }
            
        }
        return searchValueTableModel.getRowCount();
        
    }
}
