//package com.pegien.HighSchoolExamination;
///*
// * Copyright (c) 2000-2024 TeamDev Ltd. All rights reserved.
// * TeamDev PROPRIETARY and CONFIDENTIAL.
// * Use is subject to licence terms.
// */
//
//
//import static com.teamdev.jxbrowser.engine.RenderingMode.*;
//
//import com.teamdev.jxbrowser.browser.Browser;
//import com.teamdev.jxbrowser.engine.Engine;
//import com.teamdev.jxbrowser.view.swing.BrowserView;
//
//
//import java.awt.BorderLayout;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
///**
// * This example demonstrates how to create and initialize the Engine,
// * create the Browser, embed it into a Swing container, display it in
// * JFrame, and load https://html5test.teamdev.com
// */
//public final class HelloWorld {
//public static void main(String[] args) {
//Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
//Browser browser = engine.newBrowser();
//
//SwingUtilities.invokeLater(() -> {
//  BrowserView view = BrowserView.newInstance(browser);
//
//  JFrame frame = new JFrame("Swing BrowserView");
//  frame.add(view, BorderLayout.CENTER);
//  frame.setSize(700, 500);
//  frame.setVisible(true);
//
//  browser.navigation().loadUrl(
//      "https://html5test.teamdev.com");
//});
//}
//}