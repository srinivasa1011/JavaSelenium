package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricinfo {

    static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
		driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/india-tour-of-sri-lanka-2021-1262739/sri-lanka-vs-india-3rd-odi-1262757/full-scorecard");
        String name="Rahul Chahar";
        String name2="Navdeep Saini";
       List<String>list1= getBowlerInfo(name);
       System.out.println(list1);
       List<String>list2= getBowlerInfo(name2);
       System.out.println(list2);
       List<String>list3= getAllBowlers();
       for(String s:list3)
       {
    	   List<String>lists= getBowlerInfo(s);
    	   System.out.println("BOWLER  " +s +" info :  "+lists);
       }
       genric();
	}
    public static void genric()
    {
    	By loc=By.xpath("(//table[@class='table bowler'])[2]//tr//td[4]");
    	List<WebElement>li=getElements(loc);
    	int num=0;
    	for(WebElement e: li)
    	{
    		int num2=Integer.parseInt(e.getText());
    		if(num2>num)
    		{
    			num=num2;
    		}
    			
    	}
    	System.out.println(num);
    }
    
	public static List<String> getAllBowlers()
	{
		By loc=By.xpath("(//table[@class='table bowler'])[2]//tr/td/a");
		List<WebElement> li=getElements(loc);
		List<String>al=new ArrayList<String>();
	       for(WebElement e: li)
	       {
	    	   al.add(e.getText());
	       }
	       return al;
	}
	public static List<String> getBowlerInfo(String bowler)
	{
        By loc=By.xpath("//table[@class='table bowler']//a[text()='"+bowler+"']//parent::td//parent::tr/td");
		List<WebElement> li=getElements(loc);
		List<String>al=new ArrayList<String>();
	       for(WebElement e: li)
	       {
	    	   al.add(e.getText());
	       }
	       return al;
	}
	
	
	public static List<WebElement> getElements(By loc)
	{
		return driver.findElements(loc);
	}
}
