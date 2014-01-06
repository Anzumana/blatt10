import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class ChristmasSongPlayer {	
	/**
	 * How many values there are in one second of audio. Take this value into account when generating audio.
	 */
	static int samplesPerSecond = 44100;
	
	/**
	 * 
	 * Plays back a raw audio buffer being passed. You don't need to change anything here.
	 * 
	 * @param song Raw signal of sound to be played. Amplitude in range [-1.0, 1.0]
	 */
	static void playSong(double[] song) {
		AudioFormat format = new AudioFormat(
			Encoding.PCM_SIGNED,
			samplesPerSecond,			// sample rate
			Short.SIZE,					// bits per sample
			1,							// # channels
			Short.SIZE / 8,				// bytes per frame
			samplesPerSecond, 			// frame rate
			true);						// big endian
		
		ByteBuffer buffer = ByteBuffer.allocate(song.length * (Short.SIZE / 8));
		ShortBuffer sb = buffer.asShortBuffer();
		for (double value : song) {
			value = Math.max(-1.0,  Math.min(1.0, value));
			sb.put((short)(Short.MAX_VALUE * value));
		}
		
		AudioInputStream stream = new AudioInputStream(new ByteArrayInputStream(buffer.array()), format, song.length);
		try {
			Clip clip = AudioSystem.getClip();
			System.out.println("1");
			clip.open(stream);
			System.out.println("2");
			clip.start();
			System.out.println("3");
			Thread.sleep(1000 * 5); // allow AudioInputStream some time to buffer
			System.out.println("4");
			clip.drain();
			System.out.println("5");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Playback failed :(");
		}
	}
	
	/**
	 * 
	 * TODO: Describe what this function does and why it is useful.
	 * What happens when this function always returns 1.0?
	 Da die Toene nicht direkt mit voller lautstaerke anfangen sollten konenn wir durch die funtion
	 getVolume den die Lautstaerke des tons nach und nach erhoehen. 
	 dies ist sinnvoll da die toene die wir so produzieren "echter " klingen.
	 selbiges gilt fuer wenn der ton aufhoert. durch ie wahl der konstanten definieren wir wie toene ausklingen.
	 wenn die funktion immer 1 zurueckgeben wuerde wuerden toene immer in voller lautstaerje anfangen.


	 * 
	 * @param index Position inside current note region
	 * @param size Total length of current note region
	 * @return Volume [0.0, 1.0] of the note at the current time
	 */
	static double getVolume(int index, int size) {
		double x = (double)index / (double)size;
		double attackPos = Math.min(0.1,  4000.0 / size);
		
		if (x <= attackPos) {
			return x / attackPos;
		} else {
			return 1.0 - (1.0 / (1.0 - attackPos)) * (x - attackPos);
		}
	}
	
	/**
	 * 
	 * TODO: Check out the individual todos in this function. Inside the inner loop you can experiment
	 * with different ways to generate sounds.
	 * 
	 * @param song Which song to load. Currently can be either Jingle Bells or Rudolph the Red-Nosed Reindeer
	 * @param bpm Beats per minute = how fast to play the song
	 * @return Audio buffer (doubles in range [-1.0,1.0]) for the song, ready to be played back
	 */
	static double[] loadSongData(Song song, double bpm) {
		int samplesPerBeat = 60*samplesPerSecond / (int)bpm; // number of audio samples per beat, TODO
		System.out.println(samplesPerBeat);
		int totalBeats = 4*(int) song.length; // number of beats of this song, assumes 4/4 measures (one measure has 4 beats), TODO
		int totalSamples = totalBeats* samplesPerBeat; // number of audio samples for this song, TODO
		double[] buffer = new double[totalSamples]; // stores the audio samples of this song
		
		int outputPos = 0;
		for (Note n : song.notes) { // gets the next note of the song
			int samplesPerMeasure = 4 * samplesPerBeat;
			int nSamples = (int) n.length * samplesPerMeasure; // the number of samples to represent this note, TODO
			double noise = WaveGenerator.noise();
			
			for (int j = 0; j < nSamples; ++j) {
				double time = (double)j / samplesPerSecond;
				//double value = n.pitch.frequency; // TODO
				double value = noise; // TODO
				// hint: to get the frequency of a note, use: n.pitch.frequency
				
				// todo: this is your space for experimentation...
			
				value *= getVolume(j, nSamples);
				buffer[outputPos + j] = value;
			}
			
			outputPos += nSamples;
		} 
			
		return buffer;
	}
	
	public static void main(String[] args) {
/*
		double[] noiseData = new double[100000];
		for(int i = 0 ; i<noiseData.length;i++){
			noiseData[i] = WaveGenerator.noise();
		}
		playSong(noiseData); 	
*/
/*
		
		double[] songData = loadSongData(Song.jingleBells(), 160.0);
		playSong(songData);
*/

		System.out.println(Math.PI);
		System.out.println("0: " + Math.sin(0));
		System.out.println("90: " + Math.sin(90));
		System.out.println("180 " + Math.sin(180));
		System.out.println("360 + " + Math.sin(360));
		System.out.println("720: " + Math.sin(720));

		//double[] songData = loadSongData(Song.rudolfTheRedNosedReindeer(), 160.0); // also try this one
		
		// TODO: add echo effect here
		
		// playSong(songData);
	}

}
