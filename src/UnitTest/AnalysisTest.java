package UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import log.LogManagement;
import log.TrafficMgtPolicyLog;
import log.VehicleLog;
import model.Analysis;

import org.junit.Assert;
import org.junit.Test;

public class AnalysisTest {

	@Test
	public void testGetAverageSpeedByVId() {
		LogManagement lm = LogManagement.getInstance();
		Analysis a = new Analysis();
		
		
		VehicleLog v1 = new VehicleLog(1, 2, 4,10,66);
		VehicleLog v2 = new VehicleLog(1, 2, 4,20,66);
		
		lm.addLog(v1);
		lm.addLog(v2);
		
		Assert.assertTrue(15.0 == a.getAverageSpeedByVId(1));
		
	}

	@Test
	public void testGetAverageSpeedByTMPId() {
		//fail("Not yet implemented");
		LogManagement lm = LogManagement.getInstance();
		Analysis a = new Analysis();
		VehicleLog v1 = new VehicleLog(1, 2, 4,10,15);
		VehicleLog v2 = new VehicleLog(1, 2, 4,20,20);
		VehicleLog v3 = new VehicleLog(2, 2, 4,30,35);
		lm.addLog(v1);
		lm.addLog(v2);
		lm.addLog(v3);
		TrafficMgtPolicyLog tl = new TrafficMgtPolicyLog(1,1,1,0,20);
		lm.addLog(tl,1);
		
		Assert.assertTrue(15.0 == a.getAverageSpeedByTMPId(0));
		
	

		
	}

	@Test
	public void testGetCongestionRateByTMPId() {
		//fail("Not yet implemented");
	}

}
