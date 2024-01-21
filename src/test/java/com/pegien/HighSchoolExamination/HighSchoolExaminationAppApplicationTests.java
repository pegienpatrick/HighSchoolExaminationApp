package com.pegien.HighSchoolExamination;

import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
class HighSchoolExaminationAppApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testPhoneNumbers1()
	{
		String rawPhone="0723466505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers2()
	{
		String rawPhone="723-466-505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers3()
	{
		String rawPhone="0723 466 505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers4()
	{
		String rawPhone="+254723466505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	public static void main(String[] args)
	{

	}

}
