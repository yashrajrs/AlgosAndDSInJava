package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/22/15
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class StackBoxes_9_10 {


    public Set<ArrayList<Box>> stackSet = Sets.newHashSet();


    public void getstacks(ArrayList<Box> input, ArrayList<Box> currentStack) {
        if (input.isEmpty()) {
            stackSet.add(currentStack);
            return;
        }

        for (Box box : input) {
            ArrayList<Box> currentInput = new ArrayList<Box>(input);
            ArrayList<Box> newCurrentStack = new ArrayList<Box>(currentStack);
            currentInput.remove(box);
            if (currentStack.isEmpty()) {
                newCurrentStack.add(box);
            } else if (checkValidAdd(currentStack.get(currentStack.size() - 1), box)) {
                newCurrentStack.add(box);
            }
            getstacks(currentInput, newCurrentStack);
        }
    }

    public boolean checkValidAdd(Box current, Box newBox) {
        if (current.getHeight() < newBox.getHeight()) {
            return false;
        }
        if (current.getBreadth() < newBox.getBreadth()) {
            return false;
        }
        if (current.getLength() < newBox.getLength()) {
            return false;
        }
        return true;
    }

    public int getStackHeight(ArrayList<Box> boxes) {
        int height = 0;
        for (Box box : boxes) {
            height += box.getHeight();
        }
        return height;
    }

    public static void main(String[] args) {
        Box box1 = new Box(1, 1, 1);
        Box box2 = new Box(2, 2, 2);
        Box box3 = new Box(3, 3, 3);
        Box box4 = new Box(4, 4, 4);
        Box box5 = new Box(5, 5, 5);
        Box box6 = new Box(6, 6, 6);
        Box box7 = new Box(7, 7, 7);
        ArrayList<Box> input = new ArrayList<Box>(Arrays.asList(box1, box2, box3, box4, box5, box6, box7));
        StackBoxes_9_10 stackBoxes = new StackBoxes_9_10();
        stackBoxes.getstacks(input, new ArrayList<Box>());


        int heightMax = Integer.MIN_VALUE;
        ArrayList<Box> maxHeightBoxes = new ArrayList<Box>();
        for (ArrayList<Box> boxes : stackBoxes.stackSet) {
            int currentHeight = stackBoxes.getStackHeight(boxes);
            if (currentHeight > heightMax) {
                heightMax = currentHeight;
                maxHeightBoxes = boxes;
            }
        }
        System.out.println(heightMax);
        System.out.println(maxHeightBoxes.toString());

    }


}
