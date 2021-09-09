package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class classicCrm {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By username=By.name("username");
		By password=By.name("password");
		By submit=By.xpath("//input[@type='submit']");
		By contacts=By.linkText("CONTACTS");
		By newcontact=By.linkText("New Contact");
		doSendkeys(username,"groupautomation");
		doSendkeys(password,"Test@12345");
		doClick(submit);
		gotoFrame("mainpanel");		
		hoverAndClickDropDown(contacts, newcontact);	
		submitForm();
		
        
	}
	public static void hoverAndClickDropDown(By loc1, By loc2) throws Exception
	{
		Actions act=new Actions(driver);
		act.moveToElement(getElement(loc1)).perform();
		Thread.sleep(3000);
		act.click(getElement(loc2)).perform();	
	}
	public static void submitForm()
	{
		By title=By.xpath("//select[@name='title']");
		By suffix=By.xpath("//select[@name='suffix']");
		By firstname=By.name("first_name");
		By middlename=By.name("middle_initial");
		By lastname=By.name("surname");
		By upload=By.xpath("//input[@type='file']");
		By nickname=By.name("nickname");
		By company=By.name("client_lookup");
		By pos=By.name("company_position");
		By dep=By.name("department");
		By supervisor=By.name("contact_lookup_sup");
		By assistant=By.name("contact_lookup_ass");
		By ref=By.name("contact_lookup_ref");
		By owner=By.xpath("//select[@name='owner_user_id']");		
		By msn=By.xpath("//select[@name='im_netowrk']");
		By category=By.xpath("//select[@name='category']");
		By status=By.xpath("//select[@name='status']");
		By src=By.xpath("//select[@name='source']");		
		By adrTitle=By.name("address_title");
		By type=By.xpath("//select[@name='type']");
		By time_zone=By.xpath("//select[@name='time_zone']");
		By cntry=By.xpath("//select[@name='country']");
		By postcode=By.name("postcode");
		By adr=By.name("address");
		By city=By.name("city");
		By state=By.name("state");
		By country=By.name("country");
		By tags=By.name("tags");
		By des=By.name("description");		
		By mob=By.name("mobile");
		By homephone=By.name("home_phone");
		By phone=By.name("phone");
		By fax=By.name("fax");
		By email=By.name("email");
		By altmail=By.name("email_alt");
		By messenger=By.name("im_id");
		By skype=By.name("skype_id");
		By birthday=By.name("birthday");
		By identifier=By.name("identifier");
		By save=By.xpath("//input[@value='Save'  and @type='submit']");
		doSendkeys(firstname,"joe");
		doSendkeys(middlename,"kk");
		doSendkeys(lastname,"biden");
		doSendkeys(nickname,"shawn");
		doSendkeys(company,"GOOGLE");
		doSendkeys(pos,"Manager");
		doSendkeys(dep,"finance");
		doSendkeys(supervisor,"Micheal");		
		doSendkeys(assistant,"henry");
		doSendkeys(ref,"raj");
		doSendkeys(adrTitle,"home addres");
		doSendkeys(postcode,"560000");
		doSendkeys(adr,"bangalore");
		doSendkeys(city,"bangalore rural");
		doSendkeys(state,"karnataka");
		doSendkeys(country,"India");
		doSendkeys(tags,"TAG1");
		doSendkeys(des,"DESCRIPTION 100");		
		doSendkeys(mob,"99889988");
		doSendkeys(homephone,"080-22233444");
		doSendkeys(phone,"90909090");
		doSendkeys(fax,"99898");
		doSendkeys(email,"ABC1@GMAIL.COM");
		doSendkeys(altmail,"XYZ@GMAIL.COM");
		doSendkeys(messenger,"messaner@msn.com");
		doSendkeys(skype,"srini1");
		doSendkeys(birthday,"3-3-03");
		doSendkeys(identifier,"identifier 1");
 		selectOption(title,3);
		selectOption(suffix,2);
		selectOption(owner,1);
		selectOption(type,1);
		selectOption(time_zone,3);
		selectOption(cntry,5);
		selectOption(msn,3);
		selectOption(src,4);
		selectOption(status,3);
		selectOption(category,5);
		doSendkeys(identifier,"identifier 1");
		doSendkeys(upload,"c:\\users\\Untitled.png");
		doClick(save);
	}
	public static void doSendkeys(By loc, String str)
	{
		getElement(loc).sendKeys(str);
	}
    public static WebElement getElement(By loc)
    {
    	return driver.findElement(loc);
    }
    
    public static List<WebElement> getElements(By loc)
    {
    	return driver.findElements(loc);
    }
    public static void selectOption(By loc, int ind)
    {
    	Select s=new Select(getElement(loc));
    	s.selectByIndex(ind);
    }
    public static void doClick(By loc)
    {
    	getElement(loc).click();
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
