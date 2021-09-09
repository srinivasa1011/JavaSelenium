package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\skeshavkumar\\chromedriver.exe");
		String browser="chrome";
		BrowserUtil br=new BrowserUtil();
		WebDriver driver=br.getBrowser(browser);
		br.launchUrl("https://amazon.in");
		System.out.println(br.getTitle());
		
		By id1= By.xpath("		//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine navFooterCopyright']//a\r\n"
				+ "");
		By id2= By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']//a");		
		By id3= By.xpath("	//div[@class='navFooterVerticalRow navAccessibility']//a");
		 
	    ElementUtil el=new ElementUtil(driver);
		 /*List<WebElement>li=driver.findElements(id1);
		 System.out.println(li.size());
		 for(WebElement el: li)
		 System.out.println(el.getText());*/
		 
		 List<String> footer1=el.getList(id1);
		 List<String> footer2=el.getList(id2);
		 List<String> footer3=el.getList(id3);
		 
		 System.out.println(footer1.size() +"  " +footer2.size() + "  "+ footer3.size());
		 System.out.println("footer 1 contents" +footer1);
		 System.out.println("footer 2 contents" +footer2);
		 System.out.println("footer 3 contents" +footer3);
		 
		 if(footer1.size()==3)
			 System.out.println("links count  of footer 1 matches");
		 else
			 System.out.println("count dont match something missing");
		 
		 if(footer2.size()==9)
			 System.out.println("links count  of footer 2 matches");
		 else
			 System.out.println("count dont match something missing");
		 
		 if(footer3.size()==22)
			 System.out.println("links count  of footer 3 matches");
		 else
			 System.out.println("count dont match something missing");
		 
		 if(footer1.contains("Privacy Notice"))
		 {
			 System.out.println("privacy notice field exist");
		     el.clickList(id1, "Privacy Notice");
		 }
		 else
			 System.out.println("text not found");
		 
		 
	 
		 // br.closeBrowser();

 
	}


}
