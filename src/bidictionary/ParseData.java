/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bidictionary;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author BinhNguyen
 */
public class ParseData extends Thread{
    private final ArrayList<Word> wordList;
    private ArrayList<Word> _wordList;
    private final File file;
    ParseData(File _file){
        this.file = _file;
        wordList = new ArrayList<>();
    }

    private BufferedReader readFileData(File _file) throws IOException{
        BufferedReader in = null;
        try{
                in = new BufferedReader(new FileReader(_file));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return in;
    }
    private void parseLine(String _line){
        String[] part = _line.split("\t");
        Word aWord = new Word(part[0],part[1]);
        wordList.add(aWord);
    }
    public void parseList() throws IOException{
       BufferedReader in = readFileData(this.file);
       String str;
       while((str = in.readLine()) != null && (str.length() != 0)){
           
           parseLine(str);
       }
       in.close();
       System.out.println("Reading complete");
    }
    private ArrayList<Word> getTempWordList(){
        return this.wordList;
    }
    public ArrayList<Word> getWordList(){
        return this._wordList;
    }
    @Override
    public void run() {
        try {
            this.parseList();
            _wordList = this.getTempWordList();
        } catch (IOException ex) {
            Logger.getLogger(ParseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
