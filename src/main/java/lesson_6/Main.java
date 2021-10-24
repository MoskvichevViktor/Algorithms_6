package lesson_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static int min = -25;
    static int max = 25;
    static int maxDepth = 4;
    static int treesCount = 20;
    static List<Tree<Integer>> trees = new ArrayList<>();

    public static void main(String[] args) {
        TreeImpl<Integer> tree;
        int balancedCounter = 0;

        for (int i = 0; i < treesCount; i++) {
            tree = buildTree();
            trees.add(tree);
            if (tree.isBalanced(tree.getRoot())) {
                balancedCounter++;
                tree.display();
            }
        }

        System.out.printf("Количество деревьев - %d, глубина уровней - %d,  сбалансированных деревьев - %d (%.1f%%) \n",
                treesCount, maxDepth, balancedCounter, balancedCounter * 100.0 / treesCount);
    }

    public static TreeImpl<Integer> buildTree () {
        Random random = new Random();
        TreeImpl<Integer> tree = new TreeImpl<>();
        while (tree.height(tree.getRoot()) < maxDepth) {
            tree.add(random.nextInt(++max - min) + min);
        }
        return tree;
    }
}
