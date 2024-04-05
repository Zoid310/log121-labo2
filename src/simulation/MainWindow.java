package simulation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
 
public class MainWindow extends JFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 1 : LOG121 - Simulation";
	private static final Dimension DIMENSION = new Dimension(700, 700);

	private MainPanel mainPannel;
	private MenuWindow menuWindow;

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {
			repaint();
		}
	}

	public MainWindow() {
		MainPanel mainPanel = new MainPanel();
		MenuWindow menuWindow = new MenuWindow();

		add(mainPanel);
		add(menuWindow, BorderLayout.NORTH);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
}
