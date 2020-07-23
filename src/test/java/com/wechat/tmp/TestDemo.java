package com.wechat.tmp;

import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/21 17:13
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDemo {
    public static String accessToken;

    @BeforeAll
    public static void beforeAll() {
        accessToken = given().when()
                .param("corpid", "wwd2f79f6df4aa2617")
                .param("corpsecret", "FeRPGfjboDtbjh9XpIZnHm8OZdKBNT9DO_eDz0O4CCw")
                .get(" https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().body()
                .extract()
                .response()
                .path("access_token");
    }

    @Test
    @Description("创建部门")
    @Order(1)
    public void createSth() {
        String body = "    {\n" +
                "       \"name\": \"广州研发中心\",\n" +
                "       \"name_en\": \"RDGZ\",\n" +
                "       \"parentid\": 1,\n" +
                "       \"order\": 1,\n" +
                "       \"id\": 2\n" +
                "    }";
        Response response = given().when()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", response.path("errorcode").toString());

    }
}
