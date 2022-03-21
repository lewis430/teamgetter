package com.lewis.teamget.controller;

import com.alibaba.fastjson.JSONObject;
import com.lewis.teamget.VO.Template;
import com.lewis.teamget.VO.TemplateParam;
import com.lewis.teamget.service.UserService;
import com.lewis.teamget.utils.CommonUtil;
import com.lewis.teamget.utils.HttpClientUtil;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WXLoginController {

    @Autowired
    UserService userService;

//    @PostMapping("/wxLogin")
//    public JSONResult wxLogin(@RequestBody Map<String, Object> map){
//        String code=(String)map.get("code");
//
//        System.out.println("wxlogin code："+code);
//        String url = "https://api.weixin.qq.com/sns/jscode2session";
//        Map<String, String> param = new HashMap<>();
//        param.put("appid", "TODO");
//        param.put("secret", "TODO");
//        param.put("js_code", code);
//        param.put("grant_type", "authorization_code");
//
//        String jsonData = HttpClientUtil.doGet(url, param);
//        /*
//        * 成功返回{"session_key":"********","openid":"********"}
//        * 失败返回{"errcode":40163,"errormsg":"code been used,hints:[req_id:dasdas]"}
//        * */
//        System.out.println(jsonData);
//        //如果登录失败
//        if(StringUtils.contains(jsonData,"errcode")){
//            return JSONResult.errorMsg("登录失败");
//        }
//
//
//        //userService.queryUser();
//
//        //成功后
//        String md5Key= DigestUtils.md5Hex(jsonData);
//        String redisKey="WX_LOGIN_"+md5Key;
//
////        Jedis jedis=new Jedis("182.92.101.28",6379);
////        jedis.auth("root");
////        jedis.set(redisKey,jsonData);
////        //设置有效时间
////        jedis.expire(redisKey,5*60);
////        jedis.close();
//        Map<String,String> ticket=new HashMap<>();
//        ticket.put("ticket",redisKey);
//        return JSONResult.ok();
//    }

    @PostMapping("/wxLogin")
    public JSONResult wxLogin(@RequestBody Map<String, Object> map) {
        String code = (String) map.get("code");
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wxbe87d232503ff083");
        param.put("secret", "7f0880a9a843afb7fcf12ec46e521cbb");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        String openid = (String) jsonObject.get("openid");
        System.out.println("openid:" + openid);
        return JSONResult.okData(openid);
    }

    @PostMapping("/getToken")
    public JSONResult getToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wxbe87d232503ff083");
        param.put("secret", "7f0880a9a843afb7fcf12ec46e521cbb");
        param.put("grant_type", "client_credential");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        String access_token = (String) jsonObject.get("access_token");
        System.out.println("access_token:" + access_token);
        return JSONResult.okData(access_token);
    }

//    @PostMapping("/subscribeMessage")
//    public JSONResult subscribeMessage(@RequestBody Map<String,Object> map){
//        String token=(String) getToken().getData();
//        String openId=(String) map.get("openId");
//        String templateId="1";
//        String page="1";
//        String data="1";
//
//        ////////
//        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="+token;
//        Map<String, String> param = new HashMap<>();
////        param.put("access_token", token);
//        param.put("touser", openId);
//        param.put("template_id", templateId);
////        param.put("page", page);
//        param.put("data", data);
//        param.put("miniprogram_state","formal");
//        param.put("lang","zh_CN");
//
//        String wxResult = HttpClientUtil.doPost(url, param);
//        System.out.println(wxResult);
//        JSONObject jsonObject = JSONObject.parseObject(wxResult);
//        //String access_token = (String) jsonObject.get("access_token");
//        //System.out.println("access_token:" + access_token);
////        return JSONResult.okData();
//    }


    @PostMapping("/subscribeMessage")
    public JSONResult subscribeMessage(@RequestBody Map<String,Object> map){

        String Access_Token=(String) getToken().getData();
        //String openId=(String) map.get("openId");

        Template template=new Template();
        template.setTemplate_id("MMCqj_OSbPysIT-eSoj5gUEZRiErJSErES41a_tOojw");
        //template.setTouser(openId);
        template.setPage("pages/index/index");
        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("phrase5","成功"));
        paras.add(new TemplateParam("thing8","成功"));
        template.setTemplateParamList(paras);
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", Access_Token);

        System.out.println(template.toJSON());
        net.sf.json.JSONObject jsonResult= CommonUtil.httpsRequest(requestUrl, "POST", template.toJSON());
        if(jsonResult!=null){
            System.out.println(jsonResult);
            int errorCode=jsonResult.getInt("errcode");
            String errorMessage=jsonResult.getString("errmsg");
            if(errorCode==0){
                System.out.println("Send Success");
            }else{
                System.out.println("订阅消息发送失败:"+errorCode+","+errorMessage);
            }
        }
        return JSONResult.ok();
    }

}
