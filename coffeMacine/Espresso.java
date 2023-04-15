package coffeMacine;

public class Espresso {
    public String orderReady(){
        Coffe.coffee_beans = Coffe.coffee_beans-16;
        Coffe.water -= 250;
        Coffe.wallet +=4;
        return "Your Order Are Ready !";
    }
}
