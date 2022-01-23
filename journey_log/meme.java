package journey_log;

class s {

    public static void fun(int[] A) {
        int n = A.length - 1;
        int count = 1;
        for (int i = 2; i <= n; ++i) {
            int j = i;                    // Initialize j.
            while (j > 1) {
                if (A[j/2] <= A[j])  {   // Integer division.
                    System.out.println("Break at i = " + String.valueOf(i));
                    for (int k = 1; k < A.length; k++) {
                        System.out.printf(String.valueOf(A[k]) + " ");
                    }
                    System.out.println();
                    break;
                                }                // End the loop early.
                int temp = A[j];          // LINE A.
                A[j] = A[j/2];            // LINE B.
                A[j/2] = temp;            // LINE C.
                j = j/2;

            System.out.println("At " + String.valueOf(count) + " loop | " + "Value of i is " + String.valueOf(i));
                count++;
            for (int k = 1; k < A.length; k++) {
                System.out.printf(String.valueOf(A[k]) + " ");
            }
            System.out.println();
            }
        }
    }

    

    public static void main(String[] args) {
        int[] ar = {999999, 9,2,3,5,1};

        fun(ar);
    }
}