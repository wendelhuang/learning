package com.sklink.learning.dp.builder01;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class BuilderBuilder {
    @Test
    public void test() {
        Class clazz = null;
        try {
            clazz = Class.forName("com.sklink.learning.dp.builder01.Target");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        /*for(Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().toString());
        }*/
        Map<String, Object> map = new HashMap<>();
        map.put("target", "IrTPfRightIssue");
        map.put("fields", fields);
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File("D:\\github\\learning\\src\\main\\resources\\freemarker\\utils"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Template template = null;
        try {
            template = configuration.getTemplate("builderTemplate.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(template, map));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
