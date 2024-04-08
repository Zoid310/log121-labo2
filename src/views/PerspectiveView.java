package views;

import controller.PerspectiveController;
import models.PerspectiveModel;
import observer.Observer;
import observer.Subject;
import models.Image;

import javax.swing.*;
import java.awt.*;

public class PerspectiveView extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;    
    private PerspectiveModel model;
    private PerspectiveController controller;
    
    public PerspectiveView(PerspectiveModel modelInstance, Image cImage) {
        super();
        this.model = modelInstance;
        this.controller = new PerspectiveController(cImage);
        this.model.add(this); // S'abonner aux mises a jour du modele
        
        setLayout(new BorderLayout());
    }
    
    public void loadImage() {

		//TODO
        
    }
    
    @Override
    public void update(Subject subject) {
        // appelle quand modele notifie un changement
        display(); 
    }
    
    public void display() {
        
        this.removeAll(); 

        if (model.getImage() != null) {
            // afficher limage
            JLabel label = new JLabel(new ImageIcon(model.getImage().getPath()));
            add(label, BorderLayout.CENTER);
        } else {
            // message si aucune image nest chargee
            add(new JLabel("Aucune perspective disponible"), BorderLayout.CENTER);
        }
        
        revalidate();
        repaint();
    }
}
