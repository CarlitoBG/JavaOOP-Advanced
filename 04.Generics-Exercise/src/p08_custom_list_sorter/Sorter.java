package p08_custom_list_sorter;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list){

        boolean isSwapped;

        do {
            isSwapped = false;
            for (int i = 1; i < list.getSize(); i++) {
                if (list.getElement(i - 1).compareTo(list.getElement(i)) > 0){
                    list.swap(i - 1, i);
                    isSwapped = true;
                }
            }
        }while (isSwapped);
    }
}