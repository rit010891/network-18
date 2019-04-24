package core.pages;

import java.util.Map;

import agent.IAgent;
import central.Configuration;

public class HomePage extends FullPage {

	public HomePage(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {

		super(config, agent, testData);
	}

	public void verifyWhetherUserCanSearchAllTypesOfAssets() throws Exception {

		getControl("searchButton").click();
		Thread.sleep(3000);
		getControl("searchBar").enterText(getTestData().get("Asset1"));
		Thread.sleep(3000);
		getControl("stocksCategory").click();
	}

}
