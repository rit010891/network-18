package core.pages;

import java.util.Map;
import java.util.logging.Logger;

import agent.IAgent;
import central.Configuration;

public class SignUpPage extends FullPage {

	public SignUpPage(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
	//	doSignUpForAppachhi();
	}
	public void doSignUpForAppachhi() throws Exception{
		getControl("siginUpTab").click();
		enterSignUpDetails(this.getTestData());
		
		getControl("upLoadSignUpBtn").click();
		getControl("progressBar").waitUntilVisible();
		String progressData=getControl("progressBar").getText();
		System.out.println("user is navigated to progress section :"+progressData);
		System.out.println("SignUp sucessfully");
	}
	
	
	public void enterSignUpDetails(Map<String, String> testData) throws Exception{
		
		getControl("companyEmailTxt").enterText(testData.get("companyEmail"));
		getControl("passWordTxt").enterText(testData.get("password"));
		getControl("phoneTxt").enterText(testData.get("phoneNo"));
		getControl("dropApk").uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\files\\amazon.apk");
		Thread.sleep(3000);
		
	}

}
