import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stack = new int[200000];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int index;
        int[] card = new int[1001];
        for (int i = 0; i < n; i++) {
            index = Integer.parseInt(br.readLine());
            card[index]++;
        }

        for (int i = 0, j = 0; i < 1001; i++) {
            if (card[i]-- >= 1) {
                stack[j] = i;
                i--;
                j++;
            }
        }

        recursion(0, n);
        
        System.out.println(sum);
    }

    private static void recursion(int start, int end) {
        int initst = start;
        int inited = end;
        if (inited - initst == 1) return;
        end = start;
        stack[end++] = stack[start] + stack[start + 1];
        sum += stack[end - 1];
        for (int i = 2 + initst; i < inited; i++) {
            if (stack[i] > stack[start]) {
                if (end - start == 1) {
                    stack[end++] = stack[start++] + stack[i];
                    sum += stack[end - 1];
                } else {
                    if (stack[i] > stack[start + 1]) {
                        stack[end++] = stack[start] + stack[start + 1];
                        sum += stack[end - 1];
                        start += 2;
                        i--;
                    } else {
                        stack[end++] = stack[start++] + stack[i];
                        sum += stack[end - 1];
                    }
                }
            } else {
                if (i + 1 == inited) {
                    stack[end++] = stack[start++] + stack[i];
                    sum += stack[end - 1];
                    break;
                }
                if (stack[i + 1] > stack[start]) {
                    stack[end++] = stack[start++] + stack[i];
                    sum += stack[end - 1];
                } else {
                    stack[end++] = stack[i] + stack[i + 1];
                    sum += stack[end - 1];
                    i++;
                }
            }
        }

        recursion(start, end);
    }
}
