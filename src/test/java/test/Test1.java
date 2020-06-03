
  package test;
  
  
  import java.util.Calendar;
  
  import org.junit.After; import org.junit.Before; import org.junit.Test;
  
  import homePage.HomePage; import homePage.HomePage.Classes;
  
  
  
  public class Test1 {
  
  HomePage homepage; Calendar c;
  
  @Before public void before() {
  
  
  homepage = new HomePage();
  
  c= Calendar.getInstance(); c.add(Calendar.MONTH, 1);
  
  }
  
  
  @Test public void test() {
  
  
  homepage.selectOrigin("Londres"); homepage.selectDestination("Brasil");
  homepage.selectDepartureDate(c); c.add(Calendar.DAY_OF_MONTH, 32);
  homepage.selectArrivalDate(c); homepage.addAdultPassenger(3);
  homepage.substractAdultPassenger(); homepage.selectAClass(Classes.Turista);
  homepage.search();
  
  
  
  
  
  }
  
  
  
  
  @After public void close() {
  
  
  homepage.close(); }
  
  
  
  
  
  
  }
 