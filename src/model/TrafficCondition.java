package model;

import java.util.ArrayList;


import observer.ITrafficConditionObserver;
import observer.ITrafficConditionObservable;
import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;
import modelInterface.ITrafficCondition;

public class TrafficCondition implements ITrafficCondition,ITrafficConditionObservable,ITrafficMgtPolicyObservable {

	
	static TrafficCondition tc;
	ArrayList<ITrafficMgtPolicyObserver> trafficMgtPolicyObservers = new ArrayList<ITrafficMgtPolicyObserver> ();
	ArrayList<ITrafficConditionObserver> trafficConditionObservers = new ArrayList<ITrafficConditionObserver> ();

	
	int speedLimit = -1;
	int density = 1;
	
	public static TrafficCondition getInstance(){
		if(tc == null){
			tc = new TrafficCondition();
		}
		
		
		return  tc;
	}
	
	private TrafficCondition(){
		super();
	}
	
	@Override
	public int getSpeedLimit(){
		return speedLimit;
		
	}

	@Override
	public void setDensity(int level) {
		density = level;
		notifyTMPObservers();

		notifyConditionObservers();
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;	
		notifyTMPObservers();
		notifyConditionObservers();
	}

	@Override
	public int getDensity() {
		return density;
	}

	
	
	@Override
	public void registerTMPObserver(ITrafficMgtPolicyObserver ob) {
		trafficMgtPolicyObservers.add(ob);		
	}

	@Override
	public void notifyTMPObservers() {

		for(int i = 0;i<trafficMgtPolicyObservers.size();i++){
			trafficMgtPolicyObservers.get(i).update(this);
		}
				
			
	}



	@Override
	public void notifyConditionObservers() {
		for(int i = 0;i<trafficConditionObservers.size();i++){
			trafficConditionObservers.get(i).update(this);
		}
				
	}

	@Override
	public void registerConditionObserver(ITrafficConditionObserver ob) {
		trafficConditionObservers.add(ob);		
	}

}
