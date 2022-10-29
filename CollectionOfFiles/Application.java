package CollectionOfFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> fileIdToSizeMap=new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> collectionIdToListOfFilesMap=new HashMap<>();
        System.out.println("Enter number of files");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bufferedReader.readLine());
        System.out.println("input files");
        while(n>0){
            String[] arr =bufferedReader.readLine().trim().split(",");
            fileIdToSizeMap.put(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
            if(arr.length==3){
                if(collectionIdToListOfFilesMap.containsKey(Integer.parseInt(arr[2]))){
                    collectionIdToListOfFilesMap.get(Integer.parseInt(arr[2])).add(Integer.parseInt(arr[0]));
                }
                else{
                    ArrayList<Integer> list= new ArrayList<>();
                    list.add(Integer.parseInt(arr[0]));
                    collectionIdToListOfFilesMap.put(Integer.parseInt(arr[2]),list);
                }
            }
            n--;

        }
        System.out.println("map1-->"+fileIdToSizeMap);
        System.out.println("map2-->"+collectionIdToListOfFilesMap);

        Processor processor= new Processor(fileIdToSizeMap,collectionIdToListOfFilesMap);
        processor.totalSizeOfFilesProcessed();
        System.out.println("Give k");
        int k=Integer.parseInt(bufferedReader.readLine());
        processor.topKCollections(k);

    }
}
