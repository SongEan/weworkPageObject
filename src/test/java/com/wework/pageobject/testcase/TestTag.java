package com.wework.pageobject.testcase;

import com.wework.pageobject.page.ContentPage;
import com.wework.pageobject.page.MainPage;
import com.wework.pageobject.util.BaseInit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ Idea IDEA
 * java version "1.8.0_91"
 * Author: Ean Song
 * Date: 2020-06-03
 * Time: 10:15
 */
public class TestTag extends BaseInit {
    public static MainPage mainPage;
    public static ContentPage contentPage;

    @BeforeAll
    public static void beforeAll() {
        mainPage = new MainPage();
        contentPage = mainPage.toContent();
    }

    @AfterAll
    public static void afterAll() {
        contentPage.quit();
    }

    /**
     * 新增标签
     */
    @Test
    void testAddMember() {
        String tagName = contentPage.addDepartment("重要tag").getPartyName();
        assertEquals(tagName, "重要tag");
    }

}
