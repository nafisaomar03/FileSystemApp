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
public interface TreeNode {
    String getName();
    void setName(String newName);

    boolean isFolder(); 

    TreeNode getParent();
    void setParent(TreeNode parent);

    List<TreeNode> getChildren();

    void addChild(TreeNode child);

    boolean removeChild(String name);

    int depth();

    String getPath();
}