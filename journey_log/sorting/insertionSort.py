"""
Time complexity : O(n^2)
Algorithm : 
Insertion sort iterates, 
consuming one input element each repetition, and grows a sorted output list. 
At each iteration, insertion sort removes one element from the input data, 
finds the location it belongs within the sorted list, and inserts it there. 
It repeats until no input elements remain.
"""

def insertion_sort(x):
    for i in range(1, len(x)):
        print(f"Just before iteration i = {i} |", end=" ")
        print(x)
        j = i - 1
        key = x[i]
        while x[j] > key and j >= 0:
            x[j+1] = x[j]
            j = j-1
        x[j+1] = key

def main():
    list = [57,23,49,25,85,25]
    insertion_sort(list)



if __name__ == "__main__":
    main()