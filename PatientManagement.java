import java.util.Scanner; 



class Hospital {
    private Patient[] patients;
    private int patientCount;

    public Hospital() {
        patients = new Patient[10];
        patientCount = 0;
    }

    // admit patient
    public void admitPatient(String name) {
        patients[patientCount] = new Patient(name);
        patientCount++;
        System.out.println("\033[32mPatient admitted successfully!\033[0m");
    }

    // allocate doctor
    public void allocateDoctor(String patientName, String doctor) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getName().equals(patientName)) {
                patients[i].setDoctor(doctor);
                System.out.println("\033[32mDoctor allocated successfully!\033[0m");
                return;
            }
        }
        System.out.println("\033[31mPatient not found!\033[0m");
    }
    // allocate bed
public void allocateBed(String patientName, String bed) {
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].getName().equals(patientName)) {
            patients[i].setBed(bed);
            System.out.println("\033[32mBed allocated successfully!\033[0m");
            return;
        }
    }
    System.out.println("\033[31mPatient not found!\033[0m");
}

// view patient history
public void viewHistory(String patientName) {
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].getName().equals(patientName)) {
            System.out.println("Name: " + patients[i].getName());
            System.out.println("Doctor: " + patients[i].getDoctor());
            System.out.println("Bed: " + patients[i].getBed());
            System.out.println("Medication: " + patients[i].getMedication());
            return;
        }
    }
    System.out.println("\033[31mPatient not found!\033[0m");
}

// record medication
public void recordMedication(String patientName, String medication) {
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].getName().equals(patientName)) {
            patients[i].setMedication(medication);
            System.out.println("\033[32mMedication recorded successfully!\033[0m");
            return;
        }
    }
    System.out.println("\033[31mPatient not found!\033[0m");
}

// discharge patient
public void dischargePatient(String patientName) {
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].getName().equals(patientName)) {
            patients[i] = null;
            patientCount--;
            System.out.println("\033[32mPatient discharged successfully!\033[0m");
            return;
        }
    }
    System.out.println("\033[31mPatient not found!\033[0m");
}

// generate bill
public void generateBill(String patientName) {
    for (int i = 0; i < patientCount; i++) {
        if (patients[i].getName().equals(patientName)) {
            System.out.println("Bill: " + patients[i].getBill());
            return;
        }
    }
    System.out.println("\033[31mPatient not found!\033[0m");
    }
}

class Patient {
    private String name;
    private String doctor;
    private String bed;
    private String medication;
    private int bill;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}

public class PatientManagement {
public static void main(String[] args) {
Hospital hospital = new Hospital();
try (Scanner scanner = new Scanner(System.in)) {
    boolean quit = false;
    while (!quit) {
        System.out.println("\n\033[34m_-_-_-_-_-_-_-_-_-\033[0m \033[31m+\033[0m Singhe Hospital \033[31m+\033[0m \033[34m-_-_-_-_-_-_-_-_-_\n");
        System.out.println("\t1. Admit patient");
        System.out.println("\t2. Allocate doctor");
        System.out.println("\t3. Allocate bed");
        System.out.println("\t4. View patient history");
        System.out.println("\t5. Record medication");
        System.out.println("\t6. Discharge patient");
        System.out.println("\t7. Generate bill");
        System.out.println("\t8. Quit\033[0m\n");
        System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    switch (choice) {
        case 1:
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            hospital.admitPatient(name);
            break;
        case 2:
            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
            System.out.print("Enter doctor name: ");
            String doctor = scanner.nextLine();
            hospital.allocateDoctor(patientName, doctor);
            break;
        case 3:
            System.out.print("Enter patient name: ");
            patientName = scanner.nextLine();
            System.out.print("Enter bed number: ");
            String bed = scanner.nextLine();
            hospital.allocateBed(patientName, bed);
            break;
        case 4:
            System.out.print("Enter patient name: ");
            patientName = scanner.nextLine();
            hospital.viewHistory(patientName);
            break;
        case 5:
            System.out.print("Enter patient name: ");
            patientName = scanner.nextLine();
            System.out.print("Enter medication: ");
            String medication = scanner.nextLine();
            hospital.recordMedication(patientName, medication);
            break;
        case 6:
            System.out.print("Enter patient name: ");
            patientName = scanner.nextLine();
            hospital.dischargePatient(patientName);
            break;
        case 7:
            System.out.print("Enter patient name: ");
            patientName = scanner.nextLine();
            hospital.generateBill(patientName);
            break;
        case 8:
            quit = true;
            break;
        default:
    System.out.println("\033[31mInvalid choice. Please enter a valid option.\033[0m");
    break;
    }
    }
    }
}
}