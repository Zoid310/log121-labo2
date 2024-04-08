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
	private static final String STATE_MENU_TITLE = "État";
	private static final String STATE_MENU_SAVE = "Enregistrer";
	private static final String STATE_MENU_LOAD = "Charger";

	public MenuWindow() {
		addUndoButton();
		addStateManagerMenu();
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void addFileMenu() {
        JMenu fileMenu = new JMenu("Fichier");
        JMenuItem openItem = new JMenuItem("Ouvrir");
        openItem.addActionListener((ActionEvent e) -> {
            // Logique pour ouvrir un fichier
        });
        fileMenu.add(openItem);
        // Ajoutez d'autres items si nécessaire
        this.add(fileMenu);
    }


	public void addUndoButton() {
		JButton undoBtn = new JButton("Action inverse");
		undoBtn.addActionListener((ActionEvent e) -> {
			// TODO: Undo the last action.
		});
		add(undoBtn);
	}

	public void addStateManagerMenu() {
		JMenu stateMenu = new JMenu(STATE_MENU_TITLE);
		JMenuItem menuSave = new JMenuItem(STATE_MENU_SAVE);
		JMenuItem menuLoad = new JMenuItem(STATE_MENU_LOAD);

		menuLoad.addActionListener((ActionEvent e) -> {
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

		stateMenu.add(menuLoad);
		stateMenu.add(menuSave);
		

		add(stateMenu);
		
	}


	private void addEditMenu() {
        JMenu editMenu = new JMenu("Édition");
        this.add(editMenu);
    }

	private void addClipboardMenu() {
        JMenu clipboardMenu = new JMenu("Presse-Papier");
        this.add(clipboardMenu);
    }
	
}
