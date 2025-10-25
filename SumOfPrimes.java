import java.util.Scanner;

public class SumOfPrimes {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scnr.nextInt();

        LinkedList primeList = new LinkedList();

        int sumThrees = 0;
        LinkedList threeList = new LinkedList();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeList.append(new Node(i));
            }

            if (isPrime(i) && containsThree(i)){
                sumThrees += i;
                threeList.append(new Node(i));
            }
        }

        System.out.println("\nAll prime numbers up to n: ");
        primeList.printList();

        System.out.println("\nAll prime numbers up to n with 3: ");
        threeList.printList();
        System.out.println("\nSum of all prime numbers with 3: " + sumThrees);
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }

    static boolean containsThree(int num) {
        return Integer.toString(num).contains("3");
    }

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public void append(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void prepend(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
