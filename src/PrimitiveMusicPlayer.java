import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * The most primitive form of the music player, used to play sound effects and
 * play or loop currentMusics. Static methods and a private constructor are used
 * to ensure that the object is never instantiated.
 * 
 * @author tristanbell
 * 
 */
public class PrimitiveMusicPlayer {
	private static Sound	currentFX;
	private static Music	currentMusic;

	private PrimitiveMusicPlayer() {
	}

	/**
	 * Getter for currently loaded music track.
	 * 
	 * @return Music the current track
	 */
	public static Music getCurrentMusic() {
		return currentMusic;
	}

	/**
	 * Load a new music track.
	 * 
	 * @param newMusic
	 *            String filename of new track.
	 */
	public static void loadNewMusic(String newMusic) {
		try {
			currentMusic = new Music(newMusic);
		} catch (SlickException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Load a new sound effect.
	 * 
	 * @param newFX
	 *            String filename of new sound effect.
	 */
	public static void loadNewFX(String newFX) {
		try {
			currentFX = new Sound(newFX);
		} catch (SlickException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Play a new sound effect.
	 * 
	 * @param soundName
	 *            String filename of sound to play
	 */
	public static void playSoundEffect(String soundName) {
		loadNewFX(soundName);
		currentFX.play();
	}

	/**
	 * Play the currently loaded sound effect.
	 */
	public static void playSoundEffect() {
		
		currentFX.play();
	}

	/**
	 * Play a new music file from beginning to end. Note: Slick supports WAV,
	 * OGG and MOD/XM sound files.
	 * 
	 * @param musicName
	 *            String filename of track to play
	 */
	public static void playMusic(String musicName) {
		loadNewMusic(musicName);
		currentMusic.play();
	}

	/**
	 * Play the current music file from beginning to end.
	 * 
	 * @param musicName
	 *            String filename of track to play
	 */
	public static void playMusic() {
		currentMusic.play();
	}

	/**
	 * Play new music starting at a given position.
	 * 
	 * @param musicName
	 *            String filename of track to play
	 * @param position
	 *            float position to play at (in seconds)
	 */
	public static void playMusic(String musicName, float position) {
		loadNewMusic(musicName);
		currentMusic.setPosition(position);
		currentMusic.play();
	}

	/**
	 * Play the current music starting at a given position.
	 * 
	 * @param musicName
	 *            String filename of track to play
	 * @param position
	 *            float position to play at (in seconds)
	 */
	public static void playMusic(float position) {
		currentMusic.setPosition(position);
		currentMusic.play();
	}

	/**
	 * Loop new music starting at the beginning of the track.
	 * 
	 * @param musicName
	 *            String filename of track to loop
	 */
	public static void loopMusic(String musicName) {
		loadNewMusic(musicName);
		currentMusic.loop();
	}

	/**
	 * Loop the current music starting at the beginning of the track.
	 * 
	 * @param musicName
	 *            String filename of track to loop
	 */
	public static void loopMusic() {
		currentMusic.loop();
	}

	/**
	 * Loop new music starting at a given position.
	 * 
	 * @param musicName
	 *            String filename of track to loop
	 * @param position
	 *            float position to start playing at (in seconds)
	 */
	public static void loopMusic(String musicName, float position) {
		loadNewMusic(musicName);
		currentMusic.setPosition(position);
		currentMusic.loop();
	}

	/**
	 * Loop current music starting at a given position.
	 * 
	 * @param musicName
	 *            String filename of track to loop
	 * @param position
	 *            float position to start playing at (in seconds)
	 */
	public static void loopMusic(float position) {
		currentMusic.setPosition(position);
		currentMusic.loop();
	}

	/**
	 * Stop the music.
	 */
	public static void stopMusic() {
		currentMusic.stop();
	}

	/**
	 * Pause the music.
	 */
	public static void pauseMusic() {
		currentMusic.pause();
	}

	/**
	 * Resume the music.
	 */
	public static void resumeMusic() {
		currentMusic.resume();
	}

	/**
	 * Fade a new track in.
	 * 
	 * @param newTrack
	 *            String filename of track to fade in
	 * @param duration
	 *            int length of fade in milliseconds
	 * @param startVolume
	 *            float volume to begin fade at
	 * @param endVolume
	 *            float volume to end at
	 * @param stopAfterFade
	 *            boolean whether or not to stop playing after the fade
	 * @param loop
	 *            boolean whether or not to loop the new track
	 */
	public static void fadeMusicIn(String newTrack, int duration, float startVolume, float endVolume,
			boolean stopAfterFade, boolean loop) {
		loadNewMusic(newTrack);

		if (loop)
			loopMusic();
		else
			resumeMusic();

		currentMusic.setVolume(startVolume);

		currentMusic.fade(duration, endVolume, stopAfterFade);
	}

	/**
	 * Fade out current track.
	 * 
	 * @param duration
	 *            int length of the fade in milliseconds
	 * @param endVolume
	 *            float volume to end at
	 * @param stopAfterFade
	 *            boolean whether or not to stop playing after the fade
	 */
	public static void fadeMusicOut(int duration, float endVolume, boolean stopAfterFade) {
		if (musicPlaying())
			currentMusic.fade(duration, endVolume, stopAfterFade);
	}

	/**
	 * Whether music is playing currently.
	 * 
	 * @return true if music is currently loaded and playing
	 */
	public static boolean musicPlaying() {
		return currentMusic.playing();
	}

}
