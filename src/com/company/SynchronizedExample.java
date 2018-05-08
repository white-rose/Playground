package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SynchronizedExample {

    private List<String> crawledSites = new ArrayList<>();
    private List<String> linkedSites = new ArrayList<>();

    public static void main (String args []) {
    }

    public void add (String site) {
        synchronized (this) {
            if (!crawledSites.contains(site)) {
                linkedSites.add(site);
            }
        }
    }

    /**
     * Get next site to crawl. Can return null (if nothing to crawl)
     */
    public String next() {
        if (linkedSites.size() == 0) {
            return null;
        }
        synchronized (this) {
            // Need to check again if size has changed
            if (linkedSites.size() > 0) {
                String s = linkedSites.get(0);
                linkedSites.remove(0);
                crawledSites.add(s);
                return s;
            }
            return null;
        }
    }

    public class MyDataStrucutre {
        List<String> list = new ArrayList<>();

        public void add(String s) {
            list.add(s);
        }


    }

}
