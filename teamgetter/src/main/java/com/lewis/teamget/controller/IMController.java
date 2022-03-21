package com.lewis.teamget.controller;

import com.lewis.teamget.service.IMService;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/IM")
public class IMController {

    @Autowired
    IMService imService;

    @PostMapping("/getUserSig")
    public JSONResult getUserSig(@RequestBody Map<String, Object> map){
        String openId=(String)map.get("openId");
        if(openId==null||openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        String sign=imService.getUserSig(openId);
        Map<String,String> result=new HashMap<>();
        result.put("userSig",sign);
        return JSONResult.okData(result);
    }

    @PostMapping("/importUser")
    public JSONResult importUser(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String nickName=(String) map.get("nickName");
        String faceUrl=(String) map.get("faceUrl");
        String result=new String();
        try {
            result=imService.imUser(openId,nickName,faceUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+result);
        if(result.equals("OK")){
            return JSONResult.okMsg("账号导入到腾讯云IM成功");
        }else {
            return JSONResult.errorMsg("账号导入到腾讯云IM失败");
        }
    }
}
