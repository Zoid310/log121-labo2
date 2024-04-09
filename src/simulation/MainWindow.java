package simulation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 2 : LOG121 - Simulation";
	private static final Dimension DIMENSION = new Dimension(1000, 500);

	private MainPanel mainPanel;
	private MenuWindow menuWindow;

	public MainWindow() {
		
		mainPanel = new MainPanel(); 
		menuWindow = new MenuWindow();

		mainPanel.setPreferredSize(DIMENSION);
		pack();

		setJMenuBar(menuWindow); 
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setVisible(true); 
	}
}
