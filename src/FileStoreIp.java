import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileStoreIp implements IStoreIP {
    String fileName;
    long fileLength = 0;
    List<String> IPblackList;

    public FileStoreIp(String path){
         fileName = path;
    }

    @Override
    public List<String> getListIP() {
        Long currentLength = getFileSize(new File(fileName));
        List<String> localBlackList = new ArrayList<>();

        if(currentLength!= fileLength) {

            fileLength = currentLength;

            try (Scanner scanner = new Scanner(new File(fileName))) {

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if(Service.IPChecked(line)) {
                        localBlackList.add(line);
                    }
                }

                IPblackList = localBlackList;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return IPblackList;
    }

    private long getFileSize(File file) {
        long length = file.length();
        return length;
    }
}
