
public class CompareFileName implements Comparable {

    @Override
    public int compareTo(FileInfo o1, FileInfo o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
