class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        if (array != null && !(index < 0) && !(array.length - 1 < index)) {
            System.out.println(array[index] * array[index]);
        } else {
            System.out.println("Exception!");
        }

    }
}