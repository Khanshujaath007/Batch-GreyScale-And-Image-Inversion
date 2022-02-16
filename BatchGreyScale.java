
import edu.duke.*;
import java.io.*;

public class BatchGreyScale {
    // selecting image we want to greyscale
    public ImageResource makeGrey(ImageResource inImage){
        //creating a blank image
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //looping greyscale logic on all the pixels in outImage
        for (Pixel pixel: outImage.pixels()){
            //look at corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // get total by adding inpixel's red, gree, blue
            //divide total by 3 to get average
            int Avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            //set Pixel's value to avg
            pixel.setRed(Avg);
            pixel.setGreen(Avg);
            pixel.setBlue(Avg);
        }
        //greyscale image is stored in outImage
        return outImage;
    }
    
    // testing makegrey method
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource grey = makeGrey(ir);
        grey.draw();
    }
    
    //GreySacle multiple Files
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            //Store converted grey Image 
            ImageResource grey = makeGrey(inImage);
            String fname = inImage.getFileName();
            //Rename the converted image with grey as prefix
            String newname = "grey-" + fname;
            grey.setFileName(newname);
            grey.draw();
            grey.save();
        }
    }
    
    // Save Multiple Images with Different names
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            //Rename the converted image with copy as prefix
            String newname = "copy-" + fname;
            image.setFileName(newname);
            image.save();
            image.draw();
        }
    }
}
