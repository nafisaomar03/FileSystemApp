/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filesystemapp;

/**
 *
 * @author nafis
 */
import java.util.List;
public abstract class AbstractTreeNode implements TreeNode {
    private String name;
    private TreeNode parent;

    protected AbstractTreeNode(String name, TreeNode parent) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must be non-empty.");
        }
        this.name = name.trim();
        this.parent = parent;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Name must be non-empty.");
        }
        this.name = newName.trim();
    }

    @Override
    public TreeNode getParent() { return parent; }

    @Override
    public void setParent(TreeNode parent) { this.parent = parent; }

    
    @Override
    public abstract List<TreeNode> getChildren();

    @Override
    public abstract void addChild(TreeNode child);

    @Override
    public abstract boolean removeChild(String name);

    @Override
    public abstract boolean isFolder();

    @Override
    public int depth() {
        int d = 0;
        TreeNode p = getParent();
        while (p != null) {
            d++;
            p = p.getParent();
        }
        return d;
    }

    @Override
    public abstract String getPath();
}
