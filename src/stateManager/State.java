package stateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import models.*;
import views.*;

public class State implements Serializable {
	private static final long serialVersionUID = 1L;
	private static String DEFAULT_IMAGE_PATH = "src\\images\\test.jpg";

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

	public ThumbnailView getThumbnail() {
		return thumbnail;
    }

	public void setThumbnail(ThumbnailView thumbnail) {
        this.thumbnail = thumbnail;
    }
	
    public PerspectiveView getPerspective1() {
        return perspective1;
    }

	public void setPerspective1(PerspectiveView perspective1) {
        this.perspective1 = perspective1;
    }

	public PerspectiveView getPerspective2() {
        return perspective2;
    }

	public void setPerspective2(PerspectiveView perspective2) {
        this.perspective2 = perspective2;
    }

	public State(String imagePath) {

		this.thumbnail = new ThumbnailView(new ThumbnailModel(imagePath));
		this.perspective1 = new PerspectiveView(new PerspectiveModel(imagePath));
		this.perspective2 = new PerspectiveView(new PerspectiveModel(imagePath));
	}

	public State(){
		this.thumbnail = new ThumbnailView(new ThumbnailModel(DEFAULT_IMAGE_PATH));
        this.perspective1 = new PerspectiveView(new PerspectiveModel(DEFAULT_IMAGE_PATH));
        this.perspective2 = new PerspectiveView(new PerspectiveModel(DEFAULT_IMAGE_PATH));
	}
}
