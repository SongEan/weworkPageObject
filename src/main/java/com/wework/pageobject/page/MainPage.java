package com.wework.pageobject.page;

import com.wework.pageobject.util.BaseInit;
import com.wework.pageobject.util.Utils;
import org.apache.bcel.ExceptionConstants;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 15:26
 */
public class MainPage {
    RemoteWebDriver driver;

    public String url = "https://work.weixin.qq.com/wework_admin/frame#index";

//    public static MainPage mainPage;
//    public static MainPage getInstance() {
//        if (mainPage == null) {
//            mainPage = new MainPage();
//        }
//        return mainPage;
//    }

    public MainPage() {
        String browserName = System.getenv("browser");

        if (browserName.equalsIgnoreCase("firefox")) {
//            如果Firefox无法打开，设置安装路径
            System.setProperty("webdriver.firefox.bin", "Users/songshijie/Documents/Tools/webDriver/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
//            设置ChromeDriver路径为系统属性
            System.setProperty("webdriver.chrome.driver", "/Users/songshijie/Documents/Tools/webDriver/chromedriver");
//            实例化driver为ChromeDriver对象
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
//            设置IE浏览器驱动程序的所在路径为系统属性值
            System.setProperty("webdriver.ie.driver", "/Users/songshijie/Documents/Tools/webDriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.get(url);
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("js_tips")));
        Utils.addCookie(driver, "weWorkCookie.txt");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * 进入通讯录页面
     *
     * @return
     */
    public ContentPage toContent() {
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContentPage(driver);
    }


}
