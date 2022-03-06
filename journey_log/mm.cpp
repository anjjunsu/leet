// recursive binary search
#include "iostream"
using namespace std;


#include <iostream>
#include <math.h> // provides fabs (HINT!)

#define _DELTA 0.000001 // a tiny positive value (HINT!)

using namespace std;

#include <iostream>
#include <math.h> // provides fabs (HINT!)

#define _DELTA 0.000001 // a tiny positive value (HINT!)

using namespace std;

/*
*  Iteratively counts the number of times an integer can divide into a fractional component
*  Prints a message to say whether the count is exact (divisor divides dividend exactly)
*  or the dividend was exceeded.
*  PARAM:
*/
int Count(int dividend, double divisor) {
    double sum = 0;
    int count = 0;
    while (sum < dividend) {
        sum += divisor;
        count += 1;
    }

    if (fabs(sum-dividend) < _DELTA/2)
        cout << divisor << " divided " << dividend << " "
             << count << " times exactly." << endl;
    else // sum > dividend
        cout << divisor << " divided " << dividend << " "
             << count << " times, in excess." << endl;

    return count;
}


int main() {

    int c = Count(10,0.1);
}