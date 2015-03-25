package Controller;

import constValue.ConstValues;
import modelInterface.ITrafficCondition;
import ControllerInterface.ITrafficConditionController;

public class TrafficConditionController implements ITrafficConditionController {

	
	ITrafficCondition tc;
	
	public  TrafficConditionController(ITrafficCondition tc){
		this.tc = tc;
	}
	
	
	@Override
	public void setDensity(String level) {
		int densityLevel = ConstValues.Low;
    if(level.endsWith("low")){
    	densityLevel = ConstValues.Low;		
		}
	
    else if(level.endsWith("medium")){
    	densityLevel = ConstValues.Medium;		

	}
    else if(level.endsWith("high")){
    	densityLevel = ConstValues.High;		

	}
    tc.setDensity(densityLevel);
	}

	@Override
	public void setSpeedLimit(String speedLimit) {
		int limit;
		if(speedLimit.endsWith("N/A"))
			limit = -1;//there is no speedLimit
		else{
			limit =  Integer.parseInt(speedLimit);
		}
		
       tc.setSpeedLimit(limit);
       
       
	}


	@Override
	public void newPrivilegeVehicle() {
		tc.newPrivilegeVehicle();		
	}

}
