/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


/**
 *
 * @author Dustin
 */


public class GroupCheck {
private String groupName;
private String groupPass;
private String cwd;
private String directory;

    public GroupCheck(String[] input){
        groupName = input[0];
        groupPass = input[1];
        cwd = Paths.get("").toAbsolutePath().toString();
        directory = encrypt(groupName,groupPass);
        if(Files.exists(Paths.get(directory+"/")))
            System.out.println("Woot " + directory + " exists");
        else
            System.out.println(groupPass + "-->" + directory + " does not exist");
    }

    private String encrypt(String in, String in2){
        char[] out = in.toCharArray();
        char[] pass = in2.toCharArray();
        for(int i=0; i<in.length(); i++ ){
            out[i] = (char)((out[i]+(pass[i%in2.length()]))%128);
            out[i]+=128;
            /*if(out[i]<32)
                out[i] += 32;
            /*while(out[i]=='"' || out[i]=='/' || out[i]=='*' || out[i] =='<' || out[i] == '>' || out[i] == ':' || out[i] == '|' || out[i]==92)
                out[i]++;
            if(out[i]>32 && out[i]<48)
                out[i] += 16;
            if(out[i]>58 && out[i]<65)
                out[i] += 7;
            if(out[i]>32 && out[i]<48)
                out[i] += 16;*/
        }
        System.out.println(out);
        return String.copyValueOf(out);
    }

    public String getDir(){
        return directory;
    }
}

