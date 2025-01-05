package TA;

import javax.swing.*;

public class Front {
    private final JFrame frame;
    private final TabHandler tabHandler;

    public Front() {
        frame = new JFrame("Songket V1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        tabHandler = new TabHandler();
        JTabbedPane tabbedPane = tabHandler.createTabs();

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    public TabHandler getTabHandler(){
        return tabHandler;
    }
}