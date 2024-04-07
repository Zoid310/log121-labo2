package stateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import views.*;

public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	private ThumbnailView thumbnail;
	private PerspectiveView perspective1;
	private PerspectiveView perspective2;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
    }

	public State(ThumbnailView cThumbnail, PerspectiveView cPerspective1, PerspectiveView cPerspective2) {

		this.thumbnail = cThumbnail;
		this.perspective1 = cPerspective1;
		this.perspective2 = cPerspective2;

	}
}
