import java.util.Scanner;

public class HosMedExp {
    private String patientName;
    private int age, symNo, cnt;
    private final int thresholdVal = 3;
    private String anotherSym, dis, diabetesSym, hyperSym;

    public HosMedExp() {
        cnt = 0;
    }

    public void personalDetailsInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient's Name: ");
        patientName = scanner.next();
        System.out.print("Enter Patient's Age: ");
        age = scanner.nextInt();
    }

    public void medInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Various Symptoms list is given below: ");
        System.out.println("1. Cough\n2. Itchiness\n3. Headache");
        System.out.print("Enter the number of symptom you have from the given list: ");
        symNo = scanner.nextInt();
        System.out.print("Are you feeling any other symptoms also? [Enter yes/no]: ");
        anotherSym = scanner.next().toLowerCase();

        if (anotherSym.equals("no")) {
            if (symNo == 1) {
                System.out.println("Medicine: Cofsils Orange Lozenges Strip Of 10");
            } else if (symNo == 2) {
                System.out.println("Medicine: Aspirin");
            } else {
                System.out.println("Medicine: Acetaminophen");
            }
        } else {
            System.out.println("Describe your symptoms: (fever, runny nose, headache )");
            scanner.nextLine();
            dis = scanner.nextLine().toLowerCase();

            cnt = 0;
            if (dis.contains("fever")) {
                cnt++;
            }
            if (dis.contains("runny nose")) {
                cnt++;
            }
            if (dis.contains("headache")) {
                cnt++;
            }

            if (cnt >= thresholdVal) {
                System.out.println("\n\nYou Have Influenza (Flu). The Treatment is: Rest, hydration, over-the-counter pain relievers (such as ibuprofen or acetaminophen) to reduce fever and relieve symptoms. In some cases, antiviral medications like oseltamivir (Tamiflu) may be prescribed if started early in the course of the illness.\n\n");
            } else {
                System.out.println("\nOk. Take the tablet 'Aspirin'.\n\n");
            }
        }
    }

    public void diabetesCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have symptoms like increased thirst, fatigue, blurred vision, weight loss? [Yes/No]");
        diabetesSym = scanner.next().toLowerCase();
        if (diabetesSym.equals("no")) {
            System.out.println("No worries!!");
        } else {
            System.out.println("Describe your symptoms related to Diabetes: (increased thirst, fatigue, blurred vision, weight loss)");
            scanner.nextLine();
            dis = scanner.nextLine().toLowerCase();

            cnt = 0;
            if (dis.contains("increased thirst")) {
                cnt++;
            }

            if (dis.contains("weight loss")) {
                cnt++;
            }
            if (dis.contains("fatigue")) {
                cnt++;
            }
            if (dis.contains("blurred vision")) {
                cnt++;
            }

            if (cnt >= thresholdVal) {
                System.out.println("You Have Type 2 Diabetes. The Treatment: Lifestyle changes including diet modification and exercise, oral medications such as metformin to lower blood sugar levels, insulin injections in some cases, regular monitoring of blood sugar levels.");
            } else {
                System.out.println("Ok. Take the tablet 'Metformin'.");
            }
        }
    }

    public void hypertensionCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nDo you have symptoms like shortness of breath, nosebleeds, dizziness? [Yes/No]");
        hyperSym = scanner.next().toLowerCase();
        if (hyperSym.equals("no")) {
            System.out.println("No worries!!\n\n");
        } else {
            System.out.println("\n\n Describe your symptoms related to Hypertension: (shortness of breath, nosebleeds, dizziness) \n");
            scanner.nextLine();
            dis = scanner.nextLine().toLowerCase();

            cnt = 0;
            if (dis.contains("shortness of breath")) {
                cnt++;
            }
            if (dis.contains("nosebleeds")) {
                cnt++;
            }
            if (dis.contains("dizziness")) {
                cnt++;
            }

            if (cnt >= (thresholdVal - 1)) {
                System.out.println("\nYou Have Hypertension (High Blood Pressure). The Treatment is: Lifestyle changes including a low-sodium diet, regular exercise, weight loss if overweight, medication such as ACE inhibitors, beta-blockers, calcium channel blockers, or diuretics to lower blood pressure.\n");
            } else {
                System.out.println("\nOk. Take the tablet 'Triptans'.\n");
            }
        }
    }

    public static void main(String[] args) {
        HosMedExp h1 = new HosMedExp();
        h1.personalDetailsInput();
        h1.medInput();
        h1.diabetesCheck();
        h1.hypertensionCheck();
        System.out.println("Don't worry!! Continue taking above medicines and precautions .. you will be fine :)!! THANK YOU");
    }
}
