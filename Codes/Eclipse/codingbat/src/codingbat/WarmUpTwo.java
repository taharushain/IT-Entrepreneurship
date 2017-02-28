package codingbat;

public class WarmUpTwo {
	public String stringTimes(String str, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += str;
		}

		return result;
	}

	public int countXX(String str) {
		int result = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'x' && str.charAt(i) == str.charAt(i + 1)) {
				result++;
			}
		}
		return result;
	}

	public String frontTimes(String str, int n) {
		String result = "";
		if (str.length() >= 3) {
			String sub = str.substring(0, 3);
			for (int i = 0; i < n; i++) {
				result += sub;
			}
			return result;
		} else {
			for (int i = 0; i < n; i++) {
				result += str;
			}
			return result;
		}
	}

	boolean doubleX(String str) {
		boolean result = false;

		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == 'x') {
				if (str.charAt(i) == str.charAt(i + 1)) {
					result = true;
					break;
				} else {
					break;
				}
			}

		}
		return result;
	}

	public String stringBits(String str) {
		char[] characters = new char[str.length()];
		str.getChars(0, str.length(), characters, 0);

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				result += characters[i];
			}
		}

		return result;
	}

	public String stringSplosion(String str) {

		char[] characters = new char[str.length()];
		str.getChars(0, str.length(), characters, 0);

		String result = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j <= i; j++) {
				result += characters[j];
			}
		}

		return result;
	}

	public int last2(String str) {

		if (str.length() <= 2) {
			return 0;
		}

		String lastTwo = str.substring(str.length() - 2, str.length());
		String beforeLastTwo = str.substring(0, str.length() - 2);

		// char[] characters = new char[str.length()];
		// str.getChars(0,str.length(), characters, 0);

		int result = 0;

		for (int i = 0; i < beforeLastTwo.length(); i++) {
			if (lastTwo.equals("" + str.charAt(i) + str.charAt(i + 1))) {
				result++;
			}
		}

		return result;
	}

	public String stringX(String str) {

		if (str.length() <= 2) {
			return str;
		}

		String start = str.charAt(0) + "";
		String end = str.charAt(str.length() - 1) + "";
		String middle = str.substring(1, str.length() - 1) + "";
		middle = middle.replace("x", "");
		return start + middle + end;
	}

	public String altPairs(String str) {
		String result = "";

		int i = 0;

		while (i < str.length()) {
			result += str.charAt(i);
			if (i + 1 < str.length()) {
				result += str.charAt(i + 1);
			}

			i += 4;
		}

		return result;

	}

	public String stringYak(String str) {

		return str.replace("yak", "");

	}

	public int array667(int[] nums) {

		int result = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
				result++;
			}
		}

		return result;
	}

	public boolean noTriples(int[] nums) {

		for (int i = 0; i < nums.length - 2; i++) {

			if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
				return false;
			}

		}

		return true;
	}

	public boolean has271(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {

			int x = Math.abs(nums[i + 2] - (nums[i] - 1));

			if (nums[i] + 5 == nums[i + 1]) {
				if (x <= 2) {
					return true;
				}
			}
		}

		return false;
	}

}
