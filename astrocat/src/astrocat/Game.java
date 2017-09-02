package astrocat;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * Actual game.
 * 
 * @author www.gametutorial.net
 */

public class Game {

	private BufferedImage backgroundImg;
	
	private CatPlayer catPlayer;

    public Game()
    {
        Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;
        
        Thread threadForInitGame = new Thread() {
            @Override
            public void run(){
                // Sets variables and objects for the game.
                Initialize();
                // Load game files (images, sounds, ...)
                LoadContent();
                
                Framework.gameState = Framework.GameState.PLAYING;
            }
        };
        threadForInitGame.start();
    }
    
    
   /**
     * Set variables and objects for the game.
     */
    private void Initialize()
    {
    	catPlayer = new CatPlayer();
    }
    
    /**
     * Load game files - images, sounds, ...
     */
    private void LoadContent()
    {
    	try
    	{
    		URL backgroundImgUrl = this.getClass().getResource("/astrocat/resources/images/menu.png");
    		backgroundImg = ImageIO.read(backgroundImgUrl);
    	}
    	catch(IOException ex)
    	{
    		Logger.getLogger(Framework.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }    
    
    
    /**
     * Restart game - reset some variables.
     */
    public void RestartGame()
    {
        catPlayer.ResetPlayer();
    }
    
    
    /**
     * Update game logic.
     * 
     * @param gameTime gameTime of the game.
     * @param mousePosition current mouse position.
     */
    public void UpdateGame(long gameTime, Point mousePosition)
    {
        catPlayer.Update();
    }
    
    /**
     * Draw the game to the screen.
     * 
     * @param g2d Graphics2D
     * @param mousePosition current mouse position.
     */
    public void Draw(Graphics2D g2d, Point mousePosition)
    {
    	g2d.drawImage(backgroundImg, 0, 0, Framework.frameWidth, Framework.frameHeight, null);
    	catPlayer.Draw(g2d);
    }
}
