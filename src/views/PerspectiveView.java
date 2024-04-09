package views;

import controller.PerspectiveController;
import models.PerspectiveModel;
import observer.Observer;
import observer.Subject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelListener;
import java.awt.image.*;


import java.awt.event.MouseWheelEvent;


import java.io.File;

public class PerspectiveView extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;    
    private PerspectiveModel model;
    private PerspectiveController controller;
    private JLabel imageLabel;

    
    public PerspectiveView(PerspectiveModel modelInstance) {
        super();
        this.model = modelInstance;
        this.controller = new PerspectiveController(this);
        this.model.add(this); // S'abonner aux mises a jour du modele
        ImageIcon imageIcon = new ImageIcon(model.getImagePath());
        java.awt.Image image = imageIcon.getImage();
        ImageIcon newImageIcon = new ImageIcon(image.getScaledInstance((1000 / 3) - 12, 500/3, ABORT));
        imageLabel = new JLabel(newImageIcon);
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);


        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    controller.handleZoomIn(); // Zoom avant
                } else {
                    controller.handleZoomOut(); // Zoom arrière
                }
            }
        });
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
        // BufferedImage image = null;
        // try {
        //     image = ImageIO.read(new File(model.getImagePath()));
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // g.drawImage(image, model.getPosition()[0], model.getPosition()[1], this.getWidth() - borderThickness, (this.getHeight() / 3) - borderThickness, null);
    }
}
