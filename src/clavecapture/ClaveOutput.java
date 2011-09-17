
package clavecapture;
import javax.sound.midi.*;

public class ClaveOutput
{
	//instance variables of our object

        private int claveNote = 75;
	private Synthesizer synth; //our equivalent of a keyboard to play on

	private Receiver synthRcvr; //how we send a note to the keyboard to play

	private int midiChannelTen = 9; //we want our keyboard to play the percussion soundbank

	//override the default constructor with our own; it creates a synthesizer for
	//our drum object to use as well as gets a reference to the receiver of our
	//synthesizer, which is where we send notes that we want the synth to play
	public ClaveOutput()
	{
		try
		{
			// Locate the default synthesizer for the Java system, instantiate it
			// and get a reference to the object

		    synth = MidiSystem.getSynthesizer();

			// Open the synthesizer, meaning in this case that the synthesizer
			// should now request all the resources it needs to run from the
			// system and become operational

		    synth.open();

			// get a reference to the receiver, which is where
			// we send the message with the MIDI information for
			// the note that we want to play

		    synthRcvr = synth.getReceiver();

			//Note - this exception can be thrown by trying to interact
			//with a synthesizer.  If there are no more synthesizer objexts
			//available to be instantiated, or if this version of Java
			//doesn't support synthesizers, this exception is thrown, and
			//if this happens, it doesn't make much sense to continue trying
			//to build a Drum object so we exit the program with an error.

		} catch (MidiUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	} //end of constructor

	//call this method when we're done playing
    public void cleanup()
    {
		//tell the synthesizer to release any system resources it was allocated
		try
		{
			synth.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
    } //end of cleanup

    //an actual tap of the drum stick on the drum
    //the note should be a value between 35 and 81 inclusive; notes outside of this
    //range on MIDI channel 10 are inconsistent between different synthesizers
    //the velocity should be between 0 and 127
    public void beat(int velocity)
    	{
    		try {
        		ShortMessage myMsg = new ShortMessage();
        		// Play the drum note at the specified velocity
        		// on channel 9 (zero-based) which
        		// is reserved for percussion
        		myMsg.setMessage(ShortMessage.NOTE_ON, midiChannelTen, claveNote, velocity);
        		// fire the midi note through to the receiver on the
        		// synthesizer
        		synthRcvr.send(myMsg, -1); // -1 means no time stamp, so tell the
        								   // synthesizer to play the note as soon
        								   // as it gets it
    		//if the note or velocity are outside the valid range then this error is thrown
    		} catch (InvalidMidiDataException e)
    		{
    				System.out.println(e);
    		}
	} //end of hit the drum method
} //end of class Drum