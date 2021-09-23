
public class Sorter {

    Comparable compare = new CompareFileName();

    public Sorter(Comparable comparable) {

    }


    public void setComparable(Comparable comparable) {
        this.compare=comparable;
    }

    public void bubbleSort(FileInfo[] data) {
        for(int i=0; i<data.length-1; i++){
            for(int j=0; j<data.length-i-1; j++){
                if(compare.compareTo(data[j], data[j+1])>0){
                    FileInfo temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
    }


}
