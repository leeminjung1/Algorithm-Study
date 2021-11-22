import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        minHeap heap = new minHeap(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if(v == 0) {
                sb.append(heap.delete()).append('\n');
                continue;
            }
            heap.insert(v);
        }
        System.out.println(sb);
        br.close();
    }

    public static class minHeap {
        public int[] arr;
        public int index;

        public minHeap(int n) {
            arr = new int[n];
            this.index = 0;
        }

        public int delete() {
            if (index == 0 ) return 0;
            int result = arr[0];
            arr[0] = arr[--index];
            pollHeapify(0);
            return result;
        }

        private void pollHeapify(int i) {
            int p = i;
            int l = (i << 1) + 1;
            int r = (i << 1) + 2;
            if (l < index && arr[l] < arr[p]) {
                p = l;
            }
            if (r < index && arr[r] < arr[p]) {
                p = r;
            }
            if (p != i) {
                swap(i, p);
                pollHeapify(p);
            }
        }

        public void insert(int v) {
            arr[index] = v;
            addHeapify(index);
            index++;
        }

        private void addHeapify(int index) {
            int tmp = (index - 1) >> 1;
            if(tmp < 0) return;
            if (arr[tmp] > arr[index]) {
                swap(index, tmp);
                addHeapify(tmp);
            }
        }

        private void swap(int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
    }


}
