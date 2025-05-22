package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LaunchSpecificBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		

			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("chrome");
		//	lp.setChannel("firefox");
		//	lp.setChannel("msedge");
			lp.setHeadless(false);
			Browser b = pw.chromium().launch(lp);
				
			Page p = b.newPage();
			p.navigate("https://amazon.com");
			String s =p.title();
			System.out.println(" string is "+s);
			b.close();
			pw.close();
	}

}
