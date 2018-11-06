package practice.problems.others;

import org.apache.commons.lang3.SerializationUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/7/15
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class IteratorOfIterators implements Iterator{

    ArrayList objs = new ArrayList();
    Iterator itr = null;

    public IteratorOfIterators(Collection collections){
        if (!collections.isEmpty()){
            convert(collections);
            itr = objs.iterator();
        }
    }

    public void convert(Collection obj){
        Iterator iterator = obj.iterator();
        while (iterator.hasNext()){
            Object o  = iterator.next();
            if (o!=null){
                if (o instanceof Collection){
                    convert((Collection)o);
                }else{
                    objs.add(o);
                }
            }
        }
    }

//    @Override
    public boolean hasNext() {
        if (itr !=null){
            return itr.hasNext();
        }
        return false;
    }

//    @Override
    public Object next() {
        if (itr !=null){
            return itr.next();
        }
        return null;
    }

//    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public static void main(String[] args){

        List<List> list = new ArrayList<List>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4));
        list.add(Arrays.asList(5,6, Arrays.asList(7,8)));

        IteratorOfIterators i = new IteratorOfIterators(list);
        while (i.itr.hasNext()){
            System.out.println(i.itr.next());
        }


    }
}
