package simulation;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;



public class MenuWindow extends JMenuBar{
	private static final String STATE_MENU_TITLE = "État";
	private static final String STATE_MENU_SAVE = "Enregistrer";
	private static final String STATE_MENU_LOAD = "Charger";

	public MenuWindow() {
		addUndoButton();
		addStateManagerMenu();

		addFileMenu();
        addEditMenu();
        addClipboardMenu();
		
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
		JMenuItem menuUndo = new JMenuItem("Undo");
        menuUndo.addActionListener((ActionEvent e) -> {
            //TODO: Undo the last action.
        });
        add(menuUndo);
	}

	public void addStateManagerMenu(){
		JMenu stateMenu = new JMenu(STATE_MENU_TITLE);
		JMenuItem menuSave = new JMenuItem(STATE_MENU_SAVE);
		JMenuItem menuLoad = new JMenuItem(STATE_MENU_LOAD);

		menuLoad.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Sélectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				System.out.println(selectedFile.getAbsolutePath());

				//TODO: Load the selected stateFile.
			}
		});

		menuSave.addActionListener((ActionEvent e) -> {
			//TODO: Save the current state to a file using the StateManager.
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
