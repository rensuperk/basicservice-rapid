package cn.org.rapid_framework.generator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
		// 打印数据库中的表名称
		GeneratorFacade.printAllTableNames();
		// 删除生成器的输出目录
		g.deleteOutRootDir();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd aHH:mm:ss");
		GeneratorProperties.setProperty("date", sdf.format(new Date()));

		// 通过数据库表生成文件,template为模板的根目录
		String[] tables = { "bid_uploadfile_recode" };

		for (String tablename : tables) {
			g.generateByTable(tablename, "template");
		}

		// 删除生成的文件
		// g.deleteByTable("table_name", "template");

		// 打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
