import java.util.Map;
import java.util.HashMap;

public class WordProcessor {
    private ISpellChecker spellChecker;
    private final Map<String, DocConverter> docConverters= new HashMap<>();
    private final String fileName;

    public WordProcessor(String fileName){
        this.fileName=fileName;
    }

    public void addDocConverter(DocConverter converter){
        docConverters.put(converter.getExtension(), converter);

    }
    public void convertDocTo(String ext){
        if (docConverters.containsKey(ext)) {
            DocConverter t = docConverters.get(ext);
            t.save(fileName);
        }
        else{
            System.out.println(ext+"파일 형식을 지원하는 DocConverter가 없습니다");
        }
    }
    public void setSpellChecker(ISpellChecker spellChecker){
        this.spellChecker=spellChecker;
    }
    public void checkSpelling(){
        spellChecker.check();
    }
}


