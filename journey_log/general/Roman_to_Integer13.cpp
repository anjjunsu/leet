//
// Created by Junsu An on 2022-01-19.
//
#include <iostream>
#include <map>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int value = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Check subtracting cases
            if ((s[i] == 'I' || s[i] == 'X' || s[i] == 'C') && (i + 1 < s.length())) {
                if (values.at(s[i]) < values.at(s[i + 1])) {
                    value -= 2 * values.at(s[i]);
                }
            }

            value += values.at(s[i]);

        }

        return value;
    }

private:
    map<char, int> values = { {'I', 1},
                              {'V', 5},
                              {'X', 10},
                              {'L', 50},
                              {'C', 100},
                              {'D', 500},
                              {'M', 1000}};
};

//int main() {
//    Solution soln;
//
//    string s1 = "III";
//    cout << soln.romanToInt(s1) << endl;
//
//    string s2 = "LVIII";
//    cout << soln.romanToInt(s2) << endl;
//
//    string s3 = "MCMXCIV";
//    cout << soln.romanToInt(s3) << endl;
//
//    return 0;
//}