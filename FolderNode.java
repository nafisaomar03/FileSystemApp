/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filesystemapp;

/**
 *
 * @author nafis
 */
import java.util.List;
import java.util.ArrayList;
public class FolderNode extends AbstractTreeNode{
    private List<TreeNode> children = new ArrayList<>();
    
    public FolderNode(String name, TreeNode parent){
        super(name, parent); 
    }
    
    @Override
    public boolean isFolder() {
        return true; 
    }

    @Override
    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    public void addChild(TreeNode child) {
        if (!isFolder()) {
            throw new FileSystemException("Files don't contain children! ");
        }
        
        for (TreeNode node : children) {
            if (node.getName().equalsIgnoreCase(child.getName())) {
                throw new FileSystemException("Duplicate name: " + child.getName());
            }
        }

        child.setParent(this);
        children.add(child);
    }

    @Override
    public boolean removeChild(String name) {
        for (int i = 0; i < children.size(); i++) { 
            if (children.get(i).getName().equalsIgnoreCase(name)) {
                children.remove(i);
                return true;
            }
        }
        return false;      
    }

    @Override
    public String getPath() {
        if (getParent() == null) { return getName();}             
        return getParent().getPath() + "/" + getName();
    }

}
