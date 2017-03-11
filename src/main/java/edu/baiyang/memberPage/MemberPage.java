package edu.baiyang.memberPage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MemberPage {
	PageUtil<Integer> pageUtil = null;
	@Before
	public void init() throws NoSuchMethodException, SecurityException{
		Method method1 = MemberPage.class.getDeclaredMethod("getData1", new Class[] { int.class, int.class });
		Method method2 = MemberPage.class.getDeclaredMethod("getData2", new Class[] { int.class, int.class });
		MemberPage obj = new MemberPage();
		PageInfoChange pageInfoChange = new PageInfoChange(){
			@Override
			public Object[] changeParams(Object[] params, int newPageNo, int newPageSize) {
				Object[] objects = new Object[2];
				objects[0] = newPageNo;
				objects[1] = newPageSize;
				return objects;
			}
			
		};
		pageUtil = new PageUtil<>(method1, method2, obj, obj, pageInfoChange);
	}
	
	@Test
	public void test1() {
		try {
			int pageNo = 1;
			int pageSize = 10;
			Object[] params = new Object[]{pageNo,pageSize};
			Pagging<Integer> Pagging = pageUtil.mergePage(pageNo, pageSize,params ,params);
			Assert.assertEquals(88l, Pagging.getTotal().longValue());
			Assert.assertEquals(0, Pagging.getData().get(0).intValue());
			Assert.assertEquals(1, Pagging.getData().get(1).intValue());
			Assert.assertEquals(2, Pagging.getData().get(2).intValue());
			Assert.assertEquals(3, Pagging.getData().get(3).intValue());
			Assert.assertEquals(4, Pagging.getData().get(4).intValue());
			Assert.assertEquals(5, Pagging.getData().get(5).intValue());
			Assert.assertEquals(6, Pagging.getData().get(6).intValue());
			Assert.assertEquals(7, Pagging.getData().get(7).intValue());
			Assert.assertEquals(8, Pagging.getData().get(8).intValue());
			Assert.assertEquals(9, Pagging.getData().get(9).intValue());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			Assert.assertEquals(0, 1);
		}
	   
	}
	
	@Test
	public void test2() {
		try {
			int pageNo = 7;
			int pageSize = 10;
			Object[] params = new Object[]{pageNo,pageSize};
			Pagging<Integer> Pagging = pageUtil.mergePage(pageNo, pageSize, params ,params);
			Assert.assertEquals(88l, Pagging.getTotal().longValue());
			Assert.assertEquals(128, Pagging.getData().get(0).intValue());
			Assert.assertEquals(129, Pagging.getData().get(1).intValue());
			Assert.assertEquals(130, Pagging.getData().get(2).intValue());
			Assert.assertEquals(131, Pagging.getData().get(3).intValue());
			Assert.assertEquals(132, Pagging.getData().get(4).intValue());
			Assert.assertEquals(133, Pagging.getData().get(5).intValue());
			Assert.assertEquals(134, Pagging.getData().get(6).intValue());
			Assert.assertEquals(135, Pagging.getData().get(7).intValue());
			Assert.assertEquals(136, Pagging.getData().get(8).intValue());
			Assert.assertEquals(137, Pagging.getData().get(9).intValue());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			Assert.assertEquals(0, 1);
		}
	   
	}
	
	@Test
	public void test3() {
		try {
			int pageNo = 3;
			int pageSize = 10;
			Object[] params = new Object[]{pageNo,pageSize};
			Pagging<Integer> Pagging = pageUtil.mergePage(pageNo, pageSize,params ,params);
			Assert.assertEquals(88l, Pagging.getTotal().longValue());
			Assert.assertEquals(20, Pagging.getData().get(0).intValue());
			Assert.assertEquals(21, Pagging.getData().get(1).intValue());
			Assert.assertEquals(22, Pagging.getData().get(2).intValue());
			Assert.assertEquals(23, Pagging.getData().get(3).intValue());
			Assert.assertEquals(24, Pagging.getData().get(4).intValue());
			Assert.assertEquals(25, Pagging.getData().get(5).intValue());
			Assert.assertEquals(26, Pagging.getData().get(6).intValue());
			Assert.assertEquals(27, Pagging.getData().get(7).intValue());
			Assert.assertEquals(28, Pagging.getData().get(8).intValue());
			Assert.assertEquals(29, Pagging.getData().get(9).intValue());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			Assert.assertEquals(0, 1);
		}
	   
	}
	
	@Test
	public void test4() {
		try {
			int pageNo = 6;
			int pageSize = 10;
			Object[] params = new Object[]{pageNo,pageSize};
			Pagging<Integer> Pagging = pageUtil.mergePage(pageNo, pageSize, params ,params);
			Assert.assertEquals(88l, Pagging.getTotal().longValue());
			Assert.assertEquals(50, Pagging.getData().get(0).intValue());
			Assert.assertEquals(51, Pagging.getData().get(1).intValue());
			Assert.assertEquals(120, Pagging.getData().get(2).intValue());
			Assert.assertEquals(121, Pagging.getData().get(3).intValue());
			Assert.assertEquals(122, Pagging.getData().get(4).intValue());
			Assert.assertEquals(123, Pagging.getData().get(5).intValue());
			Assert.assertEquals(124, Pagging.getData().get(6).intValue());
			Assert.assertEquals(125, Pagging.getData().get(7).intValue());
			Assert.assertEquals(126, Pagging.getData().get(8).intValue());
			Assert.assertEquals(127, Pagging.getData().get(9).intValue());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			Assert.assertEquals(0, 1);
		}
	   
	}
	
	@Test
	public void test5() {
		try {
			int pageNo = 8;
			int pageSize = 10;
			Object[] params = new Object[]{pageNo,pageSize};
			Pagging<Integer> Pagging = pageUtil.mergePage(pageNo, pageSize, params ,params);
			Assert.assertEquals(88l, Pagging.getTotal().longValue());
			Assert.assertEquals(138, Pagging.getData().get(0).intValue());
			Assert.assertEquals(139, Pagging.getData().get(1).intValue());
			Assert.assertEquals(140, Pagging.getData().get(2).intValue());
			Assert.assertEquals(141, Pagging.getData().get(3).intValue());
			Assert.assertEquals(142, Pagging.getData().get(4).intValue());
			Assert.assertEquals(143, Pagging.getData().get(5).intValue());
			Assert.assertEquals(144, Pagging.getData().get(6).intValue());
			Assert.assertEquals(145, Pagging.getData().get(7).intValue());
			Assert.assertEquals(146, Pagging.getData().get(8).intValue());
			Assert.assertEquals(147, Pagging.getData().get(9).intValue());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			Assert.assertEquals(0, 1);
		}
	   
	}
	
	
	public Pagging<Integer> getData1(int pageNo,int pageSize){
		Pagging<Integer> Pagging = new Pagging<>();
		Pagging.setTotal(52l);
		List<Integer> list =  Lists.newArrayList();
		for(int i=0;i<52;i++){
			list.add(i);
		}
		PageInfo pageInfo = new PageInfo(pageNo, pageSize);
		int begin = pageInfo.getOffset();
		int end = begin + pageInfo.getLimit();
		if(begin>52){
			Pagging.setData(null);
			return Pagging;
		}else if(begin<52&&end>52){
			Pagging.setData(list.subList(begin, 52));
			return Pagging;
		}
		
		Pagging.setData(list.subList(pageInfo.getOffset(), end));
		return Pagging;
	}
	
	public Pagging<Integer> getData2(int pageNo,int pageSize){
		
        Pagging<Integer> Pagging = new Pagging<>();
        Pagging.setTotal(36l);
		List<Integer> list =  Lists.newArrayList();
		for(int i=120;i<156;i++){
			list.add(i);
		}
		PageInfo pageInfo = new PageInfo(pageNo, pageSize);
		int begin = pageInfo.getOffset();
		int end = begin + pageInfo.getLimit();
		if(begin>36){
			Pagging.setData(null);
			return Pagging;
		}else if(begin<36&&end>36){
			Pagging.setData(list.subList(begin, 36));
			return Pagging;
		}
		Pagging.setData(list.subList(pageInfo.getOffset(), end));
		
		
		return Pagging;
	}
}
