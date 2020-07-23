package com.wechat.testcase;

import com.sun.org.glassfish.gmbal.Description;
import com.wechat.basetest.BaseTest;
import com.wechat.moduleobject.MemberModule;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 通讯录管理-成员管理模块测试
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/22 18:02
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberTest extends BaseTest {
    public static MemberModule memberModule;
    @BeforeAll
    public static void initMemberTest() {
        memberModule = new MemberModule();
    }

    @AfterAll
    public static void releaseMemberTest() {
        // todo : releaseMemberTest 释放配置资源
    }

    @BeforeEach
    public void precondition() {
        // todo : precondition 测试前置条件
        // todo : 比如创建成员，这里无需断言
    }

    @AfterEach
    public void postcondition() {
        // todo : postcondition 测试后置条件
        // todo : 比如删除成员，这里无需断言
    }

    @Test
    @Description("创建成员")
    @Order(1)
    public void testCreate() {
        Response response = memberModule.createMember();
        assertAll(
                () -> assertEquals("0", response.path("errorcode").toString()),
                () -> assertEquals("created", response.path("errmsg").toString())
        );
    }

    @Test
    @Description("更新成员")
    @Order(2)
    public void testUpdate() {
        // todo : testUpdate
    }

    @Test
    @Description("删除成员")
    @Order(3)
    public void testDelete() {
        // todo : testDelete
    }
}
