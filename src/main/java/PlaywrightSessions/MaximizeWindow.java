package PlaywrightSessions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int w =(int)size.getWidth();
		int h = (int )size.getHeight();
		System.out.println("width :" + w +"height: "+  h  );
		
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc = b.newContext(new Browser.NewContextOptions().setViewportSize(w,h)); // u can give 780,500
		BrowserContext bc1 = b.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myVideos/")));
		Page p = bc.newPage();
		p.navigate("https://amazon.com");
		
		Page p1 =bc.newPage();
		p1.navigate("https://walamrt.com");
		
		
		bc.close();
		bc1.close();
		

	}

}
