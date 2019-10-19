package com.yao.jqr.util;

import com.alibaba.fastjson.JSON;
import com.yao.jqr.dto.JsonRootBean;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class TklUtils {

    private static final String apikey = "loEjPiddsS";
    private static final String host = "https://api.taokouling.com";


    private static final String basePath = "/tkl/tkljm?apikey=loEjPiddsS";


    public String parsingTKL(String tkl) throws Exception {
        String path = basePath+"&tkl="+"￥TH5aYKM3oGq￥";
        HttpResponse get = HttpUtils.doGet(host, path, "GET", new HashMap<String, String>(), new HashMap<String, String>());
        String string = EntityUtils.toString(get.getEntity());
        JsonRootBean jsonRootBean = JSON.parseObject(string, JsonRootBean.class);

        return jsonRootBean.getUrl();
    }

    public static void main(String[] args) throws Exception {
        TklUtils utils = new TklUtils();
        String s = utils.parsingTKL("1213");
        System.out.println(s);
    }
}
