package com.sklink.learning.lambda.exception01;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WebCrawler04 {
    public static void main(String[] args) {
        List<String> urlsToCrawl = Arrays.asList("http://www.baidu.com");
        WebCrawler04 webCrawler01 = new WebCrawler04();
        webCrawler01.crawl(urlsToCrawl);
    }

    public void crawl(List<String> urlsToCrawl) {
        // compile error
        urlsToCrawl.stream().map(this::createURL).forEach(u -> save(u));
    }
    public URL createURL(String urlToCrawl) {
        try {
            return new URL(urlToCrawl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void save(URL url){
        String uuid = UUID.randomUUID().toString();
        InputStream inputStream = null;
        try {
            inputStream = url.openConnection().getInputStream();
            Files.copy(inputStream, Paths.get(uuid + ".txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
