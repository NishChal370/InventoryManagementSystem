/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.util.ArrayList;
/**
 *
 * @author Dell
 */

public class Validation {

    //----------- Check it user input are empty or not------------------------//
    public String checkEmpty(String modelNamee,String color, String type, int range,String discOption,
            String fuleDeliverySystem, String breakingSystem, String fuleTankCapacity,String price){
        
        String EmptyValue ="no";
        if(modelNamee.equals("")){
            EmptyValue = "model name";
        }
        else if(range == 0){
            EmptyValue = "range";
        }
        else if(color.equals("")){
            EmptyValue = "color";
        }
        else if(discOption == null){
            EmptyValue = "disc Option";
        }
        else if(fuleDeliverySystem == null){
            EmptyValue = "fule Delivery System";
        }
        else if(breakingSystem == null){
            EmptyValue = "breaking System";
        }
        else if(fuleTankCapacity.equals("")){
            EmptyValue = "fule Tank Capacity";
        }
        else if(price.equals("")){
            EmptyValue = "price";
        }
        return EmptyValue;
    }
    
    
    
    //____CHECK if  fule delivery system AND Price is Integer______//
    public String checkInteger(String fuleTankCapacity, String price){
            String isInt = "no";
            try {   // fule tank capacity
                Integer.parseInt(fuleTankCapacity);
                Integer.parseInt(price);// Price
                
            } catch (NumberFormatException e) {
                isInt = "yes";
            }
            return isInt;
    }
    
    
    
    
    
    //------------------Create Vehicle ID------------------//
    int scooterNum = 0;
    int bikeNum = 0 ;
    String vehicleNum;
    public String createId(String type){
            if ("Scooter".equals(type)) {
                scooterNum += 1;
                vehicleNum = "00" + String.valueOf(scooterNum) + "S";
            } else if ("Bikes".equals(type)) {
                bikeNum += 1;
                vehicleNum = "00" + String.valueOf(bikeNum) + "B";
            }
            return vehicleNum;
    }
    
    
    
    
    
    //----------------------------------------STORING USER DATA IN 2D ARRAY------------------------------//
    // 2D array column
    ArrayList<String> userInput1dArray;
    public void insertIntoArray(String type, String cateogary, String vehicleId, String modelNamee, int range,
            String color, String noOfGears, String discOption, String fuleDeliverySystem, String breakingSystem,
            String fuleTankCapacity, String price, ArrayList<ArrayList<String>> storeUserAllDataArray)
    {
        userInput1dArray = new ArrayList<String>();
        
        //ADDING VALUE IN 1D array list
        userInput1dArray.add(type);
        userInput1dArray.add(cateogary);
        userInput1dArray.add(vehicleNum);
        userInput1dArray.add(modelNamee);
        userInput1dArray.add(String.valueOf(range));
        userInput1dArray.add(color);
        userInput1dArray.add(noOfGears);
        userInput1dArray.add(discOption);
        userInput1dArray.add(fuleDeliverySystem);
        userInput1dArray.add(breakingSystem);
        userInput1dArray.add(String.valueOf(fuleTankCapacity));
        userInput1dArray.add(String.valueOf(price));
        
        // storing all detail of user inputs
        storeUserAllDataArray.add(userInput1dArray);
    }
    
}
