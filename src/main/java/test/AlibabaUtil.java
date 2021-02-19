package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import test.util.HttpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AlibabaUtil {

    public static void main(String[] args){
        Float ci = generateIodCi();
        System.out.println("ci ---" + ci);
    }


    private static Map<String, BigDecimal> getUsdRate(){
        Map<String,BigDecimal> rateMap = new HashMap<>(1);
        String url = "https://www.mycurrency.net/US.json";
        String result = get(url);
        JSONArray ratas = JSONObject.parseObject(result).getJSONArray("rates");
        for(Object rate : ratas){
            JSONObject rateJson = JSONObject.parseObject(String.valueOf(rate));
            rateMap.put(rateJson.getString("code"),new BigDecimal(1).divide(new BigDecimal(rateJson.getDouble("rate")),3, RoundingMode.HALF_UP));
        }
        return rateMap;
    }


    private static Float generateIodCi() {
        int iodDeductMin = new BigDecimal(10.0).setScale(0, RoundingMode.HALF_UP).intValue();
        int iodDeductMax = new BigDecimal(11.0).setScale(0, RoundingMode.HALF_UP).intValue();
        int rondomInt = iodDeductMin;
        Float ci = new BigDecimal(rondomInt).divide(new BigDecimal(100),3,RoundingMode.HALF_UP).floatValue();
        if(iodDeductMax != iodDeductMin){
            rondomInt = new Random().nextInt(iodDeductMax - iodDeductMin + 1) + iodDeductMin;
            ci = new BigDecimal(rondomInt + new Random().nextFloat()).divide(new BigDecimal(100),3,RoundingMode.HALF_UP).floatValue() ;
        }

        return ci;
    }


    public static String get(String url){
        String result = "";
        HttpGet get = new HttpGet(url);
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpResponse response = httpClient.execute(get);
            result = getHttpEntityContent(response);

            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
                result = "服务器异常";
            }
        } catch (Exception e){
            System.out.println("请求异常");
            throw new RuntimeException(e);
        } finally{
            get.abort();
        }
        return result;
    }

    public static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException {
        String result = "";
        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber= new StringBuilder();
            String line = null;
            while((line = br.readLine())!=null){
                strber.append(line+'\n');
            }
            br.close();
            in.close();
            result = strber.toString();
        }

        return result;

    }


}
