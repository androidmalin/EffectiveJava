package com.example.memento.factorymethod;

public class URL {

    private static String API_URL = "https://moedu.cmbc.com.cn/edu/";
    private static String API_URL_RES = "http://114.215.31.108:8004/";
    private static final String CDN_DOWNLOAD_RESOURCE_URL = "https://moedudl.cmbc.com.cn/edu/";

    public static void main(String[] args) {
        String filePath = "xxxxxxx";
        String url = getCdnUrlOnLine(filePath, false, true);
        System.out.println(url);
    }

    public static String getCdnUrlOnLine(String url, boolean cdn, boolean isEdu) {
        if (url.startsWith("http") || url.startsWith("resources")) { // 读取网络图片,resources为网络图片约束
            if (url.startsWith("resources")) {
                if (isEdu) {
                    url = API_URL_RES + url;
                } else {
                    if (cdn) {
                        url = CDN_DOWNLOAD_RESOURCE_URL + url;
                    } else {
                        url = API_URL + url;
                    }
                }
            }
        } else if (url.startsWith("/")) {
            if (isEdu) {
                url = API_URL_RES + url.substring(1);
            } else {
                if (cdn) {
                    url = CDN_DOWNLOAD_RESOURCE_URL + url.substring(1);
                } else {
                    url = API_URL + url.substring(1);
                }
            }
        }
        return url;
    }
}
