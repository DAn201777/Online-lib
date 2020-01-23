/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isu.librarysystem;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 349150325
 */
public class Review {

    private String barcode;
    private File file;
    private PrintWriter output;
    private Scanner input;

    public Review(String barcode) {
        this.barcode = barcode;
        file = new File("Comment/" + barcode + ".txt");
        boolean check = file.exists();
        if (check == false) {
            try {
                boolean check2 = file.createNewFile();
                System.out.println(check2);
            } catch (IOException ex) {
                System.out.println("System Error: " + ex);
            }

        }
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter writer) {
        output = writer;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner reader) {
        input = reader;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void writer(File file) {
        try {
            setOutput(new PrintWriter(getFile()));
        } catch (FileNotFoundException ex) {
            System.out.println("no file found");
            System.exit(0);
        }
    }

    public void reader(File file) {
        try {
            setInput(new Scanner(getFile()));
        } catch (FileNotFoundException ex) {
            System.out.println("no file found");
            System.exit(0);
        }
    }

    public void addComment(String star, String text, String account) {
        reader(file);

        ArrayList<String> store = new ArrayList();
        try{
        while (getInput().hasNextLine()) {
            store.add(getInput().nextLine());
        }
        }          catch (NullPointerException e) { 

        }
        
        store.add(star + "||" + text + "||" + account);
        writer(file);
        for (String a : store) {
            getOutput().println(a);
        }
        getOutput().close();

    }
    public ArrayList<String> getComments(){
    reader(file);
    ArrayList<String>store= new ArrayList();
    try{
    while(getInput().hasNext()){
        store.add(getInput().nextLine());
    }
    }
        catch (NullPointerException e) { 
                return null;
        } 
        return store;
}
}
