package com.sklink.learning.dp.builder01;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
public class BuilderBuilder2 {
    @Test
    public void test() {
        Class clazz = null;
        try {
            clazz = Class.forName("com.sosimplebox.utils.dp.dp01.Target");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            System.out.println(f.getName());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("target", "IrTPfPositionFrozen");
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File("D:\\github\\spring-boot-01\\src\\main\\resources\\freemarker\\utils\\"));
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
