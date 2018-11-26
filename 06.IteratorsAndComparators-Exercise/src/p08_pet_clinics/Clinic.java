package p08_pet_clinics;

public interface Clinic extends Iterable<Pet> {

    boolean add(Pet pet);

    boolean releasePet();

    boolean hasEmptyRooms();

    String print(int roomNumber);
}