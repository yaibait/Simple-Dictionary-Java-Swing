/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bidictionary;

import java.util.ArrayList;

/**
 *
 * @author BinhNguyen
 */
public class Search {
    private Word aWord;
    private String text;
    private ArrayList<Word> listWord;
    
    Search(String _text,ArrayList<Word> _listWord){
        text = _text;
        aWord = new Word();
        listWord = _listWord;
    }
    private int BinarySearch(){
        ArrayList<Word> list = this.listWord;
        int size = list.size() -1;
        int min = 0,max = size,mid;
        mid = (size/2);
        while(max > min){
            aWord = list.get(max);
             if(text.compareToIgnoreCase(aWord.getWord()) == 0 ){
                
                return max;
            }
            aWord = list.get(min);
            if(text.compareToIgnoreCase(aWord.getWord()) == 0){
                return min;
            }
            aWord = list.get(mid);
            if(text.compareToIgnoreCase(aWord.getWord()) == 0){
                return mid;
            }else if(text.compareToIgnoreCase(aWord.getWord()) < 0){
                max = mid-1;
                min = min + 1;
                mid = (int)(min+max)/2;
            }else if(text.compareToIgnoreCase(aWord.getWord()) > 0){
                min = mid+1;
                max = max -1;
                mid = (int)(min+max)/2;
            }
        }
        return -1;
    }
    private int BinarySearchApproximate(){
        int sub = this.text.length();
        ArrayList<Word> list = this.listWord;
        int size = list.size() -1;
        int min = 0,max = size,mid;
        mid = (size/2);
        String temp = null;
        while(max > min){
            aWord = list.get(max);
            temp = aWord.getWord().length() > sub ? aWord.getWord().substring(0, sub) : aWord.getWord();
            if(text.compareToIgnoreCase(temp) == 0 ){
                
                return max;
            }
            aWord = list.get(min);
            temp = aWord.getWord().length() > sub ? aWord.getWord().substring(0, sub) : aWord.getWord(); 
            if(text.compareToIgnoreCase(temp) == 0){
                return min;
            }
            aWord = list.get(mid);
            temp = aWord.getWord().length() > sub ? aWord.getWord().substring(0, sub) : aWord.getWord();
            if(text.compareToIgnoreCase(temp) == 0){
                return mid;
            } else if(text.compareToIgnoreCase(temp) < 0){
                max = mid-1;
                min = min + 1;
                mid = (int)(min+max)/2;
                

            } else if(text.compareToIgnoreCase(temp) > 0){
                min = mid+1;
                max = max -1;
                mid = (int)(min+max)/2;
            }
            
        }
        return 0;
        
    }
    public int getIndex(){
        return BinarySearch() == -1 ? BinarySearchApproximate() : BinarySearch() ;
    }
}
