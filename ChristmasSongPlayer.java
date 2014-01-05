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
			clip.open(stream);
			clip.start();
			Thread.sleep(1000 * 5); // allow AudioInputStream some time to buffer
			clip.drain();
		} catch (Exception e) {
			System.out.println("Playback failed :(");
		}
	}
	
	/**
	 * 
	 * TODO: Describe what this function does and why it is useful.
	 * What happens when this function always returns 1.0?
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
		int samplesPerBeat = 0; // number of audio samples per beat, TODO
		int totalBeats = 0; // number of beats of this song, assumes 4/4 measures (one measure has 4 beats), TODO
		int totalSamples = 0; // number of audio samples for this song, TODO
		double[] buffer = new double[totalSamples]; // stores the audio samples of this song
		
		int outputPos = 0;
		for (Note n : song.notes) { // gets the next note of the song
			int nSamples = 0; // the number of samples to represent this note, TODO
			
			for (int j = 0; j < nSamples; ++j) {
				double time = (double)j / samplesPerSecond;
				double value = 0; // TODO
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
		double[] noiseData = new double[100000];
		for(int i = 0 ; i<noiseData.length;i++){
			noiseData[i] = WaveGenerator.noise();
		}
		
		//double[] songData = loadSongData(Song.jingleBells(), 160.0);
		//double[] songData = loadSongData(Song.rudolfTheRedNosedReindeer(), 160.0); // also try this one
		
		// TODO: add echo effect here
		
		// playSong(songData);
	}

}
