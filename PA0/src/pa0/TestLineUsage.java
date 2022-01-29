package pa0;

import java.util.HashMap;
import java.util.Scanner;


public class TestLineUsage {


    public static void main(String[] args) {
        //Create LineUsage object
        LineUsage lineUsage = new LineUsage();
        lineUsage.addObservation("SAMORA");
        lineUsage.addObservation("Operator");
        lineUsage.addObservation("Usermgr");
        lineUsage.addObservation("SAMORA");
        lineUsage.addObservation("Operator");
        lineUsage.addObservation("SAMORA");
        Usage usageObj = lineUsage.findMaxUsage();
        System.out.println("Usage object for the user with the highest count: (" + usageObj.getUser() + "-->" + usageObj.getCount() + ")");
    }
}
