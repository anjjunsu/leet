// recursive binary search

int main() {

    int binarySearch(int left, int right, int target, int* arr) {

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
}