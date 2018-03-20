import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepDef {
	
  @Given("^Hi World$")
  public void world() {
	  System.out.println("Hi world");
  }
    
}