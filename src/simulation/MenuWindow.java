package simulation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import models.Image;
import models.PerspectiveModel;
import models.ThumbnailModel;
import stateManager.*;
import views.PerspectiveView;
import views.ThumbnailView;

public class MenuWindow extends JMenuBar {
	private static final String FILE_MENU_TITLE = "Fichier";
	private static final String FILE_MENU_SAVE = "Sauvegarder perspective";
	private static final String FILE_MENU_LOAD = "Charger perspective";
	private static final String FILE_MENU_LOAD_IMAGE = "Charger image";
	private static final String EDIT_MENU = "Édition";
	private static final String EDIT_UNDO = "Défaire";

	public MenuWindow() {
		addFileMenu();
		addEditMenu();
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	public void addEditMenu() {
		JMenu editMenu = new JMenu(EDIT_MENU);
		JMenuItem editUndo = new JMenuItem(EDIT_UNDO);
		editUndo.addActionListener((ActionEvent e) -> {
			// TODO: Undo the last action.
		});
		add(editMenu);
	}

	public void addFileMenu() {
		JMenu fileMenu = new JMenu(FILE_MENU_TITLE);
		JMenuItem menuSave = new JMenuItem(FILE_MENU_SAVE);
		JMenuItem menuLoadStateFile = new JMenuItem(FILE_MENU_LOAD);
		JMenuItem menuLoadImage = new JMenuItem(FILE_MENU_LOAD_IMAGE);

		menuLoadStateFile.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Sélectionnez un fichier d'état'");
			fileChooser.setAcceptAllFileFilterUsed(false);

			// FileNameExtensionFilter filtre = new FileNameExtensionFilter(".txt", "txt");
			// fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());

				try {
                    StateManager.loadStateFromFile(selectedFile.getAbsolutePath());
                } catch (IOException | ClassNotFoundException ioe) {
                    ioe.printStackTrace();
                }

			}
		});

		menuSave.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showSaveDialog(null);

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();

				try{
					StateManager.saveStateToFile(file, State.getActiveState());
					System.out.println("File Saved as: " + file.getName());
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
			} else {
				System.out.println("Save command canceled");
			}
		});

		menuLoadImage.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Sélectionnez une image");
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".png, .jpg", "png,jpg");
			fileChooser.addChoosableFileFilter(filter);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
				State.setActiveState(new State(selectedFile.getAbsolutePath()));
			}
			else{
				System.out.println("No file selected");
			}

			File imageFile = fileChooser.getSelectedFile();
			State activeState = State.getActiveState();
			activeState.getThumbnail().getModel().setImagePath(imageFile.getAbsolutePath());
			activeState.getPerspective1().getModel().setImagePath(imageFile.getAbsolutePath());
			activeState.getPerspective2().getModel().setImagePath(imageFile.getAbsolutePath());
		});

		fileMenu.add(menuLoadStateFile);
		fileMenu.add(menuSave);
		fileMenu.add(menuLoadImage);
		
		add(fileMenu);
		
	}

	private void addClipboardMenu() {
        JMenu clipboardMenu = new JMenu("Presse-Papier");
        this.add(clipboardMenu);
    }
	
}
