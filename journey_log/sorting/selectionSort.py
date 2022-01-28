"""
Time complexity : O(n^2)
The algorithm divides the input list into two parts: 
 - a sorted sublist of items which is built up from left to right at the front (left) of the list and 
 - a sublist of the remaining unsorted items that occupy the rest of the list. 
 Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. 
 The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, 
 exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), 
 and moving the sublist boundaries one element to the right.
"""

def selectionSort(x):
    length = len(x)

    for i in range(length-1):
        print(f"At the just before iteration i = {i} |", end=" ")
        print(x)
        indexMin = i
        for j in range(i+1, length):
            if x[indexMin] > x[j]:
                indexMin = j
        
        x[i], x[indexMin] = x[indexMin], x[i]
        
if __name__ == "__main__" :
    list = [91,32,7,53,56,52]
    print("List before sorting : ", end="")
    print(list)

    selectionSort(list)
    print("List after sorting : ", end="")
    print(list)
