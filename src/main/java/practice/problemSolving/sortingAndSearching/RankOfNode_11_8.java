package practice.problemSolving.sortingAndSearching;

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to
 * look up the rank of a number x (the number of values less than or equal to x). Implement
 * the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated,
 * and the methodgetRankOf'Number (int x), which returns the number of values
 * less than or equal to x (not including x itself).
 *
 * @author Yashraj R. Sontakke
 */
public class RankOfNode_11_8 {

    private RankNode root;

    public void insert(int data){
        if (root == null){
            root = new RankNode(data);
        }else{
            root.insert(data);
        }
    }

    public int getRank(int data){
        if (root == null){
            return -1;
        }
        return root.getRank(data);
    }

    public class RankNode{
        public int left_size =0;
        public RankNode left,right;
        public Integer data;
        public RankNode(Integer data){
            this.data = data;
        }

        public void insert(int d){
            if (d <=data){
                if (left!=null){
                    left.insert(d); }
                else{
                    left = new RankNode(d);
                }

                left_size++;
            }else{
                if (right!=null){
                    right.insert(d);
                }else{
                    right = new RankNode(d);
                }
            }
        }

        public int getRank(int d){
            if (d == data){
                return left_size;
            }else if (d < data){
                if (left == null){
                    return -1;
                }
                return left.getRank(d);
            }else{
                int rightRank = right == null ?-1 : right.getRank(d);
                if (rightRank ==-1){
                    return -1;
                }
                return left_size + rightRank +1;
            }
        }
    }


    public static void main(String[] args){
        RankOfNode_11_8 rankOfNode = new RankOfNode_11_8();
        rankOfNode.insert(20);
        rankOfNode.insert(15);
        rankOfNode.insert(25);
        rankOfNode.insert(10);
        rankOfNode.insert(23);
        rankOfNode.insert(5);
        rankOfNode.insert(13);
        rankOfNode.insert(24);

        System.out.println(rankOfNode.getRank(20));
        System.out.println(rankOfNode.getRank(10));
        System.out.println(rankOfNode.getRank(5));
        System.out.println(rankOfNode.getRank(2));
        System.out.println(rankOfNode.getRank(24));

    }
}
