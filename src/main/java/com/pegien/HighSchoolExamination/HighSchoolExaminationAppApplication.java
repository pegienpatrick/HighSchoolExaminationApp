package com.pegien.HighSchoolExamination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootApplication
public class HighSchoolExaminationAppApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(HighSchoolExaminationAppApplication.class, args);
		}catch (Exception es) {
		}
		{
//			JFrame f=new JFrame("Failed to start new instance "+es);
//			f.setSize(160,160);
//			f.setLocationRelativeTo(null);
//			f.setVisible(true);
			try {
				// Specify the URL you want to open
				String url = "http://localhost:8080/";

				if(url.length()>0)
					return;
				// Get the operating system name
				String os = System.getProperty("os.name").toLowerCase();

				// Determine the command to open the browser based on the operating system
				String command = "";
				if (os.contains("win")) {
					command = "rundll32 url.dll,FileProtocolHandler " + url;
				} else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
					command = "xdg-open " + url;
				} else {
					System.out.println("Unsupported operating system.");
					System.exit(0);
				}

				// Execute the command to open the default web browser
				Runtime.getRuntime().exec(command);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
