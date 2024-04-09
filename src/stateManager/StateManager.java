package stateManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class that manages the saving and loading of states.
 */
public class StateManager {

	/**
	 * Saves a given state to a file.
	 * @param file the file to save the state to
	 * @param state the state to save
	 * @throws IOException if an I/O error occurs
	 */
	public static void saveStateToFile(File file, State state) throws IOException {

		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(state);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
		} else {
			System.out.println("File already exists");
		}
	}

	/**
	 * Loads a state from a file and sets it as the active state.
	 * @param fileName the name of the file to load the state from
	 * @throws IOException if an I/O error occurs
	 * @throws ClassNotFoundException if the class of a serialized object cannot be found
	 */
	public static void loadStateFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		State state = (State) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		State.setActiveState(state);
	}
}
