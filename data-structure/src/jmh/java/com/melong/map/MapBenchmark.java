package com.melong.map;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MapBenchmark {
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
    }

    @Benchmark
    public void hashMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashMap.put(i, i * 1000);
        });
    }
    @Benchmark
    public void hashTableAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashtable.put(i, i * 1000);
        });
    }
    @Benchmark
    public void identityHashMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            identityHashMap.put(i, i * 1000);
        });
    }
    @Benchmark
    public void weakHashMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            weakHashMap.put(i, i * 1000);
        });
    }

    @Benchmark
    public void treeMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            treeMap.put(i, i * 1000);
        });
    }
    @Benchmark
    public void concurrentHashMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentHashMap.put(i, i * 1000);
        });
    }

    @Benchmark
    public void concurrentSkipListMapAddTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentSkipListMap.put(i, i * 1000);
        });
    }
}
