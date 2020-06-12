package generics;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    public String toString() {
        return "Customer " + id;
    }

    // A method to produce Generator objects:
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }

    // A single Generator object:
    public static Generator<Teller> generator = new Generator<Teller>() {
        public Teller next() {
            return new Teller();
        }
    };
}

/**
 * A very simple bank teller simulation.
 */
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println("Teller: " + t);
        System.out.println("Customer: " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);

        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 1);

        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 1);

        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}