package views;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import models.ThumbnailModel;
import observer.Observer;
import observer.Subject;

/**
 * Class representing a view for a thumbnail.
 * This class extends JPanel and implements the Observer interface.
 */
public class ThumbnailView extends JPanel implements Observer {

    private ThumbnailModel model;
    private JLabel imageLabel;

    /**
     * Constructor for ThumbnailView.
     * Initializes the model and adds this view as an observer.
     * @param model the model to be observed
     */
    public ThumbnailView(ThumbnailModel model) {
        this.model = model;
        this.model.add(this);
        ImageIcon imageIcon = new ImageIcon(model.getImagePath());
        Image image = imageIcon.getImage();
        ImageIcon newImageIcon = new ImageIcon(image.getScaledInstance((1000 / 3) - 12, 500/3, ABORT));
        imageLabel = new JLabel(newImageIcon);
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Returns the model associated with this view.
     * @return the model
     */
    public ThumbnailModel getModel() {
        return this.model;
    }

    /**
     * Updates the view when the model changes.
     * @param subject the subject that this observer is observing
     */
    @Override
    public void update(Subject subject) {
        this.removeAll(); 

        if (model.getImagePath() != null) {
            ImageIcon imageIcon = new ImageIcon(model.getImagePath());
            Image image = imageIcon.getImage();
            ImageIcon newImageIcon = new ImageIcon(image.getScaledInstance((1000 / 3) - 12, 500/3, ABORT));
            imageLabel = new JLabel(newImageIcon);
            add(imageLabel, BorderLayout.CENTER);
        } else {
            add(new JLabel("Aucune perspective disponible"), BorderLayout.CENTER);
        }
        
        revalidate();
        repaint();
    }

    /**
     * Method to display the view.
     */
    public void display(){
        
    }

    /**
     * Paints the component.
     * @param g the Graphics object to protect
     */
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
