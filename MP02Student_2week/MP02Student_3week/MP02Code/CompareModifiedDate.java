
public class CompareModifiedDate implements Comparable {

    @Override
    public int compareTo(FileInfo o1, FileInfo o2) {
        return o1.getModifiedDate().compareTo(o2.getModifiedDate());
    }
}