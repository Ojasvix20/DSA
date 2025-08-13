public class Access_Modifiers {
    public static void main(String args[]) {
        BankAccount myAcc = new BankAccount();
        myAcc.userName = "Ray";
        // myacc.password="Ray@123"; cant do direcly as it is private we cant access it
        // but it can be done via setter fn.

        myAcc.setPassword("Ray@123");

        System.out.println("Account username is " + myAcc.userName);
        // System.out.println("Account password is " + myAcc.password); not possible as
        // password is protected, we need to use a getter fn.

        System.out.println("Account password is " + myAcc.getPassword());
    }
}

class BankAccount {
    public String userName;
    private String password;

    public void setPassword(String pw) {
        password = pw;
        //can also be written as this.password = pw;
    }

    public String getPassword() {
        return this.password;
        // this keyword is used to refer to the current object.
    }

}

// NOTES:
// private - accessible only within the class & nowhere else
// default - accessible within the classs and package
// protected - accessible within class, within package and outside the class by
// subclass
// public - accessible everywhere even outside the package

//this is useful if we are using same variable name instead of newPassword, newTip, newColour.
// eg:

// void setColour(String color){
//     this.color=color;   
// usually we write color = new colour, but using this we can be clear...
//this.color means the current objects original color and variable color is the new colour passed as argument.  
// }
