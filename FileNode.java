/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filesystemapp;

/**
 *
 * @author nafis
 */
import java.util.*;
public class FileNode extends AbstractTreeNode {

    public FileNode(String name, TreeNode parent) {
        super(name, parent); 
    }

    @Override
    public boolean isFolder() { return false;}

    @Override
    public List<TreeNode> getChildren() {return new ArrayList<>();}

    @Override
    public void addChild(TreeNode child) {
        throw new FileSystemException("Cannot add children to a file! ");
    }

    @Override
    public boolean removeChild(String name) {return false; }

    @Override
    public String getPath() {
        if (getParent() == null) return getName();
        return getParent().getPath() + "/" + getName();
    }
}