import java.util.Dictionary;
import java.lang.reflect.*;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.lang.InstantiationException;
import org.reflections.*;
import java.util.Set;
import java.util.Iterator;
import scripts.*;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * Handles keyboard input values
 * 
 * @author (Donovan Yates)
 * @version (0.1)
 */
public final class KeyBindManager
{
    private Dictionary controls;
    private Scanner scan;
    private Class[] storedScripts;
    public KeyBindManager() throws IOException, NoSuchMethodException
    {
        reloadControls();
    }
    public void reloadControls() throws IOException, NoSuchMethodException
    {
        String txtContents;
        boolean validClassName = true;
        txtContents = "";
        File[] txtFiles = new File("config/controls").listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".txt"); }
        } );
        for(int i=0; i<txtFiles.length; i++)
        {
            scan = new Scanner(txtFiles[i], "US-ASCII");
            while(scan.hasNextLine())
            {
                txtContents = scan.nextLine();
                if(txtContents.length()>=3)
                {
                    if(txtContents.charAt(1)==':')
                    {
                        URL scannedURL = Thread.currentThread().getContextClassLoader().getResource("scripts/");
                        URI scannedURI = null;
                        try
                        {
                            scannedURI = scannedURL.toURI();
                        }
                        catch(URISyntaxException e)
                        {
                            System.out.println("URL could not be converted.");
                        }
                        if (Thread.currentThread().getContextClassLoader().getResource("scripts/") == null)
                        {
                            System.out.println("scripts folder is missing.");
                        }
                        ArrayList<Class<?>> scriptClasses = new ArrayList<Class<?>>();
                        File scannedDir = new File(scannedURI.getPath());
                        if(!scannedDir.exists())
                        {
                            System.out.println("scripts folder is inaccessable.");
                        }
                        File[] scannedFiles = scannedDir.listFiles();
                        for(File file : scannedFiles)
                        {
                            scriptClasses.add(file);
                        }
                        for(int x=0; x<scriptClasses.size(); x++)
                        {
                            System.out.println(x);
                            if(scriptClasses.get(x).getName().equals(txtContents.substring(2,txtContents.length())))
                            {
                                System.out.println(txtContents);
                                controls.put(txtContents.charAt(0),scriptClasses.get(x).getConstructor());
                            }
                        }
                    }
                }
            }
        }
        Enumeration keys = controls.keys();
        while(keys.hasMoreElements()){
            String keyPress = (String)keys.nextElement();
            String constructorName = (String)controls.get(keyPress);
        }
    }
    public Dictionary getControls()
    {
        return controls;
    }
    private static ArrayList<Class<?>> find(File file, URI fileURI) {
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = fileURI + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, fileURI));
            }
        } else if (resource.endsWith(".class")) {
            int endIndex = resource.length() - ".class".length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}