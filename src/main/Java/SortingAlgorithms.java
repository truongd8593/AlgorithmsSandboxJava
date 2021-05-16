import java.util.Arrays;

public class SortingAlgorithms {
    public static void quickSort(int[] a, int l, int r) {
        int i = l, j = r;
        int x = a[(l+r)/2];

        do {
            while (a[i] < x) i++;
            while (a[j] > x) j--;

            if (i <= j) {
                swap(i, j, a);
                i++;
                j--;
            }
        } while (i < j);

        if (l < j) quickSort(a, l, j);
        if (i < r) quickSort(a, i, r);
    }

    public static void shellSort(int[] a, int[] steps) {
        for (int step : steps) {
            insertionSort(a, step);
        }
    }

    public static void heapSort(int[] a) {
        int N = a.length, l = N/2, r = N-1;

        while (l >= 0) {
            siftUp(a, l, N-1);
            l--;
        }

        while (r >= 0) {
            swap(0, r, a);
            r--;
            siftUp(a, 0, r);
        }
    }

    public static void shakerSort(int[] a) {
        int N = a.length;
        int l = 0, r = N-1, k = N-1;

        while (l < r) {
            int j = r;

            while (j > l) {
                if (a[j] < a[j-1]) {
                    swap(j , j-1, a);
                    k = j;
                }
                j--;
            }

            l = k;
            j = l;

            while (j < r) {
                if (a[j] > a[j+1]) {
                    swap(j , j+1, a);
                    k = j;
                }
                j++;
            }

            r = k;
        }
    }

    public static void bubbleSort(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = N-1; j > i; j--) {
                if (a[j] < a[j-1]) {
                    swap(j , j-1, a);
                }
            }
        }
    }

    public static void interchangeSort(int[] a) {
        int N = a.length;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[j] < a[i]) {
                    swap(i , j, a);
                }
            }
        }
    }

    public static void binaryInsertionSort(int[] a) {
        int l, r, m, temp;

        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            l = 0;
            r = i-1;

            while (l <= r) {
                m = (l + r) / 2;

                if (temp < a[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            for (int j = i-1; j >= l; j--) {
                a[j+1] = a[j];
            }

            a[l] = temp;

        }
    }

    public static void insertionSort(int[] a) {
        int pos, temp;
        int N = a.length;

        for (int i = 1; i < N; i++) {
            temp = a[i];
            pos = i-1;

            while ((pos >= 0) && (a[pos] > temp)) {
                a[pos+1] = a[pos];
                pos--;
            }

            a[pos+1] = temp;
        }
    }

    public static void selectionSort(int[] arr) {
        int min;
        int N = arr.length;

        for (int i = 0; i < N-1; i++) {
            min = i;

            for (int j = i+1; j < N; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            swap(min, i, arr);
        }
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] a, int step) {
        int pos, temp;
        int N = a.length;

        for (int i = step; i < N; i++) {
            temp = a[i];
            pos = i-step;

            while ((pos >= 0) && (a[pos] > temp)) {
                a[pos+step] = a[pos];
                pos = pos - step;
            }

            a[pos+step] = temp;
        }
    }

    private static void siftUp(int[] a, int l, int r) {
        int i = l, j = 2 * i;
        int x = a[i];
        int maxTry = 0;

        while (j <= r && maxTry < 10) {
            if (j < r) {
                if (a[j] < a[j+1]) j++;
                if (a[j] < x) {
                    break;
                } else {
                    a[i] = a[j];
                    i = j;
                    j = 2 * i;
                    a[i] = x;
                }
            } else {
                break;
            }
            maxTry++;
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
