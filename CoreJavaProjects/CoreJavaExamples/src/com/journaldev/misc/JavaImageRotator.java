package com.journaldev.misc;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JavaImageRotator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("/Users/pankaj/Desktop/images/Eclipse-Juno.png"));
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.PI, img.getWidth(null)/2, img.getHeight(null)/2);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage tempImg = op.filter(img, null);
		 ImageIO.write(tempImg, "png", new File("/Users/pankaj/Desktop/images/rotate/Eclipse-Juno.png"));
	}

}
