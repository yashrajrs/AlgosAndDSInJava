package practice.problems.cache;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 2/9/15
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CacheElementComparator  implements Comparator<CacheElement> {
    @Override
    public int compare(CacheElement cacheElement, CacheElement cacheElement2) {
        if (cacheElement ==null){
            return 1;
        }
        if (cacheElement2 == null){
            return -1;
        }
        return cacheElement.getCount().compareTo(cacheElement2.getCount());
    }
}
