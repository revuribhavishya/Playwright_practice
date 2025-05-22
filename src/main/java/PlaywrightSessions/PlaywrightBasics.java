package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.lang.String;  // Normally auto-imported
import java.lang.System;  // Normally auto-imported

public class PlaywrightBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext b1= b.newContext();

		Page p = b.newPage();
		p.navigate("https://amazon.com");
		String s =p.title();
		System.out.println(" amazon title is "+s);
		p.fill("#twotabsearchtextbox", "iphone");
		p.press("#twotabsearchtextbox", "Enter");
		//b.close();
		//pw.close();
		
		
		BrowserContext b2= b.newContext();
		Page p2 = b2.newPage();
		p2.navigate("https://www.walmart.com/");
		String s2 =p.title();
		System.out.println(" walmart title is  "+s);
	}

}
