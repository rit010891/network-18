package core.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import agent.IAgent;
import central.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import page.Page;
import pagedef.Identifier;

public abstract  class FullPage extends Page {
		
	public FullPage(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
	}
	
	AppiumDriver<MobileElement> mobileDriver=this.getAgent().getMobileDriver();
	WebDriver driver=this.getAgent().getWebDriver();
	
  	protected StringBuffer generateString(int length) {
   		StringBuffer output = new StringBuffer();
   		String characterSet = "";
   		characterSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
   		for (int i=0; i<length; i++) {
   			double index = Math.random()*characterSet.length();
   			output.append(characterSet.charAt((int)index));
   		}
   		return(output);
   	}

   	protected StringBuffer generateRandomNumber(int length) { 
   		StringBuffer output = new StringBuffer(); 
   		String characterSet = ""; 
   		characterSet = "1234567890"; 
   		for (int i=0; i<length; i++) { 
   			double index = Math.random()*characterSet.length(); 
   			output.append(characterSet.charAt((int)index)); 
   		} 
   		return(output);
   	}
   	
    public String mobileNumbers() {
    	String udid = System.getProperty("mobile_udid");
//    	System.out.println("Name of the model : " + udid);
    	String mob = "";
    	switch (udid) {

    	// 01, Vivo V5 s
    	case "PJFEQ8WW99999999":
    	    mob = "9108332482";
    	    break;
    	    
    	// 02, Lenovo K8 note
    	case "HKL3GJDH":
    	    mob = "9845397647";
    	    break;

    	// 03, Pixel XL
    	case "HT73P0200435":
    	    mob = "9845381283";
    	    break;

    	// 04, Honor 8
    	case "CSTDU16A22001576":
    	    mob = "9845396957";
    	    break;

    	// 05, Samsung Galaxy J7
    	case "5203786bea9ab321":
    	    mob = "9108332481";
    	    break;

    	// 06, Samsung Galaxy on 8
    	case "3300d37d4206a381":
    	    mob = "9845396034";
    	    break;
 
//    	   	// 06, Samsung Galaxy on 8
//    	case "2d9bac7e":
//    	    mob = "9845396034";
//    	    break;
// 
    	    
    	default:
    	    mob = "9606453384";
    	    break;
    	}
    	return (mob);
        }

    public String emailids() {
    	String udid = System.getProperty("mobile_udid");
//    	System.out.println("Name of the model : " + udid);
    	String email = "";
    	switch (udid) {

    	// 01, Vivo V5 s
    	case "PJFEQ8WW99999999":
    	    email = "";
    	    break;
    	    
    	// 02, Lenovo K8 note
    	case "HKL3GJDH":
    	    email = "";
    	    break;

    	// 03, Pixel XL
    	case "HT73P0200435":
    	    email = "";
    	    break;

    	// 04, Honor 8
    	case "CSTDU16A22001576":
    	    email = "";
    	    break;

    	// 05, Samsung Galaxy J7
    	case "5203786bea9ab321":
    	    email = "";
    	    break;

    	// 06, Samsung Galaxy on 8
    	case "3300d37d4206a381":
    	    email = "";
    	    break;
 
//    	   	// 06, Samsung Galaxy on 8
//    	case "2d9bac7e":
//    	    mob = "9845396034";
//    	    break;
// 
    	    
    	default:
    	    email = "loginauthautomate@gmail.com";
    	    break;
    	}
    	return (email);
        }



}
