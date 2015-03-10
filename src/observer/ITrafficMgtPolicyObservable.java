package observer;

public interface ITrafficMgtPolicyObservable {
	public void registerTMPObserver(ITrafficMgtPolicyObserver ob);
	public void notifyTMPObservers();
}
