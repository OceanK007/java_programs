import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) 
    {   
        int maxValue = Integer.MIN_VALUE;
        Integer maxNumber1 = a.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        Integer maxNumber2 = b.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        if(maxNumber1 > maxNumber2)
            maxValue = maxNumber1;
        else
            maxValue = maxNumber2;

        System.out.println("maxValue: "+maxValue);
        
        int count = 0;
        for(int i=1;i<=maxValue;i++)
        {
            boolean valid = false;
            for(int j=0;j<a.size();j++)
            {
                if(i%a.get(j) == 0)
                    valid = true;
                else
                    valid = false;
                
                if(valid == false)
                    break;
            }

            if(!valid)
                continue;

            for(int k=0;k<b.size();k++)
            {
                if(b.get(k)%i == 0)
                    valid = true;
                else
                    valid = false;
                
                if(valid == false)
                    break;
            }

            if(!valid)
                continue;

            if(valid)
            {
            	System.out.println("i: "+i);
            	count += 1;
            }
        }

        return count;
    }
}

public class Test 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        //bufferedWriter.write(String.valueOf(total));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
