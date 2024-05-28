import java.util.HashMap;
import java.util.Map;

public class  CustomerStorage {
    class MyException extends Exception{
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }

        public MyException(String message, Throwable cause) {
            super(message, cause);
        }

        public MyException(Throwable cause) {
            super(cause);
        }

        public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

        if(components.length > 4){
            try {
                throw new MyException("array index out of bounds");
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }
        if(!(components[INDEX_EMAIL].matches(".+@.+\\..+"))){
            try {
                throw new MyException("email in incorrect");
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }
        if(!(components[INDEX_PHONE].matches("^\\+?[7-8][0-9]{10}"))){
            try {
                throw new MyException("phone number is incorrect");
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}