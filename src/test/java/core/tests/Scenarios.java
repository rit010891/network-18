package core.tests;

import org.testng.annotations.Test;

public class Scenarios extends SupportTest {

	@Test(enabled = false, priority = 1)
	public void TC01_LogInToMoneyControlApp() throws Exception {
		logger.debug(this.getTestStartInfoMessage("SignInTest"));
		lp.Login();
		logger.debug(this.getTestEndInfoMessage("SignInTest"));

	}
	
	@Test(enabled = true, priority = 2)
	public void TC02_VerifyWhetherUserCanSearchAllTypesOfAssets() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying Assets"));
		hp.verifyWhetherUserCanSearchAllTypesOfAssets();
		logger.debug(this.getTestEndInfoMessage("verifying Assets ended"));

	}

}
