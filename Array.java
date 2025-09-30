package MainTopics;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int arr[]=new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            System.out.println("array is "+ arr[i]);
        }

        /*Simple array
        int roll[]={2,1,4,7,9,89};
        System.out.println(roll[2]);*/
        /*MainTopics.Array using loop
        for (int i=0;i<=5;i++){
            System.out.println(roll[i]);*/


    }
}
