/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clavecapture;

/**
 *
 * @author jibril
 */
public class Loader {
    public Loader(){
        FileAccessor access = new FileAccessor();
        ClaveOutput clave = new ClaveOutput();
        ProjectGUI gui = new ProjectGUI();
        PlayRecorded recorded = new PlayRecorded(access, clave, gui);
        MyWii wii = new MyWii(access, clave, gui);
        
    }
    
    public static void main(String[] args){

        Loader loader = new Loader();

    }
}
