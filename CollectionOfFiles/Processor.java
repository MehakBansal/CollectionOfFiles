package CollectionOfFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Processor {

    HashMap<Integer,Integer> fileMap;
    HashMap<Integer, ArrayList<Integer>> collectionMap;

    public Processor(HashMap<Integer,Integer> fileMap,HashMap<Integer, ArrayList<Integer>> collectionMap){
        this.fileMap=fileMap;
        this.collectionMap=collectionMap;
    }

    public void totalSizeOfFilesProcessed(){
        int sum=0;
        for(int k:fileMap.keySet()){
            sum=sum+fileMap.get(k);
        }
        System.out.println("Total Size of files Processed="+sum);
    }

    public void topKCollections(int k){
        ArrayList<Collection> collectionsSorted=new ArrayList<>();
        for(int e:collectionMap.keySet()){
            int sum=0;
            for(int i:collectionMap.get(e)){
                sum=sum+fileMap.get(i);
            }
            Collection collection=new Collection(e,sum);
            collectionsSorted.add(collection);
        }
        Collections.sort(collectionsSorted,new SortBySize());
        for(Collection c:collectionsSorted){
            System.out.println("Collection id-->"+c.id);
            System.out.println("Collection size-->"+c.sizeOfFiles);
        }
        System.out.println("Top"+k+"Collections are :");
        for(int j=0;j<k;j++){
            System.out.println("Collection-"+collectionsSorted.get(j).id+":"+collectionsSorted.get(j).sizeOfFiles);
        }
    }

}
