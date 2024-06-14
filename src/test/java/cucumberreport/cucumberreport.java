package cucumberreport;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class cucumberreport {
	public static void main(String[] args) {
		
	
	File f = new File("C:\\Users\\parip\\Desktop\\report\\decreport");
	
        List<String> li = new LinkedList<String>();
        li.add("C:\\maven\\decathlon\\target\\report.json");
        
      String  projectname="deco";
        
        Configuration con = new Configuration(f,projectname);
        con.setBuildNumber("2");
        con.addClassifications("Environment", "service");
        con.addClassifications("Browser", "Chrome");
        con.addClassifications("OS", "Windows 10");
        con.addClassifications("Team", "QA Team");
        con.addClassifications("Execution Mode", "Headless");
        con.addClassifications("Database", "excel");
        con.addClassifications("Test Type", "smoke");
        con.addClassifications("Locale", "en_US");
        
        ReportBuilder reportBuilder = new ReportBuilder(li, con);
        reportBuilder.generateReports();
        
        System.out.println("report generated");
        
}
}