package utils;

import org.testng.Assert;

public class AssertUtils {
	
	//整型做比较 、字符串做比较、字符串包含、非空、实型断言
	
	public Log log=new Log(AssertUtils.class);
	
	public void checkIntNum(int actual, int expected,String... com){
		try{
		Assert.assertEquals(actual, expected);
		log.info("实际值:"+actual+"  预期值："+expected+"  实际与预期相匹配");
		}catch(Exception e){
			log.error("实际值:"+actual+"  预期值："+expected+"  实际与预期不匹配："+com);
		}
	}
	
	public void checkString(String actual, String expected,String... com){
		try{
		Assert.assertEquals(actual, expected);
		log.info("实际值:"+actual+"  预期值："+expected+"  实际与预期相匹配");
		}catch(Exception e){
			log.error("实际值:"+actual+"  预期值："+expected+"  实际与预期不匹配："+com);
		}
	}
	
	public void checkStringContains(String actual, String expected,String... com){
		try{
		Assert.assertEquals(true, actual.contains(expected));
		for(String i:com)
		{
			log.info("实际值:"+actual+"  预期值："+expected+"  实际与预期相匹配: "+i);
		}
		}catch(Exception e){
			log.error("实际值:"+actual+"  预期值："+expected+"  实际与预期不匹配: "+com);
		}
	}
	
	public void checkNotNull(Object actual,String... com){
		try{
		Assert.assertNotNull(actual);
		log.info("实际值为："+actual);
	}catch(Exception e){
		log.error("实际值为:"+actual);
	}
	}

}
