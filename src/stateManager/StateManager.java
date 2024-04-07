package stateManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StateManager {
	
	public void saveStateToFile(String fileName, State state) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(state);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
	}
	
	public State loadStateFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
    	ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		State state = (State) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		return state;
	}
}
