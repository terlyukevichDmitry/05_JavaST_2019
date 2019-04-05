package by.epam.xml.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HamletInternational {

    public static void main(String[ ] args) {
        System.out.println("1 — английский /n 2 — белорусский \n любой — русский ");
        char k = 0;
        try {
            k = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "US";
        String language = "en";
        switch (k) {
            case '1':
                country = "US";
                language = "en";
                break;
            case '2':
                country = "BY";
                language = "be";
                break;
            case '3':
                country = "RU";
                language = "ru";
        }

        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);
        try {
            String st = rb.getString("str1");
            String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(s1);
            st = rb.getString("str2");
            String s2 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
