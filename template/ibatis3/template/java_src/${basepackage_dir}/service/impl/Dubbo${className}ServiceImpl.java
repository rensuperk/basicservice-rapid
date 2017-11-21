<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${serviceImplBasePackage};

import java.util.List;
import ${daoBasePackage}.${className}Dao;
import ${basepackage}.entity.${className};
import ${serviceBasePackage}.Dubbo${className}Service;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import cn.bidlink.base.ServiceResult;
import cn.bidlink.base.util.PageSet;

/**
 * <code>${className}Service</code>接口实现.
 *
 * @version : Ver 1.0
 * @author	: <a href="${authorEmail}">${authorName}</a>
 * @date	:  ${date}   
 */

public class Dubbo${className}ServiceImpl implements Dubbo${className}Service {

	private ${className}Dao ${classNameLower}Dao;

	private static Logger log = LoggerFactory.getLogger(Dubbo${className}ServiceImpl.class);

	@Override
	public ServiceResult<Long> save(${className} ${classNameLower}){
		ServiceResult<Long> result = new ServiceResult<>();

		try{
			${classNameLower}Dao.insert(${classNameLower});
			result.setResult(${classNameLower}.getId());
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.save]");
			log.error("方法使用参数：[${classNameLower}:{}]", ${classNameLower});
			log.error("异常信息：{}", e);
			result.setErrMessage("调用save方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<Integer> update(${className} ${classNameLower}){
		ServiceResult<Integer> result = new ServiceResult<>();

		try{
			int row = ${classNameLower}Dao.update(${classNameLower});
			result.setResult(row);
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.update]");
			log.error("方法使用参数：[${classNameLower}:{}]", ${classNameLower});
			log.error("异常信息：{}", e);
			result.setErrMessage("调用update方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<Integer> delete(Long id, Long companyId){
		ServiceResult<Integer> result = new ServiceResult<>();

		try{
			int row = ${classNameLower}Dao.delete(id, companyId);
			result.setResult(row);
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.delete]");
			log.error("方法使用参数：[id:{}, companyId:{}]", id, companyId);
			log.error("异常信息：{}", e);
			result.setErrMessage("调用delete方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<${className}> findByPK(Long id, Long companyId){
		ServiceResult<${className}> result = new ServiceResult<>();

		try{
			${className} ${classNameLower} = ${classNameLower}Dao.getByPK(id, companyId);
			result.setResult(${classNameLower});
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.findByPK]");
			log.error("方法使用参数：[id:{}, companyId:{}]", id, companyId);
			log.error("异常信息：{}", e);
			result.setErrMessage("调用findByPK方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<Long> getTotalCount(${className} ${classNameLower}){
		ServiceResult<Long> result = new ServiceResult<>();

		try{
			long count = ${classNameLower}Dao.getFind${className}Count(${classNameLower});
			result.setResult(count);
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.getTotalCount]");
			log.error("方法使用参数：[${classNameLower}:{}]", ${classNameLower});
			log.error("异常信息：{}", e);
			result.setErrMessage("调用getTotalCount方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<List<${className}>> findByCondition(${className} ${classNameLower}, PageSet pageSet){
		ServiceResult<List<${className}>> result = new ServiceResult<>();

		try{
			if(pageSet != null){
				if(null != pageSet.getPageNum() && null != pageSet.getPageSize()){
					PageHelper.startPage(pageSet.getPageNum(), pageSet.getPageSize());
					if(StringUtils.hasLength(pageSet.getSortColumn())){
						PageHelper.orderBy(pageSet.getSortColumn());
					}
				}
			}

			List<${className}> list = ${classNameLower}Dao.find${className}(${classNameLower});
			result.setResult(list);
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.findByCondition]");
			log.error("方法使用参数：[${classNameLower}:{}, pageSet:{}]", ${classNameLower}, pageSet);
			log.error("异常信息：{}", e);
			result.setErrMessage("调用findByCondition方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

	@Override
	public ServiceResult<List<${className}>> findByCondition(${className} ${classNameLower}){
		return this.findByCondition(${classNameLower}, null);
	}
	@Override
	public ServiceResult<Integer> insertBatch(List<${className}> ${classNameLower}List) {

		ServiceResult<Integer> result = new ServiceResult<>();

		try{
			${classNameLower}Dao.insertBatch(${classNameLower}List);
		}catch(Exception e){
			log.error("调用{}方法 异常", "[Dubbo${className}ServiceImpl.insertBatch]");
			log.error("方法使用参数：[${classNameLower}:{}]", ${classNameLower}List);
			log.error("异常信息：{}", e);
			result.setErrMessage("调用save方法异常，异常信息：" + e.getMessage());
		}

		return result;
	}

}
