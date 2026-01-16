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


public class Operations {
    public static void search(TreeNode node, String name, List<String> results) {
        if (node.getName().equalsIgnoreCase(name)) { 
            results.add(node.getPath());} 
        if (node.getChildren().isEmpty()) {return;}
        for (TreeNode c : node.getChildren()) {search(c, name, results);  }
    }
    
    public static void print(TreeNode root) {print(root, "", true);}
    private static void print(TreeNode node, String indentation, boolean isLastChild) {
        String connector; 
        if(isLastChild){ connector = "└-- ";} 
        else {connector = "|-- ";} 
        
        String name;
        if (node.isFolder()) {name = "[Folder] ";}
        else {name = "[File]  ";}

        System.out.println(indentation + connector + name + node.getName()); 
        
        String childIndentation; 
        if (isLastChild) {childIndentation = indentation + "    ";} 
        else {childIndentation = indentation + "│   ";} 

        List<TreeNode> children = node.getChildren(); 
        for (int i = 0; i < children.size(); i++) {
            print(children.get(i), childIndentation, i == children.size() - 1); 
        }
    }
}
