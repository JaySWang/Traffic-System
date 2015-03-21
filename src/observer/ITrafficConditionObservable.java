package observer;

public interface ITrafficConditionObservable {
	public void registerConditionObserver(ITrafficConditionObserver ob);
	public void notifyConditionObservers();
}
