package com.journaldev.misc;

import java.net.UnknownHostException;
import java.net.InetAddress;

public class JavaIPAddress {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        //print localhost ip address
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        //print website ip address
        System.out.println(InetAddress.getByName("www.google.com"));
        //print all ip addresses for a website
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.google.com");
        for(InetAddress inet : inetAddresses){
            System.out.println(inet);
        }
    }

}
