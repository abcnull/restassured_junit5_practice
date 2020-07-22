package com.wechat.testcase;

import com.wechat.basetest.BaseTest;
import com.wechat.moduleobject.MemberModule;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 通讯录管理-成员管理模块测试
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/22 18:02
 */
public class MemberTest extends BaseTest {
    public static MemberModule memberModule;
    @BeforeAll
    public static void initMemberTest() {
        memberModule = new MemberModule();
    }

    @Test
    public void testCreate() {
        Response response = memberModule.createMember();
        assertAll(
                () -> assertEquals("0", response.path("errorcode").toString()),
                () -> assertEquals("created", response.path("errmsg").toString())
        );
    }

    @Test
    public void testUpdate() {
        // todo : testUpdate
    }

    @Test
    public void testDelete() {
        // todo : testDelete
    }

    @AfterAll
    public static void releaseMemberTest() {
        // todo : releaseMemberTest
    }
}
