package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class provides implementation for the iretryAnalyser interface  of
 * TestNG
 * @author SRIROJARAM
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count = 0;
	int retryCount = 3; // manual analysis
	
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount) {
			count++; // 1 2 3
			return true;//retry retry retry
		}
		return false;// stop retrying
		
	}

}
