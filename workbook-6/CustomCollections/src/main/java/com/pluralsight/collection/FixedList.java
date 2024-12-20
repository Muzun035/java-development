package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList <T> {
    private int maxSize;
    private List<T> items;

    public FixedList(int maxSize, List<T> items) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void add (T item) {
        if (items.size() < maxSize) {
            items.add(item);

        } else {
            System.out.println("item can not added");
        }
    }
    public List<T> getItems() {
        return items;
    }
}
