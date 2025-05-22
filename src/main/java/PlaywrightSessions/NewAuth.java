package PlaywrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NewAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc= b.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
		
		Page p = bc.newPage();
		p.navigate("http://www.automationpractice.pl/index.php");
	
		
		
	}

}
