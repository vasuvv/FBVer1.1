package com.computech.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ConfigProvider;
import com.computech.factory.ExcelReader;

public class TestExcelAndConfigProvider {
	
	@Test
	public void testExcelLib() {
		ExcelReader excel = new ExcelReader();
		String actData = excel.getStringData("TestSheet", 0, 0);
		Assert.assertEquals(actData, "TestingExcel");
	}

	@Test
	public void testConfigLib() {
		ConfigProvider config = new ConfigProvider();
		String actData = config.getValue("testConfig");
		Assert.assertEquals(actData, "TestingConfigFile");
	}
}
