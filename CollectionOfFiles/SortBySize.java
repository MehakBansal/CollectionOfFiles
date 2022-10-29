package CollectionOfFiles;

import java.util.Comparator;

public class SortBySize implements Comparator<Collection> {

    @Override
    public int compare(Collection o1, Collection o2) {
        return o2.sizeOfFiles-o1.sizeOfFiles;
    }
}
