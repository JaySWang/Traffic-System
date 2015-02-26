package modelInterface;

import java.util.List;

public interface ITrafficLight {

//return states of all lights in a road junction	
public List<Integer> getStates();

//for the light
public void setInterval(int sec);


public void off();
public void on();
public int getNo();
public int getNumberOfLights();

	
	
	
}
