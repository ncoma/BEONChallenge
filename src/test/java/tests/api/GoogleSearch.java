package tests.api;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GooglePage;
import tests.ui.BaseUITest;
import utils.PropertiesGetter;

public class GoogleSearch extends BaseUITest {
  private GooglePage googlePage;
  String searchText;
  @BeforeClass
  public void init() {
    googlePage = new GooglePage(page);
    searchText = PropertiesGetter.get("searchText");
  }

  @Test
  public void searchText() throws InterruptedException {
    googlePage.navigate();
    googlePage.search(searchText);
    page.keyboard().press("Enter");
    Thread.sleep(2000);
    String resultURL = googlePage.resultEntry.innerText();
    googlePage.resultEntry.click();
    Thread.sleep(3000);

    assertThat(googlePage.getCurrentURL()).isEqualTo(resultURL);
  }

}
