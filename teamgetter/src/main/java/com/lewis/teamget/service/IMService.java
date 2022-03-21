package com.lewis.teamget.service;
import com.lewis.teamget.utils.getsign.TLSSigAPIv2;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.sf.json.JSONObject;




@Service
public class IMService {


    public String imUser(String openId, String nickName, String faceUrl) throws IOException {
        String URL_IMPORT = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?sdkappid=1400397600&identifier=administrator&usersig=eJw1zNEKgjAYBeB32W3hfrWZCl0UrCAijQQxvDE2x19oNpcI0bsnZpfnO4fzJsnhbHVSk5A4FpD5mFHI2mCJIxeiwhpbowvz0NOgFfeiaVCQ0F4AuMHSA-g1sm9Qy8EZYw781WA1WsA85jv*pC2q4T-m*mZSjTG45Z5HTy6215xGs1OSpS-7su5yuol6Bcec8p1akc8X9ro1YQ__&random=4192147295&contenttype=json";
        // TODO Auto-generated method stub
        // 连接服务器
        HttpURLConnection connection = connection(URL_IMPORT);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        JSONObject obj = new JSONObject();
        obj.element("Identifier", openId);
        obj.element("Nick", nickName);
        obj.element("FaceUrl", faceUrl);
        System.out.println(obj.toString());

        // 向腾讯请求传入编码为UTF-8格式的json数据
        out.write(obj.toString().getBytes("UTF-8"));

        out.flush();
        out.close();
        // 获得服务器返回的结果
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        reader.close();
        System.out.println(sb);
        // 将BufferedReader转换为String 类型，然后进行解析
        String returnString = sb.toString();
        JsonObject jObject =new JsonParser().parse(returnString).getAsJsonObject();
        String ActionStatus = jObject.get("ActionStatus").getAsString();
        System.out.println(ActionStatus);
        return ActionStatus;
    }
    public HttpURLConnection connection(String URL) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        connection.connect();
        return connection;
        // TODO Auto-generated method stub
    }

    public String getUserSig(String openId) {
        // 根据生成的IM用户生成签名
        long SDKAppID = 1400397600;//去应用里边找自己相应的SDKAppID为long类型 例：1400344574
        String miyao = "d61816aa45d7bc7c13fb35b2468163ca5a8797e48d9002794b4de48a8002ab82";//去应用里边找自己相应的秘钥
        String identifier=openId;// 所要生成签名的用户 例：zx5263
        long expire ;// 签名有效时长 例：3600 * 24 * 180
        TLSSigAPIv2 api = new TLSSigAPIv2(SDKAppID, miyao);
        String sign = api.genSig(identifier,3600 * 24 * 180);
        return sign;
    }
}
