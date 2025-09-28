package com.proyecto01.proyecto01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
* Controller to verify palidromes
* */

@RestController
public class PalindromeRestController {

    /*
    * @param word The word in order to verify
    * @return A message to show if the word is a palindrome or not
    * */
    @GetMapping({"/prove-palindrome/{word}"})
    public String isPalindrome(@PathVariable String word) {
        if(isPalidrome(word)){
            return "The word " + word + " is a palindrome.";
        }else{
            return "The word " + word + " is not a palindrome.";
        }
    }


    @GetMapping("/error")
    public String error(){
        return "No se ha podido encontrar la palabra" ;
    }


    private boolean isPalidrome(String word){
        int length = word.length();
        for(int i = 0; i < length/2; i++){
            if(word.charAt(i) != word.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }

}
