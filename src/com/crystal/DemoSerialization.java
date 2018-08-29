package com.crystal;

import java.io.*;

public class DemoSerialization {

    public static void main(String[] args) {

        Demo object = new Demo(1, "geeksforgeeks");
        String filename = "file.ser";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        Demo object1 = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            object1 = (Demo)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }

}

class Demo implements Serializable {

   public int a;
   public String b;

   public Demo(int a, String b)
   {
       this.a = a;
       this.b = b;
   }

}

//Transient and Static Example
class Emp implements Serializable {

    private static final long serialVersionUID = 129348938L;

    transient int a;
    static int b;
    String name;
    int age;

    public Emp(String name, int age, int a, int b) {
        this.a = a;
        this.name = name;
        this.age = age;
        this.b = b;
    }
}

class SerialTransitStaticExample {

    public static void printdata (Emp object1) {
        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String ... args) {
        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "shubham.txt";

        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                    (filename);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printdata(object);

            // value of static variable changed
            object.b = 2000;

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (filename);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            object = (Emp)in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(object);

            // System.out.println("z = " + object1.z);
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }

}