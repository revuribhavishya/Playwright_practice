package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc = b.newContext();
		Page pg = bc.newPage();
		pg.navigate("https://www.orangehrm.com/");
	//	Locator a = pg.getByText("Contact Sales");
	//	int count =a.count();
	//	System.out.println("no.of ele wih conatact sales"+ count);
		Locator contactSales =pg.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales"));
		//contactSales.hover();
		contactSales.click();
	//pg.pause();
		
		//Locator robot =pg.frameLocator("frame[name='a-7l8mcrif7uxo']").locator()
		
		Locator countryOptions = pg.locator("select#Form_getForm_Country");

		  Locator options = countryOptions.locator("option");
	        int count = options.count();
	        System.out.println("Total options: " + count);

	        for (int i = 0; i < count; i++) {
	            System.out.println(options.nth(i).textContent());
	        }
		
		
	/*	Locator countryOptions = pg.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Form_getForm_Country"));

		System.out.println(countryOptions.count());
		for(int i =0; i<countryOptions.count(); i++) {
			countryOptions.nth(i).textContent();
			
		}*/
		
		pg.close();
		b.close();
		pw.close();
		
		
		
		
	}

}
