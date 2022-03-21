package com.lewis.teamget.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.FileInputStream;
import java.util.UUID;

/**
 * 七牛云工具类
 */
public class QiniuUtils {
    //http://qkx7xboud.hn-bkt.clouddn.com/
    //http://qn7w8hyoz.hn-bkt.clouddn.com/
    public  static String qiniu_img_url_pre = "http://qowu3u4sd.hn-bkt.clouddn.com/";
    public  static String accessKey = "gWwaPpWBxiATEA-g5DjIPqEDNLsK811UhU3MyL-M";
    public  static String secretKey = "x1R5czbtWp3rsJ3WSXoHJyv7wuU730rOBItE2vz3";
    public  static String bucket = "teamzhengshi3";

    /**
     * 上传文件
     * @param bytes 文件内容，字节数组
     * @param uploadFileName 保存到服务端的文件名
     */
    public static String upload2Qiniu(byte[] bytes, String uploadFileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = uploadFileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            //解析上传成功的结果
            System.out.println(response.bodyString());
            // 访问路径
            System.out.println(qiniu_img_url_pre+uploadFileName);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                ex.printStackTrace();
            }
        }
        String result=qiniu_img_url_pre+uploadFileName;
        return result;
    }

    /**
     * 删除文件
     * @param fileName 服务端文件名
     */
    public static void deleteFileFromQiniu(String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
        System.out.println("删除成功");
    }
    // 测试上传与删除
    public static void main(String args[]) throws Exception{
        // 测试上传
        String localFilePath = "D:\\test.jpg";
        FileInputStream fileInputStream = new FileInputStream(localFilePath);
        byte[] data = new byte[1024*1024];
        fileInputStream.read(data);
        String saveFileName = UUID.randomUUID().toString().replace("-","");
        QiniuUtils.upload2Qiniu(data,saveFileName);

        // 测试删除
        deleteFileFromQiniu(saveFileName);
    }
}