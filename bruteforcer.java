import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

class bruteforcer implements Runnable {
    static String baseURL;
    static int counter = 0;
    static ArrayList<Integer> status = new ArrayList<Integer>();
    static ArrayList<String> path = new ArrayList<String>();
    static String fileLocation;

    static void wordExtractor() throws FileNotFoundException { // Extract paths from the wordlist to the path array
        Scanner sc = new Scanner(new File(fileLocation));
        while (sc.hasNextLine())
            path.add(sc.nextLine());
    }

    public void getStatusCode(String baseURL) throws IOException { // URL is response code is fetched with paths
                                                                   // provided in wordlist
        String p = path.get(counter++);// Storing the path in String p
        URL url = new URL(baseURL.concat(p));
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int statusCode = http.getResponseCode();
        if (status.contains(statusCode))
            System.out.println(baseURL.concat(p) + "[Status code " + statusCode + "]");
    }

    public void run() { // Overriding run() of interface Runnable

        try {
            getStatusCode(baseURL);
        } catch (Exception e) {
            System.out.println("Invalid BASE URL");
        }
    }

    public static void main(String[] args) { // Driver Function-Main Thread

        baseURL = args[0] + "/";
        fileLocation = args[1];
        for (int i = 2; i < args.length; i++)
            status.add(Integer.parseInt(args[i]));
        try {
            wordExtractor();
        } catch (Exception e) {
            System.out.println("Invalid WordList Path");
        }

        for (int i = 0; i < path.size(); i++) { // Creating multiple threads for diff paths provided in Wordlist
            Thread obj = new Thread(new bruteforcer());
            obj.start();
            try {
                obj.sleep(3000);
            } catch (Exception e) {
                System.out.println("Failed to sleep");
            }

        }
    }
}
