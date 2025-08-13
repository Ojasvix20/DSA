public class OOPS {
    public static void main(String args[]){
        Pen p1 = new Pen(); //create a pen object called p1
        p1.setColour("blue");
        p1.setTip(5);

        System.out.println("colour of pen is "+ p1.colour);
        System.out.println("tip thickness of pen is "+ p1.tip);

        //we can set value of properties directly as well:
        p1.colour="red";
        p1.tip=8;
        System.out.println("colour of pen is "+ p1.colour);
        System.out.println("tip thickness of pen is "+ p1.tip);

    }
}

class Pen {
    int tip;
    String colour;

    void setColour(String newColour) {
        colour = newColour;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}