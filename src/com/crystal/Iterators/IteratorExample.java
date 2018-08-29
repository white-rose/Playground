package com.crystal.Iterators;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IteratorExample {

    public static void main(String[] args) {

        //Enumerations Example
        Vector v = new Vector();
        for (int i = 0; i < 10; i++)
            v.addElement(i);

        System.out.println(v);

        Enumeration e = v.elements();

        while (e.hasMoreElements()) {
            int i = (Integer) e.nextElement();
            System.out.print(i + " ");
        }

        //Iterator
        ArrayList al = new ArrayList();
        for (int i = 0; i < 10; i++)
            al.add(i);

        System.out.println(al);

        Iterator itr = al.iterator();

        while (itr.hasNext()) {

            int i = (Integer) itr.next();

            System.out.println(i + " ");

            if (i % 2 != 0)
                itr.remove();

        }

        System.out.println();
        System.out.println(al);

    }
}
