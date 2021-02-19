package test.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class HttpUtil {

    public static String doGet(String url) {
//		HttpGet httpRequest = new HttpGet(url);
        HttpGet httpRequest = new HttpGet(url);
        String strResult = null;
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                strResult = EntityUtils.toString(httpResponse.getEntity());
            } else {
                strResult = "error";
                httpRequest.abort();
            }
        } catch (Exception e) {
            httpRequest.abort();
        } finally {
            if(null != httpRequest){
                httpRequest.releaseConnection();
            }
            if(null != httpClient){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return strResult;
    }


    public static CloseableHttpClient getHttpClient() {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(20 * 1000)
                .setConnectionRequestTimeout(20 * 1000)
                .setSocketTimeout(20 * 1000)
                .build();
        return  HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
    }
}
