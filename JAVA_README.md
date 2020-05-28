# String methods:
	- charAt(int index);
	- indexOf(String x);
	- toCharArray();
	- length();
	- replace();
	- replaceAll();
	- replaceFirst();
	- join();
		* Example1:
			String message = String.join("-", "Java", "is", "cool");
     		// message returned is: "Java-is-cool"
		* Example2:
			String s = String.join(System.lineSeparator(), new String[] {"Hi", "Hello", "Bye"});
			// System.lineSeparator: On UNIX systems, it returns "\n"; on MicrosoftWindows systems it returns "\r\n".
			// Output: 
			// Hi
			// Hello
			// Bye
	- format()
		* 

# StringBuilder methods:
	- sb.reverse();	// To reverse the string

# Modulus:
	- 4%2 = 0
	- 5%2 = 1
	- 2%5 = 2
	- 2%4 = 2

# java.util.Arrays
	- Arrays.toString(int[] a); // To print array
	- List<String> stores = Arrays.asList("Larry", "Moe", "Curly"); // Use it to convert array to list (you can pass an array of Strings as well)
	- List<Integer> numbers = Arrays.asList(1,2,3,4,5);	
	- String[] sArray = listOfString.toArray(new String[0]);	// Convert list to array (passing an array of size 0 as parameter)
	- Arrays.equals(array1, array2) // To check if two arrays are equal or not
	- Arrays.copyOf(arr, lenghtToReturnAfterCopy)	// To copy an array and return the array with defined length // Why we should copy array? You should not directly assign one array to another array variable, if you change first array element, it will reflect in second array.
	- Arrays.copyOfRange(arr, startIndex, endIndex) // Copying an array of within provided ranges
	- Arrays.sort(arr)	// To sort array in ascending order
	- 

# Collection methods:
	-  Deque<Integer> deque = new LinkedList<Integer>():
		* add(Object obj)
		* addFirst(Object obj)
		* addLast(Object obj)
		* remove(Object obj)
		* removeFirst()
		* removeLast()
		* poll() // removes head of queue
		* pollFirst()
		* pollLast()
		* peek()	// Retrieves head but doesn't remove
		* peekFirst()
		* peekLast()
	
	- PriorityQueue<Integer> p = new PriorityQueue<Integer>():
	- Queue<Integer> p = new PriorityQueue<Integer>():
		* add(Object obj)
		* remove()
		* remove(Object obj)
		* poll()	// removes head of queue
		* peek() // Retrieves head but doesn't remove
		
	- Stack<Integer> stack = new Stack<Integer>():
		* add(Object obj)
		* addElement(Object obj)
		* push(Object obj)
		* remove(Object obj)
		* remove(int index)
		* removeElement(Object obj)
		* removeElementAt(int index)
		* pop()	// Removes last element of stack
		* peek() // Retrieves last element of stack but doesn't remove
		
# BigInteger:
	- BigInteger is immutable
	- BigInteger Multiply
		BigInteger bi = BigInteger.valueOf(2);
		bi = bi.multiply(BigInteger.valueOf(3));		
		System.out.println(bi); // 6
	- BigInteger Add
		BigInteger bi2 = BigInteger.valueOf(2);
		bi2 = bi2.add(BigInteger.valueOf(3));
		System.out.println(bi2); // 5

# ASCII Values:
	- Ascii code of 0 = 48, 1 = 49, 2=50 .. 9 = 57
	- Print ASCII value of a char: System.out.println((int) '0');  // 48
	- Print char value of ASCII value: System.out.println((char) 48);	 // 0

