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
public class MapRandomGetBenchmark {

    private Map<Integer, Integer> hashMap;
    private Map<Integer, Integer> hashtable;
    private Map<Integer, Integer> identityHashMap;
    private Map<Integer, Integer> linkedHashMap;
    private Map<Integer, Integer> treeMap;
    private Map<Integer, Integer> weakHashMap;
    private Map<Integer, Integer> concurrentHashMap;
    private Map<Integer, Integer> concurrentSkipListMap;

    private Random random;

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
        random = new Random();
    }

    @Benchmark
    public void hashMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void hashtableRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            hashtable.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void identityHashMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            identityHashMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void linkedHashMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            linkedHashMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void treeMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            treeMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void weakHashMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            weakHashMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void concurrentSkipListMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentSkipListMap.get(random.nextInt(1000));
        });
    }

    @Benchmark
    public void concurrentHashMapRandomGetTest() {
        IntStream.range(0, 1000).forEach(i -> {
            concurrentHashMap.get(random.nextInt(1000));
        });
    }
}
