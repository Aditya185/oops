package pjava.ch04.bankaccount_v2;

public class BankAccount{
    
   public BankAccount()   {
       this.accno = next_accno++;
       this.balance = 0;
   }

    public long getAccno() {
        return accno;
    }
   
   public BankAccount(double initialBalance)   {
       accno = next_accno++;
       balance = initialBalance;
   }
   public void deposit(double amount)   {
       double newBalance = balance + amount;
       balance = newBalance;
   }
   public void withdraw(double amount)
           throws DailyLimitException, InsuffBalanceException {
       if ( amount > 25000 )
           throw new DailyLimitException();
       else if ( amount > balance )
           throw new InsuffBalanceException();

       balance = balance - amount;
   }
   public double getBalance()
   {
       return balance;
   }

   private final long accno;
   private double balance;
   private static long next_accno=10000;   
}