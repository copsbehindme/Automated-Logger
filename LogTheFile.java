import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

public class LogTheFile {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.home") + File.separator + "Desktop");
        
        // add the text file you want to log in place of "Rohit.txt" but also change fileName in log.command file
        File file = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "LogFile.txt"); 

        boolean doesFileExist = doesFileExist(file);    // checks if the file exists
        if(doesFileExist)
        {
            System.out.println("File found");
            addLogInsideTheFile(file);
        }
    }

    private static boolean doesFileExist(File file) {
        // file should exist, not be a directory, as well as should have write permission
        return file.exists() && file.isFile() && file.canWrite();
    }

    private static void addLogInsideTheFile(File file) {
        String todaysDate = "\n" + new Date().toString() + "\n";
        try {
            System.out.println(todaysDate);
            FileOutputStream f = new FileOutputStream(file,true);   // write file in append mode
            f.write(todaysDate.getBytes());                         // add bytes corresponding to today
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
