package com.ocean.programs.tricky.output;

/**
 * Binary Format or : 2^7,2^6,2^5,2^4,2^3,2^2,2^1,2^0	== 128,64,32,16,8,4,2,1
 * Binary format of 192	: 11000000
 * Binary format of 168	: 10101000
 * Binary format of 10 	: 00001010
 * Binary format of 15	: 00001111
 **/
public class BinaryAndBitwiseOperator 
{
	public static void main(String[] args) 
	{
		/***************** Binary Operators *********************/
		int binary4 = 4;	// Binary format of 4: 00000100
		
		// Binary of 4: 00000100
		// binary4 << 1 means : shift 1 to left side by one character : 000001000 = 8
		// 4*2^1 = 4 * 2 = 8
		System.out.println(binary4 << 1);	// 8
		
		// Binary of 4: 00000100
		// 4 << 2 : shift 1 to left side by two character: 0000010000	= 16
		// 4*2^2 = 4 * 4 = 16
		System.out.println(4 << 2); 		// 16
		
		// Binary of 4: 00000100
		// 4 >> 1 : shift 1 to right side by one character : 00000010 = 2
		// 4/2^1 = 4/2 = 2
		System.out.println(4 >> 1);			// 2
		
		// Binary format of 10 = 00001010
		// 10 << 1 : shift 1s to left side by one character: 00010100
		// 10*2^1 = 10*2 = 20
		System.out.println(10 << 1);		// 20
		
		// Binary format of 10 = 00001010
		// 10 >> 2 : shift 1s to right side by two character: 00000010
		// 10/2^2 = 10/4 = 2
		System.out.println(10 >> 2);		// 2
		
		// You can even assign values to variables like this using binary operators
		int i = 1 << 30;
		System.out.println(i); 				// 1073741824
		
		int j = 1 << 4;
		System.out.println(j); 				// 16
		
		/***************** Bitwise Operators *********************/
		// bitwise inclusive OR 
		// 37 		: 0 0 1 0 0 1 0 1
		// 23  		: 0 0 0 1 0 1 1 1
		// 37 | 23	: 0 0 1 1 0 1 1 1	= 32 + 16 + 4 + 2 + 1 = 55
		System.out.println(37 | 23); 		// 55
		
		// bitwise exclusive OR (XOR)
		// 37 		: 0 0 1 0 0 1 0 1
		// 23  		: 0 0 0 1 0 1 1 1
		// 37^23	: 0 0 1 1 0 0 1 0	= 32 + 16 + 2 = 50
		System.out.println(37 ^ 23); 		// 50
		
		// bitwise AND
		// 37 		: 0 0 1 0 0 1 0 1
		// 23  		: 0 0 0 1 0 1 1 1
		// 37&23	: 0 0 0 0 0 1 0 1	= 4 + 1 = 5
		System.out.println(37 & 23); 		// 5
		
		/***************** >> vs >>> *********************/
		// Binary format of 20 = 00010100
		// 20 >> 2 : shift 1s to right side by two character: 00000101
		// 20/2^2 = 20/4 = 5
		System.out.println(20 >> 2);		// 5
		
		// Binary format of 20 = 00010100
		// 20 >>> 2 : shift 1s to right side by two character: 00000101
		// 20/2^2 = 20/4 = 5
		System.out.println(20 >>> 2);		// 5 // Same as >> 
		
		// Binary format of 20 = 00010100
		System.out.println(-20 >> 2);		// -5 ???
		
		// Binary format of 20 = 00010100
		System.out.println(-20 >>> 2);		// 1073741819 ???
	}
}
