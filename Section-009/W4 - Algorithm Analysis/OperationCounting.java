public class OperationCounting {
    // worst case analysis
    public static int linearSearch(int[] values, int toFind) { //
        for (int i = 0; i < values.length; i++) {              //
           if (values[i] == toFind) {                          //
               return i;                                       //
           }
        }
        return -1;                                             //
     }                                                  // TOTAL: = O()

     public static double[] prefixAverage1(double[] elements) {
        double[] averages = new double[elements.length];                    //
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) {    //
            double total = 0.0;                                             //
            for (int sumIndex = 0; sumIndex <= avgIndex; sumIndex++) {      //
                total += elements[sumIndex];                                //
            }
            averages[avgIndex] = total / (avgIndex + 1);                    //
        }
        return averages;                                                    //
    }                                                                 // TOTAL:  = O()

    public static double[] prefixAverage2(double[] elements) {
        double[] averages = new double[elements.length];                    //
        double total = 0.0;                                                 //
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) {    //
            total += elements[avgIndex];                                    //
            averages[avgIndex] = total / (avgIndex + 1);                    //
        }
        return averages;                                                    //
    }                                                                 // TOTAL:  = O()
}
