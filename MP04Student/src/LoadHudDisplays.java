import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{

    public ArrayList<String> list;
    public String filename;
    public String s;

    LoadHudDisplays(String filename) { //txt 파일 받아옴
        list = new ArrayList<>();
        this.filename=filename;
    }

    @Override
    public ArrayList<String> load() {
        try {
            BufferedReader readme
                    = new BufferedReader(
                    new FileReader(filename));

            while((s=readme.readLine())!=null){
                System.out.println("b = " + s);
                list.add(s.split("\n")[0]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
}