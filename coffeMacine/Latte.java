package coffeMacine;

public class Latte {
    public String orderReady(){
        Coffe.coffee_beans -= 20;
        Coffe.water -= 350;
        Coffe.milk -= 75;
        Coffe.wallet +=7;
        return "Your Order Are Ready !";
    }
}
