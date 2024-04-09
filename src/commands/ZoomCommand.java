package commands;

import views.PerspectiveView;
import models.*;

public class ZoomCommand implements Command {

	private double zoomAmount;
	private PerspectiveModel model;

	public ZoomCommand(double zoomAmount,PerspectiveModel model){
		this.zoomAmount = zoomAmount;
        this.model = model;
	}
	
	@Override
	public void execute(PerspectiveModel perspective) {
		
	}
	
	public void changeZoomAmount(int newAmount,PerspectiveModel perspective) {
		
	}
}
