package Package1;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassicCrm2 {
	static WebDriver driver;
	public static void main(String[] args) throws Exception { 		 
			
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.get("https://classic.crmpro.com/index.html");
				String username="username";
				String password="password";
				String submit="//input[@type='submit']";
				String contacts="CONTACTS";
				String newcontact="New Contact";
				doSendkeys((getElement(username,"name")),"groupautomation");
				doSendkeys((getElement(password,"name")),"Test@12345");
				doClick((getBy(submit,"xpath")));
				gotoFrame("mainpanel");	
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
				Thread.sleep(3000);
				act.click(driver.findElement(By.linkText("New Contact"))).perform();	
				//hoverAndClickDropDown(getElement(contacts,"linkText"),getElement(newcontact,"linkText"));	
				submitForm();			
		        
			}
	        public static By Element(String str, String str2)
	        {
	        	return By.id(str);
	        }
	        
	        public static  By getBy(String str, String caseType)
	        {
	        	By b=null;
	        	switch(caseType)
	        	{
	        	case "id": b= By.id(str);
	        	           break;
	        	case "xpath": b= By.xpath(str);
 	                           break;
	        	case "name": b= By.name(str);
 	                           break;
	        	case "linkText":  b= By.linkText(str);
 	                              break;
	        	case "partialLinkText": b= By.partialLinkText(str);
 	                                    break;
	        	case "tagName": b= By.tagName(str);
	        						break;
	        	case "cssSelector": b= By.cssSelector(str);
	        				break;
	        	case "className":  b= By.className(str);
	        					break;
	        	default: System.out.println("wrong tag name");
	        					break;      
 	                                    
	         	}
	        	return b;
	        }
	        
	        public static WebElement getElement(String loc, String locType)
		    {
		    	return driver.findElement(getBy(loc,locType));
		    }
			public static void hoverAndClickDropDown(WebElement loc1, WebElement loc2) throws Exception
			{
				Actions act=new Actions(driver);
				act.moveToElement(loc1).perform();
				Thread.sleep(3000);
				act.click(loc2).perform();	
			}
			public static void submitForm()
			{
			String title="//select[@name='title']";
			String suffix="//select[@name='suffix']";
			String firstname="first_name";
			String middlename="middle_initial";
			String lastname="surname";
			String 	 upload="//input[@type='file']";
			String 	nickname="nickname";
			String 	 company="client_lookup";
			String 	 pos="company_position";
			String 	 dep="department";
			String 	 supervisor="contact_lookup_sup";
			String 	 assistant="contact_lookup_ass";
			String 	 ref="contact_lookup_ref";
			String 	 owner="//select[@name='owner_user_id']";		
			String	 msn="//select[@name='im_netowrk']";
			String	 category="//select[@name='category']";
			String	 status="//select[@name='status']";
			String	 src="//select[@name='source']";		
			String	 adrTitle="address_title";
			String	 type="//select[@name='type']";
			String	  time_zone="//select[@name='time_zone']";
			String	  cntry="//select[@name='country']";
			String	  postcode="postcode";
			String	 adr="address";
			String	  city="city";
			String	  state="state";
			String	  country="country";
			String	  tags="tags";
			String	  des="description";		
			String	  mob="mobile";
			String	 homephone="home_phone";
			String	 phone="phone";
			String	 fax="fax";
			String	 email="email";
			String	 altmail="email_alt";
			String	 messenger="im_id";
			String	 skype="skype_id";
			String	 birthday="birthday";
			String	 identifier="identifier";
			String	 save="//input[@value='Save'  and @type='submit']";
				doSendkeys((getElement(firstname,"name")),"joe");
				doSendkeys((getElement(middlename,"name")),"kk");
				doSendkeys((getElement(lastname,"name")),"biden");
				doSendkeys((getElement(nickname,"name")),"shawn");
				doSendkeys((getElement(company,"name")),"GOOGLE");
				doSendkeys((getElement(pos,"name")),"Manager");
				doSendkeys((getElement(dep,"name")),"finance");
				doSendkeys((getElement(supervisor,"name")),"Micheal");		
				doSendkeys((getElement(assistant,"name")),"henry");
				doSendkeys((getElement(ref,"name")),"raj");
				doSendkeys((getElement(adrTitle,"name")),"home addres");
				doSendkeys((getElement(postcode,"name")),"560000");
				doSendkeys((getElement(adr,"name")),"bangalore");
				doSendkeys((getElement(city,"name")),"bangalore rural");
				doSendkeys((getElement(state,"name")),"karnataka");
				doSendkeys((getElement(country,"name")),"India");
				doSendkeys((getElement(tags,"name")),"TAG1");
				doSendkeys((getElement(des,"name")),"DESCRIPTION 100");		
				doSendkeys((getElement(mob,"name")),"99889988");
				doSendkeys((getElement(homephone,"name")),"080-22233444");
				doSendkeys((getElement(phone,"name")),"90909090");
				doSendkeys((getElement(fax,"name")),"99898");
				doSendkeys((getElement(email,"name")),"ABC1@GMAIL.COM");
				doSendkeys((getElement(altmail,"name")),"XYZ@GMAIL.COM");
				doSendkeys((getElement(messenger,"name")),"messaner@msn.com");
				doSendkeys((getElement(skype,"name")),"srini1");
				doSendkeys((getElement(birthday,"name")),"3-3-03");
				doSendkeys((getElement(identifier,"name")),"identifier 1");
		 		selectOption(getElement(title,"xpath"),3);
				selectOption(getElement(suffix,"xpath"),2);
				selectOption(getElement(owner,"xpath"),1);
				selectOption(getElement(type,"xpath"),1);
				selectOption(getElement(time_zone,"xpath"),3);
				selectOption(getElement(cntry,"xpath"),5);
				selectOption(getElement(msn,"xpath"),3);
				selectOption(getElement(src,"xpath"),4);
				selectOption(getElement(status,"xpath"),3);
				selectOption(getElement(category,"xpath"),5);
				doSendkeys((getElement(upload,"xpath")),"c:\\users\\Untitled.png");
				doClick(getBy(save,"xpath"));
			}
			public static void doSendkeys(WebElement w, String str)
			{
				w.sendKeys(str);
			}
		    public static WebElement getElement(By loc)
		    {
		    	return driver.findElement(loc);
		    }
		   
		    public static List<WebElement> getElements(By loc)
		    {
		    	return driver.findElements(loc);
		    }
		    public static void selectOption(WebElement w, int ind)
		    {
		    	Select s=new Select(w);
		    	s.selectByIndex(ind);
		    }
		    public static void doClick(By e )
		    {
		    	getElement(e).click();
		    }
		    public static TargetLocator frames()
		    {
		    	return driver.switchTo();
		    }
		    
		    public static void  gotoFrame(String ele)
		    {
		       frames().frame(ele);
		    }
		}


