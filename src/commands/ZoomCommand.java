package commands;

import views.PerspectiveView;

public class ZoomCommand implements Command {

    private double zoomAmount;
    private PerspectiveView view;

    public ZoomCommand(double zoomAmount, PerspectiveView pv) {
        this.zoomAmount = zoomAmount;
        this.view = pv;
    }

	@Override
	public void execute() {
		double currentZoom = this.view.getModel().getZoom();
		double newZoom = currentZoom * zoomAmount; 
		view.getModel().setZoom(newZoom); 
	}
}
