package commands;

import views.PerspectiveView;

public class ZoomCommand implements Command {

<<<<<<< HEAD
	private double zoomAmount;
	private PerspectiveModel model;

	public ZoomCommand(double zoomAmount,PerspectiveModel model){
		this.zoomAmount = zoomAmount;
        this.model = model;
	}
	
	@Override
	public void execute(PerspectiveModel perspective) {
		model.setZoom(model.getZoom()*zoomAmount);
		model.notifyObservers();
	}
	
	public void changeZoomAmount(int newAmount,PerspectiveModel perspective) {
		this.zoomAmount = newAmount;
=======
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
>>>>>>> 6215db7f28c3e485874303f6510692f93379acf5
	}
}
