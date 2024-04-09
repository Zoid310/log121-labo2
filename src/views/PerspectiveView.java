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
                System.out.println("Molette de la souris déplacée");
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    System.out.println("Zoom avant");
                    controller.handleZoomIn();
                } else {
                    System.out.println("Zoom arrière");
                    controller.handleZoomOut();
                }
            }
        });
        
    }
    
    public void loadImage() {

		
        
    }
    
    @Override
    public void update(Subject subject) {
        
        if (subject == model) {
            display(); 
        }
    }
    
    

    public void display() {
        this.removeAll(); 

    if (model.getImagePath() != null) {
        ImageIcon imageIcon = new ImageIcon(model.getImagePath());
        Image originalImage = imageIcon.getImage();

 
        int newWidth = (int) (originalImage.getWidth(null) * model.getZoom());
        int newHeight = (int) (originalImage.getHeight(null) * model.getZoom());

       
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(resizedImage));

        add(imageLabel, BorderLayout.CENTER);
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
