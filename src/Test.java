import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) 
    {
        int maxLength = 0;
        int length = 1;

        for(int i=0;i<a.size();i++)
        {
            length = 1;
            for(int j=i+1;j<a.size();j++)
            {
            	if(a.get(i) < a.get(j))
            	{
            		if(Math.abs(a.get(i)-a.get(j)) == 1)
            			length++;
            	}
            	else if(a.get(i) > a.get(j))
            	{
            		if((Math.abs(a.get(i)-a.get(j)) == 1) && (Math.abs((a.get(i)+1)-a.get(j)) == 1))
            			length++;
            	}
            	else if(a.get(i) == a.get(j))
            	{
            		length++;
            	}
            	
            	System.out.println(a.get(i)+ " | "+a.get(j));
            }

            System.out.println("Length: "+length);
            if(length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }

}

class Test 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.println(Result.pickingNumbers(a));

        bufferedReader.close();
    }
}
