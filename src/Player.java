import java.util.Scanner;

public class Player {
    private int damage, health, money, rHealth;
    private String name, cName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inv = new Inventory();
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealth() {
        return rHealth;
    }

    public void setrHealth(int rHealth) {
        this.rHealth = rHealth;
    }

    public void selectChar() {
        switch (charMenu()){
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            case 2:
                initPlayer("Archer",7,18,20);
                break;
            case 3:
                initPlayer("Knight",8,24,5);
                break;
        }
        System.out.println("Character has been created ! " +
                "Name =" + getcName() + " , " +
                "Damage =" + getDamage() + " , " +
                "Health =" + getHealth() + " ," +
                "Money =" + getMoney());
    }

    public int charMenu(){
        System.out.println("Please select a class: ");
        System.out.println("1- Samurai \t Damage : 5 \t Health :21 \t Money :15");
        System.out.println("2- Archer \t Damage : 7 \t Health :18 \t Money :20");
        System.out.println("3- Knight \t Damage : 8 \t Health :24 \t Money :5");
        System.out.print("Enter your choice : ");

        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3){
            System.out.println("Invalid selection! Please enter a valid number!");
            chaID = scan.nextInt();
        }
        return chaID;
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }

    public void initPlayer(String cName, int dmg, int hlth, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealth(hlth);
        setMoney(mny);
        setrHealth(hlth);
    }

}
