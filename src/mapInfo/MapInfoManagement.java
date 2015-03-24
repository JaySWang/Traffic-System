package mapInfo;

import java.util.ArrayList;
import java.util.List;

public class MapInfoManagement {
  List<Junction> junctions = new ArrayList<Junction>();
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
  
	
	
}
