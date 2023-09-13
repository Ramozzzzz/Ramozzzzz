import java.io.IOException;
import static com.Words.WordsCut.*;
import static com.Words.txtOperation.*;
import static com.Words.CosineSimilarity.*;

public class main {
    public static void main(String[] args) throws IOException {
         String path="F:\\program\\c\\software\\txt\\orig.txt";
         System.out.println(splitWords(String.valueOf(Read(path))));
        //System.out.println(Arrays.toString(Counter(splitWords(String.valueOf(Read(path))),
        // Merge(splitWords(String.valueOf(Read(path))), splitWords(String.valueOf(Read(path)))))));

    }
}
