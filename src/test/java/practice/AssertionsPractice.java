package practice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	public void sample() {
		String data = "abc";
		
		System.out.println("step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(0,1);
		
		Assert.assertTrue(data.contains("y"));
		System.out.println("step 3");
		System.out.println("step 4");
		
		
	}
	
	public void sampleSoft() {
		SoftAssert sa = new SoftAssert();
		String data = "abc";
		
		System.out.println("step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(0,1);//failed
		
		System.out.println("step 3");

		Assert.assertTrue(data.contains("y"));//failed
		System.out.println("step 4");
		
		sa.assertAll();
		
		
		
		
	}

}
