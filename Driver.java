
/* Purpose: Data Structure and Algorithms Lab 12 
 * Status: sorta complete, getting errors :(
 * Last update: 11/30/16
 * Submitted: 11/30/16
 * Comment: sample run attached
 * @author: Brooke Brown
 * @version: 2016.11.30
 */

import java.io.*;
import java.util.*;

public class Driver
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
    	HashTable<String, Integer> hashtable = new HashTable<String, Integer>();

        String askPrompt = 
        		("   1.      Insert a symbol key with an associated value in the table \n"
        		+ "   2.      Delete a symbol from the table\n"
        		+ "   3.      Retrieve and display the value associated with a symbol key in the table \n"
				+ "   4.      Display the hash index of a symbol key\n" 
				+ "   5.      Exit program.\nEnter your input: ");
        System.out.print(askPrompt);
        int answer = Integer.parseInt(stdin.readLine().trim());
        System.out.println(answer);
        while(answer != 5) {
            switch (answer) {
            case 1: //insert symbol key with associated value in the table
                System.out.println("You are now inserting a value and key into the table.");
                System.out.print("   Enter value: ");
                Integer value  = Integer.parseInt(stdin.readLine().trim());
                System.out.println(value);
                System.out.print("   Enter key: ");
                String key  = stdin.readLine().trim();
                System.out.println(key);
                hashtable.tableInsert(key, value);
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 2: //remove symbol from table
                System.out.print("    Enter symbol key to remove: ");
                key = stdin.readLine().trim();
                System.out.println(key);
		if(!hashtable.tableDelete(key)) {
			System.out.println("Key not found.");
		}
		else {
                	System.out.println("Key " + key + " deleted.");
		}
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 3: //retrieve symbol from list
                System.out.print("    Enter symbol key to retrieve value from: ");
                key = stdin.readLine().trim();
                System.out.println(key);
                System.out.println("Key " + key + "'s value: " + hashtable.tableRetrieve(key));
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 4: //display hashIndex of a symbol key
                System.out.print("    Enter symbol key to retrieve index from: ");
                key = stdin.readLine().trim();
                System.out.println(key);
                System.out.println("Key " + key + "'s index: " + hashtable.hashIndex(key));
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            default:
                System.out.println("Oh no! You put an incorrect number. Try again!");
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            }
        }
        System.out.print("Exiting program... Good Bye!");
    }
}
