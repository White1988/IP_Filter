import java.io.File;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args)  {

        if (args.length == 0){
            System.out.println("Please enter file ip store path: program pathFile");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()){
            System.out.println("File " + args[0] + " doesn't exist. Please enter right path");
        }

        Scanner in = new Scanner(System.in);

        String input = "";


        IStoreIP store = new FileStoreIp(args[0]);

        do{
            System.out.println("Enter IP: ");
            input = in.nextLine();

            if(Service.IPChecked(input)){

                List<String> listIp = store.getListIP();

                if(listIp.contains(input)){
                    System.out.println("Dissallowed");
                }
                else
                    System.out.println("Allowed");

            }
            else if (!input.equals("quit")){

                System.out.println("Please, enter right IP adress. Yours IP = { " + input + " } is wrong.s");

            }

        }while (!input.equals("quit"));

    }
}
