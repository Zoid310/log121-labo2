package views;

import controller.PerspectiveController;
import models.PerspectiveModel;
import observer.Observer;
import observer.Subject;
import models.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import java.io.File;

public class PerspectiveView extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;    
    private PerspectiveModel model;
    private PerspectiveController controller;
    
    public PerspectiveView(PerspectiveModel modelInstance) {
        super();
        this.model = modelInstance;
        this.controller = new PerspectiveController(this);
        this.model.add(this); // S'abonner aux mises a jour du modele
        
        setLayout(new BorderLayout());
    }
    
    public void loadImage() {

		
        
    }
    
    @Override
    public void update(Subject subject) {
        // appelle quand modele notifie un changement
        display(); 
    }
    

    public void display() {
        
        this.removeAll(); 

        if (model.getImagePath() != null) {
            // afficher limage
            JLabel label = new JLabel(new ImageIcon(model.getImagePath()));
            add(label, BorderLayout.CENTER);
        } else {

            add(new JLabel("Aucune perspective disponible"), BorderLayout.CENTER);
        }
        
        revalidate();
        repaint();
    }

    public PerspectiveModel getModel() {
        return this.model;
    }

    public void setModel(PerspectiveModel model) {
        this.model = model;
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
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(model.getImagePath()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        g.drawImage(image, model.getPosition()[0], model.getPosition()[1], this.getWidth() - borderThickness, (this.getHeight() / 3) - borderThickness, null);
    }
}
