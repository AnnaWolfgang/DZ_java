import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        laptops = new HashSet<>();
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops(Map<String, String> criteria) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "ram":
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < Integer.parseInt(value));
                    break;
                case "hdd":
                    filteredLaptops.removeIf(laptop -> laptop.getHdd() < Integer.parseInt(value));
                    break;
                case "os":
                    filteredLaptops.removeIf(laptop -> !laptop.getOs().equalsIgnoreCase(value));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase(value));
                    break;
            }
        }

        if (filteredLaptops.isEmpty()) {
            System.out.println("No laptops match the criteria.");
        } else {
            filteredLaptops.forEach(System.out::println);
        }
    }
}