package com.eknv.algorithms.linked_list;

import com.eknv.algorithms.linked_list.model.Node;
import org.junit.jupiter.api.Test;

import static com.eknv.algorithms.linked_list.ReverseLinkedList.execute;
import static org.junit.jupiter.api.Assertions.*;


public class ReverseLinkedListTests {


    @Test
    public void shortLinkedListTest() {
        final Node[] nodes = valuesToLinkedListNodes(new int[]{1, 2});
        final Node result = execute(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void longLinkedListTest() {
        final Node[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4, 5, 6});
        final Node result = execute(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void oneElementLinkedListTest() {
        final Node node = new Node(1);
        final Node result = execute(node);
        assertSame(node, result);
    }

    @Test
    public void emptyLinkedListTest() {
        final Node result = execute(null);
        assertNull(result);
    }

    private static Node[] valuesToLinkedListNodes(int[] values) {
        final Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
            if (i > 0) {
                nodes[i - 1].setNext(nodes[i]);
            }
        }
        return nodes;
    }

    private static boolean isListReversed(Node list, Node[] originalNodes) {
        int i = originalNodes.length - 1;
        while (list != null && i >= 0) {
            if (originalNodes[i] != list) {
                return false;
            }
            list = list.getNext();
            i--;
        }
        return list == null && i == -1;
    }

}