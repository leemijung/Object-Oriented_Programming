public class OdtDocConverter extends DocConverter{

    public OdtDocConverter(){
        super("odt");
    }
    public void save(String fileName){
        System.out.println(fileName+"."+super.getExtension()+"로 변환해서 저장합니다");
    }
}
