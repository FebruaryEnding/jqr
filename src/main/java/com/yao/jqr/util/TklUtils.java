package com.yao.jqr.util;

import com.alibaba.fastjson.JSON;
import com.yao.jqr.dto.JOSNObject.JsonRootBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TklUtils {

    private static final String apikey = "loEjPiddsS";
    private static final String host = "https://api.taokouling.com";

    private static HashMap cacheMap = new HashMap();
    private static final String basePath = "/tkl/tkljm?apikey=loEjPiddsS";


    public String parsingTKL(String tkl) throws Exception {
        String result = (String) cacheMap.get(tkl);
        if (StringUtils.isEmpty(result)) {
            String path = basePath + "&tkl=" + tkl;
            HttpResponse get = HttpUtils.doGet(host, path, "GET", new HashMap<String, String>(), new HashMap<String, String>());
            String string = EntityUtils.toString(get.getEntity());
            JsonRootBean jsonRootBean = JSON.parseObject(string, JsonRootBean.class);
            result = jsonRootBean.getUrl();
            if(cacheMap.size() >1000){
                cacheMap.clear();
            }
            cacheMap.put(tkl, result);
        }
        return result;
    }

//    public static void main(String[] args) throws Exception {
//        TklUtils utils = new TklUtils();
//        String s = utils.parsingTKL("1213");
//        System.out.println(s);
//    }
}
