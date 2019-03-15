import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Driver {
    public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {10,20,10};
  for(int MAX : MAX_LIST){
    for(int size = 0; size < MAX_LIST[0]; size += 1){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        System.out.println("Current Array: " + Arrays.toString(data1));
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("Quick:" + Arrays.toString(data2));
          System.out.println("Default:" + Arrays.toString(data1));
          System.out.println("This error occurred on try #" + trial);
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
        else {
            System.out.println("Quick:" + Arrays.toString(data2));
            System.out.println("Default:" + Arrays.toString(data1));
            System.out.println("Trial " + trial + " success. Moving to trial " + trial+1 + "\n");

        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
