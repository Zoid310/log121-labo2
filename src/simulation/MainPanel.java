package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import views.*;

public class MainPanel extends JPanel{
	
	private ThumbnailView thumbnail;
	private ArrayList<PerspectiveView> perspectives;
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
}
