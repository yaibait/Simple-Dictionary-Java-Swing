/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bidictionary;

/**
 *
 * @author BinhNguyen
 */
public class Word {
    private String word;
    private String mind;
    
    Word(){
        this.word = "";
        this.mind = "";
    }
    Word(String _word,String _mind){
        this.word = _word;
        this.mind = _mind;
    }
    public String getWord(){
        return this.word;
    }
    public String getMind(){
        return this.mind;
    }
}
