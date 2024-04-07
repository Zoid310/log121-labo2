package stateManager;

import java.io.Serializable;

import views.*;

public class State implements Serializable{
	
	private ThumbnailView thumbnail;
	private PerspectiveView perspective1;
	private PerspectiveView perspective2;
	
	public State(ThumbnailView cThumbnail, PerspectiveView cPerspective1, PerspectiveView cPerspective2) {
		
        this.thumbnail = cThumbnail;
        this.perspective1 = cPerspective1;
        this.perspective2 = cPerspective2;
		
	}
}
