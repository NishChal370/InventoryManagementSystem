package inventorySystem;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class ImportTxtFile {
    
    
    // this class contain method add table
    AppliancesInfo appliancesInfoObj  = new AppliancesInfo();
    
    
    ArrayList<String>  toStoreValue1DArray;
    
    String tableHave= "ownData";// it is created to trak the data
    
    
     //-------------Open existing file and display the data in jTable.----------------------//
    public void openFile(JPanel openIn, JTable displayTable, ArrayList<ArrayList<String>> storeuserAllDataArray){
        JFileChooser openfileChooser = new JFileChooser();
        // file type
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES (.txt)", "txt", "text");
        // set file extension
        openfileChooser.setFileFilter(filter);
        // file chooser title
        openfileChooser.setDialogTitle("Open .txt file");
        // open dilog box
        openfileChooser.showOpenDialog(openIn);
        // checking if file is selected or not
        if (openfileChooser.getSelectedFile() != null) {
            tableHave ="fileData";
            try {
                BufferedReader br = null;
                // create file
                File file = new File(openfileChooser.getSelectedFile().toString());
                
                
                // read file
                br = new BufferedReader(new FileReader(file));
                
                // storing textfile data  in list
                Object[] tableLines = br.lines().toArray();
                
                for (int i = 1; i < tableLines.length; i += 2) {
                    // initilizaing arraylist
                    toStoreValue1DArray = new ArrayList<String>();
                    String line = tableLines[i].toString().trim();
                    // spliting table column
                    String[] dataRow = line.split("/");
                   // mArray.add(dataRow);
                    for (String dataRow1 : dataRow) {
                        // storing ecah column in array list
                        toStoreValue1DArray.add(dataRow1);
                        
                    }
                    // storing in 2D array
                    storeuserAllDataArray.add(toStoreValue1DArray);
                    
                }
                
                // display values in table
                appliancesInfoObj.addToTable(displayTable, storeuserAllDataArray);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImportTxtFile.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                    
        }
            
    }
    
    
        
}
