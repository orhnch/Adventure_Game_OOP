public class SafeHouse extends NormalLoc {
    SafeHouse(Player player){
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getrHealth());
        System.out.println("Healed up!");
        System.out.println("You are at safe house!");

        return true;
    }
}
