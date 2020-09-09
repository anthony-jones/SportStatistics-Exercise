import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("File: ");
        String fileName = scan.nextLine();
        System.out.println("Team: ");
        String teamName = scan.nextLine();
      
        ArrayList<String> list = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + fileName + " failed.");
        }
        
        int games = 0, wins = 0, losses = 0;
        for(int i = 0; i < list.size(); i++){
            String[] parts = list.get(i).split(",");
            if(parts[0].equals(teamName)){
                games++;
                if(Integer.valueOf(parts[2]) > Integer.valueOf(parts[3])){
                    wins++;
                } else {
                    losses++;
                }
            }
            if(parts[1].equals(teamName)){
                games++;
                if(Integer.valueOf(parts[3]) > Integer.valueOf(parts[2])){
                    wins++;
                } else {
                    losses++;
                }
            }
        }
        
        System.out.println("Games: " + games);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
