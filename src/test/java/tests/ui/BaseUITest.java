package tests.ui;

import com.microsoft.playwright.*;
import org.assertj.core.api.WithAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseUITest implements WithAssertions {
  static Playwright playwright;
  static Browser browser;
  BrowserContext context;
  protected Page page;
  @BeforeSuite
  public void suiteInit() {
    playwright = Playwright.create();
    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
  }
  @BeforeClass
  public void newContext() {
    context = browser.newContext();
    page = browser.newPage();
  }
  @AfterClass
  public void closeAll() {
    context.close();
    playwright.close();
  }
}
