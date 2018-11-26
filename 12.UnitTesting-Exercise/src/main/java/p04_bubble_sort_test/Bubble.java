package p04_bubble_sort_test;

class Bubble {

    static<T extends Comparable<T>> void sort(T[] elements){

        boolean isSwapped;

        do {
            isSwapped = false;

            for (int i = 0; i < elements.length - 1; i++) {
               if (elements[i].compareTo(elements[i + 1]) > 0){
                   T temp = elements[i];
                   elements[i] = elements[i + 1];
                   elements[i + 1] = temp;

                   isSwapped = true;
               }
            }
        }while (isSwapped);
    }
}