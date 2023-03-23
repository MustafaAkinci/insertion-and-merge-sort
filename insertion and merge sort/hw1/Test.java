import java.io.File;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("student.txt"));
            sc.nextLine();
            int a = 0;
            while (sc.hasNextLine()) {
                sc.nextLine();
                a = a + 1;
            }
            student[] arr = new student[a];
            sc = new Scanner(new File("student.txt"));
            int i = 0;
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] word = sc.nextLine().split(",");
                arr[i] = new student(word[0], word[1], Integer.parseInt(word[2]));
                i++;
            }
            System.out.println("seç");
            System.out.println("1- Insertion Sort");
            System.out.println("2- Merge Sort");
            Scanner choose = new Scanner(System.in);
            int b = choose.nextInt();
            if (b == 1) {
                System.out.println("Insertion Sort");
                System.out.println("-----------------");
                insertion_sort(arr);
            } else if (b == 2) {
                System.out.println("Merge Sort");
                System.out.println("-----------------");
                merge_sort(arr, 0, a - 1);
                for (int j = 0; j < a; j++) {
                    System.out.print(arr[j].name + " ");
                    System.out.print(arr[j].surname + " ");
                    System.out.println(arr[j].id + " ");
                }
            }
            choose.close();
            sc.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    static void insertion_sort(student arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            student key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].id > key.id) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].name + " ");
            System.out.print(arr[i].surname + " ");
            System.out.println(arr[i].id + " ");
        }
    }

    static void merge_sort(student arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);

        }

    }

    static void merge(student arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        student L[] = new student[n1];
        student R[] = new student[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].id <= R[j].id) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}