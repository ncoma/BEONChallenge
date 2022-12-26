package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class GooglePage {
  Page page;
  private final Locator inputSearch;
  public final Locator resultEntry;

  public GooglePage(Page page) {
    this.page = page;
    this.inputSearch = page.locator("[name=q]");
    this.resultEntry = page.locator("//div[@id='rso']//cite/../..").nth(10);
  }

  public void navigate() {
    page.navigate("https://www.google.com/");
  }

  public GooglePage search(String text) {
    this.inputSearch.fill(text);
    return this;
  }

  public String getCurrentURL() {
    return this.page.url();
  }
}
