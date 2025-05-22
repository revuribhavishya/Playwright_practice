package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext b1= b.newContext();

		Page p = b.newPage();
		
		p.navigate("https://workspace.google.com/intl/en-US/gmail/");
		// either of thw prd matches  Sign in , Login 
		Locator l =p.locator("a#sign in.span:has-text('Sign into Gmail')," 
		+ "span:has-text('Create an account')"
		+ "span:has-text('Try Gmail for Work')"
		+"span:has-text('Sign In')");
		int count = l.count();
		
		System.out.print(count);
		if(count==3) {
			System.out.print("pass");
		}
		
				
	}

}
