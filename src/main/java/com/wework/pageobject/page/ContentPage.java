package com.wework.pageobject.page;

import com.wework.pageobject.util.BaseInit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 22:35
 */
public class ContentPage extends BaseInit {

    By addMemberText = By.linkText("添加成员");
    By username = By.name("username");
    By deleteText = By.linkText("删除");
    By confirmText = By.linkText("确认");
    By clearSearchInputButton = By.id("clearMemberSearchInput");

    public ContentPage(RemoteWebDriver driver) {
        super(driver);
    }

    /**
     * 添加新用户
     *
     * @param username
     * @param acctid
     * @param memberAdd_phone
     */
    public ContentPage addMember(String username, String acctid, String memberAdd_phone) {
        while (driver.findElements(this.username).size() == 0) {
            click(addMemberText);
        }

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(memberAdd_phone);
        driver.findElement(By.cssSelector(".js_btn_save")).click();

        return this;
    }

    /**
     * 搜索成员
     *
     * @param keyword
     * @return
     */
    public ContentPage searchMember(String keyword) {
        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        return this;
    }

    /**
     * 删除搜索到的成员
     */
    public ContentPage deleteMember() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(deleteText);
        click(confirmText);
//        删除搜索框输入内容
        click(clearSearchInputButton);
        return this;
    }
}
