package Test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.sikuli.script.*;
import org.junit.Test;

public class MainViewTestTest {

	@Test
	public void testMain() {
		//fail("Not yet implemented");
		try{
			Screen s = new Screen();
			
			s.click("pic\\on.JPG");
			Assert.assertNotNull(s.exists("pic\\red.JPG"));
		}catch(Exception e){
			
		}
	}

}
