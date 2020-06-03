package Tests;


import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import seleniumClases.HomePage;
import seleniumClases.HomePage.Classes;



public class TestUno {

HomePage homepage;
Calendar departure;
Calendar arrival;

@Before
public void before() {
	
	
	homepage = new HomePage();
	
	departure= Calendar.getInstance(); 
	  departure.add(Calendar.DAY_OF_MONTH, 1);
	  departure.add(Calendar.MONTH, 3);
	  
	 arrival= Calendar.getInstance(); 
	  arrival.add(Calendar.DAY_OF_MONTH, 2);
	  arrival.add(Calendar.MONTH, 4);
	
	
}


	@Test
public	void test() {
	
		
    homepage.selectOrigin("Londres");
    homepage.selectDestination("Brasil");
    homepage.selectDepartureDate(departure);
    homepage.selectArrivalDate(arrival);
    homepage.addAdultPassenger(3);
    homepage.substractAdultPassenger();
    homepage.selectAClass(Classes.Turista);
    homepage.search();

 

  
  
	}
	
 	@After
 	public void close() {
 		
 	
 	homepage.close();
 	}
 	
 	


	

}
