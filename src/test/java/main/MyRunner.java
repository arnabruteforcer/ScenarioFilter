package main;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyRunner {

  @CucumberOptions(features = "src/test/Features",
  glue = "src/test/StepDefs")
  public class RunCukesByFeatureAndCompositionTest1 {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
      testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Before
    public void doNothin( Scenario scenario ) {
      System.out.println("Hi this is Thread from before method" + Thread.currentThread().getId() );
  
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
      System.out.println("Hey this is " + Thread.currentThread().getId());
      testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
      return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
      testNGCucumberRunner.finish();
    }
  }
}
