package PlaywrightSessions;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Playwright pw= Playwright.create();

Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

Page p = b.newPage();
/*p.navigate("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
p.locator("input#singleFileInput").scrollIntoViewIfNeeded();
p.setInputFiles("input#singleFileInput", Paths.get("appLogin.json"));
//to remove uploaded file
p.setInputFiles("input#singleFileInput", new Path[0]);


p.setInputFiles("input#multipleFilesInput", new Path[] {
		Paths.get("applogin.json"), 
		Paths.get("trace.zip")});

*/
p.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.16/");
Download dw = p.waitForDownload(()->{
	p.click("a:text('chromedriver_mac64.zip')");
});
System.out.println(dw.url());
System.out.println(dw.page().title());
dw.saveAs(Paths.get("download.zip"));
System.out.println(dw.suggestedFilename());
	}

}
