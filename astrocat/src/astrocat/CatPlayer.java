package astrocat;

import java.awt.image.BufferedImage;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
//import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CatPlayer {
	
	/*** Coordinates ***/
	public int x;
	public int y;
	
	public int catImgWidth;
	public int catImgHeight;
	
	public int groundTop;
	
	private BufferedImage catImg;
	
	public CatPlayer(){
		Initialize();
		LoadContent();
	}
	
	private void Initialize(){
		//groundTop = 450;
		
		ResetPlayer();
	}
	
	private void LoadContent(){
		try{
			URL catImgUrl = this.getClass().getResource("/astrocat/resources/images/catella.png");
			catImg = ImageIO.read(catImgUrl);
			/** not good values
			catImgWidth = catImg.getWidth();
			catImgHeight = catImg.getHeight();*
			*/
		}
		catch(IOException ex){
			Logger.getLogger(CatPlayer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void ResetPlayer(){
		x = 0;
		y = 390;
	}
	
	/**
	 * Move the cat
	 * 
	 */
	public void Update(){
		if(Canvas.keyboardKeyState(KeyEvent.VK_RIGHT)){
			x+= 2;
		}
		if(Canvas.keyboardKeyState(KeyEvent.VK_LEFT)){
			x-= 2;
		}
		/**Jumping <=> drawing cat at each pos
		 * if(Canvas.keyboardKeyState(KeyEvent.VK_SPACE)){
			for(int i=0;i<20;i++){
				y-=i;
				
			}
			for(int i=0;i<20;i++){
				y+=i;
				
			}
		}**
		*/
	}
	
	public void Draw(Graphics2D g2d){
		g2d.drawImage(catImg, x, y, null);
	}
}
