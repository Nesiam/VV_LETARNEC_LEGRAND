package fr.istic.vv;


import java.util.Stack;

public class StringUtils {
    static Stack<Character> pile=new Stack<Character>();


    private StringUtils() {}

    public static boolean isBalanced(String str) {
        return false;
    }
    	if(str.isEmpty()) {
    		if(pile.empty()){
				return true;
			}
			else{
				pile=new Stack<Character>();
				return false;
			}
    		}
    	else {
    		char charact = str.charAt(0);
    		if(charact=='(' || charact=='[' || charact=='{') {
    			pile.add(charact);
    			return isBalanced(str.substring(1,str.length()));
    		}
    		if(charact==')' || charact==']' || charact=='}') {
    			Character p=pile.pop();
    			if(p=='(' && charact==')') {
    				return isBalanced(str.substring(1,str.length()));
    			}
    			else if(p=='[' && charact==']') {
    				return isBalanced(str.substring(1,str.length()));
    			}
    			else if(p=='{' && charact=='}') {
    				return isBalanced(str.substring(1,str.length()));
    			}
    			else {
					pile=new Stack<Character>();
    				return false;
    			}
    		}
    		else {
    			return isBalanced(str.substring(1,str.length()));
    		}
    	}

    }
}