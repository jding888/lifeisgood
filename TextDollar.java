import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class TextDollar {

	/**
	 * @param args
	 */
	private static final String[] oneToTwenty ={ "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
					"Eleven" , "Twelve", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen", "Seventeen", "Seventeen", 
					"Eighteen", "Nineteen", "Twenty" };	
	private static final String[] twentyToNinty ={"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
	private static final String[] bigNumber ={ "","",  "Thounsand","Million", "Billion",};	
	private static final String DOLLAR = "Dollars";	
	private static final String HUNDRED = "Hundred";	
	private static final Integer DIV1000 = 1000;	
	private Stack <Integer> parts = new Stack<Integer>();	
	private int ct=0;
	private static Scanner sc;
	
	public static void main(String[] args) throws Exception {

		File file = new File ("c:\\Users\\Judy\\gib\\num.txt");
		sc = new Scanner(file); 
		
			while (sc.hasNextLine()){
			    String st = sc.nextLine();
			    int num = Integer.parseInt(st);
				if (num<0) {
					System.out.println(" Warnings -- Only accept positive numbers ");
					continue;
				}
			    TextDollar ctd = new TextDollar();
			    System.out.print(num + " ");
			    String textD = ctd.convertTextDollar(num);			   
				System.out.println(textD + DOLLAR);
			}
	}
	
	private String convertTextDollar(int num) throws Exception{
		if (num==0) return "Zero";	
		if ( num>0 && num<=1000){
			return convertTextDollarLess1000(num);
		}
		else {
			makeParts(num);			
			StringBuilder sb = new StringBuilder();
			while (!parts.isEmpty()){
				//System.out.println(" ct " + ct);				
				String s = convertTextDollarLess1000(parts.pop());				
				if (s!=""){
					sb.append( s + bigNumber[ct]);
				}
				ct--;
			}
			return sb.toString();
		}
	}
	
	private void makeParts(int num){
		int div = num/DIV1000;
		int rem = num%DIV1000;
		parts.push(rem);
		ct++;
		if (div>DIV1000){
			makeParts(div);
		}
		else{
			parts.push(div);
			ct++;
		}
	//	System.out.println(parts);
	}
	
	private static String convertTextDollarLess1000(int num){
		if (num==0) return "";
		if ( num>0 && num<=20){
			return oneToTwenty[num-1];
		}
		else if ( num >20 && num<100){
			int digOne = num%10;
			int digTwo = num/10;		
			if (digOne==0){
				return twentyToNinty[digTwo];
			}
			else{
				return twentyToNinty[digTwo]+oneToTwenty[digOne-1];
			}			
		}
		
		else {
			int digThree = num/100;
			int rem = num%100;
			return oneToTwenty[digThree-1]+HUNDRED + convertTextDollarLess1000(rem);		
		}	
	}
}
