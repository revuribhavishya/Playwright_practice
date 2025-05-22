package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		
		Browser b =pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc= b.newContext();

		Page p = bc.newPage();
		p.onDialog(dialog-> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("Hi hello");
		});
		
		p.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		p.click("//button[text()='Click for JS Prompt']");
		String s = p.textContent("#result");
		System.out.println(s);
		
		p.click("//button[text()='Click for JS Confirm']");
	//	String s2 = p.textContent("#result");
	//	System.out.println(s2);
	
		p.click("//button[text()='Click for JS Alert']");
		String s1 = p.textContent("#result");
		System.out.println(s1);
		
		
		p.close();
		pw.close();
	
	}

}
