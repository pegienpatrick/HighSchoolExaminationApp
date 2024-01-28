package com.pegien.HighSchoolExamination;

import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import com.pegien.HighSchoolExamination.Users.enums.UserRoles;
import com.pegien.HighSchoolExamination.Utils.GradingUtils;
import com.pegien.HighSchoolExamination.Utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;


//@SpringBootTest
class HighSchoolExaminationAppApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testPhoneNumbers1() {
		String rawPhone="0723466505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers2() {
		String rawPhone="723-466-505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers3() {
		String rawPhone="0723 466 505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	@Test
	public void testPhoneNumbers4() {
		String rawPhone="+254723466505";
		String expectedPhone="254723466505";

		Assertions.assertEquals(expectedPhone, ConvertionUtils.formatPhone(rawPhone));
	}

	public static void main(String[] args) {

//		HashMap<UserRoles,Set<String>> all= new HashMap<>();
//		for(UserRoles r:UserRoles.values())
//		{
//			all.put(r,r.getPermissions());
//		}
//
//		System.out.println(all);
//
//		JFrame f=new JFrame("test");
//		f.setSize(160,160);
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//
//		if (Desktop.isDesktopSupported()) {
//			Desktop desktop = Desktop.getDesktop();
//
//			// Check if the browser application registered to handle the URI scheme is supported
//			if (desktop.isSupported(Desktop.Action.BROWSE)) {
//				// Open the default web browser with the specified URL
//				try {
//					desktop.browse(new URL("http://localhost:8080").toURI());
//				} catch (IOException | URISyntaxException e) {
//					throw new RuntimeException(e);
//				}
//			} else {
//				System.out.println("Browser not supported.");
//			}
//		} else {
//			System.out.println("Desktop not supported.");
//		}


//		for(int i=1;i<=12;i++)
//			System.out.println(i+"-"+ GradingUtils.gradeChar(i));
		{
			int prev = -7;
			String rec = "";
			for (int i = 0; i < 110; i++) {
				int grade = GradingUtils.getGrade(78, 27, i*1.0);
				if (grade != prev) {
					System.out.println(" to \n" + rec + " \n\n\n\n");
					System.out.println(i + " - " + grade + " - " + GradingUtils.gradeChar(grade));
				}
				prev = grade;
				rec = i + " - " + grade + " - " + GradingUtils.gradeChar(grade);
			}
		}


//		{
//			int prev = -7;
//			String rec = "";
//			for (int i = 0; i < 110; i++) {
//				int grade = GradingUtils.agregateGrading(i);
//				if (grade != prev) {
//					System.out.println(" to \n" + rec + " \n\n\n\n");
//					System.out.println(i + " - " + grade + " - " + GradingUtils.gradeChar(grade));
//				}
//				prev = grade;
//				rec = i + " - " + grade + " - " + GradingUtils.gradeChar(grade);
//			}
//		}


	}

}
