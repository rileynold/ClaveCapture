/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clavecapture;
import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class GraphPanel extends JPanel {
    private ArrayList<Integer> time;
    private ArrayList<Integer> velocity;
    private boolean notdrawn = true;

    public GraphPanel(){
        setSize(750,500);
        time = new ArrayList();
        velocity = new ArrayList();
    }
    public void paintComponent(Graphics g){
        Color c = g.getColor();
        g.setColor(new Color(255,255,255));
        g.fillRect(61, 60, 690, 140);
        g.setColor(c);
        for(int i = 0; i < time.size(); i++){
            g.fillRect(time.get(i)/40 + 50, 200-velocity.get(i), 3, velocity.get(i));
        }
        if(notdrawn){
            g.drawLine(60, 200, 750, 200); //horizontal line
            g.drawLine(60, 60, 60, 200); //vertical line
            g.drawString("Time",375,225);
            g.drawString("Power", 5, 125);
            notdrawn = false;
        }
        time.clear();
        velocity.clear();
    }
    public void setNext(int time,int velocity){
        this.time.add(time);
        this.velocity.add(velocity);
    }

}
/*board code
 * paint(g){
 * for(x -> y){
 * y.drawstuff();
 * System.wait();
 * }
 * }
 * */

/* double buffering
 * MyClass{
 * JPanel 1 = new JPanel();
 * JPanel 2 = new JPanel();
 * JPanel display;
 * JPanel buffer;
 * update(){
 * draw to buffer
 * swap buffer and display
 * }
 * }
 * */

/* myevent listener(){
 * processevent(e){
 * x=e.getzforce();
 * t = System.gettime();
 * }
 * */

/* record{
 * drum.addListener();
 * }
 * stopRecording(){
 * drum.removelistener();
 * }
 * */