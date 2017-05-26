/**
    This class wraps a StringBuilder. It should be about as efficient as StringBuilder, but as easy, or easier, to use as String concatenation.
 */

package io.github.leopiccionia.easyprint;

import java.io.IOException;
import java.io.Writer;
import java.lang.CharSequence;
import java.lang.StringBuilder;

public class EasyString implements CharSequence{
    
    private StringBuilder value;

    public EasyString(String string){
    	this.value = new StringBuilder(string);
    }
    
    public EasyString(StringBuilder builder){
        this.value = builder;
    }

    public EasyString(Object... args){
        this.value = new StringBuilder();
        for(Object arg : args)
            this.value.append(String.valueOf((Object)arg));
    }

    public EasyString append(Object... args){
        this.value.append(new EasyString(args));
        return this;
    }

	public char charAt(int index){
		return this.value.charAt(index);
	}    
    
    public static EasyString concat(String separator, Object... args){
        if(args.length == 0)
            return new EasyString();
        EasyString temp = new EasyString(args[0]);
        for(int i = 1; i < args.length; i++){
            temp.value.append(separator);
            temp.value.append(String.valueOf((Object)args[i]));
        }
        return temp;
    }
    
    public int length(){
    	return this.value.length();
    }

    public static void print(Object... args){
        System.out.print(new EasyString(args));
    }

    public static void println(Object... args){
        System.out.println(new EasyString(args));
    }

    public static EasyString repeat(String string, int times){
    	EasyString temp = new EasyString();
    	for(int i = 0; i < times; i++)
    		temp.value.append(string);
    	return temp;
    }
    
	public CharSequence subSequence(int start, int end){
		return this.value.subSequence(start, end);
	}    
    
    public String toString(){
        return this.value.toString();
    }
    
    public Writer write(Writer writer, Object... args){
    	EasyString temp = new EasyString(args);
    	try{
    		writer.append(temp.toString());
    	}
    	catch(IOException e){
    		System.err.println("EasyString threw IOException: " + e.getMessage());
    	}
    	return writer;
    }
    
    public Writer writeln(Writer writer, Object... args){
    	EasyString temp = new EasyString(args, System.getProperty("line.separator"));
    	try{
    		writer.append(temp.toString());
    	}
    	catch(IOException e){
    		System.err.println("EasyString threw IOException: " + e.getMessage());
    	}
    	return writer;
    }
}