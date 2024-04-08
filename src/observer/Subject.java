package observer;

import java.util.List;
import java.util.ArrayList;

public abstract class Subject {
	
	
	private List<Observer> observers = new ArrayList<>();
	
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
}
