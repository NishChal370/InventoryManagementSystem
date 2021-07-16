/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dell
 */
public class RemoveUserData {
    
    
    //----------------------------------Remove the data from arrayList and JTable-----------------//
    public void removeData(JTable displayTable, ArrayList<ArrayList<String>> storeUserAllDataArray){
            // removing slected row  from 2D array
            storeUserAllDataArray.remove(displayTable.getSelectedRow()); 
            // removing fromm jtable
            ((DefaultTableModel) displayTable.getModel()).removeRow(displayTable.getSelectedRow()); 
    }
}
