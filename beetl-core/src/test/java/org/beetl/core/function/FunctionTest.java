package org.beetl.core.function;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class FunctionTest extends BasicTestCase
{
	@Test
	public void testCore() throws Exception
	{

		Map map = new HashMap();
		map.put("a", "hi");
		map.put("b", 1);

		Template t = gt.getTemplate("/function/function_template.html");
		t.binding(map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/function_expected.html"), str);

		t = gt.getTemplate("/function/function_template.html");
		t.binding(map);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/function_expected.html"), str);
	}

	public void testPackage() throws Exception
	{
		gt.registerFunctionPackage("test", new SampleFunctionPackage());
		Template t = gt.getTemplate("/function/function_package_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/function_package_expected.html"), str);

		t = gt.getTemplate("/function/function_package_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/function_package_expected.html"), str);

	}
}
