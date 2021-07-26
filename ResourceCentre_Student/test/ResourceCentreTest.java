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
		
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cc1, chromebookList.get(0));
		
		//Add another item. test The size of the list is 2?
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
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
				String testOutput = "";
				assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CB0011", "My Google Chromebook 1st", "Yes","", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CB0012", "SAMSUNG Chromebook 4+", "Yes","", "Win 10");
	
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
		
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		
		// BOUNDARY 
		// test if the item list is not null but empty 
		// null means non existing 
		// empty means list exists but has nothing inside
		
		assertNotNull("Test if there is a Camcorder arraylist to loan for", camcorderList);
		
		// add a camcorder cc1 so we can loan it out 
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		boolean isLoan = ResourceCentre.doLoanCamcorder(camcorderList, "cc1", "8-8-2020");
		assertTrue("Test if an available item is ok to loan?", isLoan);
		
		// Test if can loan out the camcorder added
		// STEP1: Retrieve item added
		// HINT1-1: reference the ResourceCentre.doLoanCamcorder method to understand the input parameters required
		// HINT1-2: does the ResourceCentre.doLoanCamcorder method has a return value? If so, what do you need to do?
		// HINT1-3: What is public static boolean?
		// STEP2: From item retrieved, test if item is available for loan
		// HINT2-1: which assertion method to use?
		// HINT2-2: link STEP 1 and STEP 2
		
		isLoan = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020");
		
		//////////////
		//error //
		//////////////
		
		//STEP3: Retrieve item added like above
		//STEP4: Test if item is not available for loan
		//HINT4-1: which assertion method to use?
		assertFalse("Test if the same item is not ok to loan again?", isLoan);
		
		//////////////
		//error //
		//////////////
		
		//STEP5: add camcorder cc2
		ResourceCentre.addCamcorder(camcorderList, cc2);
		//STEP6: use setIsAvailable and force it to be false
		cc2.setIsAvailable(false);
		//STEP7: test loan cc2
		isLoan = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020");
		assertFalse("Test that unavailable item is not ok to loan?", isLoan);
		
		//////////////
		//error //
		//////////////

		//STEP8: test loan a non existing item
		//HINT8-1: do not add and straight away loan out
		isLoan = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020");
		assertFalse("Test that non-existing item is not ok to loan?", isLoan);
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		// boundary 
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		
		// normal
		boolean isLoan = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertTrue("Test if an available item is ok to loan?", isLoan);
		
		// error
		isLoan = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertFalse("Test if the same item is not ok to loan again?", isLoan);
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		
		// item list is not null, a newly added item cannot be returned successfully
		assertNotNull("Test that the list is not null", chromebookList);
		assertFalse("Test that the item cannot be returned if not loaned out", ResourceCentre.doReturnChromebook(chromebookList, "CB0011"));
		
		// item can be returned successfully, when previously loaned out
		ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertTrue("Test that the item can be returned when loaned out", ResourceCentre.doReturnChromebook(chromebookList, "CB0011"));
		
		// item loaned out again can be returned successfully
		assertTrue("Test that the item can be loaned again when returned", ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020"));
		assertTrue("Test that the item can be returned when reloaned", ResourceCentre.doReturnChromebook(chromebookList, "CB0011"));
		
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
