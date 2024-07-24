import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {


    public static void main(String... args) {
        LaptopStore store = new LaptopStore();
        store.addLaptop(new Laptop("Dell", 8, 512, "Windows", "Black"));
        store.addLaptop(new Laptop("HP", 16, 1024, "Windows", "Silver"));
        store.addLaptop(new Laptop("Apple", 8, 256, "macOS", "Silver"));
        store.addLaptop(new Laptop("Asus", 4, 512, "Windows", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> criteria = new HashMap<>();

        System.out.println("Enter the number corresponding to the desired criterion:");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD size");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");
        int criterion = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (criterion) {
            case 1:
                System.out.print("Enter minimum RAM: ");
                criteria.put("ram", scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter minimum HDD size: ");
                criteria.put("hdd", scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter desired Operating System: ");
                criteria.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter desired Color: ");
                criteria.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Invalid criterion.");
                return;
        }

        store.filterLaptops(criteria);


    }
}