import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
      BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
		
		// Complete the remainder of this method 
       this.pixels = new int[this.height][this.width]; 
       for(int row = 0; row < this.pixels.length; row++)
       {
         for(int col = 0; col < this.pixels[row].length; col++)
         {
            this.pixels[row][col] = bufImage.getRGB(col, row);
         }
       }              
       
   }
   
   private BufferedImage createBufferedImage() 
   	{ 
      	BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
               bufImage.setRGB(col, row, this.pixels[row][col]);
         	}
        }
         
      	return bufImage;
	}
   
   public void write(String filename) throws Exception 
   {
        File fileImage = new File(filename);
        String ext = filename.substring(filename.indexOf('.') + 1);
        BufferedImage bufImage = createBufferedImage();
        ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   		BufferedImage bufImage = createBufferedImage();
      	gc.drawImage(bufImage, x, y, null);
   }
   
   
   public void flipY()throws Exception
   {
   
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length/2; col++)
         {
           int temp = pixels[row][col];
           pixels[row][col] = pixels[row][pixels[0].length - col -1];
           pixels[row][pixels[0].length - col - 1] = temp;
         }
      }
      
   }
   
   public void flipX() throws Exception  
   {
     
      for(int row = 0; row < pixels.length/2; row++)
      {
         int[] temp = pixels[row];
         pixels[row] = pixels[pixels.length - row - 1];
         pixels[pixels.length - row - 1] = temp;
      }
    }

     

} 