package com.wechat.moduleobject;

import com.wechat.basemodule.BaseModule;
import com.wechat.constant.WechatConstant;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

/**
 * 通讯录管理-成员管理模块
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/22 18:06
 */
@Slf4j
public class MemberModule extends BaseModule {
    /**
     * access_token
     */
    public String access_token;

    /**
     * /cgi-bin/user/create
     * 创建成员
     */
    public final String createMemberApi = "https://qyapi.weixin.qq.com/cgi-bin/user/create";

    /**
     * /cgi-bin/user/update
     * 更新成员
     */
    public final String updateMemberApi = "https://qyapi.weixin.qq.com/cgi-bin/user/update";

    /**
     * /cgi-bin/user/delete
     * 删除成员
     */
    public final String deleteMemberApi = "https://qyapi.weixin.qq.com/cgi-bin/user/delete";

    /**
     * Constructor
     */
    public MemberModule() {
        access_token = super.tokenFactoryProduce(WechatConstant.ADDRESSLIST_CORP_SECRET);
    }

    /**
     * 创建成员
     *
     * @return Response
     */
    public Response createMember() {
        log.info("创建成员");
        String requestBody = "    {\n" +
                "        \"userid\": \"zhangsan\",\n" +
                "        \"name\": \"张三\",\n" +
                "        \"alias\": \"jackzhang\",\n" +
                "        \"mobile\": \"+86 13800000000\",\n" +
                "        \"department\": [1, 2],\n" +
                "        \"order\":[10,40],\n" +
                "        \"position\": \"产品经理\",\n" +
                "        \"gender\": \"1\",\n" +
                "        \"email\": \"zhangsan@gzdev.com\",\n" +
                "        \"is_leader_in_dept\": [1, 0],\n" +
                "        \"enable\":1,\n" +
                "        \"avatar_mediaid\": \"2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0\",\n" +
                "        \"telephone\": \"020-123456\",\n" +
                "        \"address\": \"广州市海珠区新港中路\",\n" +
                "        \"main_department\": 1,\n" +
                "        \"extattr\": {\n" +
                "            \"attrs\": [\n" +
                "                {\n" +
                "                    \"type\": 0,\n" +
                "                    \"name\": \"文本名称\",\n" +
                "                    \"text\": {\n" +
                "                        \"value\": \"文本\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"type\": 1,\n" +
                "                    \"name\": \"网页名称\",\n" +
                "                    \"web\": {\n" +
                "                        \"url\": \"http://www.test.com\",\n" +
                "                        \"title\": \"标题\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"to_invite\": true,\n" +
                "        \"external_position\": \"高级产品经理\",\n" +
                "        \"external_profile\": {\n" +
                "            \"external_corp_name\": \"企业简称\",\n" +
                "            \"external_attr\": [\n" +
                "                {\n" +
                "                    \"type\": 0,\n" +
                "                    \"name\": \"文本名称\",\n" +
                "                    \"text\": {\n" +
                "                        \"value\": \"文本\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"type\": 1,\n" +
                "                    \"name\": \"网页名称\",\n" +
                "                    \"web\": {\n" +
                "                        \"url\": \"http://www.test.com\",\n" +
                "                        \"title\": \"标题\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"type\": 2,\n" +
                "                    \"name\": \"测试app\",\n" +
                "                    \"miniprogram\": {\n" +
                "                        \"appid\": \"wx8bd8012614784fake\",\n" +
                "                        \"pagepath\": \"/index\",\n" +
                "                        \"title\": \"my miniprogram\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }";
        return given().when()
                    .contentType("application/json")
                    .body(requestBody)
                    .post(createMemberApi + "?access_token=" + access_token)
                .then()
                    .log().body()
                .extract()
                    .response();
    }

    /**
     * 更新成员
     */
    public void updateMember() {
        log.info("更新成员");
        // todo : 更新成员
    }

    /**
     * 删除成员
     */
    public void deleteMember() {
        log.info("删除成员");
        // todo : 删除成员
    }
}
