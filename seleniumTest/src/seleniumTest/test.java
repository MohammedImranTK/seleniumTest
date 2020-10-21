package seleniumTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class test {
	
	static WebDriver driver;
	
	
	@BeforeClass
	public static  void bclass(){
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	
	}
	@AfterTest
	
	@DataProvider(name = "DP1")
	public Object[][] createData1() throws IOException {
		
	    Object[][] retObjArr=getExcelData("C:\\Users\\moham\\eclipse-workspace\\seleniumTest\\data\\testData.xlsx","Sheet1");
	    return(retObjArr);
	}
	
	@Test(dataProvider = "DP1")
	public void t1(String username,String password,String address1,String address2,String city,String postcode,String phone,String phoneMobile,String addinfo,String alias,String state) throws InterruptedException, IOException{
		
		driver.get("http://automationpractice.com/index.php");
		TestPom demo=PageFactory.initElements(driver, TestPom.class);
		Reporter.log("Brower Open");
		
		String title=driver.getTitle();
		Assert.assertEquals("My Store", title);
		demo.login.click();
		
		Reporter.log("User login");
		
		Thread.sleep(3000);
		String register =demo.register.getText();
		Assert.assertEquals("ALREADY REGISTERED?", register);
		
		
		
		demo.email.sendKeys(username);
		demo.password.sendKeys(password);
		String logintitle=driver.getTitle();
		Assert.assertEquals("Login - My Store", logintitle);
		
		
		
		demo.submit.click();
		Thread.sleep(3000);
		
		Reporter.log("User loged in");
		String accountTitle=driver.getTitle();
		Assert.assertEquals("My account - My Store", accountTitle);
		
		Thread.sleep(3000);
		demo.address.click();	
  		String addressTitle=driver.getTitle();
		Assert.assertEquals("Addresses - My Store", addressTitle);
		Screen_shot("previousaddress");
		demo.addaddress.click();
		Thread.sleep(5000);
		demo.address1.sendKeys(address1);
		demo.address2.sendKeys(address2);
		demo.city.sendKeys(city);
		Thread.sleep(2000);
		demo.postcode.sendKeys(postcode);
		demo.phone.sendKeys(phone);
		demo.phoneMobile.sendKeys(phoneMobile);
		demo.addinfo.sendKeys(addinfo);
		demo.alias.sendKeys(alias);
		Select objSelect =new Select(demo.state);
		objSelect.selectByVisibleText(state);
		demo.submitadd.click();
		Thread.sleep(5000);
		
		Reporter.log("New Address Added");
		Screen_shot("addedaddress");
		
		Actions action = new Actions(driver);
		
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		action.moveToElement(women).moveToElement(driver.findElement(By.xpath("//*[text()='Summer Dresses']"))).click().build().perform();
		
		String itemCount =driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[2]/div[2]")).getText();
        String count = itemCount.split(" ")[5]; //72
        Assert.assertEquals("3", count);
        
        demo.listview.click();
        Thread.sleep(5000);
        Reporter.log("Selection of Product");
		
        int counts  = Integer.parseInt(count);
        	for(int i=1;i<counts+1;i++) 
        {
        	
        	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div/div[3]/div/div[2]/a[2]")).click();
        	
        	
        	demo.quantity.clear();
        	demo.quantity.sendKeys("5");
        	
        	Select objSelect1 =new Select(demo.size);
        		objSelect1.selectByVisibleText("L");
        		
        		demo.color.click();	
        		demo.add.click();
        		Thread.sleep(10000);
        		driver.switchTo().activeElement();

        		demo.contshoping.click();
        		
                Thread.sleep(5000);
                
                demo.back.click();
                Thread.sleep(5000);
                
                Reporter.log("Selection of Product" +i);
           }
        	
		
        	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
    		
		
		
		String price =  driver.findElement(By.id("total_price")).getText();
		
		double price1 = Double.parseDouble(price.trim().substring(1).replaceAll("$", ""));
		Reporter.log("priced Verified");
		
		 
		 demo.proceed1.click();
         Thread.sleep(5000);
         
         Screen_shot("Summary");
         Reporter.log("Summary Screen");
         demo.proceed2.click();
         Thread.sleep(5000);
         Screen_shot("signin");
         Reporter.log("Signin Screen");
         demo.accept.click();
         Thread.sleep(5000);
         Screen_shot("address1");
         Reporter.log("Address validation");
         demo.proceed3.click();
         Thread.sleep(5000);
         Screen_shot("shipping");
         Reporter.log("Final Confirmation");
 String price2 =  driver.findElement(By.id("total_price")).getText();
         
         double price3 = Double.parseDouble(price2.trim().substring(1).replaceAll("$", ""));
         
         Assert.assertEquals(price1, price3);
         
         demo.proceed4.click();
         Thread.sleep(5000);
         Screen_shot("payment");
         
         //Verify Price is same on all places 
         
        	String price4 =  driver.findElement(By.id("amount")).getText();
         
         double price5 = Double.parseDouble(price4.trim().substring(1).replaceAll("$", ""));
         
         
         Assert.assertEquals(price1, price5);
         
         demo.proceed5.click();
         
String price9=  driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/span")).getText();
         
         double price8 = Double.parseDouble(price9.trim().substring(1).replaceAll("$", ""));
         
         
         Assert.assertEquals(price1, price8);
         
         
         demo.profile.click();
         Thread.sleep(2000);
         Screen_shot("profile");
         
		 
         
         demo.order.click();
         Thread.sleep(2000);
         Screen_shot("orderpic");
         
         
      	String price6 =  driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[3]/span")).getText();
      
      double price7 = Double.parseDouble(price6.trim().substring(1).replaceAll("$", ""));
      
      
      Assert.assertEquals(price1, price7);
      Thread.sleep(5000);
      
      driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
  }
	
	
	public static String[][] getExcelData(String fileName, String sheetName)throws IOException{
		String[][] arrayExcelData= null;
		Workbook wb= null;
		try{
		    File file = new File(fileName);
			FileInputStream fs = new FileInputStream(file);
			
			if(fileName.substring(fileName.indexOf(".")).equals(".xlsx")){
				wb = new XSSFWorkbook(fs);
			}else if(fileName.substring(fileName.indexOf(".")).equals(".xls")){
				wb = new HSSFWorkbook(fs);
			}
			Sheet sh = wb.getSheet(sheetName);
			
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println("totalNoOfRows="+totalNoOfRows+", totalNoOfCols="+totalNoOfCols);
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			for(int i=1;i<=totalNoOfRows-1;i++){
			  for(int j=0;j<=totalNoOfCols-1;j++){
			  arrayExcelData[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue().toString();
				}
			}
		}
				
				catch(Exception e){
					System.out.println("error in getExcelData()");
				}
		return arrayExcelData;
			}
	 public void Screen_shot(String Filename) throws IOException
	  {
			File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,  new File("C:\\Users\\moham\\eclipse-workspace\\seleniumTest\\data"+ Filename + ".jpg"));
	  }
	

}
