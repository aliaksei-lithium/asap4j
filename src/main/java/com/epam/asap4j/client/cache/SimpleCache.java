package com.epam.asap4j.client.cache;

/**
 * Simple cache interface. Contains only put/get methods.
 *
 * @param <K> key element
 * @param <V> value element
 * @author Aliaksandr_Novik
 */
public interface SimpleCache<K, V> {

    public void put(K key, V value);

    public V get(K key);
}
