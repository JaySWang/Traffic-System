package mapInfo;

import java.util.ArrayList;
import java.util.List;

public class MapInfoManagement {
  List<Junction> junctions = new ArrayList<Junction>();
  List<Exit> exits = new ArrayList<Exit>();

  private static MapInfoManagement mig;
  
  
  private MapInfoManagement(){
	 
	  
  }
  
  public static MapInfoManagement getInstance(){
	  if(mig==null){
		  mig = new MapInfoManagement();
	  }
	  
	  return mig;
  }
  
  
  
  
public List<Junction> getJunctions() {
	return junctions;
}

public void setJunctions(List<Junction> junctions) {
	this.junctions = junctions;
}
	
  
 public void addJunction(Junction j){
	 junctions.add(j);
 }

public List<Exit> getExits() {
	return exits;
}

public void setExits(List<Exit> exits) {
	this.exits = exits;
}
  
public void addExit(Exit e){
	exits.add(e);
}
	
	
}
