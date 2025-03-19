import java.util.*;

class Medicine {
    String name;
    String disease;
    int quantity;
    String expiryDate; // Format: YYYY-MM

    public Medicine(String name, String disease, int quantity, String expiryDate) {
        this.name = name;
        this.disease = disease;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " | Expiry: " + expiryDate + " | Quantity: " + quantity;
    }
}

public class PharmacyStore {
    static Map<String, Set<Medicine>> diseaseMedicineMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z0-9 ]+"); // No special characters allowed
    }

    public static void addMedicine() {
        System.out.print("Enter medicine name: ");
        String name = sc.nextLine();
        if (!isValidName(name)) {
            System.out.println("Invalid name! No special symbols allowed.");
            return;
        }

        System.out.print("Enter disease: ");
        String disease = sc.nextLine();
        if (!isValidName(disease)) {
            System.out.println("Invalid disease name! No special symbols allowed.");
            return;
        }

        System.out.print("Enter quantity: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid quantity! Only numbers are allowed.");
            sc.next();
            return;
        }
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter expiry date (YYYY-MM): ");
        String expiry = sc.nextLine();

        Medicine medicine = new Medicine(name, disease, quantity, expiry);
        diseaseMedicineMap.computeIfAbsent(disease, k -> new LinkedHashSet<>()).add(medicine);
        System.out.println("Medicine added successfully!");
    }

    public static void displayMedicines() {
        for (String disease : diseaseMedicineMap.keySet()) {
            System.out.println("Disease: " + disease);
            for (Medicine med : diseaseMedicineMap.get(disease)) {
                System.out.println("   " + med);
            }
        }
    }

    public static void retrieveMedicine() {
        System.out.print("Enter disease: ");
        String disease = sc.nextLine();
        if (!diseaseMedicineMap.containsKey(disease)) {
            System.out.println("No medicines found for this disease!");
            return;
        }
        
        List<Medicine> medicines = new ArrayList<>(diseaseMedicineMap.get(disease));
        medicines.sort(Comparator.comparing(m -> m.expiryDate)); // Sort by expiry
        
        System.out.println("Available Medicines:");
        for (int i = 0; i < medicines.size(); i++) {
            System.out.println((i + 1) + ". " + medicines.get(i));
        }

        System.out.print("Select a medicine (Enter number): ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > medicines.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        Medicine selectedMed = medicines.get(choice - 1);
        System.out.print("Enter quantity to take: ");
        int takeQuantity = sc.nextInt();
        sc.nextLine();
        
        if (takeQuantity > selectedMed.quantity) {
            System.out.println("Not enough stock available!");
        } else {
            selectedMed.quantity -= takeQuantity;
            if (selectedMed.quantity == 0) {
                diseaseMedicineMap.get(disease).remove(selectedMed);
            }
            System.out.println("Medicine retrieved successfully!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPharmacy Store Management");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Retrieve Medicine");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int option = sc.nextInt();
            sc.nextLine();
            
            switch (option) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    displayMedicines();
                    break;
                case 3:
                    retrieveMedicine();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
