//Main class
public class Tasks {
	public static void main(String[] args) {
		System.out.println("Enter the task number: ");
		String input = System.console().readLine();
		try {
		switch(input) {
			case "1":
				System.out.println(repeat(args[0],Integer.parseInt(args[1])));
				return;
			case "2":
				System.out.println(differenceMaxMin(strArrToIntArr(args)));
				return;
			case "3":
				System.out.println(isAvgWhole(strArrToIntArr(args)));
				return;
			case "4":
				int[] result = cumulativeSum(strArrToIntArr(args));
				System.out.print("[");
				String temp = "";
				for(int i = 0; i < result.length; i++) {
					System.out.print(temp+result[i]);
					temp = ", ";
				}
				System.out.print("]\n");
				return;
			case "5":
				System.out.println(getDecimalPlaces(args[0]));
				return;
			case "6":
				System.out.println(Fibonacci(Integer.parseInt(args[0])));
				return;
			case "7":
				System.out.println(isValid(args[0]));
				return;
			case "8":
				System.out.println(isStrangePair(args[0], args[1]));
				return;
			case "9":
				System.out.println(suffprefHandler(args[0], args[1]));
				return;
			case "10":
				System.out.println(boxSeq(Integer.parseInt(args[0])));
				return;
			default:
				System.out.println("[ERROR] Input does not match a task number.");
		}
		} catch(Exception err) {
			System.out.println("An error has occured. Check what you're inputting as arguments. Error follows: ");
			System.out.println(err);
		}
	}
	
	//Repeats letters in a string
	public static String repeat(String s, int n) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < n; j++) {
				res += s.charAt(i);
			}
		}
		return res;
	}
	
	//Finds and substracts max and min of an array of ints
	public static int differenceMaxMin(int nums[]) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < min) {
				min = nums[i];
			}
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		return max-min;
	}
	
	//Checks if array average is whole
	public static boolean isAvgWhole(int nums[]) {
		double temp = 0;
		for(int i = 0; i < nums.length; i++) {
			temp += nums[i];
		}
		temp /= nums.length;
		if(temp == Math.floor(temp) || temp == Math.ceil(temp)) {
			return true;
		}
		return false;
	}
	
	//Finds cumulative sums of each array element
	public static int[] cumulativeSum(int nums[]) {
		int temp = 0;
		int[] result = new int [nums.length];
		for(int i = 0; i < nums.length; i++) {
			temp += nums[i];
			result[i] = temp;
		}
		return result;
	}
	
	//Finds how many decimal places a number has
	public static int getDecimalPlaces(String num) {
		int temp = 0;
		boolean dotFlag = false;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '.') {
				dotFlag = true;
			} else if (dotFlag) {
				temp++;
			}
		}
		return temp;
	}
	
	//Finds a fibbonachi number
	public static int Fibonacci(int n) {
		int x = 1;
		int y = 1;
		if(n == 0) {
			return 0;
		} else if (n < 3) {
			return 1;
		}
		for(int i = 0; i < n-2; i++) {
			if(x > y) {
				y = x+y;
			} else {
				x = x+y;
			}
		}
		return Math.max(x,y);
	}
	
	//Finds if a number is a valid mail index
	public static boolean isValid(String x) {
		if(x.length() == 5) {
			for(int i = 0; i < x.length(); i++) {
				if(!(x.charAt(i) <= '9' && x.charAt(i) >= '0')) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	//Finds if a pair of strings is strange
	public static boolean isStrangePair(String a, String b) {
		if(a == "" && b == "") return true;
		if(a == "" || b == "") return false;
		return a.charAt(a.length()-1) == b.charAt(0) && a.charAt(0) == b.charAt(b.length()-1);
	}
	
	//Handles suffix and prefix search
	public static boolean suffprefHandler(String s, String xfix) {
		if(xfix.charAt(0) == '-') {
			return isSuffix(s, xfix);
		} else {
			return isPrefix(s, xfix);
		}
	}
	
	//Finds if prefix is a prefix of s
	private static boolean isPrefix(String s, String prefix) {
		for(int i = 0; i < prefix.length()-1; i++) {
			if(!(prefix.charAt(i) == s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	//Finds if suffix is a suffix of s
	private static boolean isSuffix(String s, String suffix) {
		for(int i = 0; i < suffix.length()-1; i++) {
			if(!(suffix.charAt(suffix.length()-i-1) == s.charAt(s.length()-i-1))) {
				return false;
			}
		}
		return true;
	}
	
	//Finds a'th element in a particular sequence
	public static int boxSeq(int a) {
		return (a/2+a%2)*3-a/2;
	}
	
	//Converts an array of string to an array of integers
	protected static int[] strArrToIntArr(String array[]) {
		int nums[] = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			nums[i] = Integer.parseInt(array[i]);
		}
		return nums;
	}
}

