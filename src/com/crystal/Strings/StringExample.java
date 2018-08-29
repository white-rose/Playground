package com.crystal.Strings;

import java.io.UnsupportedEncodingException;

public class StringExample {

    public static void main (String ... args) throws UnsupportedEncodingException {

       StringBuffer s = new StringBuffer();
       StringBuffer s2 = new StringBuffer(20);
       StringBuffer s3 = new StringBuffer("GeeksforGeeks");

       int p = s3.length();
       int q = s3.capacity();

       System.out.println("Length of string GeeksforGeeks " + p);
       System.out.println("Capacity of String GeeksforGeeks " + q);

       StringBuffer s4 = new StringBuffer("Geeksfor");
       s.append("Geeks");
       System.out.println(s);
       s.append(1);
       System.out.println(s);

    }

}
