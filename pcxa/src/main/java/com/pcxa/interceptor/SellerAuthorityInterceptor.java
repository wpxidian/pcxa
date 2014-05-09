package com.pcxa.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pcxa.model.Shop;
/**
 * 
 * 类名称：SellerAuthorityInterceptor   
 * 类描述：权限控制拦截器的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-5-4 下午3:43:28   
 * 修改人：WangPeng   
 * 修改时间：2014-5-4 下午3:43:28   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class SellerAuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7264919584356580500L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx=invocation.getInvocationContext();  
        Map<String, Object> session=ctx.getSession();
        Shop shop = (Shop) session.get("shop") ;
        if(shop != null){
        	return invocation.invoke();  
        }
        return Action.LOGIN; 
	}

}
