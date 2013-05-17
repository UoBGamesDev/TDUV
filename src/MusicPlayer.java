import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Timer;

public class MusicPlayer {
	private ArrayList<String>	tracks	= new ArrayList<String>();

	/**
	 * Constructor.
	 * 
	 * @param file1
	 *            String filename of track to be played
	 */
	public MusicPlayer(String file1) {
		tracks.add(file1);
	}

	/**
	 * Constructor.
	 * 
	 * @param files
	 *            String[] filenames of tracks to be played
	 */
	public MusicPlayer(String[] files) {
		tracks.addAll(Arrays.asList(files));
	}

	/**
	 * Set a given track.
	 * 
	 * @param trackNumber
	 *            int number of track to set
	 * @param filename
	 *            String filename of new track
	 */
	public void setTrack(int trackNumber, String filename) {
		if (trackNumber < tracks.size()) {
			tracks.set(trackNumber, filename);
		} else {
			tracks.add(filename);
		}
	}

	/**
	 * Reset the track list and replace with an array of new filenames
	 * 
	 * @param newTracks
	 *            String[] filenames of new tracks to add
	 */
	public void resetTracks(String[] newTracks) {
		tracks.clear();
		tracks.addAll(Arrays.asList(newTracks));
	}

	/**
	 * Play a track.
	 * 
	 * @param trackNumber
	 *            int number of track to play
	 */
	public void playTrack(int trackNumber) {
		try {
			PrimitiveMusicPlayer.playMusic(tracks.get(trackNumber));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Invalid track number.");
		}
	}

	/**
	 * Loop a given track.
	 * 
	 * @param trackNumber
	 *            int number of track to loop
	 */
	public void loopTrack(int trackNumber) {
		try {
			PrimitiveMusicPlayer.loopMusic(tracks.get(trackNumber));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Invalid track number.");
		}
	}

	/**
	 * Cross-fade between current and a given track. Currently fades out track 1
	 * and then fades in track 2, due to the limitations Slick has on playing
	 * music. I'll work to try and find an alternative.
	 * 
	 * @param track2num
	 *            int number of track to fade into
	 * @param fadeLength
	 *            int length of the fade in milliseconds
	 * @param loop
	 *            boolean whether to loop track 2 or not
	 * @param endVolume
	 *            float volume at the end of the fade
	 */
	public void crossFade(final int track2num, final int fadeLength, final boolean loop, final float endVolume) {
		Timer fadeTimer = new Timer(fadeLength / 2, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrimitiveMusicPlayer.fadeMusicIn(tracks.get(track2num), fadeLength / 2, 0.1f, endVolume,
						false, loop);
			}
		});
		// Only fire the timer once, to start the next track
		fadeTimer.setRepeats(false);

		PrimitiveMusicPlayer.fadeMusicOut(fadeLength / 2, 0.1f, true);
		fadeTimer.start();

	}

}
