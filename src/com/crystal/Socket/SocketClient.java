package com.crystal.Socket;

import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;

import java.net.*;
import java.io.*;

public class SocketClient {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public SocketClient(String address, int port) {

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        String line = "";

        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String argsp[]) {
        try {
            char[] characters = new char[1];
            Client client = new Client("127.0.0.1", "5000", "", "", characters);
        } catch (NTLMException e) {
            e.printStackTrace();
        }
    }

}
