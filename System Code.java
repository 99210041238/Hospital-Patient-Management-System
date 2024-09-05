package patient;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Patient {
    String name;
    int age;
    String bloodGroup;
    String gender;
    String phone_number;
    String another_phone_number;
    String date;

    Patient(String name, int age, String bloodGroup, String gender, String phone, String mobileNumber, String date) {
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.phone_number = phone;
        this.another_phone_number = mobileNumber;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Blood Group: " + bloodGroup + 
               ", Gender: " + gender + ", Phone: " + phone_number + ", Mobile Number: " + another_phone_number + ", Date: " + date;
    }
}

public class HospitalManagement {
    LinkedList<Patient> patients = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    Map<String, String[]> operationDetails = new HashMap<>();

    public static void main(String[] args) {
        HospitalManagement hm = new HospitalManagement();
        hm.run();
    }

    public HospitalManagement() {
        // Initialize operation details
        operationDetails.put("Lungs", new String[]{"Dr. Smith", "4.5", "01-01-2024", "10-01-2024", "5000", "X-Ray, CT-Scan"});
        operationDetails.put("Brain", new String[]{"Dr. Brown", "4.8", "05-01-2024", "15-01-2024", "15000", "MRI, EEG"});
        operationDetails.put("Eyes", new String[]{"Dr. Green", "4.2", "08-01-2024", "12-01-2024", "3000", "Eye Test, Vision Test"});
        operationDetails.put("Bones", new String[]{"Dr. White", "4.7", "10-01-2024", "20-01-2024", "7000", "X-Ray, Bone Density Test"});
        operationDetails.put("Ear", new String[]{"Dr. Black", "4.4", "12-01-2024", "18-01-2024", "4000", "Hearing Test, CT-Scan"});
        operationDetails.put("Kidneys", new String[]{"Dr. Grey", "4.6", "15-01-2024", "25-01-2024", "8000", "Ultrasound, Blood Test"});
    }

    void run() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. Search Patient");
            System.out.println("4. Patient Past History");
            System.out.println("5. Patient Appointment Details");
            System.out.println("6. Update Patient");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    deletePatient();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    patientPastHistory();
                    break;
                case 5:
                    patientAppointmentDetails();
                    break;
                case 6:
                    updatePatient();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    additionalFeatures();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void addPatient() {
        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Blood Group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        String phone;
        while (true) {
            System.out.print("Phone: ");
            phone = scanner.nextLine();
            if (phone.matches("[6789]\\d{9}") && phone.length() == 10) {
                break;
            } else {
                System.out.println("Invalid phone number. It should start with 6, 7, 8, or 9 and be 10 digits long.");
            }
        }
        System.out.print("Mobile Number: ");
        String mobileNumber = scanner.nextLine();
        System.out.println("Enter appointment date (dd-mm-yyyy): ");
        String date = scanner.nextLine();

        patients.add(new Patient(name, age, bloodGroup, gender, phone, mobileNumber, date));
        System.out.println("Patient added successfully.");
        printAllPatients();
    }

