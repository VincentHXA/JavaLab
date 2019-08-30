package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataConstructSolutions {

    /**
     * LRU缓存机制
     */
    class LRUCache {

        private class ListNode {

            public int key;
            public int val;
            public ListNode pre;
            public ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, ListNode> map = new HashMap<>();
        private ListNode head = new ListNode(-1, -1);
        private ListNode tail = new ListNode(999, 999);
        private int capacity;
        private int vol;
        private int lastkey;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
            this.vol = 0;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            ListNode node = map.get(key);
            update(node);
            return node.val;
        }

        private void update(ListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = this.head.next;
            node.pre = this.head;
            this.head.next.pre = node;
            this.head.next = node;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                update(node);
                node.val = value;

                return;
            }

            ListNode node = new ListNode(key, value);
            node.next = this.head.next;
            node.pre = this.head;
            this.head.next.pre = node;
            this.head.next = node;

            if (this.vol < this.capacity) {
                this.vol++;
            }else {
                map.remove(tail.pre.key);
                this.tail.pre.pre.next = this.tail;
                this.tail.pre = this.tail.pre.pre;
            }

            map.put(key, node);
        }
    }

    /**
     * 全 O(1) 的数据结构
     *
     */
    class AllOne {
        private Map<String, Integer> map = new HashMap<>();
        private List<String> minKeys;
        private List<String> maxKeys;
        private Integer min;
        private Integer max;

        /** Initialize your data structure here. */
        public AllOne() {
            minKeys = new ArrayList<>();
            maxKeys = new ArrayList<>();
            min = Integer.MAX_VALUE;
            max = 0;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
            update(key);
        }

        private void update(String key) {
            if (min > map.get(key)) {
                min = map.get(key);
                minKeys.clear();
            }
            if (min == map.get(key)) {
                minKeys.add(key);
            }
            if (minKeys.contains(key) && min < map.get(key)) {
                minKeys.remove(key);
            }
            if (max < map.get(key)) {
                max = map.get(key);
                maxKeys.clear();
            }
            if (max == map.get(key)) {
                maxKeys.add(key);
            }
            if (maxKeys.contains(key) && max > map.get(key)) {
                maxKeys.remove(key);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                map.remove(key);
                minKeys.remove(key);
                maxKeys.remove(key);

                if (minKeys.isEmpty()) {
                    min = 0;
                }
                if (maxKeys.isEmpty()) {
                    max = 0;
                }
            }else {
                update(key);
            }

        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return maxKeys.isEmpty() ? "" : maxKeys.get(0);
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return minKeys.isEmpty() ? "" : minKeys.get(0);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new DataConstructSolutions().new LRUCache( 2 /* 缓存容量 */ );

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回  1
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));       // 返回  1
//        System.out.println(cache.get(3));       // 返回  1
//        System.out.println(cache.get(4));       // 返回  1
    }
}
