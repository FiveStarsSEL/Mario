import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Main{
	
	public static void main(String args[]) throws Exception{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("SMario/SMsound.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        
		Loading loading=new Loading();
	}

}
