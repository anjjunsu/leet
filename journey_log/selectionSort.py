def selectionSort(x):
    length = len(x)

    for i in range(length-1):
        print(f"At the start of iteration i = {i} |", end=" ")
        print(x)
        indexMin = i
        for j in range(i+1, length):
            if x[indexMin] > x[j]:
                indexMin = j
        
        x[i], x[indexMin] = x[indexMin], x[i]

        

    

if __name__ == "__main__" :
    list = [53,10,69,51,33,12]
    print("List before sorting : ", end="")
    print(list)

    selectionSort(list)
    print("List after sorting : ", end="")
    print(list)
