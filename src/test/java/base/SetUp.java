package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.tracing.Propagator;

import net.bytebuddy.asm.Advice.Return;

public class SetUp {
	WebDriver driver;
	public Properties prop;
	
	public void loadConfig() throws IOException{
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"/src/test/java/config/config.properties");
		FileInputStream data = new FileInputStream(file);
		prop.load(data);
 	} 
	
	public WebDriver browser(String browserName) {
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		return driver;
	}
}
