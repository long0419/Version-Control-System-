/*
 * Author Names : Parth Patel, Vishrut Shah, Jui Desai
 *
 * Contact info :
 * Parth: parthashokbhai.patel@student.csulb.edu
 * Vishrut: vishrutshah15@gmail.com
 * Jui: jui1995@yahoo.in
 *
 * Description :  The main method of Source class gets the source tree path and the target repo folder path from the user.
 * Three commands are there in main method : create , checkin , checkout
 * " create source_tree_path target_repo_folder " command will create new files in the target folder. 
 * checkin : " checkin source_tree_path target_repo_folder " command will create a new modified file in the same target sub folder.
 * checkout: " checkout repo_folder destination_path " command will create a new project tree inside the empty target folder. The files will be those mentioned in the identified manifest file.
 * createManifest method adds an activity folder to the repository and creates a manifest file for the repository
 * creation (a record of the user command's activity).
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * Created by parth on 2/25/2017.
 */
public class Source {

    static String path;
    static String content;
    static String cmd;
    static String[] cmdElements;
    String activity_locaiton;
    String new_project_location;
    String old_repo_location;
    String temp_project_location;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Command");
        cmd = sc.nextLine();
        cmdElements = cmd.split("\\s+");
        System.out.println(cmdElements[1]);
        if("create".equals(cmdElements[0]) || "checkin".equals(cmdElements[0]))
        {
        FolderParser folderParser = new FolderParser(cmdElements[1], cmdElements[2]);
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        content = "PVJ-1" + "\r\n";
        content += "Current Date: " + ft.format(dNow) + "\r\n";
        content += cmd + "\r\n";
        content += cmdElements[1] + "\r\n" + cmdElements[2] + "\r\n";
        folderParser.parse();
        createManifest(content);
        }
        else if("checkout".equals(cmdElements[0]))
        {
           
            
            File folder = new File(cmdElements[1]+"\\"+"Activity");
            File[] listOfFiles = folder.listFiles();
            
            for(int i=0;i<listOfFiles.length;i++)
            {
                if(listOfFiles[i].isFile())
                {
                    System.out.println( (i+1) + " " + listOfFiles[i].getName());
                } 
                else if (listOfFiles[i].isDirectory()) 
                {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
                
            }
            System.out.println("Enter number to select manifest file");
            Scanner sc1 = new Scanner(System.in);
            //sc1.nextInt();
            File f = listOfFiles[sc1.nextInt()-1];
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            ArrayList<String> s = new ArrayList <>();
            while ((line = br.readLine()) != null) {
                s.add(line);
    }
            for(int i=5;i<s.size();i++)
            {
                String s_temp = s.get(i);
                String[] commands = s_temp.split(",");
                String[] slash = commands[2].split("\\\\");
                if(slash.length <= 3)
                {
                    Files.copy(Paths.get(cmdElements[1]+"/"+commands[2]), Paths.get(cmdElements[2]+"/"+commands[1]), StandardCopyOption.REPLACE_EXISTING);
                
                } 
                
                else{
                    String s1 = cmdElements[2];
                    for(int j=1;j<(slash.length)-2;j++)
                    {
                        s1 = s1 + "\\" + slash[j];
                        File new_folder = new File(s1);
                        if(!new_folder.exists())
                        {
                        new_folder.mkdir();
                        }
                        
                        
                    }
                    Files.copy(Paths.get(cmdElements[1]+"/"+commands[2]), Paths.get(s1+"/"+commands[1]), StandardCopyOption.REPLACE_EXISTING);
                    
                }
                
                
                
            }
}
           // FolderParser folderParser = new FolderParser(cmdElements[1], cmdElements[2]);
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        content = "PVJ-1" + "\r\n";
        content += "Current Date: " + ft.format(dNow) + "\r\n";
        content += cmd + "\r\n";
        content += cmdElements[1] + "\r\n" + cmdElements[2] + "\r\n";
        //folderParser.parse();
        createManifest(content);
        }
    }

    public static void createManifest(String content) throws IOException {
        SimpleDateFormat ft2 = new SimpleDateFormat("yyyyMMdd_hhmmss");
        File file = new File("F:\\Activity");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        Date date = new Date();
        
        if("create".equals(cmdElements[0]) || "checkin".equals(cmdElements[0]))
        {
            String fileNmae = "Manifest_" + ft2.format(date) + ".txt";
        System.out.println(fileNmae);
        path = cmdElements[2] + File.separator + "Activity" + File.separator + fileNmae;
        }
        else if("checkout".equals(cmdElements[0]))
        {
            String fileNmae = "Manifest_" + ft2.format(date) +"(Checkout manifest) " +".txt";
        System.out.println(fileNmae);
        path = cmdElements[1] + File.separator + "Activity" + File.separator + fileNmae;
        }
        File f = new File(path);
        f.getParentFile().mkdirs();
        f.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(content);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
