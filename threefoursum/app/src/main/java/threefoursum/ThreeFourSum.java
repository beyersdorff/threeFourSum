/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package threefoursum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ThreeFourSum {
    public static boolean allDistinct(int[] arr) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int num : arr) {
            if (uniqueValues.contains(num)) {
                return false;
            }
            uniqueValues.add(num);
        }
        return true;
    }

    // Three Cubic
    public static int[] threeSumCubic(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                for (int k = j+1; k < n; ++k) {
                    int c = x[k];
                    if (a + b + c == 0) {
                        return new int[] { a, b, c };
                    }
                }
            }
        }
        return null;
    }

    // Three Quadratic
    public static int[] threeSumQuadratic(int[] x) {
        int n = x.length;
        int[] y = x.clone();
        Arrays.sort(y);
        for (int i = 0; i < n; ++i) {
            int a = y[i];
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int b = y[left];
                int c = y[right];
                if (a+b+c == 0) {
                    return new int[] { a, b, c};
                }
                else if (a+b+c < 0) {
                    ++left;
                }
                else {
                    --right;
                }
            }
        }

        return null;
    }

    // Three HashMap
    public static int[] threeSumHashMap(int[] x) {
        int n = x.length;
        HashMap<Integer,Integer> H = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; ++i) {
            H.put(x[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                int c = -a - b;
                Integer k = H.get(c);
                if (k != null && j < k) {
                    return new int[] { a, b, c };
                }
            }
        }
        return null;
    }

    // [1, 2, 3, 4, 5, -5, (-5)]
    // a = 1, b = 2, c = -3, k = null | i = 0, j = 1
    // a = 1, b = 3, c = -4, k = null | i = 0, j = 2
    // a = 1, b = 4, c = -5, k = 5    | i = 0, j = 3 *
    // a = 1, b = 5, c = -6, k = null | i = 0, j = 4
    // a = 1, b = -5, c = 4, k = 3 | i = 0, j = 5

    // Three HashMap without comparison (j < k)
    public static int[] threeSumHashMapNoComparison(int[] x) {
        int n = x.length;
        HashMap<Integer,Integer> H = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; ++i) {
            H.put(x[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                int c = -a - b;
                Integer k = H.get(c);
                if (k != null) {
                    return new int[] { a, b, c };
                }
            }
        }
        return null;
    }

    /* ---------------------------------------------------------- */

    // Four Cubic
    public static int[] fourSumCubic(int[] x) {
        int n = x.length;
        int[] y = x.clone();
        Arrays.sort(y);
        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                int left = j + 1;
                int right = n;
                while (left < right) {
                    int c = x[left];
                    int d = x[right];
                    if (a + b + c + d == 0) {
                        return new int[] { a, b, c, d };
                    }
                    else if (a + b + c + d < 0) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return null;
    }

    // Four Quartic
    public static int[] fourSumQuartic(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                for (int k = j+1; k < n; ++k) {
                    int c = x[k];
                    for (int l = k+1; l < n; ++l) {
                        int d = x[l];
                        if (a + b + c + d == 0) {
                            return new int[] { a, b, c, d };
                        }
                    }
                }
            }
        }
        return null;
    }

    // Four HashMap
    public static int[] fourSumHashMap(int[] x) {
        int n = x.length;
        HashMap<Integer, Integer[]> H = new HashMap<Integer, Integer[]>();

        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                Integer[] pair = {i, j};
                H.put(x[i] + x[j], pair);
            }
        }

        for (int i = 0; i < n; ++i) {
            int a = x[i];
            for (int j = i+1; j < n; ++j) {
                int b = x[j];
                Integer[] values = H.get(-a-b);
                if (values != null) {
                    Integer k = values[0];
                    Integer l = values[1];
                    if (k != null && l != null && k == 0 && l == 0 && j < k) {
                        int c = x[k];
                        int d = x[l];
                        System.out.println("HERE");
                        return new int[] { a, b, c, d };
                    }
                }
            }
        }

        return null;
    }

    // Read input with Scanner
    public static int[] readData() {
        Scanner s = new Scanner(System.in);
        int[] x = null;
        try {
            int n = s.nextInt();
            x = new int[n];
            for (int i = 0; i < n; ++i) {
                x[i] = s.nextInt();
            }
        }
        finally {
            s.close();
        }
        return x;
    }

    // Validate arguments passed to the main function
    public static void validateArgs(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Supossed to find 1 element as argument");
        }

        // if (!args[0].matches("[a-zA-Z]+$")) {
        //     throw new IllegalArgumentException("Argument is supposed to be composed of characters");
        // }
    }

    public static void main(String[] args) {
        validateArgs(args);

        int[] x = readData();
        int[] y = null;

        if (!allDistinct(x)) {
            System.out.println("null");
            System.exit(0);
        }

        if ("t_cubic".equals(args[0])) {
            y = threeSumCubic(x);
        }
        else if ("t_quadratic".equals(args[0])) {
            y = threeSumQuadratic(x);
        }
        else if ("t_hashmap".equals(args[0])) {
            y = threeSumHashMap(x);
        }
        else if ("t_hashmap_nocomp".equals(args[0])) {
            y = threeSumHashMapNoComparison(x);
        }
        else if ("f_cubic".equals(args[0])) {
            y = fourSumCubic(x);
        }
        else if ("f_quartic".equals(args[0])) {
            y = fourSumQuartic(x);
        }
        else if ("f_hashmap".equals(args[0])) {
            y = fourSumHashMap(x);
        }

        if (y == null) {
            System.out.println("null");
        }
        else {
            System.out.println(String.format("%d %d %d", y[0], y[1], y[2]));
        }
    }
}
