
/**
 * Project Two 
 * @author Joseph Farrish
 * @version 1.0
 * A program for managing rescue Animals - Dogs, Monkeys, and miscellaneous species. 
 * This is the main driver file.
 * The program consists of the following classes Dog.java, Monkey.java, RescureAnimal.java.
 * 
 * TO DO: (Stuff to make it better.)
 * Consdense repatative code into functions.
 * Try to utilize polymorphisim and generics.
 * Implement screen clearing
 * Implement input validation --- Implemented on menu and intake methods for dog, monkey and rescure animal.
 * Find a more efficent way to filter the lists when reserving a dog,monkey or animal. 
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    /**
     * A mock program that manages rescue animals. 
     * The program provides methods for dogs, monkeys and other animals.
     */
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static ArrayList<RescueAnimal> otherAnimalList = new ArrayList<RescueAnimal>();
    private static boolean runOnce = false;
    // Instance variables (if needed)
    
    /**
     * The main method which provides a loop with a menu display. 
     * Input validation prevents the user from crashing the program 
     * when a invalid response is entered. 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        
        if((!runOnce)){
            initializeDogList();    //initialize doglist with do
            initializeMonkeyList();
            runOnce = true;
        }

        boolean run = true;     //used for menu logic
        char option = 0;        // ""  ""   ""   ""

        //Loop that displays the menu, accepts the users input
        while (run) {
            displayMenu();
            try{ 
                option = sc.next().charAt(0);
                if (option > 48 && option < 56 || option == 81 || option == 113) { // input validation
                    takeAction(sc, option);
                    // run = false; //use for testing menu logic
                } else {
                   throw new Exception("Invalid option");
                }   
            }catch(Exception excpt){
                pt(excpt.getMessage());
            }   
        }
	    // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
    }

    /**
     * Methods to ease typeing when printing to screen.
     * 
     * @param in
     */
    public static void pt(String in) {
        System.out.println(in);
    }

    /**
     * Method to ease typeing when printing formated text to screen.
     * @param format
     * @param argument
     */

    public static void pf(String format, String argument) {
        System.out.printf(format, argument);
    }

    /**
     * This method displays menu items available to the user. 
     */
    public static void displayMenu() {
        pt("\n\n");
        pt("\t\t\t\tRescue Animal System Menu");
        pt("[1] Intake a new dog");
        pt("[2] Intake a new monkey");
        pt("[3] Reserve an animal");
        pt("[4] Print a list of all dogs");
        pt("[5] Print a list of all monkeys");
        pt("[6] Print a list of all animals that are not reserved");
        pt("[7] Print a list of all animals");
        pt("[q] Quit application");
        pt("Enter a menu selection");
    }

    public static void takeAction(Scanner sc, char action){
        switch(action){
            case '1':
                intakeNewDog(sc);
                break;
            case '2':
                intakeNewMonkey(sc);
                break;
            case '3':
                reserveAnimal(sc);
                break;
            case '4':
                printDogList();
                break;
            case '5':
                printMonkeyList();
                break;
            case '6':
                printAllAnimalsNR();
                break;
            case '7':
                printAnimals();
                break;
            case 'q':
                System.exit(0);
            default:
            break;
        }
    }


  /**
   * This method creates test data for the dogList. 
   */
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in-service", true, "Canada");
        Dog dog4 = new Dog("Bea", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in-service", false, "Canada");
        Dog dog5 = new Dog("Cee", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Germany", "in-service", false, "Canada");
        Dog dog6 = new Dog("Tommy", "Lab", "male", "2", "24.6", "11-11-2011", "United States", "in-service", false,"United States");
        

        dog1.setAnimalType("Dog");
        dog2.setAnimalType("Dog");
        dog3.setAnimalType("Dog");
        dog4.setAnimalType("Dog");
        dog5.setAnimalType("Dog");
        dog6.setAnimalType("Dog");
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
        dogList.add(dog5);
        dogList.add(dog6);
    }
  
    /**
     * This method creates test data for the monkeyList.
     */
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Kong", "Capuchin", .8, 1.8, 1.2, "male", "4", "35.4", "12-10-2021", "Costa Rica", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Chewbaca", "Tamarin", .6, 1.6, .982, "female", "2", "25.8", "12-22-2021","Mauritius", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Goo", "Guenon", .8, 1.7, 1.4, "male", "3", "26.8", "1-23-2015","Uganda", "in-service", true, "United Kingdon");
        Monkey monkey4 = new Monkey("Timbah", "Guenon", .8, 1.3, 1.2, "male", "3", "26.8", "1-23-2015","Uganda", "in-service", false, "United Kingdon");
        Monkey monkey5 = new Monkey("Hibah", "Guenon", .8, 1.4, 1.23, "female", "2", "26.4", "1-23-2015","Uganda", "in-service", false, "Canada");
        Monkey monkey6 = new Monkey("Hiyak", "Guenon", .8, 1.4, 1.23, "female", "2", "26.4", "1-23-2015", "Uganda", "in-service", false, "Canada");

        monkey1.setAnimalType("Monkey");
        monkey2.setAnimalType("Monkey");
        monkey3.setAnimalType("Monkey");
        monkey4.setAnimalType("Monkey");
        monkey5.setAnimalType("Monkey");
        monkey6.setAnimalType("Monkey");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
        monkeyList.add(monkey5);
        monkeyList.add(monkey6);
    }

    /**
     * This method is called when the user wants to add a new dog to the dog list.
     * @param sc
     */
    public static void intakeNewDog(Scanner sc){
        String name, breed, sex, age, weight, acquisitionDate, acquisitionCountry, 
        trainingStatus, inServiceCountry, animalType = "Dog";
        boolean reserved;
        boolean proceed = false;
        name="";
        sc.nextLine();
        while(!proceed){
            try{
                pt("Enter Dog name: ");
                name = sc.nextLine();
                proceed = validateDog(name); // Validate by name try/catch block is in here.
            }catch(Exception excpt){
                System.out.println(excpt.getMessage());
                pt("\n\nThis dog is already in the system...\n\n");
                proceed = false;
            }
        }

       
        if(proceed){        //Dog is not in list proceed to check dog in. 
            pt("Enter Breed: ");
            breed = sc.nextLine();
            pt("Enter Dog sex: ");
            sex = sc.nextLine();
            pt("enter Dog age: ");
            age = sc.nextLine();
            pt("Enter Dog weight: ");
            weight = sc.nextLine();
            pt("Enter acquistion date: ");
            acquisitionDate = sc.nextLine();
            pt("Enter acquistion Country: ");
            acquisitionCountry = sc.nextLine();
            pt("What is the training status?: ");
            trainingStatus = sc.nextLine();
            pt("Do you want to set the Dog as reserved? (Y/N): ");
            reserved = setAsReserved(sc);
            pt("What country is the dog in service in?:");
            inServiceCountry = sc.nextLine();
            
            // Bellow is the better way to do this however going off the provided data I've
            // implemented it as is...
            // if (reserved) {
            //     pt("What country is the dog in service in?:");
            //     inServiceCountry = sc.next();
            // } else {
            //     inServiceCountry = "NA";
            // }

            // Instantiate a new dog and add it to dogList
            Dog dog = new Dog(name, breed, sex, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                    reserved, inServiceCountry);
            dog.setAnimalType(animalType);        
            dogList.add(dog);
            pt(dog.getName() + " has been added to the dog list.");
            printADogList(dogList);
        }

    }
    
    /**
     * This method is called when the user wants to add a new monkey to the monkeyList.
     * @param sc
     */
    public static void intakeNewMonkey(Scanner sc){
        String name="", species, sex, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, inServiceCountry, animalType = "Monkey";
        Double tailLength, height, bodyLengthh;         
        boolean reserved = false;
        boolean proceed = false;
        sc.nextLine();
        while(!proceed){
            try{
                pt("Enter Monkey name: ");
                name = sc.nextLine();
                proceed = validateMonkey(name); // Validate by name.
            }catch(Exception excpt){
                System.out.println(excpt.getMessage());
                pt("\n\nThis Monkey is already in the system...");
            }
        }


        if(proceed){
            pt("Enter Species of Monkey: ");
            species = sc.nextLine();
            pt("Please enter the tail length. :");
            tailLength = sc.nextDouble();
            pt("Please enter Monkey height. :");
            height = sc.nextDouble();
            pt("Please enterr Monkey bodyLength. :");
            bodyLengthh = sc.nextDouble();
            sc.nextLine();
            pt("Enter Monkey sex (male/female): ");
            sex = sc.nextLine();
            pt("Enter Monkey age: ");
            age = sc.nextLine();
            pt("Enter Monkey weight: ");
            weight = sc.nextLine();
            pt("Enter acquistion date: ");
            acquisitionDate = sc.nextLine();
            pt("Enter acquistion Country: ");
            acquisitionCountry = sc.nextLine();
            pt("What is the Monkey training status? : ");
            trainingStatus = sc.nextLine();
            pt("Do you want to set the Monkey as reserved? (Y/N): ");
            reserved = setAsReserved(sc);
            pt("What country is the Monkey in service in?:");
            inServiceCountry = sc.nextLine();
            
            // Bellow is the better way to do this however going off the provided data I've
            // implemented it as is...
            // if (reserved) {
            //     pt("What country is the Monkey in service in?:");
            //     inServiceCountry = sc.nextLine();
            // } else {
            //     inServiceCountry = "NA";
            // }

            Monkey monkey = new Monkey(name, species, tailLength, height, bodyLengthh, sex,
                    age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            monkey.setAnimalType(animalType);
            monkeyList.add(monkey);
            pt(monkey.getName() + " has been added to the Monkey list.");
        }
  
    }

   /**
    * This method would be used to intake a new animal, however it's not utilized.
    * @param sc
    */
    public static void intakeNewAnimal(Scanner sc){
        String name="", sex, age, weight, acquisitionDate, acquisitionCountry, 
        trainingStatus, inServiceCountry, animalType = "Misc";
        boolean reserved;
        boolean proceed = false;
        sc.nextLine();
        while (!proceed) {
            try {
                pt("Enter Animal name: ");
                name = sc.nextLine();
                proceed = validateAnimal(name); // Validate by name.
            } catch (Exception excpt) {
                System.out.println(excpt.getMessage());
                pt("\n\nThis Monkey is already in the system...");
            }
        }
       
        if(proceed){        //Dog is not in list proceed to check dog in. 
            pt("Enter Animal sex: ");
            sex = sc.nextLine();
            pt("enter Animal age: ");
            age = sc.nextLine();
            pt("Enter Animal weight: ");
            weight = sc.nextLine();
            pt("Enter acquistion date: ");
            acquisitionDate = sc.nextLine();
            pt("Enter acquistion Country: ");
            acquisitionCountry = sc.nextLine();
            pt("What is the training status?: ");
            trainingStatus = sc.nextLine();
            pt("Do you want to set the Animal as reserved? (Y/N): ");
            reserved = setAsReserved(sc);
            pt("What country is the Animal in service in?:");
            inServiceCountry = sc.nextLine();
            // Bellow is the better way to do this however going off the provided data I've implemented it as is...
            // if (reserved) {
            //     pt("What country is the Animal in service in?:");
            //     inServiceCountry = sc.nextLine();
            // } else {
            //     inServiceCountry = "NA";
            // }

            // Instantiate a new dog and add it to dogList
            RescueAnimal anml = new RescueAnimal(name, animalType, sex, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,reserved, inServiceCountry);
            otherAnimalList.add(anml);
            pt(anml.getName() + " has been added to the Animal list.");
        }
    }

    /**
     * Reusable function to set an animal as reserved.
     * @param sc
     * @return
     */ 
    public static boolean setAsReserved(Scanner sc){
        String res = sc.nextLine().toLowerCase();
        char r = res.charAt(0);
        boolean rtrn = false;
        // check for valid input
        while ((r != 'y') && (r != 'n')) {
            pt("INVALID INPUT - Do you want to set animal as reserved? (Y/N): ");
            res = sc.nextLine().toLowerCase();
            r = res.charAt(0);
            pt("r = " + r + "res = " + res);
        }
  
        if(r == 121)
        {
            rtrn = true;
        } else if (r == 110) {
            rtrn = false;
        }

        return rtrn;
        
    }
    
    /**
     * Used to check for duplicate entry in the dogList.
     * @param name
     * @return boolean
     * @throws Exception
     */
    public static boolean validateDog(String name) throws Exception {   

            for (Dog dog : dogList) {
                if (dog.getName().equalsIgnoreCase(name)) {
                    throw new Exception("Duplicate entry");    
                }
            }
           return true;
    }

    /**
     * Used to check for duplicate entry in the monkeyList
     * @param name
     * @return
     * @throws Exception
     */
    public static boolean validateMonkey(String name) throws Exception {

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                throw new Exception("Duplicate entry");
            }     
        }
        return true;
    }

    /**
     * Used to check for duplicate entry in the animal list.
     * @param name
     * @return
     * @throws Exception
     */
    public static boolean validateAnimal(String name) throws Exception {

        for (RescueAnimal animal : otherAnimalList) {
            if (animal.getName().equalsIgnoreCase(name)) {
                throw new Exception("Duplicate entry");
            }
        }
        return true;
    }

    /**
     * Used to reserve an animal. 
     * @param sc
     */
    public static void reserveAnimal(Scanner sc) {
        int chc = 0;
        while(chc != 1 && chc !=2){
            pt("What kind of animal Do you want to reseve? 1 - Dog, 2 - Monkey");
            chc = sc.nextInt();
        }
        
        if(chc == 1)
        {
            // printDogList();
            reserveADog(sc);

        }else if(chc == 2){
            // printMonkeyList();
            reserveAMonkey(sc);
        }else{
            pt("error");
        }


    }

    /**
     * Used to reserve a dog. The code filters through the list based on country. 
     * @param sc
     */
    public static void reserveADog(Scanner sc){
        ArrayList<Dog> unreserved = new ArrayList<Dog>();
        ArrayList<Dog> l2unreserved = new ArrayList<Dog>();

        for(Dog dg : dogList)
        {

            if(Boolean.FALSE.equals(dg.getReserved()) && dg.getTrainingStatus().equals("in-service")){
                unreserved.add(dg);
            }                
        }

        pt("We have Dogs in the following countries that are currently unreserved.");
        printADogList(unreserved);
        pt("Select a number from the available Countries. The resulting list will display other Dogs in the same country." + 
        "Valid options: 0 - " + ( unreserved.size() - 1 ));
        int chc = -1;
        boolean chk = false;
        String Country = "";

        while(!chk){
            chc = sc.nextInt();
            Country = unreserved.get(chc).getAcquisitionLocation();
            chk = chkValDogList(chc, unreserved);   
        }

        for(Dog dg: unreserved)
        {
            if((dg.getAcquisitionLocation().equals(Country))){
                l2unreserved.add(dg);
            }
        }

        chc = -1;
        chk = false;

        pt("Available Dogs in " + Country + ". Valid choice is 0 - " + (l2unreserved.size() - 1));
        printADogList(l2unreserved);
        
        while(!chk){
            chc = sc.nextInt();
            chk = chkValDogList(chc, l2unreserved);
        }
        sc.nextLine();
        pt("What is country of service?");
        String cos = sc.nextLine();


        markDogAsReserved(dogList, l2unreserved, chc, cos); 
    }
    /**
     * Method is called when the users wishes to reserve a monkey. 
     * @param sc
     */
    public static void reserveAMonkey(Scanner sc) {
        ArrayList<Monkey> unreserved = new ArrayList<Monkey>();
        ArrayList<Monkey> l2unreserved = new ArrayList<Monkey>();

        for (Monkey mk : monkeyList) {
            if (Boolean.FALSE.equals(mk.getReserved()) && mk.getTrainingStatus().equals("in-service")) {
                unreserved.add(mk);
            }
        }

        pt("We have Monkies in the following countries that are currently unreserved.");
        printAMonkeyList(unreserved);
        pt("Select a number from the available Countries. The resulting list will display other Monkies in the same country." +
        "Valid options: 0 - " + (unreserved.size() - 1));
        
        int chc = -1;
        boolean chk = false;
        String Country = "";

        while (!chk) {
            chc = sc.nextInt();
            Country = unreserved.get(chc).getAcquisitionLocation();
            chk = chkValMonkeyList(chc, unreserved);
        }

        for (Monkey mk : unreserved) {
            if ((mk.getAcquisitionLocation().equals(Country))) {
                l2unreserved.add(mk);
            }
        }

        chc = -1;
        chk = false;

        pt("Available Monkies in " + Country + ". Valid choice is 0 - " + (l2unreserved.size() - 1));
        printAMonkeyList(l2unreserved);

        while (!chk) {
            chc = sc.nextInt();
            chk = chkValMonkeyList(chc, l2unreserved);
        }

        pt("What is country of service?");
        String cos = sc.nextLine();

        markMonkeyAsReserved(monkeyList, l2unreserved, chc, cos);
    }

    /**
     * This method is used in reserveDog to filter out dogs based on country. 
     * Todo: find a more efficent way to filter the list. 
     * @param ADList
     * @return
     */
    public static ArrayList<Dog> aDogLst(ArrayList<Dog> ADList){
        ArrayList<Dog> availList = new ArrayList<Dog>();
        for(Dog dg : ADList){
            if(!dg.getReserved()){
                availList.add(dg);
            }
        }

        return availList;
    }
    /**
     * This method is used in reserveMoneky to filter out the monkey list.
     * @param ADList
     * @return
     */
    public static ArrayList<Monkey> aMnkLst(ArrayList<Monkey> ADList) {
        ArrayList<Monkey> availList = new ArrayList<Monkey>();
        for (Monkey mk : ADList) {
            if (!mk.getReserved()) {
                availList.add(mk);
            }
        }

        return availList;
    }
    
    /**
     * Method used to print out all the dogs in a list.
     * The use of System.out.printf is employed here to keep things looking nice.
     */
    public static void printDogList(){
        // based on the listType parameter
        // dog - prints the list of dogs
        int i = 0;
        pt("\n");
        pt("Start Dog List\n");
        pf("%-10s", "Anml");
        pf("%-10s", "Name ");
        pf("%-20s", "Breed ");
        pf("%-10s", "Age ");
        pf("%-10s", "Weight ");
        pf("%-10s", "Reserved ");
        pf("%-22s", "Country IS");
        pf("%-22s", "Acq Location ");
        pf("%-10s", "Acq Date " + "\n");

        // + "Acq Country" + "\t" + "Status" + "\t\t" + "Reserved:" 
        // + "\tCountry in Service:");
        String status;


        for(Dog dg: dogList){
            pf("%-10s", dg.getAnimalType());
            pf("%-10s", dg.getName());
            pf("%-20s", dg.getBreed());
            pf("%-10s", dg.getAge());
            pf("%-10s", dg.getWeight());

            if(dg.getReserved()){
                status = "True";
            }else{
                status = "False";
            }
            pf("%-10s", status);
            pf("%-22s", dg.getInServiceLocation());
            pf("%-22s", dg.getAcquisitionLocation());
            pf("%-10s", dg.getAcquisitionDate());
            pf("%n","");
            int number = 5;
  
            i++;
        }
        pt("\n\n");
        
        // pt("End of Dog List. ");
    }
    
    /**
     * Prints the monkeyList.
     */
    public static void printMonkeyList(){
        //clear the console
        // based on the listType parameter
        // dog - prints the list of dogs
        int i = 0;
        pt("\n\n");
        pt("Start Monkey List\n\n");
        pf("%-10s", "Anml");
        pf("%-10s", "Name ");
        pf("%-15s", "Speices ");
        pf("%-10s", "Age ");
        pf("%-10s", "Weight ");
        pf("%-10s", "Reserved ");
        pf("%-17s", "Country IS");
        pf("%-22s", "Acq Location");
        pf("%-10s", "Acq Date " + "\n");

        String status;

        for (Monkey mnk : monkeyList) {
            pf("%-10s", mnk.getAnimalType());
            pf("%-10s", mnk.getName());
            pf("%-15s", mnk.getSpecies());
            pf("%-10s", mnk.getAge());
            pf("%-10s", mnk.getWeight());
            if (mnk.getReserved()) {
                status = "True";
            } else {
                status = "False";
            }
            pf("%-10s", status);
            pf("%-17s", mnk.getInServiceLocation());
            pf("%-22s", mnk.getAcquisitionLocation());
            pf("%-10s", mnk.getAcquisitionDate());
            pf("%n", "");
            i++;
        }
        pt("\n\n");

        // pt("End of Dog List. ");
    }
    
    /**
     * Prints all animals Dogs, monkeys and other animals that are not reserved.
     * Prints a combined list of all animals that are
     * Fully trained ("in service") but not reserved.
     */
    public static void printAllAnimalsNR(){
        // dog - prints the list of dogs
        pt("\n");
        pt("Start Animal List\n");
        pf("%-10s", "Anml");
        pf("%-10s", "Name ");
        pf("%-10s", "Age ");
        pf("%-10s", "Weight ");
        pf("%-22s", "Country IS");
        pf("%-22s", "Acq Location ");
        pf("%-10s", "Acq Date " + "\n");
          
        String status;
        for(Dog dog : dogList) {
            if((!dog.getReserved()) && (dog.getTrainingStatus().equals("in-service"))){
                pf("%-10s", dog.getAnimalType());
                pf("%-10s", dog.getName());
                pf("%-10s", dog.getAge());
                pf("%-10s", dog.getWeight());
                pf("%-22s", dog.getInServiceLocation());
                pf("%-22s", dog.getAcquisitionLocation());
                pf("%-10s", dog.getAcquisitionDate());
                pf("%n", "");
            }
        }

        for(Monkey mnk : monkeyList){
            if((!mnk.getReserved()) && (mnk.getTrainingStatus().equals("in-service"))){
                pf("%-10s", mnk.getAnimalType());
                pf("%-10s", mnk.getName());
                pf("%-10s", mnk.getAge());
                pf("%-10s", mnk.getWeight());
                pf("%-22s", mnk.getInServiceLocation());
                pf("%-22s", mnk.getAcquisitionLocation());
                pf("%-10s", mnk.getAcquisitionDate());
                pf("%n", "");
            }
        }
        pt("\n\n");
    }   
    
    /**
     * This function populates otherAnimalList then prints all animals.
     */
    public static void printAnimals() {
            otherAnimalList.removeAll(otherAnimalList);
            pt("The method printAnimals needs to be implemented");
            // use otherAnimalList
            // add dogs to list
            for(Dog dog: dogList){
                otherAnimalList.add(dog);
            }
            // add Monkies to the list.
            for(Monkey mnk: monkeyList){
                otherAnimalList.add(mnk);
            }

            pt("\n");
            pt("Start Animal List\n");
            pf("%-10s", "Anml");
            pf("%-10s", "Name ");
            pf("%-10s", "Age ");
            pf("%-10s", "Weight ");
            pf("%-15s", "Srcv Status ");
            pf("%-10s", "Reserved ");
            pf("%-22s", "Country IS");
            pf("%-22s", "Acq Location ");
            pf("%-10s", "Acq Date " + "\n");
            String status;
            for(RescueAnimal anl: otherAnimalList){
                if (anl.getReserved()) {
                    status = "True";
                } else {
                    status = "False";
                }
                // if (!mnk.getReserved() && mnk.getTrainingStatus().equals("in service")) {
                    pf("%-10s", anl.getAnimalType());
                    pf("%-10s", anl.getName());
                    pf("%-10s", anl.getAge());
                    pf("%-10s", anl.getWeight());
                    pf("%-15s", anl.getTrainingStatus());
                    pf("%-10s", status);
                    pf("%-22s", anl.getInServiceLocation());
                    pf("%-22s", anl.getAcquisitionLocation());
                    pf("%-10s", anl.getAcquisitionDate());
                    pf("%n", "");
                 }
    }
    
    // RESERVE A DOG METHODS used in reserveADog().
    
    /**
     * Prints an ArrayList of type Dog for use in reserveADog() method.
     * @param dogLst
     */
    public static void printADogList(ArrayList<Dog> dogLst){
        pf("%-5s", "No. ");
        pf("%-10s", "Name ");
        pf("%-22s", "Breed ");
        pf("%-10s", "Age ");
        pf("%-10s", "Weight ");
        pf("%-22s", "Country IS ");
        pf("%-22s", "Acq Location ");
        pf("%-10s", "Acq Date " + "\n");
        int i = 0;


        for (Dog dg : dogLst) {
                pf("%-5s", "" + i);
                pf("%-10s", dg.getName());
                pf("%-22s", dg.getBreed());
                pf("%-10s", dg.getAge());
                pf("%-10s", dg.getWeight());
                pf("%-22s", dg.getInServiceLocation());
                pf("%-22s", dg.getAcquisitionLocation());
                pf("%-10s", dg.getAcquisitionDate() + "\n");
                i++;
        }

    }
    
    /**
     * Check if a selection is valid based on a filtered ArrayList of unreserved dogs that are in service.
     * @param chc
     * @param unreserved
     * @return
     */
    public static boolean chkValDogList(int chc, ArrayList<Dog> unreserved){
        try {
            if (chc < 0 || chc > unreserved.size()-1) throw new Exception();
            else return true;
       } catch (Exception excpt) {
            pt("Invalid Selection!");
            return false;
       }

    }

    /**
     * Marks an unreserved dog as reserved usually you would use dogList as aDogList and l2unreserved as bDogList.
     * Used in reserveADog(). 
     * @param aDogList
     * @param bDogList
     * @param chc
     * @return
     */
    public static boolean markDogAsReserved(ArrayList<Dog> aDogList, ArrayList<Dog> bDogList, int chc, String cos ){
        String s1 = "";
        String s2 = ""; 
        boolean checkVl = false;
        int i = 0;
        for (Dog dg : aDogList) {
            s1 = dg.getName();
            s2 = bDogList.get(chc).getName();
            checkVl = s1.equals(s2);
            if (checkVl) {
                dg.setReserved(true);
                dg.setInServiceCountry(cos);
                pt("Dog found reserving " + dg.getName());
                // dogList.get(i).setReserved(dg.getReserved());
                // dogList.get(i).setInServiceCountry(cos);
                return true;
            }
            i++;

        }

        return false;
    }


    // RESERVE A MONKEY METHODS used in reserveAMonkey.
    /**
     * Prints an ArrayList of type Monkey for use in reserveAMonkey() method.
     * 
     * @param mnk
     */
    public static void printAMonkeyList(ArrayList<Monkey> mnk) {
        pf("%-5s", "No. ");
        pf("%-10s", "Name ");
        pf("%-22s", "Species ");
        pf("%-10s", "Age ");
        pf("%-10s", "Weight ");
        pf("%-22s", "Country IS ");
        pf("%-22s", "Acq Location ");
        pf("%-10s", "Acq Date " + "\n");
        int i = 0;

        for (Monkey mk : mnk) {
            pf("%-5s", "" + i);
            pf("%-10s", mk.getName());
            pf("%-22s", mk.getSpecies());
            pf("%-10s", mk.getAge());
            pf("%-10s", mk.getWeight());
            pf("%-22s", mk.getInServiceLocation());
            pf("%-22s", mk.getAcquisitionLocation());
            pf("%-10s", mk.getAcquisitionDate() + "\n");
            i++;
        }

    }

    /**
     * Check if a selection is valid based on a filtered ArrayList of unreserved
     * monkies that are in service.
     * 
     * @param chc
     * @param unreserved
     * @return
     */
    public static boolean chkValMonkeyList(int chc, ArrayList<Monkey> unreserved) {
        try {
            if (chc < 0 || chc > unreserved.size() - 1)
                throw new Exception();
            else
                return true;
        } catch (Exception excpt) {
            pt("Invalid Selection!");
            return false;
        }

    }

    /**
     * Marks an unreserved Monkey as reserved usually you would use monkeyList as aMonkeyList
     * and l2unreserved as bMonkeyList.
     * Used in reserveAMonkey().
     * 
     * @param aMonkeyList
     * @param bMonkeyList
     * @param chc
     * @return
     */
    public static boolean markMonkeyAsReserved(ArrayList<Monkey> aMonkeyList, ArrayList<Monkey> bMonkeyList, int chc, String cos) {
        String s1 = "";
        String s2 = "";
        boolean checkVl = false;
        for (Monkey mk : aMonkeyList) {
            s1 = mk.getName();
            s2 = bMonkeyList.get(chc).getName();
            checkVl = s1.equals(s2);
            int i =0;
            if (checkVl) {
                mk.setReserved(true);
                pt("Monkey found reserving " + mk.getName());
                // monkeyList.get(i).setReserved(mk.getReserved());
                // monkeyList.get(i).setInServiceCountry(cos);
                return true;
            }
            i++;

        }

        return false;
    }

  

}

