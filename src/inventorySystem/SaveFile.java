/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/**
 *
 * @author Dell
 */
public class SaveFile {
    
    File fileToSave;
    String isSaved;
    //-------------------------Save the table data in file--(.txt)-----------------------//
    public String save(JFileChooser saveFileChooser, int userSelection, JTable displayTable) {
        
        try{
         
            if (saveFileChooser.getSelectedFile() != null) {
                
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    fileToSave = saveFileChooser.getSelectedFile();
                }//"D:\\Emerging\\ yo.txt"
                
                File file = new File(fileToSave.getAbsolutePath() + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                
                try (FileWriter fw = new FileWriter(file.getAbsoluteFile())) {
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("____________________________________________________________________________________\n");
                    for (int i = 0; i < displayTable.getRowCount(); i++) {
                        for (int j = 0; j < displayTable.getColumnCount(); j++) {
                            bw.write(displayTable.getModel().getValueAt(i, j) + "/");
                        }
                        bw.write("\n____________________________________________________________________________________\n");
                    }

                    bw.close();
                }
                isSaved = "saved";
                
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved;
    }
    
}
