/*package test;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homePage.HomePage;

public class Test3 {

HomePage homepage;
Calendar c;
@Before
public void before() {
	
	
	homepage = new HomePage();
	c= Calendar.getInstance(); 
	 c.add(Calendar.DAY_OF_MONTH, 1);
}
	
	
	@Test
	public	void test(){
		
			
	    homepage.selectOrigin("Cordoba");
	    homepage.selectNoDestination(true);
	    homepage.selectDepartureDate(c);
	    c.add(Calendar.DAY_OF_MONTH, 60);
	    homepage.selectArrivalDate(c);
	    c.add(Calendar.DAY_OF_MONTH, -30);
	    homepage.selectArrivalDate(c);
	    homepage.search();
	}
	 
	    @After
	    
	 	public void close() {
homepage.close();
	 	}
	 	
	 	
	  
	  
}
*/