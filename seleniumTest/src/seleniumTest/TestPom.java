package seleniumTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPom {

	
	@FindBy(className ="login")
	public WebElement login;
	
	@FindBy(xpath="//*[@id=\"login_form\"]/h3")
	public WebElement register;
	
	@FindBy(id ="email")
	public WebElement email;
	
	@FindBy(id ="passwd")
	public WebElement password;
	
	@FindBy(id ="SubmitLogin")
	public WebElement submit;
	
	@FindBy(xpath ="//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a")
	public WebElement address;
	
	@FindBy(xpath ="//*[@id=\"center_column\"]/div[2]/a")
	public WebElement addaddress;
	
	@FindBy(id ="address1")
	public WebElement address1;
	
	@FindBy(id ="address2")
	public WebElement address2;
	
	@FindBy(id ="city")
	public WebElement city;
	
	@FindBy(id ="postcode")
	public WebElement postcode;
	
	@FindBy(id ="phone")
	public WebElement phone;
	
	@FindBy(id ="phone_mobile")
	public WebElement phoneMobile;
	
	@FindBy(id ="other")
	public WebElement addinfo;
	
	@FindBy(id ="alias")
	public WebElement alias;
	
	@FindBy(id="id_state")
	public WebElement state;
	
	@FindBy(id="submitAddress")
	public WebElement submitadd;
	
	@FindBy(id="list")
	public WebElement listview;
	
	@FindBy(id="quantity_wanted")
	public WebElement quantity;
	
	
	@FindBy(id="group_1")
	public WebElement size;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[2]/div/ul/li[1]/a")
	public WebElement color;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
	public WebElement add;
	
	
	@FindBy(css ="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
	public WebElement contshoping;
	
	
	@FindBy(xpath="	//*[@id=\"columns\"]/div[1]/a[4]")
	public WebElement back;
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	public WebElement proceed1;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	public WebElement proceed2;
	
	@FindBy(id="cgv")
	public WebElement accept;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button")
	public WebElement proceed3;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	public WebElement proceed4;
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	public WebElement proceed5;
	
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	public WebElement profile;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")
	public WebElement order;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
