package journey_log;

class s {

    public static int binarySearch(int left, int right, int target, int[] arr) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (arr[mid] > target) {
                binarySearch(left, mid-1, target, arr);
            } else {
                binarySearch(mid+1, right, target, arr);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] ar = {3, 5, 7, 9, 11, 22, 44, 66, 72, 88};

        int r = s.binarySearch(0, ar.length - 1, 5, ar);
        System.out.println("++++++++++++++++++");
        System.out.println(r);
    }
}