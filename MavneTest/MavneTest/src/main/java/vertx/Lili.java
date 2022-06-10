package vertx;

import reflect.Aman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Lili {


    public static List<List<String>> suussusus(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        for (String temp : strs) {
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            String newTemp = new String(chars);
            if (!list.contains(newTemp)) {
                list.add(newTemp);
                lists.add(new ArrayList<>());
            }
            lists.get(list.indexOf(newTemp)).add(temp);
        }
        return lists;
    }

    public static int add(int a, int b) {
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        int jinwei = 0;
        return jinwei;
    }

    public static int beatN(int n) {
        return 1;
    }

    public static int mainElement(int[] nums) {
        int main = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == 0) {
                main = nums[i];
            }
            if (nums[i] != main) {
                result--;
            } else if (nums[i] == main) {
                result++;
            }
        }
        int order = 0;
        for (int num : nums) {
            if (num == main) {
                order++;
            }
        }
        if (order > nums.length / 2) {
            return main;
        } else {
            return -1;
        }
    }

    public static int circle(int[] nums) {
        int left = 0;
        int right = 2;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 2; j < nums.length; j++) {
                int temp = nums[j] - nums[i];
                for (int k = i + 1; k < j; k++) {
                    if (nums[k] > temp) {
                        count += j - k;
                        break;
                    }
                }
            }
        }
        return count;
    }


    class NetNode {
        int val;
        int roadLength = 0;
        HashMap<NetNode, Integer> children = new HashMap<>();

        public NetNode(int val) {
            this.val = val;
        }
    }

    public static int lastStone(int[] height) {
        int first = 0;
        int end = height.length - 1;
        int max = -1;
        while (first != end) {
            int temp = Math.min(height[first], height[end]) * (end - first);
            if (temp > max) {
                max = temp;
            }
            if (Math.min(height[first + 1], height[end]) * (end - first - 1) > Math.min(height[first],
                    height[end - 1]) * (end - first - 1)) {
                first++;
            } else {
                end--;
            }
//            if (height[first + 1] > height[first] && height[end - 1] > height[end]) {
//                if (height[first] > height[end]) {
//                    end--;
//                } else {
//                    first++;
//                }
//            } else if (height[first + 1] < height[first] && height[end - 1] < height[end]) {
//                if (height[first + 1] > height[end - 1]) {
//                    first++;
//                } else {
//                    end--;
//                }
//            } else if (height[first] < height[end]) {
//                first++;
//            } else if (height[first] > height[end]) {
//                end--;
//            }
        }
        return max;
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int first = nums[0] > nums[1] ? 0 : 1;
        int second = nums[0] > nums[1] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[first]) {
                second = first;
                first = i;

            } else if (nums[i] > nums[second] && nums[i] <= nums[first]) {
                second = i;
            }
        }
        if (nums[first] >= nums[second] * 2) {
            return first;
        } else {
            return -1;
        }
    }

    public static void checkTreeNode(TreeNode node, ArrayList<Integer> list, AtomicInteger result, int targetNum) {

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + node.val);
        }
        list.add(node.val);
        for (Integer integer : list) {
            if (integer == targetNum) {
                result.incrementAndGet();
            }
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            checkTreeNode(node.left, list, result, targetNum);
            list.remove(list.size() - 1);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - node.left.val);
            }
        }

        if (node.right != null) {
            checkTreeNode(node.right, list, result, targetNum);
            list.remove(list.size() - 1);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - node.right.val);
            }
        }
    }

    public static void calColor(int[][] grip, int row, int col, int color, int targetColor,
                                int source, HashSet<int[]> mark) {
        if (row >= 0 && col >= 0 && row < grip.length && col < grip[0].length) {
            if (grip[row][col] == targetColor) {
                if (source != 3) {
                    calColor(grip, row + 1, col, color, targetColor, 1, mark);
                }
                if (source != 4) {
                    calColor(grip, row, col - 1, color, targetColor, 2, mark);
                }
                if (source != 1) {
                    calColor(grip, row - 1, col, color, targetColor, 3, mark);
                }
                if (source != 2) {
                    calColor(grip, row, col + 1, color, targetColor, 4, mark);
                }

            } else {
                if (source == 1) {
                    grip[row - 1][col] = color;
                }
                if (source == 2) {
                    grip[row][col + 1] = color;
                }
                if (source == 3) {
                    grip[row + 1][col] = color;
                }
                if (source == 4) {
                    grip[row][col - 1] = color;
                }
            }
        } else {
            if (source == 1) {
                grip[row - 1][col] = color;
            }
            if (source == 2) {
                grip[row][col + 1] = color;
            }
            if (source == 3) {
                grip[row + 1][col] = color;
            }
            if (source == 4) {
                grip[row][col - 1] = color;
            }
        }
    }


    public static boolean findTarget(String instructions) {
        int angle = 0;
        int[] pos = new int[]{0, 0};
        char[] chars = instructions.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'G') {
                if (angle == 0) {
                    pos[1]++;
                } else if (angle == 90) {
                    pos[0]++;
                } else if (angle == 180) {
                    pos[1]--;
                } else if (angle == 270) {
                    pos[0]--;
                }
            } else if (aChar == 'L') {
                angle -= 90;
                if (angle < 0) {
                    angle += 360;
                }
            } else if (aChar == 'R') {
                angle += 90;
                if (angle >= 360) {
                    angle -= 360;
                }
            }
        }
        if (pos[0] == 0 && pos[1] == 0) {
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                for (char aChar : chars) {
                    if (aChar == 'G') {
                        if (angle == 0) {
                            pos[1]++;
                        } else if (angle == 90) {
                            pos[0]++;
                        } else if (angle == 180) {
                            pos[1]--;
                        } else if (angle == 270) {
                            pos[0]--;
                        }
                    } else if (aChar == 'L') {
                        angle -= 90;
                        if (angle < 0) {
                            angle += 360;
                        }
                    } else if (aChar == 'R') {
                        angle += 90;
                        if (angle >= 360) {
                            angle -= 360;
                        }
                    }
                }
            }
            if (pos[0] == 0 && pos[1] == 0) {
                return true;
            }
        }
        return false;
    }
    public int countKDifference(int[] nums, int k) {
        int num = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] > k) {
                    break;
                } else if (nums[j] - nums[i] == k) {
                    num++;
                }

            }
        }
        return num;
    }

    public static void main(String[] args) throws ParseException, InterruptedException {



        HashMap<Integer, Aman>hashMap1 = new HashMap<>();
        HashMap<Integer, Aman>hashMap2 = new HashMap<>();
        HashMap<Integer, Aman>hashMap3 = new HashMap<>();
        Aman aman = new Aman();
        aman.setName("aman")  ;
        aman.setAge(20);
        aman.setSex(true);
        hashMap1.put(1, aman);
        hashMap2.put(2, aman);
        hashMap3.put(3, aman);
        System.out.println(hashMap1.get(1).getName());
        System.out.println(hashMap2.get(2).getName());
        System.out.println(hashMap3.get(3).getName());
        aman.setName("aman1")  ;
        System.out.println(hashMap1.get(1).getName());
        System.out.println(hashMap2.get(2).getName());
        System.out.println(hashMap3.get(3).getName());

        HashMap<Integer,Integer>hashMap = new HashMap<>();
        for (Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> next =  iterator.next();
            
        }
        String s = "";
        String [] ss = s.split(":");
        System.out.println(Arrays.toString(ss));


        FizzBuzz fizzBuzz = new FizzBuzz(5);
        new Thread(()-> {
            try {
                fizzBuzz.fizz(()-> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.buzz(()-> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(()-> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.number(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        H2O h2O = new H2O();
        Runnable H = () -> {
            try {
                h2O.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable O = () -> {
            try {
                h2O.oxygen(() -> System.out.println("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(O);
        service.execute(O);
        service.execute(H);
        service.execute(H);
        service.execute(H);
        service.execute(H);

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        FooBar fooBar = new FooBar(3);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString());
        System.out.println(lastStone(new int[]{1, 1}));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        var d = simpleDateFormat.parse("2015-07-03");
        System.out.println(d.getTime());
        String data = "20190907";
        StringBuilder stringBuilder = new StringBuilder(data);
        stringBuilder.insert(6, "-");
        stringBuilder.insert(4, "-");
        System.out.println(stringBuilder.toString());


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Foo {
    AtomicInteger integer = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (true) {
            if (integer.get() == 0) {
                printFirst.run();
                integer.incrementAndGet();
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true) {
            if (integer.get() == 1) {
                printSecond.run();
                integer.incrementAndGet();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true) {
            if (integer.get() == 2) {
                printThird.run();
                break;
            }
        }
    }
}

class FooBar {
    private int n;

    Object o = new Object();
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            printFoo.run();
            i++;
            conditionB.signal();

            if (i == n) {
                lock.unlock();
                break;
            } else {
                conditionA.await();
                lock.unlock();
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {

            // printBar.run() outputs "bar". Do not change or remove this line.

            lock.lock();
            printBar.run();
            i++;
            conditionA.signal();

            if (i == n) {
                lock.unlock();
                break;
            } else {
                conditionB.await();
                lock.unlock();
            }


        }
    }

}

class ZeroEvenOdd {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    Condition conditionZero = lock.newCondition();
    Condition conditionEven = lock.newCondition();
    Condition conditionOdd = lock.newCondition();
    volatile int index = 1;


    Semaphore semaphoreZero = new Semaphore(1);
    Semaphore semaphoreOdd = new Semaphore(0);
    Semaphore semaphoreEven = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {

            semaphoreZero.acquire();
            printNumber.accept(0);
            if (index % 2 == 1) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {

            if (i % 2 == 1) {
                semaphoreOdd.acquire();
                printNumber.accept(index);
                index++;
                semaphoreZero.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (i % 2 == 0) {
                semaphoreEven.acquire();

                printNumber.accept(index);
                index++;
                semaphoreZero.release();
            }
        }

    }


}

class H2O {
    Object o = new Object();

    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


        // printFoo.run() outputs "foo". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
        if (semaphoreO.availablePermits() == 0 && semaphoreH.availablePermits() == 0) {
            semaphoreH.release(2);
            semaphoreO.release();
        }


        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire();
        releaseOxygen.run();
        if (semaphoreO.availablePermits() == 0 && semaphoreH.availablePermits() == 0) {
            semaphoreH.release(2);
            semaphoreO.release();
        }


    }
}
class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    AtomicInteger integer = new AtomicInteger(1);
    ReentrantLock lock = new ReentrantLock();
    Condition conditionFizz = lock.newCondition();
    Condition conditionBuzz = lock.newCondition();
    Condition conditionFizzbuzz = lock.newCondition();
    Condition conditionNormal = lock.newCondition();

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while (integer.get() <= n) {
            if (integer.get() % 3 == 0) {
                printFizz.run();
                integer.incrementAndGet();
            } else {
                conditionNormal.signal();
                conditionFizz.await();

            }
        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        while (integer.get() <= n) {
            if (integer.get()%5==0) {
                printBuzz.run();
                integer.incrementAndGet();
            } else {
                conditionNormal.signal();
                conditionBuzz.await();

            }
        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while (integer.get() <= n) {
            if (integer.get() % 3 == 0&&integer.get()%5==0) {
                printFizzBuzz.run();
                integer.incrementAndGet();
            } else {
                conditionNormal.signal();
                conditionFizzbuzz.await();

            }
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (integer.get() <= n) {

            if (integer.get() % 3 != 0 && integer.get() % 5 != 0) {
                printNumber.accept(integer.get());
                integer.incrementAndGet();
            } else if (integer.get() % 3 == 0 && integer.get() % 5 == 0) {
                conditionFizzbuzz.signal();
                conditionNormal.await();

            } else if (integer.get() % 3 == 0) {
                conditionFizz.signal();
                conditionNormal.await();

            } else if (integer.get() % 5 == 0) {
                conditionBuzz.signal();
                conditionNormal.await();

            }
        }
        conditionBuzz.signal();
        conditionFizz.signal();
        conditionFizzbuzz.signal();
        lock.unlock();
    }
}