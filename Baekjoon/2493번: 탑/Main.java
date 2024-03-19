public class Main {

    static class Tower {
        int height;
        int idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = read();

        Tower[] stack = new Tower[n + 1];
        StringBuilder sb = new StringBuilder();

        int size = 0;
        for (int i = 1; i < n + 1; i++) {
            int height = read();

            while (size != 0 && stack[size - 1].height < height) {
                size--;
            }

            if (size == 0) {
                sb.append('0').append(' ');
            } else {
                sb.append(stack[size - 1].idx).append(' ');
            }

            stack[size++] = new Tower(height, i);
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32) {
            o = (o << 3) + (o << 1) + (d & 15);
        }
        return o;
    }
}
