package observer;

public interface IVehicleObservable {
	public void registerObserver(IVehicleObserver ob);
	public void notifyObservers();
}
