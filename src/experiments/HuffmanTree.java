package experiments;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 贪心算法 哈夫曼树 最优前缀码
 * Created by 36249 on 2017/4/26.
 */
public class HuffmanTree {


    public Node func(String str) {

        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

            public int compare(Node o1, Node o2) {

                if (o1.times != o2.times) {

                    return o1.times - o2.times;
                } else {

                    return o1.value - o2.value;
                }
            }

        });

        Map<Integer, Value> map = new HashMap<Integer, Value>();

        for (int i = 0; i < str.length(); ++i) {


            Value times = map.getOrDefault((int) str.charAt(i), new Value(0));
            ++times.value;
            map.put((int) str.charAt(i), times);

        }

        for (Integer key : map.keySet()) {


            queue.offer(new Node(key, map.get(key).value));
        }


        while (queue.size() > 1) {

            Node left = queue.poll();
            Node right = queue.poll();
            if (left.value > left.value) {

                Node temp = left;
                left = right;
                right = temp;
            }

            Node temp = new Node(left, right);

            queue.offer(temp);
        }

        Node header = queue.poll();
        return header;
    }

    public static void main(String[] args) {

        String a = "aaabbc";
        HuffmanTree test = new HuffmanTree();
        Node header = test.func(a);

        System.out.println((char) header.right.left.value);

    }

    private class Node {

        int value;
        int times;
        Node left;
        Node right;

        public Node(int value) {

            this.value = value;
        }

        public Node(int value, int times) {

            this.value = value;
            this.times = times;

        }

        public Node(Node left, Node right) {

            this.value = left.value + right.value;
            this.times = left.times + right.times;
            this.left = left;
            this.right = right;
        }
    }


    private class Value {

        int value;

        public Value() {

            value = 0;
        }

        public Value(int value) {

            this.value = value;
        }

    }


}
