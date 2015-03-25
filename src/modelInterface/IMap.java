package modelInterface;

import java.util.List;

import mapInfo.Entrance;
import model.TrafficPolicyManagement;
import view.MapView;

public interface IMap {

	
	
	
	public MapView setMap(String map);
	
	public List<Entrance> getEntrance();
	
	public TrafficPolicyManagement getTPmgt();
}
