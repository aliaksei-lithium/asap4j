package com.epam.asap4j.client.cache;

/**
 * Simple cache interface. Contains only put/get methods.
 *
 * @author Aliaksandr_Novik
 * @param <K> key element
 * @param <V> value element
 */
public interface SimpleCache<K,V> {

    public void put(K key, V value);

    public V get(K key);
}
