package modelInterface;

public interface ITrafficCondition {
	public void setDensity(int level);
	public void setSpeedLimit(int speedLimit);
	
	public int getDensity();
	public int getSpeedLimit();
}
