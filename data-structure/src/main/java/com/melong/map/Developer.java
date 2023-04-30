package com.melong.map;

public class Developer implements Comparable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Developer) {
            return name.compareTo(((Developer) o).name);
        }
        return 0;
    }
}
