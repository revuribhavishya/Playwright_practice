package PlaywrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("binaries");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
      page.getByTestId("todo-title").click();
      page.getByTestId("todo-title").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("real TodoMVC app.")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Blog")).click();
      Page page1 = context.newPage();
      page1.close();
      page.getByTestId("headerSearchInput").click();
      page.getByTestId("headerSearchInput").fill("playwright ");
      page.getByTestId("headerSearchInput").press("Enter");
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}