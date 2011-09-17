/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clavecapture;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class FileAccessor {
    private String outString;
    private File selectedFile;
    
    public String getString(){
        try {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
            else {
                return "";
            }
            BufferedReader input = new BufferedReader(new FileReader(selectedFile));
            outString = input.readLine();
            if (outString == null) {
                return "";
            }
            else {
                input.close();
                
            }
        } catch(IOException e){
            System.err.println("problem opening file");
        }
            return outString;
    }
    
    public void writeString(String input){
        try {
            JFileChooser fileSaver = new JFileChooser();
            int returnValue = fileSaver.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                BufferedWriter output = new BufferedWriter(new FileWriter(fileSaver.getSelectedFile().getPath()));
                output.write(input);
                output.close();
            }
        } catch(IOException e){
            System.err.println("cannot write to file");
        }
    }
}
