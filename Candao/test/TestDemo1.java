package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestDemo1 {
  @Test
  public void f() {
	  System.out.println("this is a test");
	  Assert.assertEquals(0, 1);
  }
}
