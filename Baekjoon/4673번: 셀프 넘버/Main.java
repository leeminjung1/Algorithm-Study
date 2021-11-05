public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            if(d(i)>10000) continue;
            arr[d(i)] = d(i);
        }
        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) System.out.println(i);
        }
    }

    private static int d(int i) {
        int sum = i;
        String s = String.valueOf(i);
        for (char c : s.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

}
