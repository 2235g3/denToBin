package com.company;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        int exponent;
        int userDen;
        do {
            System.out.println("Enter a denary number:");
            userDen = intInput();
            if (userDen >= 0) {
                break;
            }
        } while (true);
        exponent = findExponent(userDen);
        String bin = denBinConvert(exponent, userDen);
        System.out.println(userDen + " is " + bin + " in binary");
    }
    public static int intInput() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (Exception e){
            System.out.println("Please enter a valid input\n");
            return -1;
        }
    }
    public static int findExponent(int userDen) {
        int exponent = 0;
        for (int i = 0; userDen > 0; i++) {
            userDen -= Math.pow(2,i);
            exponent = i;
        }
        exponent += 1;
        return exponent;
    }
    public static String denBinConvert(int exponent, int userDen) {
        String bin = "";
        for (int i = exponent; i > -1; i--) {
            if (userDen - Math.pow(2,i) >= 0) {
                userDen -= Math.pow(2,i);
                bin += "1";
            }
            else {
                bin += "0";
            }
        }
        return bin.substring(1,bin.length());
    }
}
