package cn.org.rapid_framework.generator.util;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.org.rapid_framework.generator.GeneratorProperties;

public class PathUtil {
	private static final String inAndOutCommon="\\ibatis3\\template\\java_src";
	private static final String outRoot=GeneratorProperties.getProperty("outRoot", "D:\\genOutput")+inAndOutCommon;
	private static final String basepackage="\\"+GeneratorProperties.getProperty("basepackage").replace('.', '\\');
	public static final String SUBCOMMONPATH=inAndOutCommon+"\\${basepackage_dir}";
	/** 模板基路径，即分模块的父目录*/
	public static final String TEPCOMMONPATH=getTplPath()+"\\ibatis3\\template\\java_src\\${basepackage_dir}";
	/** 输出基路径*/
	public static final String OUTCOMMONPATH=outRoot+basepackage;
	
	 
	/**
	 * 得到类路径下指定资源的路径，默认template
	 */
	public static String getTplPath(){
		String resourceName="template";
		Resource res=new ClassPathResource(resourceName);
		File result=null;
		try {
			 result=res.getFile();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
