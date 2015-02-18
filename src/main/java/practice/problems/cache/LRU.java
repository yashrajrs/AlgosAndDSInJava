package practice.problems.cache;

import java.util.ArrayList;

/**
 * Implements LRU cache.
 *
 * @author Yashraj R. Sontakke
 */
public class LRU {

    private ArrayList<CacheElement> cache = new ArrayList<CacheElement>();
    private final Integer size;

    /**
     * Constructor for {@link LRU}.
     *
     * @param size the size of the cache
     */
    public LRU(final Integer size) {
        this.size = size;
    }

    /**
     * Adds element to the cache based on the following rules :- <br />
     * <p /> If the cache is empty, element is added to the cache.
     * <p /> If the cache already contains the element, the element is moved the most recently added element.
     * <p /> If the cache is not full element is added to the cache.
     * <p /> If the cache is full, the element least recently used element is removed and the new element is added.
     *
     * @param element the element to be added.
     */
    private void addElement(Integer element) {
        if (cache.isEmpty()) {
            final CacheElement cacheElement = new CacheElement(element);
            cache.add(cacheElement);
        } else if (findElement(element) != null) {
            final CacheElement cachedElement = findElement(element);
            cache.remove(cachedElement);
            cache.add(cachedElement);
        } else if (cache.size() < 4) {
            final CacheElement cacheElement = new CacheElement(element);
            cache.add(cacheElement);
        } else {
            cache.remove(0);
            final CacheElement cacheElement = new CacheElement(element);
            cache.add(cacheElement);
        }
    }

    /**
     * Finds the cache element.
     *
     * @param value the element value to be searched.
     * @return {@link practice.problems.cache.CacheElement} if the element is in the cache, else returns null.
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
    private void printCache() {
        System.out.println("--------");
        for (CacheElement n : cache) {
            System.out.println(n.getValue());
        }
        System.out.println("--------");
        System.out.println();
    }

    public static void main(String[] args) {
        LRU p = new LRU(4);
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
        p.addElement(7);
        p.printCache();
        p.addElement(2);
        p.printCache();
    }

}
