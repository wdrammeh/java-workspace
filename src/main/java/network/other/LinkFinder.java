package network.other;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/**
 * Question 3
 *
 * Write a program that reads all data from a web page and prints all hyperlinks
 * PROVIDE A TESTER CLASS FOR PROGRAM
 */
public class LinkFinder {

    /**
     * Prints out all the hyperlinks in this url; includes both relative and absolute links
     */
    public void findLinks(String url) throws IOException {
        URL site = new URL(url);
        InputStream inputStream = site.openStream();
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(new InputStreamReader(inputStream), new HTMLEditorKit.ParserCallback() {
            public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
                if (t == HTML.Tag.A) {
                    Enumeration attrNames = a.getAttributeNames();
                    while (attrNames.hasMoreElements()) {
                        Object key = attrNames.nextElement();
                        if ("href".equals(key.toString())) {
                            System.out.println(a.getAttribute(key));
                        }
                    }
                }
            }
        }, true);
        inputStream.close();
    }

}
