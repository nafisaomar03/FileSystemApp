/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filesystemapp;

/**
 *
 * @author nafis
 */
public class FileSystemException extends RuntimeException { //custom exception
    public FileSystemException(String message) {
        super(message);
    }
}