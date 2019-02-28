import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            Integer n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; st.hasMoreElements(); i++)
                arr[i] = Integer.parseInt(st.nextElement().toString());
            findContiguousSubArray(arr);
        }catch (Exception e){
            System.out.print("SOMETHING WENT WRONG WHILE GIVING INPUT DATA: ");
            System.out.println(e.getMessage());
        }finally {
            br.close();
        }
    }


    /**
     *
     * @param arr containing elements in array
     *
     * this code is implementation of Kadane’s algorithm
     *
     * Look for all positive contiguous segments of the array (maxEnd is used for this).
     *    And keep track of maximum sum contiguous segment among all positive segments
     *           (maxYet is used for this).
     * Each time we get a positive sum compare it with maxYet and update maxYet
     *            if it is greater than maxYet
     *
     */
    public static void findContiguousSubArray(int arr[]){
        int maxYet = Integer.MIN_VALUE, maxEnd = 0;
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < arr.length ; i++)
        {
            maxEnd = maxEnd + arr[i];
            if (maxYet <= maxEnd) {
                maxYet = maxEnd;
                if(maxEnd == arr[i]){
                    startIndex = i;
                    endIndex = i;
                }else {
                    endIndex = i;
                }
            }
            if (maxEnd < 0)
                maxEnd = 0;
        }
        System.out.println("Largest SubArray");
        System.out.println("Start Index: "+startIndex);
        System.out.println("Length: "+ (endIndex-startIndex+1));
        System.out.println("Sum: "+maxYet);
        System.out.print("Elements: ");
        IntStream.range(startIndex, endIndex+1).forEach( i -> System.out.print(arr[i] + " "));

    }
}
