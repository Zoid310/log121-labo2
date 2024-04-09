package commands;

import models.PerspectiveModel;
import views.PerspectiveView;

public class ZoomCommand implements Command {

    private double zoomAmount;
    private PerspectiveView view;
	private double previousZoom;

    public ZoomCommand(double zoomAmount, PerspectiveView pv) {
        this.zoomAmount = zoomAmount;
        this.view = pv;
		this.previousZoom = pv.getModel().getZoom();
    }

    public void execute() {
      double currentZoom = view.getModel().getZoom();
      double newZoom = currentZoom * zoomAmount; 
      if (newZoom < PerspectiveModel.MIN_ZOOM) {
          newZoom = PerspectiveModel.MIN_ZOOM; // Enforce a minimum zoom level
      }
      view.getModel().setZoom(newZoom);
    }

	public void undo(){
		view.getModel().setZoom(previousZoom);
	}
}
