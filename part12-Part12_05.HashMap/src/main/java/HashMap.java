public class HashMap<K, V> {
    
    private List<Pair<K, V>>[] pairLists;
    private int currentSize;

    public HashMap() {
        pairLists = new List[32];
        currentSize = 0;
    }
    
    private int getPairListIndex(K key) {
        return Math.abs(key.hashCode() % pairLists.length);
    }

    private int getKeyIndex(K key) {
        List<Pair<K,V>> pairList = pairLists[getPairListIndex(key)];
        if (pairList == null) {
            return -1;
        }
        for (int i = 0; i < pairList.size(); i++) {
            if (pairList.value(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
    private Pair<K, V> getPair(K key) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            List<Pair<K,V>> pairList = pairLists[getPairListIndex(key)];
            return pairList.value(keyIndex);
        }
        return null;
    }
    
    public V get(K key) {
        Pair<K,V> pair = getPair(key);
        if (pair != null) {
            return pair.getValue();
        } else {
            return null;
        }
    }
    
    private void copyPairListToNewPairLists(List<Pair<K, V>> currentPairList, List<Pair<K, V>>[] newPairLists) {
        for (int i = 0; i < currentPairList.size(); i++) {
            Pair<K, V> pair = currentPairList.value(i);
            int newPairListIndex = Math.abs(pair.getKey().hashCode() % newPairLists.length);
            if (newPairLists[newPairListIndex] == null) {
                newPairLists[newPairListIndex] = new List<>();
            }
            newPairLists[newPairListIndex].add(pair);
        }        
    }
    
    private void grow() {
        List<Pair<K, V>>[] newPairLists = new List[pairLists.length * 2];
        for (int i = 0; i < pairLists.length; i++) {
            List<Pair<K, V>> currentPairList = pairLists[i];
            if (currentPairList != null) {
                copyPairListToNewPairLists(currentPairList, newPairLists);
            }
        }
        pairLists = newPairLists;
    }
    
    public void add(K key, V value) {
        int pairListIndex = getPairListIndex(key);
        if (pairLists[pairListIndex] == null) {
            pairLists[pairListIndex] = new List<>();
        }
        
        Pair<K,V> pair = getPair(key);
        if (pair == null) {
            pairLists[pairListIndex].add(new Pair<>(key, value));
            currentSize++;
        } else {
            pair.setValue(value);
        }
        
        if (1.0 * currentSize / pairLists.length > 0.75) {
            grow();
        }        
    }

    public V remove(K key) {
        V itemRemoved = null;
        Pair<K, V> pair = getPair(key);
        if (pair != null) {
            List<Pair<K, V>> pairList = pairLists[getPairListIndex(key)];
            itemRemoved = pair.getValue();
            pairList.remove(pair);
            currentSize--;
        }
        return itemRemoved;
    }
    
    public int size() {
        return currentSize;
    }
}
