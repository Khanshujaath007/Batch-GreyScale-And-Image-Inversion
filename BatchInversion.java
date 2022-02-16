
import edu.duke.*;
import java.io.*;

public class BatchInversion {
 public ImageResource makeInversion(ImageResource NormalImg){
     ImageResource InvImage = new ImageResource(NormalImg.getWidth(), NormalImg.getHeight());
     for(Pixel pixel : InvImage.pixels()){
         Pixel NormalPixel = NormalImg.getPixel(pixel.getX(), pixel.getY());
         
         
         //setting pixels to inverted value of normal image
         pixel.setRed(255-NormalPixel.getRed());
         pixel.setGreen(255-NormalPixel.getGreen());
         pixel.setBlue(255-NormalPixel.getBlue());
     } 
     //inverted InvImage is returned
     return InvImage;
 }
 
 //testing makeInversion() 
 public void testInversion(){
        ImageResource ir = new ImageResource();
        ImageResource InvertedImage = makeInversion(ir);
        InvertedImage.draw();
    }
    

    // Inverting Multiple Images and saving with prefix Inverted 
 public void selectAndConvert(){
      DirectoryResource dr = new DirectoryResource();
      for(File f: dr.selectedFiles()){
            ImageResource NormalImage = new ImageResource(f);
            //InvImage Stores the inverted image
            ImageResource InvImage = makeInversion(NormalImage);
            //fname gets the file name 
            String fname = NormalImage.getFileName();
            //newname stores inverted prefix
            String newname = "Inverted-" + fname;
            //InvImage is set to new file name
            InvImage.setFileName(newname);
            InvImage.draw();
            //saving InvImage
            InvImage.save();
        }
 }
}
