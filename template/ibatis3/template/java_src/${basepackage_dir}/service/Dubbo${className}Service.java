<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${serviceBasePackage};

import java.util.List;
import cn.bidlink.base.ServiceResult;
import cn.bidlink.base.util.PageSet;
import ${basepackage}.entity.${className};
/**
 * <code>${className}</code>Service接口.
 *
 * @version : Ver 1.0
 * @author	: <a href="${authorEmail}">${authorName}</a>
 * @date	:  ${date}
 */
public interface Dubbo${className}Service {
	/**
	 * 新增条目
	 * @param ${classNameLower} 带有新增数据的对象
	 * @return 返回新增条目数据库影响数
	 */
	ServiceResult<Long> save(${className} ${classNameLower});

	/**
	 * 更新条目
	 * @param ${classNameLower} 带有更新数据的对象
	 * @return 返回更新条目数据库影响数
	 */
	ServiceResult<Integer> update(${className} ${classNameLower});

	/**
	 * 根据ID删除对应条目
	 * @param id id
	 * @return 返回删除条目数据库影响数
	 */
	ServiceResult<Integer> delete(Long id);
	/**
	 * 根据IDS删除对应条目
	 * @param ids ids
	 * @return 返回删除条目数据库影响数
	 */
	ServiceResult<Integer> deleteBatch(List<Long> ids);
	/**
	 * 根据ID查询对应的条目
	 * @param id id
	 * @return 返回查询的结果
	 */
	ServiceResult<${className}> findByPK(Long id);

	/**
	 * 根据条件查询对应的条目总数
	 * @param ${classNameLower} 带有查询条件的对象
	 * @return 返回查询的结果总数
	 */
	ServiceResult<Long> getTotalCount(${className} ${classNameLower});

	/**
	 * 根据条件查询对应的条目
	 * @param ${classNameLower} 带有查询条件的对象
	 * @param pageSet   分页对象
	 * @return 返回查询的结果集合
	 */
	ServiceResult<List<${className}>> findByCondition(${className} ${classNameLower},PageSet pageSet);

	/**
	 * 根据条件查询对应的条目
	 * @param ${classNameLower} 带有查询条件的对象
	 * @return 返回查询的结果集合
	 */
	ServiceResult<List<${className}>> findByCondition(${className} ${classNameLower});

	/**
	 *
	 * @param ${classNameLower}List 需要批量出入的对象集合
	 * @return 返回数据库的影响条数
	 */
	ServiceResult<Integer> insertBatch(List<${className}> ${classNameLower}List);

}
