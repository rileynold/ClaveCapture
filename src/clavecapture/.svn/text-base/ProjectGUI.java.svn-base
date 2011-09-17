/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clavecapture;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author farbodg
 */
public class ProjectGUI extends JFrame {

    private GraphPanel Screen;
    private JPanel ButtonPanel;
    private JButton playStopButton, loadButton;
    
    public ProjectGUI() {
        
        ButtonPanel = new JPanel();
        Screen = new GraphPanel();
        ButtonPanel.setSize(200, 150);
        
        playStopButton = new JButton("Record/Stop");
        loadButton = new JButton("Load");
        
        ButtonPanel.add(playStopButton);
        ButtonPanel.add(loadButton);
        
        add(Screen);
        add(ButtonPanel);
        setSize(800,600);
        setResizable(false);
        setTitle("Wiimotes as Claves");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void addRecordListener (ActionListener listener) {
        playStopButton.addActionListener(listener);
    }
    
    public void addPlayListener (ActionListener listener) {
        loadButton.addActionListener(listener);
    }
    public void drawGraph(){
        Screen.repaint();
    }
    public void setNextGraph(int time, int velocity){
        Screen.setNext(time,velocity);
    }
    
}
