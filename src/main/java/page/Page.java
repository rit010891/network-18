package page;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import agent.IAgent;
import central.Configuration;
import central.AppachhiCentral;
import control.Control;
import control.IControl;
import enums.Platform;
import pagedef.Identifier;
import pagedef.PageDef;

public abstract class Page implements IPage {
	protected static Logger logger = AppachhiCentral.getLogger();
	private Configuration config = null;
	private IAgent agent = null;
	private PageDef pageDef = null;
	private Platform platform = null;
	public Map<String, String> testData = null;

	public Page(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		this.testData = testData;
		this.config = config;
		this.platform = config.getPlatform();
		pageDef = AppachhiCentral.INSTANCE.getPageDef(this.getClass().getSimpleName());
		this.agent = agent;
	}

	protected Configuration getConfig() {
		return this.config;
	}

	public IAgent getAgent() {
		return this.agent;
	}

	protected Map<String, String> getTestData() {
		return this.testData;
	}

	public IControl getControl(String name) throws Exception {
		return Control.createControl(this, name, getIdentifier(name));
	}

	public List<IControl> getControls(String name) throws Exception {
		return Control.createControls(this, name, getIdentifier(name));
	}

	@Override
	public void takeSnapShot() throws Exception {
		this.agent.takeSnapShot();
	}

	@Override
	public void swipeUp() throws Exception {
		this.agent.swipeUp();
	}

	@Override
	public void swipeUp(int count) throws Exception {
		this.agent.swipeUp(count);
	}

	@Override
	public void swipeDown() throws Exception {
		this.agent.swipeDown();
	}

	@Override
	public void swipeDown(int count) throws Exception {
		this.agent.swipeDown(count);
	}
	
	@Override
	public void swipeLeft(int count) throws Exception {
		this.agent.swipeLeft(count);		
	}
	@Override
	public void swipeLeft() throws Exception {
		this.agent.swipeLeft();
	}
	@Override
	public void swipeRight(int count) throws Exception {
		this.agent.swipeRight(count);
		
	}
	@Override
	public void swipeRight() throws Exception {
		this.agent.swipeRight();
	}

	@Override
	public void goTo(String url) throws Exception {
		this.agent.goTo(url);
	}

	@Override
	public void goBack() throws Exception {
		this.agent.goBack();
	}

	@Override
	public void switchToNewWindow() throws Exception {
		this.agent.switchToNewWindow();
	}

	@Override
	public void switchToMainWindow() throws Exception {
		this.agent.switchToMainWindow();
	}
	
	@Override
	public void switchToFrame(String id) throws Exception {
		this.agent.switchToFrame(id);
	}

	@Override
	public void switchToFrame(int index) throws Exception {
		this.agent.switchToFrame(index);
	}
	
	@Override
	public void switchToParentFrame() throws Exception {
		this.agent.switchToParentFrame();
	}
	
	@Override
	public void switchToDefaultFrame() throws Exception {
		this.agent.switchToDefaultFrame();
	}

	
	@Override
	public void acceptAlert() throws Exception {
		this.agent.acceptAlert();
	}

	@Override
	public void scrollUp() throws Exception {
		this.agent.scrollUp();
	}

	@Override
	public void scrollUp(int count) throws Exception {
		this.agent.scrollUp(count);
	}

	@Override
	public void scrollDown() throws Exception {
		this.agent.scrollDown();
	}

	@Override
	public void scrollDown(int count) throws Exception {
		this.agent.scrollDown(count);
	}

	@Override
	public Platform getPlatform() {
		return this.platform;
	}

	@Override
	public Identifier getIdentifier(String name) {
		return this.pageDef.getIdentifier(this.platform, name);
	}

	@Override
	public void switchToNativeView() throws Exception {
		this.agent.switchToNativeView();
	}

	@Override
	public void switchToWebView() throws Exception {
		this.agent.switchToWebView();
	}

	@Override
	public void assertPageLoad() throws Exception {
		this.agent.assertPageLoad();
	}

	@Override
	public void swipeDownTillElement(String elementName) throws Exception {
		this.agent.swipeDownTillElement(elementName);
		String msg = String.format("Scrolling till element - ", elementName);
		try {
			logger.debug(msg);
			for (int i = 0; i < 10; i++) {
				try {
					getControl(elementName);
					break;
				} catch (Exception e) {
					this.getAgent().swipeDown();
				}

			}
			this.getAgent().takeConditionalSnapShot();
		} catch (Exception e) {
			logger.debug(String.format("Failure in %s", msg));
		}
	}

	public void androidWebView() throws Exception {
		if (this.getPlatform() == Platform.ANDROID) {
			this.getAgent().switchToWebView();
		}
	}

	public void androidNativeView() throws Exception {
		if (this.getPlatform() == Platform.ANDROID) {
			this.getAgent().switchToNativeView();
		}
	}

}
