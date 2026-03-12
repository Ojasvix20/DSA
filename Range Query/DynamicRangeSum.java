import java.util.*;
import java.io.*;

public class DynamicRangeSum {

    static long[] arr, seg;
    static int n;

    // build segment tree
    public static void buildSt(int idx, int l, int r) {

        if (l == r) {
            seg[idx] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        buildSt(2 * idx + 1, l, mid);
        buildSt(2 * idx + 2, mid + 1, r);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    // range sum query
    public static long query(int ql, int qr, int idx, int l, int r) {

        // no overlap
        if (qr < l || ql > r)
            return 0;

        // complete overlap
        if (ql <= l && r <= qr)
            return seg[idx];

        int mid = (l + r) / 2;

        return query(ql, qr, 2 * idx + 1, l, mid) +
               query(ql, qr, 2 * idx + 2, mid + 1, r);
    }

    // update single index
    public static void update(int idx, int l, int r, int pos, long val) {

        if (l == r) {
            seg[idx] = val;
            arr[pos] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(2 * idx + 1, l, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, r, pos, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        seg = new long[4 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        buildSt(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {

            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {

                int k = Integer.parseInt(st.nextToken()) - 1;
                long u = Long.parseLong(st.nextToken());

                update(0, 0, n - 1, k, u);

            } else {

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                sb.append(query(a, b, 0, 0, n - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}