package property;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany m;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("NewJeansCo", "12345",5);
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("YourFirstHouse", "CollegePark", 1000, "You",1,2,3,3);
		p2 = new Property ("SecondHouse", "Seoul", 1500, "Daniel",1,6,3,2);
		p3 = new Property ("Restaurant", "Rockville", 2000.00, "Danyeol",5,6,1,1);
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=null;
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		p4 = new Property ("ThirdHouse", "CollegePark", 1400, "Dawn", 0, 0, 1, 1);
		p5 = new Property ("Barbershop", "Centreville", 1300, "Lisa", 7, 7, 1, 1);
		p6 = new Property("FourthHouse", "TakomaPark", 1600, "Tae", 6, 6, 1, 1);
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),2000.0,0);
	}

	@Test
	public void testTotalRent() {
		
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),4500.0,0);
	}

 }
