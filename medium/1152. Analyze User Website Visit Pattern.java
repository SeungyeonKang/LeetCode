class Pair {
    int time;
    String web;
    public Pair(int time, String web) {
        this.time = time;
        this.web = web;
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //save <username, <timestamp, web>>
        Map<String, List<Pair>> map = new HashMap<>();
        int n = username.length;
        
        for (int i = 0; i < n; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        Map<String, Integer> s_count = new HashMap<>();
        String res="";
        for(String key : map.keySet()) {
            //sequene set by user
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            Collections.sort(list, (a, b)->(a.time - b.time));
            //list.sort((a,b) -> Integer.compare(a.time, b.time));
            int length = list.size();
            for(int i = 0; i < length; i++){
                for(int j = i+1; j < length; j++) {
                    for(int k = j+1; k < length; k++){
                        String sequence = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if(!set.contains(sequence)) {
                            s_count.put(sequence, s_count.getOrDefault(sequence, 0) + 1);
                            set.add(sequence);
                        }
                        if(res.equals("") || s_count.get(res) < s_count.get(sequence) || (s_count.get(res) == s_count.get(sequence)) && res.compareTo(sequence) > 0) {
                            res = sequence;
                        }
                    }
                }
            }
        }
        
        String[] str = res.split(" ");
        List<String> result = new ArrayList<>();
        for(int i=0; i<3; i++){
            result.add(str[i]);
        }
        
        return result;
        
                           
    }
}
