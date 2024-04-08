package observer;

import java.util.ArrayList;

public abstract class Subject {
	
	private ArrayList<Observer> observers;
	
	public void add(Observer o) {
		observers.add(o);
	}
	
	public void remove(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}

	public Subject(){
		observers = new ArrayList<>();
	}
}
