import random
import datetime as time

def quicksort(lista):
    if lista == []:
        return []
    else:
        # First, select a pivot
        pivot = lista[0]
        # Retrieve all the values less than the pivot to create the left partition.
        left = [x for x in lista[1:] if x < pivot]
        # Sort the left partition.
        lesser = quicksort(left)
        # Retrieve all the values greater than or equal to the pivot to create the right partition.
        right = [x for x in lista[1:] if x >= pivot]
        # Sort the right partition.
        greater = quicksort(right)
        # Return the sorted list.
        return lesser + [pivot] + greater

if __name__ == "__main__":
    lista = random.sample(xrange(0, 5000), 5000)
    print "Unsorted list: ",
    print lista
    start = time.datetime.now() #start timer
    lista = quicksort(lista)
    end = time.datetime.now() #stop timer
    print "\nSorted list:   ",
    print lista
    print "\nTime: ", (end-start).microseconds, "microseconds"
