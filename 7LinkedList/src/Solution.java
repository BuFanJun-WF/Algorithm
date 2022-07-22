/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; // 节点中的内容
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 方法一：使用递归完成
 */
class Solution {
    // 判断head指示的元素是否为val，然后移除
    public ListNode removeElements(ListNode head, int val) {
        // 递归终止条件
        if (head == null) {
            return head;
        }
        // head标记继续向下连接，移除head.next的下一个元素
        // head.next = removeElements(head.next, val);
        // return head.val == val ? head.next : head;

        // 存储删除头节点之后的val值剩下的链表
        ListNode res = removeElements(head.next, val);
        // 处理此时head这个头节点的情况
        if (head.val == val) {
            // 删除head这个头节点
            return res;
        } else {
            // 不要删除head这个头节点
            head.next = res;
            return head;
        }


    }

    // 不设计虚拟头节点
    public ListNode removeElements2(ListNode head, int val) {
        // val的值一直在头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    // 设计虚拟头节点
    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 所以从第一个元素开始进行删除
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}