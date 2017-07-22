import java.lang.reflect.Array;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for(int i=0; i<storage.length;i++){
            storage[i]=null;
        }
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume value = null;
        for(int i=0; i<size;i++){
            if(storage[i].uuid.equals(uuid)){
                value = storage[i];
                break;
            }
        }
        return value;
    }

    void delete(String uuid) {
        for(int i=0; i<size;i++){
            if(storage[i].uuid.equals(uuid)){
                storage[i] = storage[size-1];
                storage[size-1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size];
        for(int i=0; i<size;i++){
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
