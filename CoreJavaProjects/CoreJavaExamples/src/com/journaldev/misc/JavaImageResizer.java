package com.journaldev.misc;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * This class will resize all the images in a given folder
 * @author pankaj
 *
 */
public class JavaImageResizer {

	public static void main(String[] args) throws IOException {
	
		File folder = new File("/Users/pankaj/Desktop/images");
	    File[] listOfFiles = folder.listFiles();
		System.out.println("Total No of Files:"+listOfFiles.length);
		BufferedImage img = null;
		BufferedImage tempPNG = null;
		BufferedImage tempJPG = null;
		File newFilePNG = null;
		File newFileJPG = null;
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile() && (listOfFiles[i].getName().toLowerCase().endsWith(".png")) || listOfFiles[i].getName().toLowerCase().endsWith(".jpg")) {
		        System.out.println("File " + listOfFiles[i].getName());
		        img = ImageIO.read(new File("/Users/pankaj/Desktop/images/"+listOfFiles[i].getName()));
		        //to maintain the aspect ratio with fixed width of 100 pixels
		        //double aspectRatio = (double) img.getWidth(null)/(double) img.getHeight(null);
		        tempPNG = rotate(img);
		        //tempJPG = resizeImage(img, 100, (int) (100/aspectRatio));
		        newFilePNG = new File("/Users/pankaj/Desktop/images/rotate/"+listOfFiles[i].getName());
		        //newFileJPG = new File("/Users/pankaj/Desktop/images/rotate/"+listOfFiles[i].getName()+"_New.jpg");
		        ImageIO.write(tempPNG, "png", newFilePNG);
		        //ImageIO.write(tempJPG, "jpg", newFileJPG);
		      }
		}
		System.out.println("DONE");
	}

	private static BufferedImage rotateImage(Image img) {
		int width = img.getWidth(null);
		int height=img.getHeight(null);
		AffineTransform at = new AffineTransform();
		final BufferedImage bufferedImage = new BufferedImage(height,width,BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics2D = bufferedImage.createGraphics();
		//at.translate(width/2, width/2);
		at.rotate(Math.PI/2,width/2,height/2);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		//at.translate(-height/2, -width/2);
		graphics2D.drawImage(img, at, null);
        graphics2D.dispose();
        return op.filter(bufferedImage, null);
       // return bufferedImage;
	}
	
	private static BufferedImage rotate(BufferedImage img){
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.PI/2, img.getWidth(null)/2, img.getHeight(null)/2);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(img, null);
	}

	/**
	 * This function resize the image file and returns the BufferedImage object that can be saved to file system.
	 */
	public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
}
