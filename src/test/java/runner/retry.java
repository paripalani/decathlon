package runner;


	
	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	import io.cucumber.junit.CucumberOptions.SnippetType;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"C:\\maven\\decathlon\\target\\rerun.txt"},
	                 glue = {"decathlon"},
	                 plugin = {"pretty",
	                 		"html:C:\\maven\\decathlon\\target\\report.html",
	                        "json:C:\\maven\\decathlon\\target\\report.json",
	                 		"junit:C:\\maven\\decathlon\\target\\report.xml",
	                 		"rerun:C:\\maven\\decathlon\\target\\rerun.txt"},
	                 monochrome = true,
	                 dryRun = false,
	                 snippets = SnippetType.CAMELCASE)

	public class retry {

	}


