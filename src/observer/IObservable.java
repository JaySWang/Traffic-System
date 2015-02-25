package observer;

public interface IObservable {

	public void registerObserver(ITrafficLightObserver ob);
	public void notifyObservers();
	
	
	
}
