package model;

import java.awt.Point;

public class Area {
	private Point topLeft;
	private Point botRight;

	public Area(Point p1, Point p2) {
		int left = Math.min(p1.x, p2.x);
		int right = Math.max(p1.x, p2.x);
		int top = Math.min(p1.y, p2.y);
		int bot = Math.max(p1.y, p2.y);
		topLeft = new Point(top, left);
		botRight = new Point(bot, right);
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getBotRight() {
		return botRight;
	}

	public int width() {
		return botRight.x - topLeft.x;
	}

	public int height() {
		return botRight.y - topLeft.y;
	}

	public int surfaceArea() {
		return width() * height();
	}

	public boolean contains(Point p) {
		return topLeft.x <= p.x && p.x <= botRight.x && topLeft.y <= p.y && p.y <= botRight.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((botRight == null) ? 0 : botRight.hashCode());
		result = prime * result + ((topLeft == null) ? 0 : topLeft.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Area) {
			Area other = (Area) obj;
			return other.getBotRight().equals(botRight) && other.getTopLeft().equals(topLeft);
		}
		return false;
	}

}
