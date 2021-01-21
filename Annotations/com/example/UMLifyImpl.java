package com.example;


public class UMLifyImpl implements UMLify {
    @CustomFieldUMLify("Get the value of X")
    private int x;

    @CustomMethodUMLify("Set the value of X")
   public void setX(int x){
       this.x  = x;
   }

   
   public int getX(){
       return x;
   }
public static void main(String[]args)throws Exception{

    new UMLifyImpl().classDiagram();
}   

    
}
