package p08_pet_clinics;

import java.util.Arrays;
import java.util.Iterator;

public class ClinicImpl implements Clinic, Iterable<Pet> {

    private Pet[] rooms;
    private Iterator<Integer> addPetIterator;
    private Iterator<Integer> releasePetIterator;

    ClinicImpl(int size) {
        this.setRooms(size);
        this.addPetIterator = new AddPetIterator();
        this.releasePetIterator = new ReleaseIterator();
    }

    private void setRooms(int size) {
        if (size < 1 || size % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[size];
    }

    public boolean add(Pet pet) {
        while (this.addPetIterator.hasNext()) {
            int index = this.addPetIterator.next();
            if (this.rooms[index] == null){
                this.rooms[index] = pet;
                return true;
            }
        }

        return false;
    }

    public boolean releasePet() {
        while (this.releasePetIterator.hasNext()) {
            int index = this.releasePetIterator.next();
            if (this.rooms[index] != null) {
                this.rooms[index] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        return Arrays.asList(this.rooms).contains(null);
    }

    public String print(int roomNumber) {
        int index = roomNumber - 1;
        return this.rooms[index] != null ? this.rooms[index].toString() : "Room empty";
    }

    @Override
    public Iterator<Pet> iterator() {
        return new RoomsIterator();
    }

    private final class RoomsIterator implements Iterator<Pet> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[index++];
        }
    }

    private final class AddPetIterator implements Iterator<Integer> {

        private int index;
        private int counter;

        AddPetIterator() {
            this.index = rooms.length / 2;
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < rooms.length;
        }

        @Override
        public Integer next() {
            this.index = (this.counter % 2 != 0) ? this.index - this.counter : this.index + this.counter;
            this.counter++;

            return this.index;
        }
    }

    private final class ReleaseIterator implements Iterator<Integer> {

        private int counter;
        private int[] indexes;

        ReleaseIterator() {
            this.counter = 0;
            this.setIndexes();
        }

        private void setIndexes() {
            this.indexes = new int[rooms.length];

            int index = 0;
            for (int i = rooms.length / 2; i < rooms.length; i++) {
                this.indexes[index++] = i;
            }

            for (int i = 0; i < rooms.length / 2; i++) {
                this.indexes[index++] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return this.counter < this.indexes.length;
        }

        @Override
        public Integer next() {
            return this.indexes[this.counter++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pet room : this.rooms) {
            sb.append(room != null ? room : "Room empty").append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}