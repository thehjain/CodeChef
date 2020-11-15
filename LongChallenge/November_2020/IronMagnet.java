/*
.
Iron, Magenet and Wall
.
*/
import java.util.*;
import java.io.*;
import java.math.*;

class IronMagnet {

	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static int MOD = 1000000007;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- != 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		String[] input = br.readLine().trim().split(" ");
		char[] arr = br.readLine().toCharArray();

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int res = findMax(arr, n, k);
		System.out.println(res);
	}

	static int findMax(char[] arr, int n, int k) {

		int count = 0;
		int sheets = 0;
		int power = 0;
		int indM = -1;
		int indI = -1;

		int countIron = 0, countMag = 0;
		for (char ele : arr) {
			if (ele == 'M')
				countMag++;
			if (ele == 'I')
				countIron++;
		}

		if (countIron == 0 || countMag == 0 || k == 0)
			return 0;

		for (int i = 0; i < n; i++) {

			if (arr[i] == 'M') {
				if (indI != -1) {
					power = k + 1 - Math.abs(indI - i) - sheets;
					if (power > 0) {
						count++;
						indM = -1;
					} else
						indM = i;
					sheets = 0;
					power = 0;
					indI = -1;
				} else
					indM = i;
			} else if (arr[i] == 'I') {
				if (indM != -1) {
					power = k + 1 - Math.abs(indM - i) - sheets;
					if (power > 0) {
						count++;
						indI = -1;
					} else
						indI = i;
					sheets = 0;
					power = 0;
					indM = -1;
				} else
					indI = i;
			} else if (arr[i] == ':')
				sheets++;
			else if (arr[i] == 'X') {
				indI = -1;
				indM = -1;
				power = 0;
				sheets = 0;
			}
		}
		return count;
	}

}


// for (int i = 0; i < n; i++) {
// 	sheets = 0;
// 	power = 0;
// 	flag = false;
// 	if (arr[i] == 'M') {

// 		int left = i - 1, right = i + 1;
// 		while (left >= 0 && arr[left] != 'I') {
// 			if (arr[left] == ':')
// 				sheets++;
// 			if (arr[left] == 'X' || arr[left] == '.') {
// 				flag = true;
// 				break;
// 			}
// 			left--;
// 		}
// 		//System.out.println(arr[left]);
// 		if (!flag && left >= 0 && arr[left] == 'I') {
// 			power = k + 1 - Math.abs(left - i) - sheets;
// 			//System.out.println(power);
// 			if (power > 0) {
// 				arr[i] = '.';
// 				arr[left] = '.';
// 				count++;
// 				continue;
// 			}
// 		}
// 		power = 0;
// 		sheets = 0;
// 		flag = false;
// 		while (right < n && arr[right] != 'I') {
// 			if (arr[right] == ':')
// 				sheets++;
// 			if (arr[right] == 'X' || arr[right] == '.') {
// 				flag = true;
// 				break;
// 			}
// 			right++;
// 		}
// 		if (!flag && right < n && arr[right] == 'I') {
// 			power = k + 1 - Math.abs(right - i) - sheets;
// 			if (power > 0) {
// 				arr[i] = '.';
// 				arr[right] = '.';
// 				count++;
// 				continue;
// 			}
// 		}
// 	}
// }



// while (j < n && arr[j] != 'I') {
// 	if (arr[j] == ':')
// 		sheets++;
// 	if (arr[j] == 'X') {
// 		index = j;
// 		flag = true;
// 	}
// 	if (j + 1 >= n)
// 		break;
// 	j++;

// }
// if (arr[j] != 'I')
// 	continue;
// if (index != -1 && ((index >= j && index < i) || (index >= i && index < j)))
// 	continue;
// power = k + 1 - Math.abs(j - i) - sheets;
// if (power > 0) {
// 	arr[j] = '.';
// 	arr[i] = '.';
// 	count++;
// }