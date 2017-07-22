package model;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Game {
	public abstract boolean isOver();

	public abstract Player getWinner();

	public abstract void onGameOver();

	public abstract void startGame();

	public abstract ArrayList<DrawableWithLocation> getDrawableLocations();

	public abstract boolean play(Point point, Card c);
}
