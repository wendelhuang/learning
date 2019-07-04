package com.sosimplebox.mall_000.mbg;

import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

public class CommentGenerator extends DefaultCommentGenerator {
	private boolean addRemarkComments = false;
	
	@Override
	public void addConfigurationProperties(Properties properties) {
		super.addConfigurationProperties(properties);
		this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
	}
	
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		String remarks = introspectedColumn.getRemarks();
		if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
			addFieldJavaDoc(field, remarks);
		}
	}
	
	private void addFieldJavaDoc(Field field, String remarks) {
		field.addJavaDocLine("/**");
		String[] remarkLines = remarks.split(System.getProperty("line.separator"));
		for(String remarkLine : remarkLines) {
			field.addJavaDocLine(" * " + remarkLine);
		}
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}
}
