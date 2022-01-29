package pa0;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LineUsage {

    private HashMap<String, Integer> lines=new HashMap<>();


    public LineUsage() {

    }

    public void addObservation(String username)
    {
        //If map has user name, increment count
        int count=0;
        if(lines.containsKey(username))
        {
            count=(int)lines.get(username)+1;
            lines.put(username,count);
        }
        else  //Add new entry to map
        {
            count=1;
            lines.put(username, count);
        }
    }

    //Returns max count usage object
    public Usage findMaxUsage()
    {

        HashMap<String, Integer> sortedHashMapLines = sortByValue(lines);   //sorted in ascending order
        String s = String.valueOf(sortedHashMapLines.entrySet().toArray()[sortedHashMapLines.size() - 1]); // getting the last entry in the map
        String[] split = s.split("=");    //getting the max username and count by splitting
        String maxUsername=split[0];

        int maxCount=Integer.parseInt(split[1]);
        return new Usage(maxUsername,maxCount); //returning Usage object
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        HashMap<String, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted(Comparator.comparing(Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return temp;
    }

}


