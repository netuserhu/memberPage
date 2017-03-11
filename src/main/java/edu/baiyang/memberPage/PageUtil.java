package edu.baiyang.memberPage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PageUtil<T> {
    
	private Method pagePrevMethod;
	
	private Method pageAfterMethod;
	
	private Object instPrev;
	
	private Object instAfter;
	
	private PageInfoChange pageInfoChange;
	
	public Pagging<T> mergePage(int pageNo , int pageSize,Object[] argsPrev,Object[] argsAfter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Pagging<T> paging = new Pagging<>();
		
		/**
		 * step:
		 * 1.向方法1拉取数据 结果为list1 数量为total1，实例化list2
		 *   拉够了：
		 *      list2 = list1
		 *      任意拉1次方法2数据 只为了要total2
		 *   没拉够 拉到部分
		 *      list2.addAll(list1)
		 *      获取方法2请求的pageNo
		 *      pageSize*2处理
		 *      list2.addAll(向方法2拉取数据填充到)
		 *      如果list2长度超过pageSize则截取0到pageSize的数据
         *   没拉够 一条都没拉到
		 *      list2.addAll(list1)
		 *      获取方法2请求的pageNo
		 *      pageSize*2处理
		 *      向方法2拉取数据跳过填充临界页的条数
		 *      list2.addAll()
		 *      如果list2长度超过pageSize则截取0到pageSize的数据
		 * 2.实例化page对象
		 *   将total填充为total1+total2
		 *   将data填充list2
		 * 返回list
		 */
		Pagging<T> page1 = (Pagging<T>) pagePrevMethod.invoke(instPrev, argsPrev);
		List<T> list1 = page1.getData();
		List<T> list2 = Lists.newArrayList();
		long tempTotal;
		if (Arguments.notEmpty(list1)) {
			if (list1.size() == pageSize) {
				Pagging<T> page2 = (Pagging<T>) pageAfterMethod.invoke(instAfter, argsAfter);
				tempTotal = page2.getTotal();
				list2 = list1;
			} else {
				int pageNo2 = pageNo - (int) Math.ceil(page1.getTotal() * 1.0 / pageSize);
				int pageSize2 = pageSize;
				Object[] newArgsAfter = pageInfoChange.changeParams(argsAfter, pageNo2, pageSize2);
				Pagging<T> page2 = (Pagging<T>) pageAfterMethod.invoke(instAfter, newArgsAfter);
				tempTotal = page2.getTotal();
				if (Arguments.notEmpty(list1)) {
					list2.addAll(list1);
				}
				if (!Arguments.isEmpty(page2.getData())) {
					list2.addAll(page2.getData());
				}
				if (list2.size() > pageSize) {
					list2 = list2.subList(0, pageSize);
				}
			}
		} else {
			int pageNo2 = pageNo - (int) Math.ceil(page1.getTotal() * 1.0 / pageSize);
			int pageSize2 = pageSize;
			int skip = pageSize - (page1.getTotal().intValue()%pageSize);
			Object[] newArgsAfter = pageInfoChange.changeParams(argsAfter, pageNo2, pageSize2);
			Pagging<T> page2_prev = (Pagging<T>) pageAfterMethod.invoke(instAfter, newArgsAfter);
			newArgsAfter = pageInfoChange.changeParams(argsAfter, pageNo2+1, pageSize2);
			Pagging<T> page2_after = (Pagging<T>) pageAfterMethod.invoke(instAfter, newArgsAfter);
			tempTotal = page2_prev.getTotal();
			if (Arguments.notEmpty(list1)) {
				list2.addAll(list1);
			}
			if (!Arguments.isEmpty(page2_prev.getData())&&skip<page2_prev.getData().size()) {//前面元素执行跳过操作
				list2.addAll(page2_prev.getData().subList(skip, page2_prev.getData().size()));
			}
			if (!Arguments.isEmpty(page2_after.getData())) {
				list2.addAll(page2_after.getData());
			}
			if (list2.size() > pageSize) {
				list2 = list2.subList(0, pageSize);
			}
		}
		paging.setTotal(page1.getTotal()+tempTotal);
		paging.setData(list2);
		return paging;
	}
	
}
