package PlaywrightSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM_locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext b1= b.newContext();

		Page p = b.newPage();
		p.navigate("https://amazon.com");
		List<String> s=p.locator("a:has-text('Amazon')").allInnerTexts();
	//	s.stream().forEach(e->System.out.println(e));
		
		 p .close();
			BrowserContext b2= b.newContext();
			Page p2 = b2.newPage();
		 
		p2.navigate("https://practice.expandtesting.com/shadowdom");
		p2.locator("#shadow-host").scrollIntoViewIfNeeded();

	
		Locator shadowHost = p.locator("#shadow-host");
		Locator shadowButton = shadowHost.locator(">>> #my-btn");
		shadowButton.click();
		
		Locator l = p.locator("select#Form_getForm_Country:has(option[value='India'])");
	//	l.allInnerTexts().forEach(e->System.out.println(e));
		
		p.navigate("https://gmail.com");
		p.locator("span:has-text('Sign in'), span:has-text('Login')").click();
		


	}

}
