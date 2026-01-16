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
import java.util.Scanner;

public class FileSystemApp {
    public static void main(String[] args) {

        TreeNode root = new FolderNode("root", null);
        TreeNode current = root;

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n-- File System Explorer --");
            System.out.println("1) Add Folder");
            System.out.println("2) Add File");
            System.out.println("3) Display Contents (Current)");
            System.out.println("4) Navigate to Subfolder");
            System.out.println("5) Go Back to Parent");
            System.out.println("6) Search (Recursive)");
            System.out.println("7) Display Full Tree");
            System.out.println("8) Exit");
            System.out.print("Choose: ");

            String choice = in.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter folder name: ");
                        String folderName = in.nextLine();
                        if (folderName.isEmpty()) {
                            throw new IllegalArgumentException("Folder name cannot be empty.");
                        }
                        current.addChild(new FolderNode(folderName, current)); 
                        System.out.println("Folder '"+ folderName +"' has been created. ");
                        break;
                        
                    case "2":
                        System.out.print("Enter file name: ");
                        String fileName = in.nextLine();
                        if (fileName.isEmpty()) {
                            throw new IllegalArgumentException("Folder name cannot be empty.");
                        }
                        current.addChild(new FileNode(fileName, current)); 
                        System.out.println("File '"+ fileName +"' has been created.");
                        break;
                        
                    case "3":
                        List<TreeNode> children = current.getChildren(); 
                        if (children.isEmpty()) {System.out.println("Current directory is empty.");} 
                        else {
                            System.out.println("Current Directory: " + current.getName());
                            for (TreeNode c : children) {
                                if(c.isFolder()) 
                                    System.out.println("[Folder] " + c.getName());
                                else
                                    System.out.println("[File]  " + c.getName());
                            }
                        }
                        break;
                        
                    case "4":
                        System.out.print("Enter folder name to navigate: ");
                        String findFolder = in.nextLine();
                        boolean found = false; 
                        for (TreeNode c : current.getChildren()) { 
                            if (c.isFolder() && c.getName().equalsIgnoreCase(findFolder)) { 
                                current = c;                    
                                found = true; 
                                break; 
                            }
                        }
                        if (!found) {
                            throw new FileSystemException("Folder '" + findFolder + "' does not exist in the current directory.");
                        } else {
                            System.out.println("Now in folder: " + current.getName());
                        }
                        break;

                    case "5":
                        if (current != root) { 
                            current = current.getParent(); 
                            System.out.println("Returned to parent directory: " + current.getPath());
                        } else {
                            System.out.println("Already at the root folder. Cannot go back.");
                        }
                        break;
                        
                    case "6":
                        System.out.print("Enter file or folder name to search: ");
                        String name = in.nextLine();
                        List<String> results = new ArrayList<>(); 
                        Operations.search(root, name, results); 
                        if (results.isEmpty()) {
                            System.out.println("No matching file or folder found.");
                        } else {
                            System.out.print("Path:");
                            for (String path : results) { 
                                System.out.println(path);
                            }
                        }
                                
                        break;
                        
                    case "7":
                        System.out.println("--------Directory Tree--------");
                        Operations.print(root); //calls print method on root
                        break;
                   
                    case "8":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }       
}
