package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class React {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext b1= b.newContext();

		Page p = b.newPage();
	/*	p.navigate("https://www.netflix.com/");
		Locator l = p.locator("\"_react=[name='email']").first();
		
		l.click();
		l.fill("bhavishya@gmail.com");*/
		
		p.navigate("https://testautomationpractice.blogspot.com/");
		Locator l1 = p.locator("table#productTable tr");
		l1.locator(":scope", new Locator.LocatorOptions()
				.setHasText("Smartphone"))
		.locator(".input[type='checkbox']")
		.click();
	
	//	l1.locator(":scope").allInnerTexts().forEach(e->System.out.print(e));
		
		p.close();
		pw.close();
	

	}

}
