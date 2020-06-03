package com.wework.pageobject.page;

import com.wework.pageobject.util.BaseInit;
import com.wework.pageobject.util.Utils;
import org.openqa.selenium.By;

/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 15:26
 */
public class MainPage extends BaseInit {

    public String url = "https://work.weixin.qq.com/wework_admin/frame#index";

    public MainPage() {
        super();
        driver.get(url);
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("js_tips")));
        Utils.addCookie(driver, "weWorkCookie.txt");
        driver.get(url);
    }

    /**
     * 进入通讯录页面
     *
     * @return
     */
    public ContentPage toContent() {
        click(By.cssSelector("#menu_contacts"));
//        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContentPage(driver);
    }


}