# java.lang.Math
    - Math.abs()	
	
		  // abs() method taking float type as input 
        System.out.println(Math.abs(123.0f)); 				// 123.0
        System.out.println(Math.abs(-34.2323f)); 			// 34.2323	
        System.out.println(Math.abs(1.0 / 0)); 			// Infinity
  
        // abs() method taking double type as input 
        System.out.println(Math.abs(-0.0)); 				// 0.0
        System.out.println(Math.abs(-999.3456)); 			// 999.3456
  
        // abs() method taking int type as input 
        System.out.println(Math.abs(-123)); 				// 123
        System.out.println(Math.abs(-0)); 					// 0
        System.out.println(Math.abs(Integer.MIN_VALUE));// -2147483648
  
        // abs() method taking long type as input 
        System.out.println(Math.abs(-12345678)); 			// 12345678
        System.out.println(Math.abs(98765433)); 			// 98765433
        System.out.println(Math.abs(Long.MIN_VALUE)); 	// -9223372036854775808
        
    - Math.pow()
    
	    	System.out.println(Math.pow(2.0, 5.4)); // 42.22425314473263
			System.out.println(Math.pow(5.4, 2.0));	// 29.160000000000004
			System.out.println(Math.pow(2, 2));		// 4.0
			System.out.println(Math.pow(2.0, 2.0));	// 4.0
			
	 - Math.random()
	 		
	 		// a pseudo random double greater than or equal to 0.0 and less than 1.0
			System.out.println(Math.random());						// 0.7525898657380261
			System.out.println(Math.random());						// 0.6916553867342917
			System.out.println(Math.random()*10);					// 1.83082622844851
			System.out.println(Math.round(Math.random()*10));	// 3
		
	 - Math.round()
	 	
	 		System.out.println(Math.round(4567.9874f));		// 4568
			System.out.println(Math.round(-3421.134f));		// -3421
		
	 - Math.floor() : returns the largest Double data type that is less than or equal to the argument
	 	
	 		System.out.println(Math.floor(60984.1));		// 60984.0
			System.out.println(Math.floor(-497.99));		// -498.0
			System.out.println(Math.floor(125.9));		// 125.0
			System.out.println(Math.floor(125.99));		// 125.0
			System.out.println(Math.floor(-125.99));		// -126.0
			System.out.println(Math.floor(0.4873));		// 0.0
			System.out.println(Math.floor(-0.65));		// -1.0

	 - Math.ceil() : returns the smallest Double data type that is greater than or equal to the argument
	 		
	 		System.out.println(Math.ceil(60984.1));		// 60985.0
			System.out.println(Math.ceil(-497.99));		// -497.0
			System.out.println(Math.ceil(125.9));			// 126.0
			System.out.println(Math.ceil(125.99));		// 126.0
			System.out.println(Math.ceil(-125.99));		// -125.0
			System.out.println(Math.ceil(0.4873));		// 1.0
			System.out.println(Math.ceil(-0.65));			// -0.0
	
	 - Math.min()
	 		
	 		System.out.println(Math.min(2, 4));		// 2
			System.out.println(Math.min(0, -1));		// -1
			
	 - Math.max()
	 		
	 		System.out.println(Math.max(2, 4));		// 4
			System.out.println(Math.max(0, -1));		// 0
			
	 - Math.sqrt()
	 		
	 		System.out.println(Math.sqrt(2));	// 1.4142135623730951
			System.out.println(Math.sqrt(4));	// 2.0
			System.out.println(Math.sqrt(6));	// 2.449489742783178

# Java 8 
	- Finding max from list of Integers:
			Integer maxNumber1 = a.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	- 

# Searching in array:
	- LinearSearch:
		* You can search by using linear search, where you can iterate over the array and find the element.
	- BinarySearch: 
		* You can sort the whole array first then find the middle of array and compare the element with middle element. If middle element is greater than element then you need to search in first half of array.
	
# Sorting in array:
	- BubbleSort: 
		* It compares the first two elements, if the first is greater than the second, swaps them, keep doing (compares and swaps) for the next pair of adjacent elements. After complete whole loop, it starts again with the first two elements, compares, swaps until no more swaps are required.
	- InsertionSort: 
		* Insertion sort works in the similar way as we sort cards in our hand in a card game.
		* We assume that the first card is already sorted then, we select an unsorted card. If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left. In the same way, other unsorted cards are taken and put at their right place.
		* Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.
	- SelectionSort: 
		* Select the smallest element from array and put it at leftmost part of unsorted array. Keep doing it until whole array is sorted.
	- QuickSort: 
		* Find the pivot (left-most, right-most, middle element. Right-most is implemented). Compare each element with pivot element and sort them. Keep doing it until all elements are sorted. Recursion will be required for quicksort.
	
# Programs which needs to be reviewed:
	- HR_FormingMagicSquare.java
	- HR_ClimbingTheLeaderboard.java	 