package com.wechat.basemodule;

import com.wechat.constant.WechatConstant;

import static io.restassured.RestAssured.given;

/**
 * BaseModule
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/22 18:05
 */
public class BaseModule {
    /**
     * /cgi-bin/gettoken
     */
    public final String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    /**
     * 访问 /cgi-bin/gettoken 获取 access_token
     * 工厂模式，传入不同 corpsecret 获取不同的 access_token
     *
     * @param corpsecret corpsecret
     * @return access_token
     */
    public String tokenFactoryProduce(String corpsecret) {
        String access_token = given().when()
                    .param("corpid", WechatConstant.CORP_ID)
                    .param("corpsecret", corpsecret)
                    .get(getTokenUrl)
                .then()
                    .log().body()
                .extract()
                    .response()
                .path("access_token");
        return access_token;
    }
}
