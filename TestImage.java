import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
	public static void main(String args[]) throws Exception 
	{
    	Frame frame = new Frame("My Images");
      frame.setSize(1024,768);
      frame.setVisible(true);
      Graphics gc = frame.getGraphics();
      
        
      try 
      {
         Image myImage = new Image("animals.jpg");
         myImage.draw(gc, 10, 40);
         myImage.flipY();
         myImage.draw(gc, 30 + myImage.getWidth(), 40);
         //myImage.flipX();
        // myImage.draw(gc, 30 + 2 * myImage.getWidth(), 40);
         myImage.write("AnimalFlippedY.jpg"); 
         //myImage.write("AnimalFlippedX.jpg");               	
		} 
   	catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}