package com.pegien.HighSchoolExamination;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.MavenCefAppHandlerAdapter;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import me.friwi.jcefmaven.impl.progress.ConsoleProgressHandler;
import org.cef.CefApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
		new Thread(()->{
		Boolean launcher=false;
		if(launcher)
		{

			//Create a new CefAppBuilder instance
			CefAppBuilder builder = new CefAppBuilder();

//Configure the builder instance
			builder.setInstallDir(new File("jcef-bundle")); //Default
			builder.setProgressHandler(new ConsoleProgressHandler()); //Default
			builder.addJcefArgs("--disable-gpu"); //Just an example
			builder.getCefSettings().windowless_rendering_enabled = true; //Default - select OSR mode

//Set an app handler. Do not use CefApp.addAppHandler(...), it will break your code on MacOSX!
			builder.setAppHandler(new MavenCefAppHandlerAdapter(){

			});

//Build a CefApp instance using the configuration above
			try {
				CefApp app = builder.build();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (UnsupportedPlatformException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} catch (CefInitializationException e) {
				throw new RuntimeException(e);
			}
			boolean useOsr = false;
//			new MainFrame("http://www.google.com", useOsr, false, args);
			try {
				new com.pegien.HighSchoolExamination.embedded.MainFrame("http://localhost:8080", useOsr, false, args);
			} catch (UnsupportedPlatformException e) {
				throw new RuntimeException(e);
			} catch (CefInitializationException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

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
		}).start();
	}

}
