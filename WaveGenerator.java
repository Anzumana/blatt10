class WaveGenerator {

	static double noise() {
		// Math.random returns [0,1[
	 	// @return White noise amplitude [-1.0, 1.0] 
		double result;
		
		result = -1 + Math.random() + Math.random();

		return result; 	
	}

	/**
	 * 
	 * TODO: Implement this function
	 * 
	 * @param timeInSeconds Point in time for which to determine the amplitude
	 * @param frequency Desired signal frequency in Hertz 
	 * @return Amplitude [-1.0, 1.0] of sine wave of given frequency at given time
	 */
	static double sineWave(double timeInSeconds, double frequency) {
		return 0; // hint: use Math.sin(...)
	}
	
	/**
	 * 
	 * TODO: Implement this function
	 * 
	 * @param timeInSeconds Point in time for which to determine the amplitude
	 * @param frequency Desired signal frequency in Hertz 
	 * @return Amplitude [-1.0, 1.0] of square wave of given frequency at given time
	 */
	static double squareWave(double timeInSeconds, double frequency) {
		return 0;
	}
	
	/**
	 * 
	 * TODO: Implement this function
	 * 
	 * @param timeInSeconds Point in time for which to determine the amplitude
	 * @param frequency Desired signal frequency in Hertz 
	 * @return Amplitude [-1.0, 1.0] of sawtooth wave of given frequency at given time
	 */
	static double sawtoothWave(double timeInSeconds, double frequency) {
		return 0;		
	}
	
	/**
	 * 
	 * TODO: Implement this function
	 * 
	 * @param timeInSeconds Point in time for which to determine the amplitude
	 * @param frequency Desired signal frequency in Hertz 
	 * @return Amplitude [-1.0, 1.0] of triangle wave of given frequency at given time
	 */
	static double triangleWave(double timeInSeconds, double frequency) {
		return 0;
	}

}
