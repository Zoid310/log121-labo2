package simulation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

import models.PerspectiveModel;
import models.ThumbnailModel;
import stateManager.State;
import views.*;

public class MainPanel extends JPanel implements EventListener {

    private static final int SUBPANELS_AMNT = 3;
    private Image image;

    public MainPanel() {
        setBackground(Color.WHITE);

        // try {
        // BufferedImage cImage = ImageIO.read(new File("/chemin/vers/.png"));
        // ImageIcon imageIcon = new ImageIcon(cImage);
        // ThumbnailModel model = new ThumbnailModel(imageIcon);
        // thumbnail = new ThumbnailView(model);
        // this.add(thumbnail);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        setLayout(new GridLayout(0, SUBPANELS_AMNT));
        State.setActiveState(new State());
        add(State.getActiveState().getThumbnail());
        add(State.getActiveState().getPerspective1());
        add(State.getActiveState().getPerspective2());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
