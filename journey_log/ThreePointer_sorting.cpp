//
// Created by Junsu An on 2022-01-22.
// Sort vector in order of all 'T' elements first, 'K' elements after 'T' elements, and then any other elements.
//
#include <iostream>
#include <vector>

using namespace std;

class ThreePointer_sorting {
public:
    void sort(vector<char>& A) {
        int n = A.size();
        int left= 0;
        int T_pointer = -1;
        int right = n;
        int count = 1;
        while (left < right){
            if (A[left] == 'K') left++;
            else if (A[left] == 'T') {
                swap(A[left], A[T_pointer + 1]);
                T_pointer++;
                left++;
            } else { // A[left] == other
                swap(A[left], A[right - 1]);
                right--;
            }


            cout << "At " << count << " loop" << endl;
            count++;
            for (char d : A) {
                cout << d << " ";
            }
            cout << endl;
            cout << "u is " << left << " | ";
            cout << "w is " << T_pointer << " | ";
            cout << "v is " << right << endl;
        }
    }
};

int main() {
    ThreePointer_sorting tb;
    vector<char> play_list = { 'T', 'K', 'T', 'A', 'K', 'B', 'Q', 'T', 'K' , 'a', 'd', 'K', 'K'};

    cout << "Play list before sorting :";
    for (char i : play_list) {
        cout << i << " ";
    }
    cout << endl;
    cout << "============================================" << endl;

    tb.sort(play_list);

    cout << "============================================" << endl;
    cout << ">> Play list after soring :";
    for (char j : play_list) {
        cout << j << " ";
    }
    cout << endl;
}