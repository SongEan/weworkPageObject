package com.wework.pageobject.testcase;

import com.wework.pageobject.page.ContentPage;
import com.wework.pageobject.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-01
 * Time: 22:47
 */
public class TestContent {
    public static MainPage mainPage;
    public static ContentPage contentPage;

    @BeforeAll
    public static void beforeAllb() {
        mainPage = new MainPage();
        contentPage = mainPage.toContent();
    }

    @AfterAll
    public static void afterAll() {
        MainPage.driver.quit();
    }

    @Test
    @Order(2)
    void testAddMember() {
        System.out.println("执行1");
        contentPage.addMember("12", "23", "13651362122");
    }

//    @Test
//    @Order(1)
    void testDeleteMember() {
        System.out.println("执行2");
        contentPage.searchMember("12").deleteMember();
    }

}
