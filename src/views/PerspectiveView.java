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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;



import java.io.File;
import java.io.IOException;

public class PerspectiveView extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    private PerspectiveModel model;
    private PerspectiveController controller;
    private JLabel imageLabel;

    public PerspectiveView(PerspectiveModel modelInstance) {
        super(new GridBagLayout()); //ajout
        this.model = modelInstance;
        this.controller = new PerspectiveController(this);
        this.model.add(this); // S'abonner aux mises a jour du modele
        ImageIcon imageIcon = new ImageIcon(model.getImagePath());
        java.awt.Image image = imageIcon.getImage();
        ImageIcon newImageIcon = new ImageIcon(image.getScaledInstance((1000 / 3) - 12, 500 / 3, ABORT));
        imageLabel = new JLabel(newImageIcon);
        imageLabel.setLocation(model.getPosition());
        imageLabel.setSize(new Dimension(1000 / 3, 500 / 3));

        add(imageLabel);

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

        /*addMouseMotionListener( new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                controller.handleTranslate(e.getX() - (imageLabel.getWidth() / 2), e.getY() - (imageLabel.getHeight() / 2));
            }
    
            @Override
            public void mouseMoved(MouseEvent e) {
    
            }
    
        });*/


        addMouseMotionListener(new MouseAdapter() {
            private Point lastDragPoint = null;
        
            @Override
            public void mousePressed(MouseEvent e) {
                lastDragPoint = e.getPoint();
            }
        
            @Override
            public void mouseDragged(MouseEvent e) {
                if (lastDragPoint == null) {
                    lastDragPoint = e.getPoint();
                    return;
                }
                int deltaX = e.getX() - lastDragPoint.x;
                int deltaY = e.getY() - lastDragPoint.y;
                lastDragPoint = e.getPoint();
                controller.handleTranslate(deltaX, deltaY);
            }
        });

    }

    @Override
    public void update(Subject subject) {
        // appelle quand modele notifie un changement
        display();
    }

    public void display() {
        try {
            BufferedImage fullImage = ImageIO.read(new File(model.getImagePath()));
            int visibleWidth = (int) (this.getWidth() / model.getZoom());
            int visibleHeight = (int) (this.getHeight() / model.getZoom());
            int x = Math.max(0, Math.min(model.getPosition().x, fullImage.getWidth() - visibleWidth));
            int y = Math.max(0, Math.min(model.getPosition().y, fullImage.getHeight() - visibleHeight));
            BufferedImage visibleImage = fullImage.getSubimage(x, y, visibleWidth, visibleHeight);
            Image scaledImage = visibleImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
    
            // Center imageLabel inside PerspectiveView
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.CENTER;
            imageLabel.setSize(new Dimension(visibleWidth, visibleHeight));
            this.add(imageLabel, gbc);
    
        } catch (IOException e) {
            e.printStackTrace();
            imageLabel.setIcon(null);
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
        // image = ImageIO.read(new File(model.getImagePath()));
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }
        // g.drawImage(image, model.getPosition()[0], model.getPosition()[1],
        // this.getWidth() - borderThickness, (this.getHeight() / 3) - borderThickness,
        // null);
    }
}
