/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clavecapture;
import java.awt.event.*;
import javax.swing.JButton;
/**
 *
 * @author jibril
 */
public class PlayRecorded implements ActionListener {
    private FileAccessor access;
    private ClaveOutput clave;
    private ProjectGUI gui;
    private String[] input;
    private String[] timeAndVelocity;
    private int timeElapsed = 0;
    public PlayRecorded(FileAccessor access, ClaveOutput clave, ProjectGUI gui){
        this.access = access;
        this.clave = clave;
        this.gui = gui;
        gui.addPlayListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
            JButton source = (JButton)ae.getSource();
            if(source.getText().equals("Record/Stop")){
                
            }
            if(source.getText().equals("Load")){
                
                input = access.getString().split(" ");
                for(int i = 0;i<input.length;i++){
                    timeAndVelocity = input[i].split(",");
                    timeElapsed += Integer.parseInt(timeAndVelocity[0]);
                    
                    gui.setNextGraph(timeElapsed,Integer.parseInt(timeAndVelocity[1]));
                    
                    try{
                        Thread.sleep(Integer.parseInt(timeAndVelocity[0]));
                    }catch(Exception exc){
                        System.err.println("cant sleep");
                    }
                    clave.beat(Integer.parseInt(timeAndVelocity[1]));
                    
                    
                }
                gui.drawGraph();
                timeElapsed = 0;
    
            }
        }
}
