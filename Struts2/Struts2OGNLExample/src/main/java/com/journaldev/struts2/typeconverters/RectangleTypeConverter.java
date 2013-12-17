package com.journaldev.struts2.typeconverters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.journaldev.struts2.model.Rectangle;
import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * Custom type converter to convert user input to Rectangle
 * Format is R:x,y where x and y are int defining Rectangle dimensions 
 * @author pankaj
 *
 */
public class RectangleTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] inputs, Class arg2) {
		String input = inputs[0];
		if(!input.startsWith("R:")) throw new TypeConversionException("invalid input");
		input = input.substring(2);
		String[] dimensions = input.split(",");
		int x = Integer.parseInt(dimensions[0]);
		int y = Integer.parseInt(dimensions[1]);
		Rectangle rect = new Rectangle();
		rect.setX(x);
		rect.setY(y);
		return rect;
	}

	@Override
	public String convertToString(Map arg0, Object obj) {
		Rectangle rect = (Rectangle) obj;
		String output = "R:" + rect.getX() + "," + rect.getY();
		return output;
	}

}
