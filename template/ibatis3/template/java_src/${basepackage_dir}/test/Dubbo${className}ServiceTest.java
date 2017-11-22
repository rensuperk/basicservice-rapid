<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${serviceBasePackage}.test;

import ${basepackage}.entity.${className};
import ${basepackage}.service.Dubbo${className}Service;
import cn.bidlink.base.util.PageSet;

/**
 * <code>${className}</code>Service接口.
 *
 * @version : Ver 1.0
 * @author	: <a href="${authorEmail}">${authorName}</a>
 * @date	:  ${date}
 */
public class Dubbo${className}ServiceTest extends TestBase{

    private Dubbo${className}Service dubbo${className}Service;

    @Override
    protected void init() {
        dubbo${className}Service =context.getBean(Dubbo${className}Service.class);
    }

    public void testSave(){
        ${className} ${classNameLower} = new ${className}();
        print(dubbo${className}Service.save(${classNameLower}));
    }
    public void testUpdate(){
        ${className} ${classNameLower} = new ${className}();
        print(dubbo${className}Service.update(${classNameLower}));
    }
    public void testDelete(){
        Long id = null;
        Long companyId = null;
        print(dubbo${className}Service.delete(id,companyId));
    }
    public void testFindByPK(){
        Long id = null;
        Long companyId = null;
        print(dubbo${className}Service.findByPK(id,companyId));
    }
    public void testGetTotalCount(){
        ${className} ${classNameLower} = new ${className}();
        print(dubbo${className}Service.getTotalCount(${classNameLower}));
    }
    public void testFindByConditionPage(){
        ${className} ${classNameLower} = new ${className}();
        PageSet pageSet = new PageSet();
        print(dubbo${className}Service.findByCondition(${classNameLower},pageSet));
    }
    public void testFindByCondition(){
        ${className} ${classNameLower} = new ${className}();
        print(dubbo${className}Service.findByCondition(${classNameLower}));
    }

    public void testInsertBatch(){
        List<${className}> ${classNameLower}List = new ArrayList<>();

        print(dubbo${className}Service.insertBatch(${classNameLower}List));
    }
}
