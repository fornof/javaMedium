package midi;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.sound.midi.*;

import javax.sound.midi.spi.MidiFileReader;
public class MidiController {
	//static Note note = new Note();
	static int noteValueToPlay = 0;
	
	public MidiController(){
		
	}
	public void stuff() throws InvalidMidiDataException, IOException{
		File file = new File("/Users/rob/Downloads/movie.mid");
		//getSequence(file);
		
	}
	public static void main(String args[])  throws InvalidMidiDataException {
	
		MidiFileFormat midiFile = new MidiFileFormat(0, 0, 0, 0, 0);
		File file = new File("/Users/rob/Downloads/movie.mid");
		
	}
	// Now, display strings from synthInfos list in GUI.    
	public static void playSomething() throws MidiUnavailableException{
		Synthesizer synth = MidiSystem.getSynthesizer();
		long startTime = System.nanoTime();
		synth.open();
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime * Math.pow(10,  -9) + "seconds");
		MidiChannel[] midiChannel = synth.getChannels();
		Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();
		boolean LoadedInstrument;
		//note.setNoteValue(noteValuetoPlay);
	}
}
