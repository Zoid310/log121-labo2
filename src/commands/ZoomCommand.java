package commands;

import models.PerspectiveModel;
import views.PerspectiveView;

public class ZoomCommand implements Command {

    private double zoomAmount;
    private PerspectiveModel model;

    public ZoomCommand(double zoomAmount, PerspectiveModel model) {
        this.zoomAmount = zoomAmount;
        this.model = model;
    }

	@Override
	public void execute(PerspectiveView perspective) {
		double currentZoom = model.getZoom();
		double newZoom = currentZoom * zoomAmount; 
		model.setZoom(newZoom); 
	}
}
