// i will have to however do this again. coz i used the gfg code given in the learning page of this problem
class FoxAndNamesCF {

    public static void main(String[] args){ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];
        for(int i=0; i<n; i++   )
        String s = br.readLine();

    }

    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
         
        int[] inDegree = new int[26];
        
        
        boolean[] exists = new boolean[26];

        
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Build the graph from adjacent words
        for (int i = 0; i + 1 < words.length; ++i) {
            String w1 = words[i];
            String w2 = words[i + 1]; 
            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) ++j;

            if (j < len) {
                int u = w1.charAt(j) - 'a';
                int v = w2.charAt(j) - 'a';
                graph.get(u).add(v);
                inDegree[v]++;
            } else if (w1.length() > w2.length()) {
                // Invalid input 
                return "";
            }
        }

        // Topological sort 
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; ++i) {
            if (exists[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }

        String result = "";
        while (!q.isEmpty()) {
            int u = q.poll();
            result += (char)(u + 'a');

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Check, there was a cycle or not
        for (int i = 0; i < 26; ++i) {
            if (exists[i] && inDegree[i] != 0) {
                return "";
            }
        }

        return result;

    }
}