
package clavecapture;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiuseapievents.ButtonsEvent;
import wiiusej.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiuseapievents.IREvent;
import wiiusej.wiiuseapievents.MotionSensingEvent;
import wiiusej.wiiuseapievents.StatusEvent;
import wiiusej.wiiuseapievents.WiimoteListener;
import java.awt.event.*;

public class MyWii implements ActionListener {
    private static final int HARD_HIT = 127;
    private static final float threshold = 2.35f;
    private boolean recording = false;
    private int state = 1;
    private long timeBetween;
    private String output;
    private long timeElapsed;
     
     private FileAccessor access;
     private ClaveOutput clave;
     private ProjectGUI gui;
     private Wiimote[] wiimotes;
     private Wiimote wiimote;
    
    public MyWii(FileAccessor access, ClaveOutput clave, ProjectGUI gui) 
    {
        this.access = access;
        this.clave = clave;
        this.gui = gui;
        gui.addRecordListener(this);
        wiimotes = WiiUseApiManager.getWiimotes(1);
        wiimote = wiimotes[0];
        wiimote.activateMotionSensing();
        wiimote.activateSmoothing();
        wiimote.addWiiMoteEventListeners(
			new WiimoteListener()
        	{
				public void onButtonsEvent(ButtonsEvent arg0) {
				}

				public void onIrEvent(IREvent arg0) {
				}

				public void onMotionSensingEvent(MotionSensingEvent arg0) {
                                        if(recording){
                                            float ztap = arg0.getGforce().getZ();
                                            process(ztap);
                                        }
				}

				public void onStatusEvent(StatusEvent arg0) {

				}

				public void onDisconnectionEvent(DisconnectionEvent arg0) {

				}
			}
        );
    }
    public void actionPerformed(ActionEvent ae){
        if(recording){
            recording = false;
            gui.drawGraph();
            access.writeString(output);
            
        }
        else if(!recording){
            output = "";
            timeBetween = System.currentTimeMillis();
            timeElapsed = 0;
            recording = true;
            
        }
    }
    public void process(float ztap){
        switch(state){
            case(1):
                if(ztap < -threshold){
                    state = 2;
                }
                
                break;
            case(2):
                if(ztap > threshold){
                    state = 1;
                    clave.beat(HARD_HIT);
                    timeBetween = System.currentTimeMillis() - timeBetween;
                    timeElapsed = timeElapsed + timeBetween;
                    output = output + timeBetween + "," + HARD_HIT + " ";
                    timeBetween = System.currentTimeMillis();
                    gui.setNextGraph((int)timeElapsed, HARD_HIT);
                }
                break;
                    
        }
    }
}
