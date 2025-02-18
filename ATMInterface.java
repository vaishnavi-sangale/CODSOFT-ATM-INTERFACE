import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ATMInterface extends JFrame implements ActionListener{
JLabel l1,l2,l3;

JTextField pin,amt;
JButton verify,check,withdraw,deposit,exit;
Container c;
Double balance=100000.00;
String CorrectPin="1234";
boolean isauthenticated=false;
public ATMInterface()
{
c=getContentPane();
l1=new JLabel("ATM INTERFACE");
l1.setBounds(480,40,400,50);
l1.setForeground(Color.BLACK);

l1.setFont(new Font("Arial",Font.BOLD,32));

c.add(l1);
l2=new JLabel("Enter A Pin :");
l2.setBounds(400,125,200,50);
l2.setForeground(Color.BLACK);
l2.setFont(new Font("Arial",Font.BOLD,25));
c.add(l2);


l3=new JLabel("Enter A Amount :");
l3.setBounds(640,125,200,50);
l3.setForeground(Color.BLACK);
l3.setFont(new Font("Arial",Font.BOLD,25));
c.add(l3);

amt=new JTextField("");
amt.setBounds(350,170,200,40);
amt.setFont(new Font("Arial",Font.BOLD,25));
c.add(amt);
amt.addActionListener(this);



pin=new JTextField("");
pin.setBounds(640,170,200,40);
//pin.setForeground(Color.BLACK);
c.add(pin);
pin.addActionListener(this);

verify=new JButton("Verify Pin");
verify.setBounds(350,250,150,40);
verify.setFont(new Font("Arial",Font.BOLD,25));

c.add(verify);
verify.addActionListener(this);
check=new JButton("Check Balance");
check.setBounds(650,230,250,50);
check.setFont(new Font("Arial",Font.BOLD,25));

c.add(check);
check.addActionListener(this);

withdraw=new JButton("WithDraw");
withdraw.setBounds(350,350,200,40);
withdraw.setFont(new Font("Arial",Font.BOLD,25));
c.add(withdraw);
withdraw.addActionListener(this);

deposit=new JButton("Deposit");
deposit.setBounds(650,350,200,40);
deposit.setFont(new Font("Arial",Font.BOLD,25));
c.add(deposit);
deposit.addActionListener(this);
exit=new JButton("EXIT");
exit.setBounds(550,450,200,40);
exit.setFont(new Font("Arial",Font.BOLD,25));
exit.setForeground(Color.BLACK);

c.add(exit);
exit.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{

String enteredPin=amt.getText();
if(enteredPin.equals(CorrectPin))
{
isauthenticated=true;
JOptionPane.showMessageDialog(this,"Correct Pin");
}
else{
JOptionPane.showMessageDialog(this,"Incorrect PIN! Try Again");
}


if(e.getSource()==check)
{
JOptionPane.showMessageDialog(this,"Your Balance: $"+balance);
}
else if(e.getSource()==deposit)
{
try{
double amount=Double.parseDouble(pin.getText());
if(amount>0){
balance+=amount;
JOptionPane.showMessageDialog(this,"Deposited:$"+amount);
}
else{
JOptionPane.showMessageDialog(this,"Enter a Valid Amount!");
}
}
catch(NumberFormatException ex)
{
JOptionPane.showMessageDialog(this,"Invalid Input! Enter a number");
}
}
else if(e.getSource()==withdraw)
{
try{
double amount=Double.parseDouble(pin.getText());
if(amount>0&& amount<=balance)
{
balance-=amount;
JOptionPane.showMessageDialog(this,"Withdrawn:$"+amount);
}
else{
JOptionPane.showMessageDialog(this,"Insufficient Balance or Invalid Amount!");
}
}
catch(NumberFormatException ex)
{
JOptionPane.showMessageDialog(this,"Invalid input! Enter a Number:");
}
}

else if(e.getSource()==exit)
{
JOptionPane.showMessageDialog(this,"Thank You for using ATM!");
System.exit(0);
}



}
public static void main(String[] args)
{
ATMInterface f=new ATMInterface();
f.setSize(800,800);
f.setLayout(null);
f.setTitle("ATM Interface");

f.setLocationRelativeTo(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
}
