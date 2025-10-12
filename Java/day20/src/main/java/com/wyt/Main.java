import java.util.Scanner;

public class Main {
    static String preorder, inorder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            preorder = sc.next();
            inorder = sc.next();
            printPostorder(0, preorder.length() - 1, 0, inorder.length() - 1);
            System.out.println();
        }
    }

    public static void printPostorder(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) return;

        char root = preorder.charAt(preL);

        int k = inL;
        while (k <= inR && inorder.charAt(k) != root) {
            k++;
        }

        int leftSize = k - inL;

        printPostorder(preL + 1, preL + leftSize, inL, k - 1);

        printPostorder(preL + leftSize + 1, preR, k + 1, inR);

        System.out.print(root);
    }
}
