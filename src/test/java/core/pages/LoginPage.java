package core.pages;

import java.util.Map;
import agent.IAgent;
import central.Configuration;

public class LoginPage extends FullPage {

	public LoginPage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}

	public void Login() throws Exception {
		logger.debug(String.format("(%s) Logging in...", this.getPlatform()));

		getControl("linkLogin").click();
		
	

		// return new HomePage(getConfig(), getAgent(), getTestData());
	}

}
