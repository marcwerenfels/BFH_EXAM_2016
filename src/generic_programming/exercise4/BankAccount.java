package generic_programming.exercise4;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private static final Lock lock = new ReentrantLock();
    private static final int INITIAL_BALANCE = 100;
    private static Random random = new Random();
    private int amount;

    public BankAccount(){
        this.amount = INITIAL_BALANCE;
    }

    public void deposit(int amount){
        this.amount += amount;
    }

    public void withdraw(int amount){
        //System.err.println("Withdraw: " + amount + " from BankAccount " + this);
        if (amount > this.amount) {
            throw new IllegalArgumentException();
        }
        this.amount -= amount;
    }

    public int getBalance(){
        return this.amount;
    }

    public void randomTransfer(BankAccount other) {

        lock.lock();
        {
            int amount = random.nextInt(this.amount);
            this.withdraw(amount);
            other.deposit(amount);
        }
        lock.unlock();

        /**
        synchronized (lock) {
            int amount = random.nextInt(this.amount);
            this.withdraw(amount);
            other.deposit(amount);
        }
         */
    }
}
