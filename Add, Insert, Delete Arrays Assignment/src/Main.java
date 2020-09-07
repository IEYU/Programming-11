import java.util.Arrays;

public class Main {
    //Method of adding a value to the end of an array and increasing the size of the array by 1
    //type: int
    static int[] add(int[] array, int value) {
        int arraylength = array.length;
        int new_array[] = new int[arraylength + 1];
        for (int i = 0; i < arraylength; i++) {
            new_array[i] = array[i];
        }
        new_array[arraylength] = value;
        //modify the orignal array
        array = new_array;
        return array;
    }

    //Method of deleting the end of an array and reducing the size of the array by 1
    //type: int
    static int[] pop(int[] array){
        int arraylength = array.length;
        int new_array[] = new int[arraylength - 1];
        for (int i = 0; i < arraylength - 1; i++){
            new_array[i] = array[i];
        }
        //modify the orignal array
        array = new_array;
        return array;
    }

    //Method of inserting a value into an array at chosen index position and increasing the size of the array by 1
    //type: int
    static int[] insert(int[] array, int index, int value){
        int arraylength = array.length;
        int new_array[] = new int[arraylength + 1];
        for (int i=0; i < index; i ++){
            new_array[i] = array[i];
        }
        for (int i = index + 1; i > index && i < arraylength + 1; i++){
            new_array[i] = array[i - 1];
        }
        new_array[index] = value;
        //modify the orignal array
        array = new_array;
        return array;
    }

    public static void main(String[] args){
        int int_array_1[] = {1,2,3,4,5};
        System.out.println("Original Array: " + Arrays.toString(int_array_1));
        int_array_1 = add(int_array_1, 6);
        System.out.println("Add To The End: " + Arrays.toString(int_array_1));
        int int_array_2[] = {1,2,3,4,5};
        int_array_2 = pop(int_array_2);
        System.out.println("Delete the End: " + Arrays.toString(int_array_2));
        int int_array_3[] = {1,2,3,4,5};
        int_array_3 = insert(int_array_3, 3, 6);
        System.out.println("Insert To A Chosen Position: " + Arrays.toString(int_array_3));
    }
}
