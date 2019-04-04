package com.sklink.learning.framework.reflect02;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseDao<T> {
    /*private static BasicDataSource dataSource = new BasicDataSource();

    static {

    }*/

    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://118.89.219.190:3306/dp_pro?useUnicode=true&characterEncoding=utf-8&autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Huangww@211");
    }

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    private Class<T> beanClass;

    public BaseDao() {
        beanClass = (Class) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void add(T bean) {
        Field[] declaredFields = beanClass.getDeclaredFields();

        String sql = String.format("insert into %s values(%s)",
                beanClass.getSimpleName(), Arrays.stream(declaredFields).map(f -> "?").collect(Collectors.joining(",")));

        Object[] params = Arrays.stream(declaredFields).map(f -> {
            f.setAccessible(true);
            Object o = null;
            try {
                o = f.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return o;
        }).collect(Collectors.toList()).toArray(new Object[declaredFields.length]);
        /*jdbcTemplate.*/
    }

    public void select() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from CBS_T_BOOK_KEEP limit 3");
        for(Map<String, Object> m : list) {
            System.out.println("---");
            for(String k : m.keySet()) {
                System.out.println(String.format("key: %s, value: %s", k, m.get(k) == null ? "" : m.get(k).toString()));
            }
            System.out.println("---");
        }
    }

    public void select2() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(String.format("select * from %s limit 3", beanClass.getAnnotation(Table.class).value()));
        Arrays.stream(beanClass.getDeclaredFields()).map(f -> f.getName()).forEach(System.out::println);
        for(Map<String, Object> m : list) {
            System.out.println("---");
            for(String k : m.keySet()) {
                System.out.println(String.format("key: %s, value: %s", k, m.get(k) == null ? "" : m.get(k).toString()));
            }
            System.out.println("---");
        }
    }


}
