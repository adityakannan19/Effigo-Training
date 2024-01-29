import java.util.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public String getUsername() {
        return username;
    }
}

class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }
}

class InventoryManager extends User {
    public InventoryManager(String username, String password) {
        super(username, password);
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}

public class InventoryManagementSystem {
    private static Map<String, User> userMap = new HashMap<>();
    private static Map<String, Product> productMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            int custTemp = 0;
            int logTemp = 0;
            System.out.println("\n------ Inventory Management System Menu ------");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        int t = login();
                        if(t==1){
                            while (custTemp !=3){
                                System.out.println("1. View Inventory");
                                System.out.println("2. Place Order");
                                System.out.println("3. Back");
                                System.out.print("Enter your choice: ");
                                custTemp = scanner.nextInt();
                                scanner.nextLine();
                                switch(custTemp){
                                    case 1:
                                        viewInventory();
                                        break;
                                    case 2:
                                        placeOrder();
                                        break;
                                }
                                
                            }
                            
                        }
                        else if(t==2){
                            while (logTemp !=3){
                                System.out.println("1. View Inventory");
                                System.out.println("2. Add Inventory");
                                System.out.println("3. Back");
                                System.out.print("Enter your choice: ");
                                logTemp = scanner.nextInt();
                                scanner.nextLine();
                                switch(logTemp){
                                    case 1:
                                        viewInventory();
                                        break;
                                    case 2:
                                        addInventory();
                                        break;
                                }
                                
                            } 
                        }
                        break;
                    case 2:
                        signUp();
                        break;
                    case 3:
                        System.out.println("Thank You");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static int login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        User user = userMap.get(enteredUsername);

        int temp = 0;

        if (user != null && user.authenticate(enteredUsername, enteredPassword)) {
            if (user instanceof Customer) {
                System.out.println("Logged in as Customer");
                temp=1;
            } else if (user instanceof InventoryManager) {
                System.out.println("Logged in as Inventory Manager");
                temp = 2;
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        return temp;
    }

    private static void signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String newUsername = scanner.nextLine();

        if (userMap.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter password: ");
        String newPassword = scanner.nextLine();

        System.out.println("Select user type\n1. Customer\n2. Inventory Manager\n");
        System.out.print("Enter your choice: ");
        int userType = scanner.nextInt();

        switch (userType) {
            case 1:
                userMap.put(newUsername, new Customer(newUsername, newPassword));
                System.out.println("Customer account created successfully!");
                break;
            case 2:
                userMap.put(newUsername, new InventoryManager(newUsername, newPassword));
                System.out.println("Inventory Manager account created successfully!");
                break;
            default:
                System.out.println("Invalid user type. Account creation failed.");
        }
    }

    private static void addInventory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();

        Product newProduct = new Product(productName, productPrice, productQuantity);
        productMap.put(productName.toLowerCase(), newProduct);
        System.out.println("Product added successfully!");
    }

    private static void viewInventory() {
        System.out.println("\n===== Current Inventory =====");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice() + ", Quantity: " + product.getQuantity());
        }
    }

    private static void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to place an order: ");
        String productName = scanner.nextLine().toLowerCase();

        Product product = productMap.get(productName);

        if (product != null) {
            System.out.print("Enter quantity to order: ");
            int orderQuantity = scanner.nextInt();

            if (orderQuantity <= 0) {
                System.out.println("Invalid quantity. Please enter a positive number.");
            } else if (orderQuantity > product.getQuantity()) {
                System.out.println("Insufficient stock. Unable to place the order.");
            } else {
                int newQuantity = product.getQuantity() - orderQuantity;
                product.setQuantity(newQuantity);
                System.out.println("Order placed successfully!");
            }
        } else {
            System.out.println("Product not found. Please check the product name.");
        }
    }
}