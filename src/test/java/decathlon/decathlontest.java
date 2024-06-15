package decathlon;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class decathlontest extends Baseclass {
	

@Given("I am on the Decathlon homepage")
public void i_am_on_the_decathlon_homepage() {
    
	boolean status = findelement("xpath","//div[@id='__next']").isDisplayed();
	Assert.assertEquals(true, status);
}

@When("I navigate to the all section section")
public void i_navigate_to_the_all_section_section() {
	
	WebElement sports = findelement("xpath","//p[text()=' Sports']");
	sports.click();
   
	
}
   
@When("I select Running as my sport")
public void iSelectRunningAsMySport() {
  
	Wait(5);
	WebElement running = findelement("xpath","//a[normalize-space()='Running']");
	running.click();
}

@Then("I should see a list of running-related products")
public void i_should_see_a_list_of_running_related_products() {
	
	 boolean status1 = findelement("xpath","//p[text()='Running Accessories']").isDisplayed();
	Assert.assertEquals(true, status1);
}

@Given("I am viewing a product page")
public void i_am_viewing_a_product_page() {
	
	
	WebElement sports = findelement("xpath","//p[text()=' Sports']");
	sports.click();
	
	Wait(5);
	WebElement running = findelement("xpath","//a[text()='Running']");
	running.click();
	
    WebElement running1 = findelement("xpath","//img[@alt='Running']");
    running1.click();
    
    switchToSecondWindow();
	
	WebElement shoe = findelement("xpath","//div[@id='8733469']");
	shoe.click(); }
    


@When("I click on the Add to Cart button")
public void iClickOnTheAddToCartButton() {
	
	WebElement size = findelement("xpath","(//div[normalize-space()='8'])[2]");
	size.click();
	
	WebElement addtocart = findelement("xpath","//span[text()='ADD TO CART ']");
	addtocart.click();
    
}

@Then("the product should be added to my shopping cart")
public void the_product_should_be_added_to_my_shopping_cart() {
	
	WebElement cart = findelement("xpath","//a[contains(@href,'/cart')]");
	cart.click();
	
	Wait(5);
	
	 boolean status3 = findelement("xpath","//p[text()='JOGFLOW 100 Superior Grip Cushioned Men Running Shoes max 10km/wk- Navy Orange']").isDisplayed();
	 Assert.assertEquals(true, status3);
	
	 System.out.println("task completed");
		
}


@When("I navigate to the shopping cart page")
public void i_navigate_to_the_shopping_cart_page() {
	
	
	
    System.out.println("ur in cart");
	
    System.out.println("task completed");
	
}

@When("I click on the Remove button for a product")
public void iClickOnTheRemoveButtonForAProduct() {
	
	Wait(5);
  
	WebElement remove = findelement("xpath","(//button[@type='button'])[2]");
	remove.click();
	
	WebElement delete = findelement("xpath","//span[text()='DELETE']");
	delete.click();
}



@Then("the product should be removed from my cart")
public void theProductShouldBeRemovedFromMyCart() {
	
	
	boolean displayed = findelement("xpath","//a[text()='CONTINUE SHOPPING']").isDisplayed();
	Assert.assertEquals(true, displayed);
	
	System.out.println("task completed");
	
   
	
}
    
	
	
}
