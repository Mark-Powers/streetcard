package model;

import java.awt.Point;

public class DrawableWithLocation {
	public Drawable drawable;
	public Point point;
	
	public DrawableWithLocation(Drawable drawable, Point point){
		this.drawable = drawable;
		this.point = point;
	}
}
