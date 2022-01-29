package pa0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineReport {
    // Variables here
    private  final int TOTAL_TERMINAL_LINES=500;
    private Map<String,LineUsage> stringLineUsageHashMap = new TreeMap<>();
    private List<LineUsage> lineUsageList = new ArrayList<>();
    private static List<String> linesFromFiles = new ArrayList<>();

    // Constructor
    public LineReport() { }

    public void loadData(String filepath) {

        Path path = Paths.get(filepath); // get absolute filepath
        List<String> terminalLinesList = new ArrayList<>(); // store terminal lines
        List<String> userNamesList = new ArrayList<>();  // store user names

        //Using Java8 Stream to read lines from path instead of Scanner
        try (Stream<String> stream = Files.lines(path)) {
            //reading each line into a array list
            linesFromFiles = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //terminal lines and usernames are loaded in separate array list
        for (String line : linesFromFiles) {
            //if any blank line ignore
            if (line.length() > 0) {
                // \\s+ any number of white space between terminal line and username
                String[] split = line.split("\\s+");

                String terminalLine = split[0];
                terminalLinesList.add(terminalLine);

                String username = split[1];
                userNamesList.add(username);
            }
        }

        //terminal line are put into hashmap as key with LineUsage object as value
        terminalLinesList.forEach(terminalLine -> stringLineUsageHashMap.put(terminalLine, new LineUsage()));

        //add observation method is called based on terminal line key
        stringLineUsageHashMap.forEach((tl, lu) ->
        {

            for (String line : linesFromFiles) {
                //if any blank line ignore
                if (line.length() > 0) {
                    // \\s+ any number of white space between terminal line and username
                    String[] split = line.split("\\s+");
                    String terminalLine = split[0];
                    String username = split[1];
                    //if terminal lines which are present in map a key
                    //their corresponding username are added to the observation
                    if (tl.equals(terminalLine)) {
                        lu.addObservation(username);
                    }
                }
            }
        });
    }

    // given loaded lines array, generate report on lines

    void generateReport() {
        System.out.println("Terminal Line Most Common User Count");
        Map<Integer,LineUsage> sortedTreeMap = new TreeMap<>();

        //copying values to a tree map, to sort it
        stringLineUsageHashMap.forEach((tl, lu) ->
                {
                    sortedTreeMap.put(Integer.parseInt(tl), lu);
                }
        );

        //putting terminal line which are present in the input file as null
        for(int i=1;i<=TOTAL_TERMINAL_LINES;i++) {
            if(!sortedTreeMap.containsKey(i))
            sortedTreeMap.put(i,null);
        }
        //displaying the output
            sortedTreeMap.forEach((terminalLine, lineUsage) ->
            {
                if (lineUsage==null) {
                    System.out.println((terminalLine) + "\t\t\t\t" + "<NONE>" + "\t\t\t" + "0");
                } else {
                    //findMaxUsage() method of LineUsage is being called here
                    System.out.println(terminalLine + "\t\t\t\t" + lineUsage.findMaxUsage().getUser() + "\t\t\t" + lineUsage.findMaxUsage().getCount());
                }
            });
        }



    public static void main(String[] args) {

        String filepath=args[0]; // receive arguments

         LineReport lineReport = new LineReport();  //load the file into memory
         lineReport.loadData(filepath);    //load file in  the linesFromFiles and generate i
         lineReport.generateReport();    // generate report loaded on the tree map-> stringLineUsageHashMap printing terminalLine, lineUsage.findMaxUsage().getUser()

    }


}


