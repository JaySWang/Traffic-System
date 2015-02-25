package observer;

public interface ITrafficLightObservable {

	
	public void registerObserver(ITrafficLightObserver ob);
	public void notifyObservers();
	
}
