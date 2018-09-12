package com.journaldev.huffmancoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanTree {


    private static HuffmanNode buildTree() {

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : charFreqHashMap.entrySet()) {

            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.data = entry.getKey();
            huffmanNode.frequency = entry.getValue();
            huffmanNode.left = null;
            huffmanNode.right = null;
            priorityQueue.offer(huffmanNode);
        }


        while (priorityQueue.size() > 1) {


            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode sum = new HuffmanNode();

            sum.frequency = x.frequency + y.frequency;
            sum.data = Character.MIN_VALUE;
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


        if (node != null) {
            if (node.left == null && node.right == null) {
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


    }

    private static HashMap<Character, Integer> charFreqHashMap = new HashMap<>();

    String encoding(String test) {

        if (test != null) {
            for (char c : test.toCharArray()) {

                if (charFreqHashMap.containsKey(c)) {
                    Integer integer = charFreqHashMap.get(c) + 1;
                    charFreqHashMap.put(c, integer);
                } else {
                    charFreqHashMap.put(c, 1);
                }

            }
            root = buildTree();

            setPrefixCodes(root, new StringBuilder());
            StringBuilder s = new StringBuilder();

            for (int i = 0; i < test.length(); i++) {
                char c = test.charAt(i);
                s.append(charPrefixHashMap.get(c));
            }

            return s.toString();
        }
        return null;
    }

    void decode(String s) {

        StringBuilder stringBuilder = null;
        if (s != null) {

            stringBuilder = new StringBuilder();
            HuffmanNode temp = root;


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
        }
        System.out.println("Encoded: " + s);
        if (stringBuilder != null) {
            System.out.println("Decoded string is " + stringBuilder.toString());
        } else {
            System.out.println("Decoded string is " + s);
        }


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

class HuffmanCodingSolution {
    public static void main(String[] args) {


        HuffmanTree huffmanTree = new HuffmanTree();

        String test = "ABCD1&1";
        String s = huffmanTree.encoding(test);
        huffmanTree.decode(s);

    }
}



