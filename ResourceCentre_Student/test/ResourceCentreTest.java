import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
		
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
		
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		
		allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
	
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("test if there is valid Camcorder arraylist to loan from", camcorderList);
		
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		Boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020");
		//normal
		assertTrue("test if an available item is ok to loan", ok);
		//error
		//assertFalse("test if the same item is NOT ok to loan", ok);
		
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020");
		assertFalse("test that unavailable item is NOT ok to loan", ok);
		
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020");
		assertFalse("test that non-existing item is NOT ok to loan", ok);
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("test if there is valid chromebook arraylist to loan from", chromebookList);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		
		Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		
		assertTrue("test if an available item is ok to loan", ok);
		
		//assertFalse("test if the same item is NOT ok to loan", ok);
		
		ResourceCentre.addChromebook(chromebookList, cb2);
		cb2.setIsAvailable(false);
		
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
		assertFalse("test that unavailable item is NOT ok to loan", ok);
		
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020");
		assertFalse("test that non-existing item is NOT ok to loan", ok);
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		  assertNotNull(camcorderList);
		  assertFalse(ResourceCentre.doReturnCamcorder(camcorderList, cc2.getAssetTag()));
		  
		    ResourceCentre.addCamcorder(camcorderList, cc2);
	        ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "24/8/2021");
	        String Camcorder2= ResourceCentre.retrieveAllCamcorder(camcorderList);
	        String testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7","No","24/8/2021",20);
	        assertEquals("Test if cc2 is loaned",Camcorder2,testOutput);
	        
	        ResourceCentre.doReturnCamcorder(camcorderList,"CC0012");
	        String Camcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
	        String testOutput2 = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	        assertEquals("Test if cc2 is now available", Camcorder, testOutput2);
	        
	        assertEquals("Test if cc2 isAvailable is now true",camcorderList.get(0).getIsAvailable(),cc2.getIsAvailable());
		
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		  assertNotNull(chromebookList);
		  
		  assertFalse(ResourceCentre.doReturnChromebook(chromebookList, cb2.getAssetTag()));
		  
		    ResourceCentre.addChromebook(chromebookList, cb2);
	        ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "24/8/2021");
	        String Chromebook2= ResourceCentre.retrieveAllChromebook(chromebookList);
	        String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+","No","24/8/2021","Win 10");
	        assertEquals("Test if cb2 is loaned",Chromebook2,testOutput);
	        
	        ResourceCentre.doReturnChromebook(chromebookList,"CB0012");
	        String Chromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
	        String testOutput2 = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
	        assertEquals("Test if cb2 is now available", Chromebook, testOutput2);
	        
	        assertEquals("Test if cb2 isAvailable is now true",chromebookList.get(0).getIsAvailable(),cb2.getIsAvailable());
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
