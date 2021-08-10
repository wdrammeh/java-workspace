package network.other;

import javax.swing.*;

public class LinkFinderTester {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "This program reads data from a website and prints all hyperlinks.", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        String url = JOptionPane.showInputDialog(null, "Enter the URL: ", "URL", JOptionPane.QUESTION_MESSAGE);
        if (!url.startsWith("https://")) {
            url = "https://"+url;
        }
        try {
            new LinkFinder().findLinks(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }

}
