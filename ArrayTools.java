import java.util.Scanner;
import java.util.Arrays;

/**
* @author  Parwinder Deep Kaur
* @version 1.0
* @since   2021-09-30

* Name: Parwinder Deep Kaur
* Student ID: A00237487
* The program does 4 operations on array i.e. encryption, reverse, search, contains
* takes string input & key from the user to encrypt using Caesar cipher
* inputs numeric array and prints the average of array,
* search  element in array,
* inputs numeric array and prints the reverse of array
*/

public class ArrayTools{
	
	public static Scanner scanner = new Scanner(System.in);	// initialize scanner

	public static void main(String args[]){
					
		System.out.print("Enter a string to encrypt: ");
		String plainText = scanner.nextLine();	// store string to be encrypted in String variable
		System.out.print("Enter a value to encrypt with: ");
		int shiftValue = scanner.nextInt();	// store shiftValue/encryption key
		System.out.println("The encrypted string is " + encryptString(plainText, shiftValue));	// method to encrypt and print the encrypted string
		
		System.out.print("\nFind average of array\nEnter the number of items in array: ");
		int[] averageArr = inputArrayValues(); // create array
		// calculate the average and print the result
		System.out.println("Average of array is " + calculateArrayAverage(averageArr));
		
		System.out.print("\nReverse the array\nEnter the number of items in array: ");
		int[] reversedArr = inputArrayValues();
		// reverse and print the elements of array
		System.out.println("Array in reversed order:" + Arrays.toString(reverseArray(reversedArr)));
	  
		System.out.print("\nArray Search\nEnter the number of items in array:");
		int[] searchNumArr = inputArrayValues();
		// check if input value exists in the array
		System.out.print("Enter a value to search for: ");
		int searchValue = scanner.nextInt();	// take value from user to be searched
		if (checkValueExists(searchValue, searchNumArr) == true){	// check if input value matched
			System.out.print("The array contains the value " + searchValue);  
		} else{
			System.out.print("The array do not contains the value " + searchValue);    
		}  
	}
	
	/**
	* create the array of integer type with length specified by user
	* adds integers into array upto the array length specified
	* @return numberArray array containing integers
	*/
	public static int[] inputArrayValues(){
		int num = scanner.nextInt();
		// create array of input size
		int[] numberArray = new int[num];
		System.out.println("Enter the numbers");

		for(int index = 0; index < num; index++){
			numberArray[index] = scanner.nextInt(); // takes num number of inputs from user and stores in array
		}
		return numberArray;
	}
	
	/**
	* Takes plainText and shiftValue then create cipher text 
	* for lower case alphabets, upper case alphabets and numeric value
	* returns cipher text in string data type
	* check for white spaces
	*
	* @param plainText the text that is to be encrypted
	* @param offset shift value or key with which string will be encrypted
	* @return cipherText encrypted text in string format
	*/
	public static StringBuilder encryptString(String plainText, int offset){
		StringBuilder cipherText = new StringBuilder();	// create a StringBuilder object for mutable sequence of characters
		
		//	traverse plain text string
		for (int index = 0; index < plainText.length(); index++) {
		System.out.println("character is " + plainText.charAt(index));
		//	check of white spaces
			if (plainText.charAt(index) != ' ') {
				int originalAlphabetPosition = plainText.charAt(index) - 'a';	// get ascii value of char at index	
				int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;	//	encrypt with ascii value
				char newCharacter = (char) ('a' + newAlphabetPosition);	// get character from the ascii value
				cipherText.append(newCharacter);	// append character to string builder
			} else {
				cipherText.append(plainText.charAt(index));	// append white space to string builder
			}
		}
		return cipherText;	// return encrypted string
	}

	/**
	* take integer array as input, calculate average
	* return the integer average of given array
	*
	* @param numbersArray array of input integer value
	* @return returns integer average value of input array
	*/
	public static int calculateArrayAverage(int[] numbersArray){
		int average = 0;
		// traverse upto array length
		for (int index = 0; index < numbersArray.length; index++){
			//	sum of all values of array
			average = average + numbersArray[index];
		}
		average = average / numbersArray.length; // calculate average of array
		return average; // return integer average value
	}
	
	/**
	* take integer array as input, reverse the elements in array,
	* return new integer array with reversed elements
	
	* @param inputArr array of integer elements
	* @return reversed integer array
	*/
	public static int[] reverseArray(int[] inputArr){
		int[] reverseArr = new int[inputArr.length]; // create new array of same size 
		int counter = inputArr.length; // length of the array
		for (int index = 0; index < inputArr.length; index++) {  
            reverseArr[counter - 1] = inputArr[index]; // stores current element in array in decreasing order of array length
			counter = counter - 1; // decrease array length by 1
        }
		// return new array with reversed values
		return reverseArr;
	}
	
	/**
	* take integer array as input and a value to be find inside the array
	* traverse throughout the array and returns #true if value found
	* #false if value do no found in the array
	
	* @param inputArr array of integer elements
	* @param integer value to be searched inside the array
	* @return boolean value true/false if value exists in array otherwise false
	*/
	public static boolean checkValueExists(int value, int[] inputArr){
		for (int index = 0; index < inputArr.length; index++){ // traverse through each element of array
			if (inputArr[index] == value){	// check if value at current index matches with the input value
				return true;	// return true if value matches
			}
		}
		return false;
	}

}