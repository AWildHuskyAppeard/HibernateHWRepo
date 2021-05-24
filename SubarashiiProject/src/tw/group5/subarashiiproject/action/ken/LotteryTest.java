package tw.group5.subarashiiproject.action.ken;

public class LotteryTest {

	public static void main(String[] args) {

		int[] count = new int[42];
		int[] lottery = new int[42];

		for (int i = 0; i < 10000; i++) {
			int temp = (int) (Math.random() * 42 + 1);
			count[temp - 1]++;
		}

		for (int i = 0; i < lottery.length; i++) {
			lottery[i] = i + 1;

		}
		while (true) {
			int a = 0;

			for (int i = 0; i < count.length - 1; i++) {
				if (count[i] < count[i + 1]) {
					int temp, temp2;
					// 前後排序
					temp = count[i];
					count[i] = count[i + 1];
					count[i + 1] = temp;

					// 號碼排序
					temp2 = lottery[i];
					lottery[i] = lottery[i + 1];
					lottery[i + 1] = temp2;

					a++;
				}
			}

			if (a == 0) {
				for (int i = 0; i < lottery.length-1; i++) {
					System.out.print(lottery[i]+":");
					System.out.println(count[i]);
				}
				break;
			}
		}
	}

}
