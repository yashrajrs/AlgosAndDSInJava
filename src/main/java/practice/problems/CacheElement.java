package practice.problems;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 2/9/15
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CacheElement{

    private final Integer value;
    private Integer count;

    public CacheElement(final Integer value){
        this.value = value;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCount() {
        return count;
    }
}