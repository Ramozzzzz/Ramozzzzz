
import java.io.*;
import java.util.*;

class GetTXT {
    private static List<String> Read(String path) throws IOException {
        List<String> article=new ArrayList<String>();
        File read=new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(read));
        BufferedReader r = new BufferedReader(reader);
        String line=r.readLine();
        while(line!=null){
            article.add(line);
            line=r.readLine();
        }
        return article;
    }

    public static void main(String[] args) throws IOException {
        String path="F:\\program\\c\\software\\txt\\orig.txt";
        System.out.println(Read(path));
    }
}
