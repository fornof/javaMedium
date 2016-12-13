package midi;

import javax.sound.midi.*;

public class MidiTest{
 static int tempo = 60;
 static MidiChannel curChannel ;
    public static void main(String[] args) { 
      try{
        /* Create a new Sythesizer and open it. Most of 
         * the methods you will want to use to expand on this 
         * example can be found in the Java documentation here: 
         * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
         */
    	  System.out.println("Hello");
        Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
        midiSynth.open();

        //get and load default instrument and channel lists
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        MidiChannel[] mChannels = midiSynth.getChannels();

        midiSynth.loadInstrument(instr[0]);//load an instrument
        String message = "Habcd,Aaa,Hbcdefaabbcddeeffgg";
        curChannel = mChannels[0];
        parseMessage(message);
        
        // pie('b');
        //apple("df");
        //note('a', 2);
        
      } catch (MidiUnavailableException e) {}
      
 
   }
    private static void parseMessage(String message) {
		String[] messages = message.split(",");
		for (String msg : messages){
			char decider =msg.charAt(0);
			// if lower case character
			if (decider > 96){
				note(decider, msg.charAt(1));
			}
			else{
		try {
			switch(decider){
				case 'A':
					apple(msg);
					break;
				case 'H':
					huckleberry(msg);
					break;
				case 'M':
						
					break;
					case 'O':
					case 'P':
					}
				} catch (Exception e) {
					System.out.println("incorrectly formatted:" +msg);
				}
			}
		}
		
	}
	public static void pie( char note) {
    	note(note, 1);
    } 
    public static void apple( String note) {
    	System.out.println("note is on apple");
    	note(note.charAt(0), 2);
    	System.out.println("note is on apple2");
    	note(note.charAt(1), 2);
    } 
    public static void huckleberry( String msg) {
    	note(msg.charAt(1),8);
		note(msg.charAt(2),8);
		note(msg.charAt(3),8);
		note(msg.charAt(4),8);
    } 
    public static void strawberry(String note){
    	
    }
    public static void lemonade( char note) {
    	note(note, 3);
    } 
    
    /**
     * 
     * @param note : letter of the note a-g
     * @param noteType : quarter note (4) , whole note (1)
     */
    public static void note(char note, double noteType){
    	double bps = tempo/60 ;
    	double length = bps/noteType *1000;
    	// based on c note = 1 (60) ;
    	int currentNote = (int) note - 37 ;
        curChannel.noteOn(currentNote, 100);//On channel 0, play note number 60 with velocity 100 
        try { Thread.sleep((int)length); // wait time in milliseconds to control duration
        } catch( InterruptedException e ) { }
        curChannel.noteOff(currentNote);//turn off the note
        //System.out.println("note is ending on length:"  + length);
//        try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}    