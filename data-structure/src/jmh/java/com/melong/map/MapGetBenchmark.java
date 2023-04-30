package com.melong.map;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MapGetBenchmark {

    private Map<Integer, Integer> hashMap;
    private Map<Integer, Integer> hashtable;
    private Map<Integer, Integer> identityHashMap;
    private Map<Integer, Integer> linkedHashMap;
    private Map<Integer, Integer> treeMap;
    private Map<Integer, Integer> weakHashMap;
    private Map<Integer, Integer> concurrentHashMap;
    private Map<Integer, Integer> concurrentSkipListMap;

    @Setup
    public void setUp() {
        hashMap = new HashMap<>();
        hashtable = new Hashtable<>();
        identityHashMap = new IdentityHashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();
        weakHashMap = new WeakHashMap<>();
        concurrentHashMap = new ConcurrentHashMap<>();
        concurrentSkipListMap = new ConcurrentSkipListMap<>();
        IntStream.range(0, 1000).forEach(i -> {
            hashMap.put(i, i * 1000);
            hashtable.put(i, i * 1000);
            identityHashMap.put(i, i * 1000);
            linkedHashMap.put(i, i * 1000);
            treeMap.put(i, i * 1000);
            weakHashMap.put(i, i * 1000);
            concurrentHashMap.put(i, i * 1000);
            concurrentSkipListMap.put(i, i * 1000);
        });
    }

    @Benchmark
    public void hashMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashMap.get(i);
        });
    }

    @Benchmark
    public void hashtableGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashtable.get(i);
        });
    }

    @Benchmark
    public void identityHashMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            identityHashMap.get(i);
        });
    }

    @Benchmark
    public void linkedHashMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            linkedHashMap.get(i);
        });
    }

    @Benchmark
    public void treeMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            treeMap.get(i);
        });
    }

    @Benchmark
    public void weakHashMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            weakHashMap.get(i);
        });
    }

    @Benchmark
    public void concurrentSkipListMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentSkipListMap.get(i);
        });
    }

    @Benchmark
    public void concurrentHashMapGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentHashMap.get(i);
        });
    }
}
