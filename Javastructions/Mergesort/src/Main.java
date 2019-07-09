public class Main {
    public static void main(String[] args) {
        int[] v1 = {14,8,13,8,15,17,10,-10,4,15,8,12,17,12,-1};
        int[] v2 = {-10,-1,4,8,8,8,10,12,12,13,14,15,15,17,17};
        int[] v3 = {33,32,30,34,28,21,23,26,27,22,29,20,28,25};
        MergeSort ms = new MergeSort();
        ms.mergesort(v3);
    }
}
