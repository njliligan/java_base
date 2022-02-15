package com.njganlili.node;

import java.util.*;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 10:54 a b | xyz xyz|m | l| q o xyz 删除xyz开头的
 */
public class NodeTree {

    public static void main(String[] args) {

        Node node = getNodeTree();
        System.out.println("完成树构建");
        delete(node);
        System.out.println(node);
    }

    private static Node getNodeTree() {
        Node nodeFirstA = new Node().setName("o");
        Node nodeFirstXyz = new Node().setName("xyz");

        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(nodeFirstA);
        ArrayList<Node> arrayList1 = new ArrayList<>();
        arrayList1.add(nodeFirstXyz);
        Node nodeSecondXyz = new Node().setName("xyz").setChildren(arrayList);
        Node nodeSecondM = new Node().setName("m");
        Node nodeSecondL = new Node().setName("l");
        Node nodeSecondQ = new Node().setName("q").setChildren(arrayList1);

        ArrayList<Node> arrayList2 = new ArrayList<>();
        arrayList2.addAll(Arrays.asList(nodeSecondXyz, nodeSecondM));
        ArrayList<Node> arrayList3 = new ArrayList<>();
        arrayList3.addAll(Arrays.asList(nodeSecondL, nodeSecondQ));
        Node nodeThreeB = new Node().setName("b").setChildren(arrayList2);
        Node nodeThreeXyz = new Node().setName("xyz").setChildren(arrayList3);

        ArrayList<Node> arrayList4 = new ArrayList<>();
        arrayList4.addAll(Arrays.asList(nodeThreeB, nodeThreeXyz));
        Node nodeFourA = new Node().setName("a").setChildren(arrayList4);
        return nodeFourA;
    }

    public static void delete(Node node) {
        Optional<Node> optionalNode = Optional.ofNullable(node);
        if (!optionalNode.isPresent() || node.getName().equals("xyz")) {
            node.setName("");
            node.setChildren(new ArrayList<>());
        } else if (Objects.nonNull(node.getChildren()) && node.getChildren().size() > 0) {
            ArrayList<Node> arrayList = new ArrayList<>();
            for (Node node1 : node.getChildren()) {
                if (node1.getName().equals("xyz")) {

                } else {
                    delete(node1);
                    arrayList.add(node1);
                }
            }
            node.setChildren(arrayList);
        }
    }

    private static class Node {

        private String name;
        private ArrayList<Node> children;

        public String getName() {
            return name;
        }

        public Node setName(String name) {
            this.name = name;
            return this;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public Node setChildren(ArrayList<Node> children) {
            this.children = children;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" + "name='" + name + '\'' + ", children=" + children + '}';
        }
    }
}
