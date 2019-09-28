package stepDefinition;

import java.io.IOException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import objects.TestBase;
import utility.TLDriverFactory;

public class Hooks extends TestBase {
	   
		@Before
		public void before(Scenario scr) throws IOException {	
			System.out.println("Before - "+scr);
			String ScenarioName = scr.getName();
			scenario.set(feature.get().createNode(ScenarioName));
		    TLDriverFactory.setTLDriver(browser);
		   
		}	
		
		@BeforeStep
		public void doSomethingBeforeStep(Scenario scenario){
			System.out.println("Before step - "+scenario);
		}
		 	 	
		 @After
		public void loginOut() throws IOException {
			 extent.flush();
			 if(!(TLDriverFactory.getTLDriver().equals(null))){
			 TLDriverFactory.getTLDriver().close();
			 }
		}		 

}
