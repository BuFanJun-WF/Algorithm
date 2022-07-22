/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/6 16:19
 * @description 206题，反转列表
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseList {

    // 使用迭代进行反转
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {

            ListNode next = cur.next;

            cur.next = pre;
            // 将三个指针都向后移动一位，继续操作
            pre = cur;
            cur = next;
        }

        // 因为cur当前为空，所以之前pre是最后一个节点
        return pre;
    }

    // 使用递归进行反转
    public ListNode reverseList2(ListNode head) {

        // 最基本的问题
        if (head == null || head.next == null) {
            return head;
        }

        // 先尝试以head为头节点的进行反转，反转后的头节点用last进行承接
        ListNode last = reverseList2(head.next);
        // 想像一下，假设已经完成反转，所以要将现在的反转列表加入head
        head.next.next = head;
        head.next = null;

        return last;
    }
}
