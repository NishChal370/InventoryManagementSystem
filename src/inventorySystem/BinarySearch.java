/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class BinarySearch {
    
    //----------------------------------Search the required price--------------------------------------------//
    String searchedPrice;
    public String searchByPrice(JTable displayTable, String findSearchPrice,int findSearchPriceNum, 
            JDialog binaySearchDialog, JTable binSearchValueTable, JTextField searchPrice, JLabel jLabelPrice){
        searchedPrice = " ";
        try {            
            findSearchPriceNum = Integer.parseInt(findSearchPrice);
            int rowsNo = displayTable.getRowCount();     // get the no of rows from the table
            int[] arr = new int[rowsNo];        // create a array and declare a size equals to no of rows in the table
            int[] ogArr = new int[rowsNo]; // unsorted original array
            int colNo = displayTable.getColumnCount();
            String[] arr2 = new String[colNo];

            if (rowsNo > 0) {// rows no should be greater than 0
                for (int i = 0; i < rowsNo; i++) {    // the loop will execute according to no of rows in the table            
                    String price =  String.valueOf(displayTable.getValueAt(i,11));   // the data from price column from the table will be store in price variable
                    arr[i] = Integer.parseInt(price);       // in the specified index data will be stored in the array
                    ogArr[i] = Integer.parseInt(price);
                }

                int[] newArr = splitMethod(arr);//calling method splitMethod
                int lowIdx = 0;
                int highIdx = newArr.length - 1;
                int resultIdx = binSearchMethod(newArr,lowIdx,highIdx,findSearchPriceNum);//calling method binSearchMethod
                int ogIdx = 0;
                int m = 0;
                if (resultIdx != -1) {              

                    for (m = 0; m < ogArr.length; m++) {
                        if (ogArr[m] == newArr[resultIdx]) {
                            ogIdx = m;
                            break;
                        }
                    }

                    for (int i = 0; i < arr2.length; i++) {
                                String colVal = String.valueOf(displayTable.getValueAt(m, i));
                                arr2[i] = colVal; 
                            }

                    // using the loop to access array an  d put the arrays value in specific column  

                    for (int j = 0; j < 1; j++) {
                        for (int k = 0; k < arr2.length; k++) {
                            binSearchValueTable.setValueAt(arr2[k], j, k);
                        }
                    }
                    // making the dialog box with table visible
                    String price = searchPrice.getText();
                    jLabelPrice.setText(price);
                    binaySearchDialog.setVisible(true);

                }
                else {
                    searchedPrice ="notExist";
                    //JOptionPane.showMessageDialog(binaySearchDialog, "Two wheller with such price does not exist!!!");
                }

                //System.out.println(Arrays.toString(newArr));
            } else {
                searchedPrice = "notContain";
                //JOptionPane.showMessageDialog(this, "The table does not contain any data!!!");    
            }
        }
        catch (Exception e) {
            searchedPrice ="notInNumerical";
            //JOptionPane.showMessageDialog(this, "Please enter the price in numberical form!!"); 
        }   
        return searchedPrice;
    }
    
    
    
    
    
    //-------------This method splits 1 array with multiple elements into single elements----//
    private static int[] splitMethod(int[] arr) {
        if (arr.length <= 1) {    
            return arr;
        }
        
        int[] first = new int[arr.length/2];
        int[] second = new int[arr.length - first.length];
        
        for (int i = 0; i < first.length; i++) {
            first[i] = arr[i];
        }
        
        for (int j = 0; j < second.length; j++) {
            second[j] = arr[first.length + j];
        }
        
        splitMethod(first); 
        splitMethod(second);
        
        mergeMethod(first, second, arr);
        
        return arr;
    }
    
    
    
    
    //----------------------Compaires array and combine them into single array------//
    private static void mergeMethod(int[] first, int[] second, int[] arr) {
        int firstIdx = 0;
        int secondIdx = 0;
        int arrIdx = 0;
        
        while (firstIdx < first.length && secondIdx < second.length) {
            if (first[firstIdx] < second[secondIdx]) {
                arr[arrIdx] = first[firstIdx];
                firstIdx++;
            } else {
                arr[arrIdx] = second[secondIdx];
                secondIdx++;
            }
            arrIdx++;
        }
        while(firstIdx < first.length) {
            arr[arrIdx] = first[firstIdx];
            firstIdx++;
            arrIdx++;       
        }

        while(secondIdx < second.length) {
            arr[arrIdx] = second[secondIdx];   
            secondIdx++;
            arrIdx++;       
        }                       
    }   
    
    
    //------------------return searched value index---------------------------//
    private static int binSearchMethod(int[] a, int low, int high, int find) {
        if (low <= high ) {
            int midIdx = (low + high) / 2;
            if (a[midIdx] == find) {
                return midIdx;
            }else if (a[midIdx] < find) {
                return binSearchMethod(a, midIdx+1, high, find);
            } else {
                return binSearchMethod(a, low, midIdx-1, find);
            }
        } else {
            return -1;
        }
    }
    
    
}

