<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.entity;
/**
 * <code>${className}</code>数据库映射.
 *
 * @table 	: ${table.sqlName}   ${table.remarks}
 * @version : Ver 1.0
 * @author	: <a href="${authorEmail}">${authorName}</a>
 * @date	:  ${date}  
 */
public class ${className} implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	<#list table.columns as column>

	/**
     * @描述:${column.remarks}     
     * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})  
     */	
	private ${column.javaType} ${column.columnNameLower};
	<#if column.isDateTimeColumn>
	
	/** 非数据库字段，查询时使用 */
	private ${column.javaType} ${column.columnNameLower}Begin;
	
	/** 非数据库字段，查询时使用 */
	private ${column.javaType} ${column.columnNameLower}End;
	</#if> 
	</#list>
	<@generateConstructor className/>
	<@generateJavaColumns/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>
}
<#macro generateJavaColumns>
	<#list table.columns as column>
	
	/**
	 * @param ${column.columnNameLower} ${column.remarks}
	 */
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
	/**
	 * @return ${column.remarks}
	 */
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	<#if column.isDateTimeColumn>
	
	/**
	 * @param ${column.columnNameLower}Begin ${column.remarks}开始
	 */
    public void set${column.columnName}Begin(${column.javaType} ${column.columnNameLower}Begin) {
		this.${column.columnNameLower}Begin = ${column.columnNameLower}Begin;
	}
	
    /**
	 * @return ${column.remarks}开始
	 */
	public ${column.javaType} get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}
	
	/**
	 * @param ${column.columnNameLower}End ${column.remarks}结束
	 */
	public void set${column.columnName}End(${column.javaType} ${column.columnNameLower}End) {
		this.${column.columnNameLower}End = ${column.columnNameLower}End;
	}
	
	/**
	 * @return ${column.remarks}结束
	 */
	public ${column.javaType} get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}	
	</#if>
	</#list>
</#macro>
<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>
<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>

	private String sortColumns;

	public String getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
</#macro>