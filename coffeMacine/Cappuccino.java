package coffeMacine;

public class Cappuccino {
    public String orderReady(){
        Coffe.coffee_beans -= 12;
        Coffe.water -= 200;
        Coffe.milk -= 100;
        Coffe.wallet +=6;
        return "Your Order Are Ready !";
    }
}
