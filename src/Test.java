import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test
{	
	public static void main(String[] args) 
	{
		List<String> myList = Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(myList);  // [A, B]
		
		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		System.out.println(list);  // [[a], [b]]
		// The flatMap() method first flattens the input Stream of Streams to a Stream of Strings
		// Thereafter it works similarly to the map() method.
		// flatMap() can take a single stream of a list of streams as well and then flattens it into single stream
		List<String> list2 = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(list2); // [a, b]
	}
}