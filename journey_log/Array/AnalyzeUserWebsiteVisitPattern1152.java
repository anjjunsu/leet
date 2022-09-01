import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        int length = username.length;
        Map<String, List<Record>> visitHistory = new HashMap<>();
        Map<String, Integer> patternCount = new HashMap<>();
        
        // Record each user's website visit history
        for(int i = 0; i < length; i++) {
            visitHistory.putIfAbsent(username[i], new ArrayList<>());
            visitHistory.get(username[i]).add(new Record(timestamp[i], website[i]));
        }

        // Create every possible pattern and count
        String mostVisited = "";

        for (String user : visitHistory.keySet()) {
            List<Record> visits = visitHistory.get(user);
            Set<String> uniquePattern = new HashSet<>();

            // sort visits by time
            Comparator<Record> recordComparator = 
                Comparator.comparing(Record::getTimeStamp);

            Collections.sort(visits, recordComparator);

            for (int i = 0; i < visits.size(); i++) {
                for (int j = i + 1; j < visits.size(); j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String pattern = visits.get(i).website + " " 
                            + visits.get(j).website + " " 
                            + visits.get(k).website;

                        if (!uniquePattern.contains(pattern)) {
                            uniquePattern.add(pattern);
                            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
                        }

                        if ((mostVisited.equals("")) ||
                            (patternCount.get(pattern) > patternCount.getOrDefault(mostVisited, -1)) ||
                            ((patternCount.get(pattern) == patternCount.get(mostVisited)) && (pattern.trim().compareTo(mostVisited.trim())) < 0)) {
                                mostVisited = pattern;
                            }
                    }
                    
                }
            }

        }

        String[] resultArray = mostVisited.split(" ");
        return List.of(resultArray);
    }
}

class Record {
    int timestamp;
    String website;

    public Record(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }

    int getTimeStamp() {
        return timestamp;
    }

    String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return Integer.toString(timestamp) + " " + website;
    }
}
