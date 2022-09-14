/**

import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import com.codeborne.selenide.webdriver.SafariDriverFactory;
import com.greglturnquist.learningspringboot.webdriver.WebDriverConfigurationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;



import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import com.codeborne.selenide.webdriver.SafariDriverFactory;
import com.greglturnquist.learningspringboot.webdriver.WebDriverConfigurationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;


// tag::1[]
@Configuration
@ConditionalOnClass(WebDriver.class)
@EnableConfigurationProperties(
	WebDriverConfigurationProperties.class)
@Import({ChromeDriverFactory.class,
	FirefoxDriverFactory.class, SafariDriverFactory.class})
public class WebDriverAutoConfiguration {
// end::1[]

	// tag::2[]
	@Autowired
	WebDriverConfigurationProperties properties;
	// end::2[]

	// tag::3[]
	@Primary
	@Bean(destroyMethod = "quit")
	@ConditionalOnMissingBean(WebDriver.class)
	public WebDriver webDriver(
		FirefoxDriverFactory firefoxDriverFactory,
		SafariDriverFactory safariDriverFactory,
		ChromeDriverFactory chromeDriverFactory) {

		WebDriver driver = firefoxDriverFactory.getObject();

		if (driver == null) {
			driver = safariDriverFactory.getObject();
		}

		if (driver == null) {
			driver = chromeDriverFactory.getObject();
		}

		if (driver == null) {
			driver = new HtmlUnitDriver();
		}

		return driver;
	}
	// end::3[]

	// tag::5[]
	@Bean(destroyMethod = "stop")
	@Lazy
	public ChromeDriverService chromeDriverService() {
		System.setProperty("webdriver.chrome.driver",
			"ext/chromedriver");
		return createDefaultService();
	}
	// end::5[]

}

**/

