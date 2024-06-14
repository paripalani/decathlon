package decathlon;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hookes extends Baseclass{
	
	@Before
	public void beforescenario() {
		
		driverLaunch("chrome");
		url("https://www.decathlon.in/");
		maximizeWindow();
		
	}

	
	@After
	public void afterscenario(Scenario s) {
		
		
		if (s.isFailed()) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			
			s.attach(screenshotAs,"png",s.getName());
			
		} 
		else {

		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		
		s.attach(screenshotAs,"png",s.getName());
		
		}
		
	closeDriver();
		
		
	}
	
	
}
