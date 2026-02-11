// LC- 733 
class FloodFill {
    static int clr;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length==0) return image;
        clr = image[sr][sc];
        if(clr==color) return image;

        dfs(image, sr, sc, color);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int color){
        if(sr<0 || sc< 0|| sr>= image.length || sc>=image[0].length ||image[sr][sc]!=clr) return;
        image[sr][sc] = color;
        dfs(image, sr,sc-1,color);
        dfs(image, sr,sc+1,color);
        dfs(image, sr-1,sc,color);
        dfs(image, sr+1,sc,color);
        
    }
}