package com.company;
import java.util.Scanner;
// Worked with Mariah McRae, Daniel Loyd
public class Main {
    public static void main(String[] args) {
        int total = 0;
        int q = 0;
        while (q != -1) {
            System.out.println("Input Positive Integer (-3 to print sum, -2 to reset sum to 0, -1 to end) ");
            Scanner scan = new Scanner(System.in);
            Integer scanRes = scan.nextInt();
            if (scanRes == -1) {
                q = scanRes;
                System.out.println("Sum: " + total);
                System.out.println("Goodbye!");
            }
            else if (scanRes == -2) {
                total = 0;
                System.out.println("Sum: " + total);
            }
            else if (scanRes == -3) {
                System.out.println("Sum: " + total);
            }
            else if (scanRes > 0) {
                total = total + scanRes;
            }
            else if (scanRes < -3 || scanRes == 0); {
            }
        }
    }
    }




