package practice.problems;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implements LFU cache.
 *
 * @author Yashraj R. Sontakke
 */
public class LFU {

    private ArrayList<CacheElement> cache = new ArrayList<CacheElement>();
    private final Integer size;

    /**
     * Constructor for {@link LFU}.
     * @param size the size of the cache
     */
    public LFU(final Integer size) {
        this.size = size;
    }

    /**
     * Adds element to the cache based on the following rules :- <br />
     * <p /> If the cache is empty, element is added to the cache.
     * <p /> If the cache already contains the element, the count on the element is increased by 1.
     * <p /> If the cache is not full element is added to the cache.
     * <p /> If the cache is full, the element with the lowest count and which is least recently used is replaced by
     *       the element to be added.
     * @param element the element to be added.
     */
    private void addElement(Integer element) {
        if (cache.isEmpty()) {
            final CacheElement cacheElement = new CacheElement(element);
            cacheElement.setCount(1);
            cache.add(cacheElement);
        } else if (findElement(element) != null) {
            final CacheElement cachedElement = findElement(element);
            cachedElement.setCount(cachedElement.getCount() + 1);
        } else if (cache.size() < 4) {
            final CacheElement cacheElement = new CacheElement(element);
            cacheElement.setCount(1);
            cache.add(cacheElement);
        } else {
            Collections.sort(cache, new CacheElementComparator());
            cache.remove(0);
            final CacheElement cacheElement = new CacheElement(element);
            cacheElement.setCount(1);
            cache.add(cacheElement);
        }
    }

    /**
     * Finds the cache element.
     * @param value the element value to be searched.
     * @return {@link CacheElement} if the element is in the cache, else returns null.
     */
    private CacheElement findElement(Integer value) {
        for (CacheElement cacheElement : cache) {
            if (cacheElement.getValue() == value) {
                return cacheElement;
            }
        }
        return null;
    }

    /**
     * Prints the cache
     */
    private void printCache(){
        System.out.println("--------");
        for (CacheElement n : cache){
            System.out.println(n.getValue() + ":" + n.getCount());
        }
        System.out.println("--------");
        System.out.println();
    }

    public static void main(String[] args) {
        LFU p = new LFU(4);
        p.addElement(1);
        p.printCache();
        p.addElement(1);
        p.printCache();
        p.addElement(2);
        p.printCache();
        p.addElement(3);
        p.printCache();
        p.addElement(4);
        p.printCache();
        p.addElement(5);
        p.printCache();

        p.addElement(3);
        p.printCache();
        p.addElement(3);
        p.printCache();
        p.addElement(2);
        p.printCache();
    }

}
