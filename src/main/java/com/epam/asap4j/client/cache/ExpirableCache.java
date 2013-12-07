package com.epam.asap4j.client.cache;

import com.epam.asap4j.client.token.Expirable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Cache where values are expirable elements (should implement {@link Expirable}).
 * Cache cleanup perfoms after writing new value and before retrieving a value.
 * If element's expiration time is set to -1 then it's not expirable and won't
 * be removed from cache.
 *
 * @author Aliaksandr_Novik
 * @param <K> key element
 * @param <V> value(must implement {@link Expirable})
 */
public class ExpirableCache<K,V extends Expirable> implements SimpleCache<K,V> {

    private final ConcurrentMap<K,ValueWrapper> concurrentMap = new ConcurrentHashMap<>();

    /**
     * Put a value in a cache.
     *
     * @param key key element
     * @param value {@link Expirable} value
     */
    public void put(K key, V value) {
        long now = now();
        ValueWrapper valueWrapper = new ValueWrapper(value, now);
        concurrentMap.putIfAbsent(key, valueWrapper);
        cleanUp();
    }

    /**
     * Get value by key. Returns <code>null</code> if element is expired.
     *
     * @param key key element
     * @return {@link Expirable} value
     */
    public V get(K key) {
        cleanUp();
        V value = (V) concurrentMap.get(key);
        return value;
    }

    private void cleanUp() {
        for (Map.Entry<K, ValueWrapper> entry : concurrentMap.entrySet()) {
            K key = entry.getKey();
            ValueWrapper valueWrapper = entry.getValue();
            long insertTime = valueWrapper.insertTime;
            V value = valueWrapper.value;
            long expirationTime = value.expiresAfter();
            long now = now();
            if(now <= insertTime + expirationTime && expirationTime != -1) {
                concurrentMap.remove(key);
            }
        }
    }

    private long now() {
        return System.currentTimeMillis();
    }

    /**
     * Wrapper for a value. Contains insertTime field - time when element was
     * inserted.
     * TODO: set 'expires at' value (sum of insert time and value.expiresAfter)
     * instead of insertTime?
     */
    private class ValueWrapper {

        private V value;

        private long insertTime;

        ValueWrapper(V value, long insertTime) {
            this.value = value;
            this.insertTime = insertTime;
        }
    }
}
