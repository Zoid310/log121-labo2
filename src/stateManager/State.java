package stateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import models.*;
import views.*;

public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	private static State activeState;
	private ThumbnailView thumbnail;
	private PerspectiveView perspective1;
	private PerspectiveView perspective2;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
    }

	public static State getActiveState() {
		return activeState;
    }

	public static void setActiveState(State newState) {
        activeState = newState;
    }

	public State(Image image) {

		this.thumbnail = new ThumbnailView(new ThumbnailModel(image));
		this.perspective1 = new PerspectiveView(new PerspectiveModel(image), image);
		this.perspective2 = new PerspectiveView(new PerspectiveModel(image), image);
	}
}
