# java_programs
Simple java project to implement basic and advance level programs

# Levels
Easy, Medium, Hard, Advance, Expert

# Methods used:

* String methods:
	- charAt(int index);
	- indexOf(String x);
	- toCharArray();
	- length();
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
	- 

* java.util.Arrays
	- Arrays.toString(int[] a); // To print array
	- List<String> stooges = Arrays.asList("Larry", "Moe", "Curly"); // Use it to convert array to list
	- Arrays.equals(array1, array2) // To check if two arrays are equal or not

* Collection methods:
	-  
	
* ASCII Values:
	- Ascii code of 0 = 48, 1 = 49, 2=50 .. 9 = 57

* java.lang.Math
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

* Java 8 
	- Finding max from list of Integers
		Integer maxNumber1 = a.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	- 

* Searching in array:
	- First approach (LinearSearch): You can search by using linear search, where you can iterate over the array and find the element.
	- Second approach (BinarySearch): You can sort the whole array first then find the middle of array and compare the element with middle element. If middle element is greater than element then you need to search in first half of array.
	
* Sorting in array:
	- First approach (BubbleSort): Take the first element and compare it with the next element and if next element is smaller, then replace it with it. Keep doing it until it's sorted.
	- Second approach (InsertionSort): Keep first element as it is and iterate the loop from index 1 and create sub-arrays (by taking one element on each iteration) and sort the sub-arrays individually.
	- Third approach (SelectionSort): Select the smallest element from array and put it at leftmost part of unsorted array. Keep doing it until whole array is sorted.
	- Fourth approach (QuickSort): Find the pivot (left-most, right-most, middle element. Right-most is implemented). Compare each element with pivot element and sort them. Keep doing it until all elements are sorted. Recursion will be required for quicksort.
	
	 