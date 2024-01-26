package tn.esprit.aerolux.test;

import tn.esprit.aerolux.Utils.MyDatabase;

public class Main {
    public static void main (String[] args){
        MyDatabase db = MyDatabase.getInstance();
        MyDatabase db2 = MyDatabase.getInstance();
        MyDatabase db3 = MyDatabase.getInstance();
        System.out.println(db);
        System.out.println(db2);
        System.out.println(db3);//modif khadija

    }
}