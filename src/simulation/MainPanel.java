package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.ThumbnailModel;


import views.*;

public class MainPanel extends JPanel{
	
	private ThumbnailView thumbnail;
	private ArrayList<PerspectiveView> perspectives;
	private Image image;
	

	public MainPanel() {
        setBackground(Color.WHITE);
        
        try {
            BufferedImage cImage = ImageIO.read(new File("/chemin/vers/.png")); 
            ImageIcon imageIcon = new ImageIcon(cImage);
            ThumbnailModel model = new ThumbnailModel(imageIcon); 
            thumbnail = new ThumbnailView(model);
            this.add(thumbnail);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        int borderThickness = 3; 
        g.fillRect(0, 0, getWidth(), borderThickness); 
        g.fillRect(0, getHeight() - borderThickness, getWidth(), borderThickness); 
        g.fillRect(0, 0, borderThickness, getHeight()); 
        g.fillRect(getWidth() - borderThickness, 0, borderThickness, getHeight()); 
    }
	


}
