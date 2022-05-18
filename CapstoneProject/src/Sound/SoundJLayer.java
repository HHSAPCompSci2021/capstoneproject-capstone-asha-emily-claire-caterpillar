package Sound;
import javazoom.jl.player.advanced.*;


/**
 * Represents a song player 
 */
public class SoundJLayer extends PlaybackListener implements Runnable
{
    private String filePath;
    private AdvancedPlayer player;
    private Thread playerThread;    
    
    /**
     * Constructs a song player
     * @param filePath - the mp3 file it will be playing
     */
    public SoundJLayer(String filePath)
    {
        this.filePath = filePath;
    }
    
    /**
     * Plays the song
     */
    public void play()
    {
        try
        {
            String urlAsString = "file:///" + new java.io.File(".").getCanonicalPath() + "/" + this.filePath;

            this.player = new AdvancedPlayer(new java.net.URL(urlAsString).openStream(),
            		javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

            this.player.setPlayBackListener(this);

            this.playerThread = new Thread(this, "AudioPlayerThread");

            this.playerThread.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

       
    
//    // PlaybackListener members
//    
//    public void playbackStarted(PlaybackEvent playbackEvent)
//    {
//        System.out.println("playbackStarted");
//    }
//
//    public void playbackFinished(PlaybackEvent playbackEvent)
//    {
//        System.out.println("playbackEnded");
//    }    

    // Runnable members
    
    /**
     * Runs through the song
     */
    public void run()
    {

        try
        {
            this.player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException ex)
        {
            ex.printStackTrace();
        }

    }
    
    /**
     * Getter method for the AdvancedPlayer
     * @return player - the AdvancedPlayer
     */
    public AdvancedPlayer getAdvancedPlayer() {
    	return player;
    }
    
    }