package stateManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StateManager {

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

	public static void loadStateFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		State state = (State) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		State.setActiveState(state);
	}
}
