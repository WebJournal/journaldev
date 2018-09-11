package com.journaldev.huffmancoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCodeSolution {


    private static HuffmanNode buildTree(int[] charFrequencies) {

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < charFrequencies.length; i++) {


            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.data = (char) i;
            huffmanNode.frequency = charFrequencies[i];
            huffmanNode.left = null;
            huffmanNode.right = null;
            priorityQueue.offer(huffmanNode);
        }
        assert priorityQueue.size() > 0;

        while (priorityQueue.size() > 1) {


            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode sum = new HuffmanNode();

            sum.frequency = x.frequency + y.frequency;
            sum.data = '-';

            sum.left = x;

            sum.right = y;
            root = sum;

            priorityQueue.offer(sum);
        }

        return priorityQueue.poll();
    }

    private static Map<Character, String> charPrefixHashMap = new HashMap<>();
    static HuffmanNode root;

    private static void setPrefixCodes(HuffmanNode node, StringBuilder prefix) {


        if (node.left == null && node.right == null && Character.isLetter(node.data)) {
            charPrefixHashMap.put(node.data, prefix.toString());

        } else {
            prefix.append('0');
            setPrefixCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);


            prefix.append('1');
            setPrefixCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }


    }

    public static void main(String[] args) {


        String test = "ABACA";
        String s = encoding(test);
        decode(s);

    }

    private static String encoding(String test) {
        int[] charFrequencies = new int[256];
        for (char c : test.toCharArray())
            charFrequencies[c]++;

        root = buildTree(charFrequencies);

        setPrefixCodes(root, new StringBuilder());
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(charPrefixHashMap.get(c));
        }

        return s.toString();
    }

    private static void decode(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        HuffmanNode temp = root;

        System.out.println("Encoded: " + s);

        for (int i = 0; i < s.length(); i++) {
            int j = Integer.parseInt(String.valueOf(s.charAt(i)));

            if (j == 0) {
                temp = temp.left;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
            if (j == 1) {
                temp = temp.right;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
        }

        System.out.println("Decoded string is " + stringBuilder.toString());


    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char data;
    HuffmanNode left, right;

    public int compareTo(HuffmanNode node) {
        return frequency - node.frequency;
    }
}



