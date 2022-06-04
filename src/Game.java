import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Greetings adventurer!");
        System.out.println("Enter your nickname: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println();
            System.out.println("Choose a location: ");
            System.out.println("1- Safe House --> Safe Place - No Enemies!");
            System.out.println("2- Cave --> You may see zombies here!");
            System.out.println("3 Forest --> You may see vampires here!");
            System.out.println("4 River --> You may see bears here!");
            System.out.println("5 Tool Store --> You can bring guns or armors!");
            System.out.println("Pick the place where you want to go: ");

            int selectedLoc = scan.nextInt();

            while (selectedLoc<1 || selectedLoc > 5 ){
                System.out.println("Please enter a valid number!: ");
                selectedLoc = scan.nextInt();
            }

            switch (selectedLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location.getClass().getName().equals("SafeHouse")){
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Congratulations you won the game !");
                    break;
                }
            }

            if (!location.getLocation()) {
                System.out.println("Game Over !");
                break;
            }

        }
    }
}
