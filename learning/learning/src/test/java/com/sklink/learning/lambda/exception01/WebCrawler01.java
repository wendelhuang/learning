package com.sklink.learning.lambda.exception01;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WebCrawler01 {
    public static void main(String[] args) {
        List<String> urlsToCrawl = Arrays.asList("http://www.baidu.com");
        WebCrawler01 webCrawler01 = new WebCrawler01();
        webCrawler01.crawl(urlsToCrawl);
    }

    public void crawl(List<String> urlsToCrawl) {
        // 编译错误, 异常未处理
        //urlsToCrawl.stream().map(u -> new URL(u)).forEach(u -> save(u));
    }

    public void save(URL url) throws IOException {
        String uuid = UUID.randomUUID().toString();
        InputStream inputStream = url.openConnection().getInputStream();
        Files.copy(inputStream, Paths.get(uuid + ".txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
