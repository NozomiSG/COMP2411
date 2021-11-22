/**
 * 
 * @author Yixin Cao (September 11, 2021)
 *
 * A circularly and doubly linked list. 
 * 
 * The task is to split the original list into three circularly and doubly linked lists of equal length.
 * 
 * For simplicity, you can assume that the length of the input is a multiple of three. 
 * There are nine in the example in {@code main}.
 * 
 * You are not allowed to use the {@code insert} method or write a method that adding nodes to a list.
 * 
 */
public class CDList_20074794d_ZHUGuanYu { // Please change! In Eclipse, press Alt-Shift-R on the class name.
    class DNode {
        int element;
        DNode previous, next;

        DNode(int data) { this.element = data; }
    }

	private DNode head;

	// this method is provided for the purpose of test (in the main).
	// it's not for your use.
	public void insert(int e) {
		DNode newNode = new DNode(e);
		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			return;
		}
		newNode.next = head;
		newNode.previous = head.previous;
		head.previous = newNode;
		newNode.previous.next = newNode;
	}
	
    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. LI LiYing 20084215D
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. None
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O(n).
     */ 
	public CDList_20074794d_ZHUGuanYu[] split() {
		CDList_20074794d_ZHUGuanYu[] ans = new CDList_20074794d_ZHUGuanYu[3];
        for(int i = 0; i < 3; i++)
            ans[i] = new CDList_20074794d_ZHUGuanYu();
        if (head == null) return ans;
        int count = 1;
        DNode test = head.next;
        while (test != head) {
            count ++;
            test = test.next;
        }
        int[] nums = new int[3];
        nums[0] = nums[1] = count/3-1;
        nums[2] = count - 3 - 2*(count/3-1);
        for (int n=0; n<(count<3? count:3); n++) {
            ans[n].head = test;
            for (int m=0; m<nums[n]; m++)
                test = test.next;
            DNode mid = test.next;
            test.next = ans[n].head;
            ans[n].head.previous = test;
            test=mid;
        }
		return ans;
	}

	// Bonus question.
	public CDList_20074794d_ZHUGuanYu[] split(int d) {
        CDList_20074794d_ZHUGuanYu[] ans = new CDList_20074794d_ZHUGuanYu[d];

        for(int i = 0; i < d; i++)
            ans[i] = new CDList_20074794d_ZHUGuanYu();
        if (head == null) return ans;
        int count = 1;
        DNode test = head.next;
        while (test != head) {
            count ++;
            test = test.next;
        }
        int[] nums = new int[d];
        for (int i=0; i<d; i++) nums[i] = count/d-1;
        for (int j=0; j<count%d; j++) nums[j]++;

        for (int n=0; n<(count<d? count:d); n++) {
            ans[n].head = test;
            for (int m=0; m<nums[n]; m++)
                test = test.next;
            DNode mid = test.next;
            test.next = ans[n].head;
            ans[n].head.previous = test;
            test=mid;
        }
        return ans;
    }

	public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        DNode cur = head;
        sb.append(cur.element);
        cur = cur.next;
        while ( cur != head ) {
            sb.append(", " + cur.element);
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int d=3;
        CDList_20074794d_ZHUGuanYu l = new CDList_20074794d_ZHUGuanYu();
        for (int i: a) l.insert(i);
        System.out.println(l);
        CDList_20074794d_ZHUGuanYu[] lists = l.split();
        for (int t=0; t<d; t++) {
            System.out.println(lists[t]);
        }
    }
}
