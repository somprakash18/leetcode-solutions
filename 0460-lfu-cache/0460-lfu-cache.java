import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    int capacity;
    int minFreq;

    // key -> Node
    HashMap<Integer, Node> map;

    // frequency -> keys
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        // Key does not exist
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Increase frequency
        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Capacity is 0
        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            updateFrequency(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            LinkedHashSet<Integer> set = freqMap.get(minFreq);

            // Remove least recently used key
            int removeKey = set.iterator().next();

            set.remove(removeKey);
            map.remove(removeKey);
        }

        // Add new node
        Node newNode = new Node(key, value);

        map.put(key, newNode);

        freqMap
            .computeIfAbsent(1, k -> new LinkedHashSet<>())
            .add(key);

        // New key always has frequency 1
        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        LinkedHashSet<Integer> oldSet = freqMap.get(oldFreq);

        oldSet.remove(node.key);

        // If old frequency becomes empty
        if (oldSet.isEmpty()) {

            freqMap.remove(oldFreq);

            // Important
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        // Increase frequency
        node.freq++;

        // Add to new frequency group
        freqMap
            .computeIfAbsent(node.freq, k -> new LinkedHashSet<>())
            .add(node.key);
    }
}