import java.util.ArrayList;


class Song {
	/**
	 * Contains a list-of-notes representation of the song. Pauses are encoded by notes with pitch == Pitch.None   
	 */
	ArrayList<Note> notes = new ArrayList<Note>();
	
	/** 
	 * Overall length of the song in measures (= Takte) (assume 4 beats per measure for this assignment)
	 */
	double length = 0.0;
	
	/**
	 * Based on: http://www.makingmusicfun.net/pdf/sheet_music/jingle-bells-recorder-solo.pdf
	 * @return Provides Song object for "Jingle Bells"
	 */
	static Song jingleBells() {
		Song s = new Song();
		
		// Measure 1
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.5, Note.Pitch.B3));
		// Measure 2		
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.5, Note.Pitch.B3));
		// Measure 3
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 4
		s.notes.add(new Note(1.0, Note.Pitch.B3));
		
		// Measure 5
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 6
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 7
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 8
		s.notes.add(new Note(0.5, Note.Pitch.A3));
		s.notes.add(new Note(0.5, Note.Pitch.D4));
		
		// Measure 9
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.5, Note.Pitch.B3));
		// Measure 10		
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.5, Note.Pitch.B3));
		// Measure 11
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 12
		s.notes.add(new Note(1.0, Note.Pitch.B3));

		// Measure 13
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 14
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 15
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 16
		s.notes.add(new Note(1.0, Note.Pitch.G3));
		
		for (Note n : s.notes) {
			s.length += n.length;
		}
		
		return s;
	}
	
	/**
	 * Based on: http://pianoandsynth.com/rudolph-the-red-nosed-reindeer-mastering-christmas-songs-on-the-piano-and-keyboard/
	 * @return Provides Song object for "Rudolph the Red-Nosed Reindeer"
	 */
	static Song rudolfTheRedNosedReindeer() {
		Song s = new Song();
		
		// Measure 1
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.E3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 2		
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 3
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 4
		s.notes.add(new Note(1.0, Note.Pitch.B3));
		// Measure 5
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.D3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 6
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 7
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 8
		s.notes.add(new Note(1.0, Note.Pitch.E3));
		
		// Measure 9
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.E3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 10		
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 11
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 12
		s.notes.add(new Note(1.0, Note.Pitch.B3));
		// Measure 13
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.D3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 14
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 15
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		// Measure 16
		s.notes.add(new Note(1.0, Note.Pitch.C4));
		
		// Measure 17
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 18		
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.E3));
		s.notes.add(new Note(0.625, Note.Pitch.G3));
		// Measure 19
		s.notes.add(new Note(0.25, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.F3));
		// Measure 20
		s.notes.add(new Note(1.0, Note.Pitch.E3));
		// Measure 21
		s.notes.add(new Note(0.25, Note.Pitch.D3));
		s.notes.add(new Note(0.25, Note.Pitch.E3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 22
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.5, Note.Pitch.B3));
		// Measure 23
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		// Measure 24
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.625, Note.Pitch.D3));
		
		// Measure 25
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.E3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 26		
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 27
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.C4));
		// Measure 28
		s.notes.add(new Note(1.0, Note.Pitch.B3));
		// Measure 29
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.F3));
		s.notes.add(new Note(0.25, Note.Pitch.D3));
		s.notes.add(new Note(0.25, Note.Pitch.B3));
		// Measure 30
		s.notes.add(new Note(0.25, Note.Pitch.A3));
		s.notes.add(new Note(0.75, Note.Pitch.G3));
		// Measure 31
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.125, Note.Pitch.G3));
		s.notes.add(new Note(0.125, Note.Pitch.A3));
		s.notes.add(new Note(0.25, Note.Pitch.G3));
		s.notes.add(new Note(0.25, Note.Pitch.D4));
		// Measure 32
		s.notes.add(new Note(1.0, Note.Pitch.C4));
		
		for (Note n : s.notes) {
			s.length += n.length;
		}
		
		return s;
	}
}
