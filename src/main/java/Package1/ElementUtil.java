package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	
	public  WebDriver driver;
	ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	void doSendKeys(By locator, String str)
	{
		getElement(locator).sendKeys(str);
	}
	
	public   WebElement getElement(By locator)
	{
		 return driver.findElement(locator);
		
	}
	void doSelectByindex(By locator, int i)
	{
		Select s=new Select(getElement(locator));
		s.selectByIndex(i);
	}
	
	void doSelectByText(By locator, String text)
	{
		Select s=new Select(getElement(locator));
		s.selectByVisibleText(text);
	}
	
	void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public List<WebElement> getElements(By locator)
	 
	{
		return driver.findElements(locator);
	}
	
	public List<String> getList(By locator)
	{
		List<String> al=new ArrayList<String>();
		List<WebElement> li=getElements(locator);
		for(WebElement el: li)
		{
			if(!el.getText().isEmpty())
			{
				al.add(el.getText());				
			}		
			
		}
		return al;
	}
	
	public void clickList(By locator, String text)
	{
		List<WebElement>li=getElements(locator);
	    for(WebElement el: li)
	    {
	    	if(el.getText().equals(text))
	    			{
	    		      el.click();
	    		      break;
	    			}
	    }
		
	} 
	
	public void clickDropDown(By locator, String text)
	{
		List<WebElement>li=getElements(locator);
	    for(WebElement el: li)
	    {
	    	if(el.getText().equals(text))
	    			{
	    		      System.out.println(el.getText() +" is clicked");
	    		      el.click();	    		     
	    		      break;
	    			}
	    }
		
	} 
	public void printList(List<String> al)
	{
		 
	    for(String el: al)
	    {
	    	System.out.println(el);
	    }
		
	} 
	public List<String> getStringList(By locator)
	{
		List<String> s=new ArrayList<String>();
		List<WebElement> li=getElements(locator);
		for(WebElement e: li)
		{
			s.add(e.getText());			
		}
		return s;
	};
	
	public void selectAllOptions(By locator, String... value)
	{
		List<WebElement>li=getElements(locator);	
		if(!value[0].equalsIgnoreCase("all"))
		{
			
			for(WebElement e: li)
			{
				System.out.println(e.getText());
				for(String v:value)
				{
					if(v.equals(e.getText()))
					{
						e.click();
						break;
					}
				}
			}
		}
		else
		{
			for(WebElement e:li)
			{
				try {
					e.click();
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	}
	
	public void doSend_SendKEYS(By loc, String str)
	{
		Actions ac=new Actions(driver);
		ac.sendKeys(getElement(loc),str).perform();
	}
	public void doSend_SendKEYSClick(By loc)
	{
		Actions ac=new Actions(driver);
		ac.click(getElement(loc)).perform();
	}
	public  void threelevelclick(By loc1, By loc2, By loc3) throws InterruptedException
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(getElement(loc1)).perform();
		Thread.sleep(3000);	
		ac.moveToElement(getElement(loc2)).build().perform();
		ac.click(getElement(loc3)).build().perform();
	}

} 



