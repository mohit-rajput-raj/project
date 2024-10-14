
package atsystem;


import java.util.*;
import java.io.*;
public class Student extends Member implements Serializable{
    private static final long serialVersionUID = 1L;
    
    List<Subject> subject;
    String path;
    String courseid;
    
    String enrolmentnumber;
    Student(String name, String id, String g, String edu,String tag, String path) {
        super(name, id, g, edu);
        this.path = path +"\\STUDENTS";
        this.enrolmentnumber = tag;
        this.subject = new ArrayList<>();
        File folder = new File(this.path);
        
        if (!folder.exists()) {
            folder.mkdir();
            
        }
        
        
        File file = new File(this.path+"\\"+"student.txt"); // Specify the file name
        
        try {
            
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(file, true); 
                writer.write("enrolment\t       name\t       gender\t      ID\n");
                writer.close();
            } 

            FileWriter writer = new FileWriter(file, true); 
            writer.write(this.enrolmentnumber+"\t"+"    "+this.name+"\t"+"    "+g+"\t"+"    "+edu+"\t"+"    "+"\n");
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        this.path = this.path+"\\"+name+id;
        folder = new File(this.path);
        
        if (!folder.exists()) {
            folder.mkdir();
            
        }
        
    }
    
    void addSubject(String sName, String sId, int totalClass){
        this.subject.add(new Subject(sName, sId, totalClass, path));
        
    }
    
    String getName(){
        return name;
    }
    
    
}

