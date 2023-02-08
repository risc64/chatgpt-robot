package com.llf.chatgpt.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import java.io.IOException;

/**
 * @author 李良发
 * @version v1.0.0
 * @since 2023/2/8 11:47
 */
public class MySpiderTest {
    
    @Test
    public void queryQuesttions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie", "zsxq_access_token=544FD498-89E1-9D5F-D6EB-1FB69A8EC3FE_194850ADDC95DEF3; abtest_env=product; zsxqsessionid=fe622e537804e0270698e0e5199e4d5b; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22422128241445218%22%2C%22first_id%22%3A%22185c919af39dd0-0159b0131a7a58a-26021051-2073600-185c919af3a34d%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1YzkxOWFmMzlkZDAtMDE1OWIwMTMxYTdhNThhLTI2MDIxMDUxLTIwNzM2MDAtMTg1YzkxOWFmM2EzNGQiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MjIxMjgyNDE0NDUyMTgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22422128241445218%22%7D%2C%22%24device_id%22%3A%22185c919af39dd0-0159b0131a7a58a-26021051-2073600-185c919af3a34d%22%7D; UM_distinctid=1862eefff0f123a-0d2588ec9c0da-26021051-1fa400-1862eefff101415");
        //get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
        
    }
}
