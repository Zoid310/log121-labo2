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

public class ThumbnailView extends JPanel implements Observer {

    private ThumbnailModel model;
    private JLabel imageLabel;

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

    public ThumbnailModel getModel() {
        return this.model;
    }

    @Override
    public void update(Subject subject) {
        this.removeAll(); 

        if (model.getImagePath() != null) {
            // afficher limage
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

    public void display(){
        
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
        // g.drawImage(image, 0, (this.getHeight() / 3), this.getWidth() - borderThickness, (this.getHeight() / 3) - borderThickness, null);
    }

}