    void deletePatient() {
        System.out.print("Enter patient name to delete: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                patients.remove(patient);
                System.out.println("Patient deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        } else {
            printAllPatients();
        }
    }

    void searchPatient() {
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println("Patient details: " + patient);
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    void patientPastHistory() {
        // Assuming past history is the same as patient details for this example
        System.out.print("Enter patient name to view past history: ");
        String name = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println("Patient past history: " + patient);
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    void patientAppointmentDetails() {
        System.out.print("Enter patient name to view appointment details: ");
        String name = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println("Patient appointment details: " + patient + ", Date: " + patient.date);
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    void updatePatient() {
        System.out.print("Enter patient name to update: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println("Enter new details (leave blank to keep current value):");
                System.out.print("Name (" + patient.name + "): ");
                String newName = scanner.nextLine();
                System.out.print("Age (" + patient.age + "): ");
                String newAge = scanner.nextLine();
                System.out.print("Blood Group (" + patient.bloodGroup + "): ");
                String newBloodGroup = scanner.nextLine();
                System.out.print("Gender (" + patient.gender + "): ");
                String newGender = scanner.nextLine();
                System.out.print("Phone (" + patient.phone_number + "): ");
                String newPhone = scanner.nextLine();
                System.out.print("Mobile Number (" + patient.another_phone_number + "): ");
                String newMobileNumber = scanner.nextLine();
                System.out.print("Appointment date (" + patient.date + "): ");
                String newDate = scanner.nextLine();

                if (!newName.isEmpty()) patient.name = newName;
                if (!newAge.isEmpty()) patient.age = Integer.parseInt(newAge);
                if (!newBloodGroup.isEmpty()) patient.bloodGroup = newBloodGroup;
                if (!newGender.isEmpty()) patient.gender = newGender;
                if (!newPhone.isEmpty() && newPhone.matches("[6789]\\d{9}")) patient.phone_number = newPhone;
                if (!newMobileNumber.isEmpty()) patient.another_phone_number = newMobileNumber;
                if (!newDate.isEmpty()) patient.date = newDate;

                System.out.println("Patient details updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    void printAllPatients() {
        System.out.println("Current patient list:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    void additionalFeatures() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Type of Treatment");
            System.out.println("2. View Current Operations");
            System.out.println("3. Room Allocation");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    typeOfTreatment();
                    break;
                case 2:
                    viewOperations();
                    break;
                case 3:
                    roomAllocation();
                    break;
                case 4:
                    System.out.println("Exiting additional features...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void typeOfTreatment() {
        System.out.println("Select type of treatment:");
        System.out.println("1. General Checkup");
        System.out.println("2. Operation");

        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        if (choice == 1) {
            System.out.println("You have selected General Checkup.");
        } else if (choice == 2) {
            System.out.println("You have selected Operation.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    void viewOperations() {
        System.out.println("Available Operations:");
        int index = 1;
        for (String operation : operationDetails.keySet()) {
            System.out.println(index + ". " + operation);
            index++;
        }

        System.out.print("Select an operation to view details: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        if (choice < 1 || choice > operationDetails.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        String selectedOperation = (String) operationDetails.keySet().toArray()[choice - 1];
        String[] details = operationDetails.get(selectedOperation);

        System.out.println("Operation: " + selectedOperation + 
                           "\nDoctor: " + details[0] + 
                           "\nRating: " + details[1] + 
                           "\nOperation Date: " + details[2] + 
                           "\nDischarge Date: " + details[3] + 
                           "\nCost: " + details[4] + 
                           "\nDiagnostic Tests: " + details[5] + "\n");

        System.out.print("Do you want to proceed with this operation? (y/n): ");
        char proceed = scanner.nextLine().charAt(0);

        if (proceed == 'y' || proceed == 'Y') {
            System.out.println("Operation granted.");
            printReceipt(selectedOperation, details);
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    void printReceipt(String operation, String[] details) {
        System.out.println("Generating receipt...");
        System.out.println("Patient Details: ");
        System.out.println(patients.getLast());  // Assuming the last added patient is the current patient
        System.out.println("Operation Details: ");
        System.out.println("Operation: " + operation + 
                           "\nDoctor: " + details[0] + 
                           "\nRating: " + details[1] + 
                           "\nOperation Date: " + details[2] + 
                           "\nDischarge Date: " + details[3] + 
                           "\nCost: " + details[4] + 
                           "\nDiagnostic Tests: " + details[5]);
    }

    void roomAllocation() {
        System.out.print("Enter joining date (dd-mm-yyyy): ");
        String joiningDate = scanner.nextLine();
        System.out.print("Enter discharging date (dd-mm-yyyy): ");
        String dischargingDate = scanner.nextLine();
        System.out.println("Select room type:");
        System.out.println("1. AC");
        System.out.println("2. Non-AC");

        int roomTypeChoice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        String roomType = roomTypeChoice == 1 ? "AC" : "Non-AC";

        System.out.println("Room allocated successfully.");
        System.out.println("Room Type: " + roomType + 
                           "\nJoining Date: " + joiningDate + 
                           "\nDischarging Date: " + dischargingDate);
    }

    void openFileSelector() {
        System.out.println("Feature to open file selector for diagnostic test report.");
        // Placeholder for file manager integration to select file path
    }
}
