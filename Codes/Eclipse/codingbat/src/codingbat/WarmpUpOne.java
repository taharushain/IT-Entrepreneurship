package codingbat;

public class WarmpUpOne {

	public boolean sleepIn(boolean weekday, boolean vacation) {
		if (!weekday || vacation) {
			return true;
		} else {
			return false;
		}

	}

	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		if (aSmile == bSmile) {
			return true;
		} else {
			return false;
		}
	}

	public int sumDouble(int a, int b) {
		if (a == b) {
			return (a + b) * 2;
		} else {
			return a + b;
		}
	}

	public int diff21(int n) {
		if (n > 21) {
			return Math.abs(n - 21) * 2;
		} else {
			return Math.abs(n - 21);
		}
	}

	public boolean parrotTrouble(boolean talking, int hour) {
		if (talking && (hour < 7 || hour > 20)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean makes10(int a, int b) {
		if (a == 10 || b == 10 || (a + b) == 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean nearHundred(int n) {
		int a = Math.abs(100 - n);
		int b = Math.abs(200 - n);

		if (a <= 10 || b <= 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean posNeg(int a, int b, boolean negative) {
		if (negative && (a < 0 && b < 0)) {
			return true;
		} else if (!negative && ((a < 0 && b >= 0) || (a >= 0 && b < 0))) {
			return true;
		} else {
			return false;
		}
	}

	public static String notString(String str) {

		String temp = "";
		if (str.length() >= 3) {
			temp = str.substring(0, 3);
		}

		if (temp.contains("not")) {
			return str;
		} else {
			return "not " + str;
		}

	}

	public String missingChar(String str, int n) {
		String one = str.substring(0, n);
		String two = str.substring(n + 1, str.length());
		return one + two;
	}

	public String frontBack(String str) {
		if (str.length() > 1) {
			char a = str.charAt(0);
			char b = str.charAt(str.length() - 1);
			String sub = str.substring(1, str.length() - 1);
			return b + sub + a;
		} else {
			return str;
		}

	}

	public String front3(String str) {
		if (str.length() >= 3) {
			String sub = str.substring(0, 3);
			return sub + sub + sub;
		} else {
			return str + str + str;
		}
	}

	public String backAround(String str) {
		if (str.length() > 0) {
			char last = str.charAt(str.length() - 1);
			return last + str + last;
		} else {
			return str;
		}
	}

	public boolean or35(int n) {
		if (n % 3 == 0 || n % 5 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String front22(String str) {
		if (str.length() >= 2) {
			String front = str.substring(0, 2);
			return front + str + front;
		} else {
			return str + str + str;
		}
	}

	public boolean startHi(String str) {
		if (str.length() >= 2) {
			String sub = str.substring(0, 2);
			if (sub.equals("hi"))
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean icyHot(int temp1, int temp2) {
		if (temp1 < 0 && temp2 > 100)
			return true;
		else if (temp2 < 0 && temp1 > 100)
			return true;
		else
			return false;
	}

	public boolean in1020(int a, int b) {
		if (a >= 10 && a <= 20) {
			return true;
		} else if (b >= 10 && b <= 20) {
			return true;
		} else {
			return false;
		}
	}
	public boolean hasTeen(int a, int b, int c) {
		if (a >= 13 && a <= 19) {
			return true;
		} else if (b >= 13 && b <= 19) {
			return true;
		} else if (c >= 13 && c <= 19) {
			return true;
		} else
			return false;
	}

	public boolean loneTeen(int a, int b) {
		if (a >= 13 && a <= 19) {
			if (!(b >= 13 && b <= 19)) {
				return true;
			} else
				return false;
		} else if (b >= 13 && b <= 19) {
			if (!(a >= 13 && a <= 19)) {
				return true;
			} else
				return false;
		} else
			return false;

	}
	public static String delDel(String str) {
		if (str.length() >= 4) {
			String sub = str.substring(1, 4);
			if (sub.equals("del")) {
				String a = str.substring(0, 1);
				String b = "";
				if (str.length() >= 5) {
					b = str.substring(4);
				}
				return a + b;
			} else {
				return str;
			}
		} else {
			return str;
		}
	}
	public int close10(int a, int b) {
		  int nearA = Math.abs(a-10);
		  int nearB = Math.abs(b-10);
		  
		  if(nearA > nearB){
		    return b;
		  }else if(nearA < nearB){
		    return a;
		  }else{
		    return 0;
		  }
		}
	public boolean in3050(int a, int b) {
		  if(a >= 30 && a<= 40 && b >= 30 && b<= 40){
		    return true;
		  }else if(a >= 40 && a<= 50 && b >= 40 && b<= 50){
		    return true;
		  }else{
		    return false;
		  }
		}
	public int max1020(int a, int b) {
		  if(a >= 10 && a <= 20 && (a > b || !(b >= 10 && b <= 20))){
		    return a;
		  }else if(b >= 10 && b <= 20 && (b > a || !(a >= 10 && a <= 20))){
		    return b;
		  }else{
		    return 0;
		  }
		}
	public boolean stringE(String str) {
		  
	    char[] chars= new char[str.length()];
			str.getChars(0, str.length(), chars, 0);
			int eCount = 0;
			for(int i=0; i < str.length(); i++){
				if(chars[i] == 'e'){
				  eCount++;
				}
			}
			
			if(eCount >= 1 && eCount <= 3){
			  return true;
			}else{
			  return false;
			}
	}
	public boolean lastDigit(int a, int b) {
		  if(a % 10 == b % 10){
		    return true;
		  }else{
		    return false;
		  }
		}
	public String endUp(String str) {
		  if(str.length()>3){
		    String left = str.substring(0, str.length()-3);
		    String right = str.substring(str.length() - 3, str.length());
		    return left + right.toUpperCase();
		  }else{
		    return str.toUpperCase();
		  }
		}
	public String everyNth(String str, int n) {
		  char[] characters = new char[str.length()];
		  str.getChars(0, str.length(), characters, 0);
		  String result = "";
		  
		  for(int i=0; i < str.length(); i++){
		    if(i % n == 0){
		      result += characters[i];
		    }
		  }
		  
		  return result;
		}



	
	public static void main(String[] args) {

		String str= "xxHxix";
		
		String start = str.charAt(0) + "";
		String end = str.charAt(str.length()-1) + "";
		String middle = str.substring(1,str.length()-1) + "";
		middle = middle.replace("x","");
		System.out.println(start);
		System.out.println(middle);
		System.out.println(end);
		System.out.println(start + middle + end);
		
		//
		//
		// int n =0;
		//
		// for(int i=0; i<n; i++){
		// for(int j=n; j>i; j--)
		// System.out.print(" ");
		// for(int j=0; j <= i ; j++){
		// System.out.print("*");
		// }
		// for(int j=0; j < i ; j++){
		// System.out.print("*");
		// }
		// System.out.println("");
		// }

	}

}
