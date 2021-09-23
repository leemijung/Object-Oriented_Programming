
public class CompareSize implements Comparable {

    @Override
    public int compareTo(FileInfo o1, FileInfo o2) {
        return o1.getSize()-o2.getSize();
    }
}