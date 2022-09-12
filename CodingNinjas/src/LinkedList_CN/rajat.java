package LinkedList_CN;
import java.util.*;

public class rajat {

        public static void printSpiral(int arr[][] , int r , int c){
            int rmax = r-1;
            int rmin = 0;
            int cmax = c-1;
            int cmin = 0;
            int digits = r*c;
            int count = 0;
            while(count<digits) {
                //print first row --->
                for (int i = rmin, j = cmin; j <= cmax && count<digits ; j++) {
                    System.out.print(arr[i][j] + " ");
                    count++;
                }
                rmin++;
                //print last coloum |v
                for (int i = rmin, j = cmax; i <= rmax && count<digits; i++) {
                    System.out.print(arr[i][j] + " ");
                    count++;
                }
                cmax--;
                //print bottom row <----
                for (int i = rmax, j = cmax; j >= cmin && count<digits; j--) {
                    System.out.print(arr[i][j] + " ");
                    count++;
                }
                rmax--;
                //print first colom |^
                for (int i = rmax, j = cmin; i >= rmin && count<digits; i--) {
                    System.out.print(arr[i][j] + " ");
                    count++;
                }
                cmin++;
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
//        int r = sc.nextInt();
//        int c = sc.nextInt();
//        int arr[][] = new int [r][c];
//        for(int i = 0 ; i <  r ; i++){
//            for(int j = 0 ; j < c ; j++){
//                arr[i][j]= sc.nextInt();
//            }
//        }
            int arr[][]  = {
                    {1,2,3,4,5},
                    {6,7,8,9,10},
                    {11,12,13,14,15},
                    {16,17,18,19,20}
            };

            printSpiral(arr,4,5);
        }
    }

