package PlaywrightSessions;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUpTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc= b.newContext();
		//BrowserContext bc1= b.newContext();
		
		Page p = bc.newPage();
		p.navigate("https://testautomationpractice.blogspot.com/");
		
		Page popup =p.waitForPopup(()-> {
			p.click("//a[text()='Online Trainings']");
		});
		System.out.print("popup title " + popup.title());
		popup.close();
		System.out.print("popup title " + p.title());
		b.close();
		pw.close();
		
	}

}
