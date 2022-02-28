public class Monkey extends RescueAnimal {

    // Instance variable
    // Species we accept - Capuchin • Guenon • Macaque • Marmoset • Squirrel monkey • Tamarin
    private String species;
    private Double tailLength;
    private Double height;
    private Double bodyLength;

    // Constructor
    public Monkey(String name, String species, Double tailLength, Double height, Double bodyLength, String gender, String age,
            String weight, String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

    // Accessor Method
    public String getSpecies() {
        return this.species;
    }

    // Mutator Method
    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getTailLength(){
        return this.tailLength;
    }
    
    public void setTailLength(Double tL)
    {
        this.tailLength = tL;
    }

    public Double getHeight(){
        return this.height;
    }

    public void setHeight(Double height){
        this.height = height;
    }

    public Double getBodyLength(){
        return this.bodyLength;
    }

    public void setBodyLength(double bodyLength){
        this.bodyLength = bodyLength;
    }










}
