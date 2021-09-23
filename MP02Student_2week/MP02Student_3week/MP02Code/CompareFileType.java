
public class CompareFileType implements Comparable {

    @Override
    public int compareTo(FileInfo o1, FileInfo o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
