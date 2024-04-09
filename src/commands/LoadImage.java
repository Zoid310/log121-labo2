package commands;

import models.PerspectiveModel;
import views.PerspectiveView;

public class LoadImage implements Command {

	private String imagePath;
    private PerspectiveModel model;

    public LoadImage(String imagePath, PerspectiveModel model) {
        this.imagePath = imagePath;
        this.model = model;
    }

    @Override
    public void execute(PerspectiveModel perspective) {
        model.setImagePath(imagePath);
    }

}
