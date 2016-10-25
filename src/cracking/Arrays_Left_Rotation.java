package cracking;

import java.util.Scanner;

public class Arrays_Left_Rotation {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] b = new int[n];
        int j = 0;
        for (int i = k; i < a.length; i++) {
            b[j++] = a[i];
        }
        for (int i = 0; i < k; i++) {
            b[j++] = a[i];
        }
        return b;
    }

    public static int[] arrayLeftRotationInline(int[] a, int n, int k) {
        for (int i = k; i > 0; i--) {
            int temp = a[k - i];
            a[k - i] = a[a.length - 1 - k + i];
            a[a.length - 1 - k + i] = temp;
        }
        return a;
    }

    public static int[] arrayLeftRotationModulus(int[] a, int n, int k) {
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[(i - k + n) % n] = a[i];
        }
        return b;
    }

    public static int[] arrayRightRotationModulus(int[] a, int n, int k) {
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[(i + k) % n] = a[i];
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayRightRotationModulus(a, n, k);
        for (int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
