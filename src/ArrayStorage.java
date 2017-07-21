import java.lang.reflect.Array;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i=0; i<storage.length;i++){
            storage[i]=null;
        }
    }

    void save(Resume r) {
        for(int i=0; i<storage.length;i++){
            if(storage[i]==null){
                storage[i]=r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume value = null;
        for(int i=0; i<storage.length;i++){
            if(storage[i]==null)
                continue;
            else if(storage[i].uuid.equals(uuid)){
                value = storage[i];
                break;
            }
        }
        return value;
    }

    void delete(String uuid) {
        int i = 0;
        for(; i<storage.length;i++){
            if(storage[i]==null)
                break;
            if(storage[i].uuid.equals(uuid)){
                storage[i] = null;
                int deletedVar = i;
                for(;i<storage.length;i++){
                    if(storage[i]==null){
                        try {
                            storage[deletedVar] = storage[i - 1];
                        }catch (ArrayIndexOutOfBoundsException e){
                            break;
                        }
                        storage[i-1]=null;
                        break;
                    }else
                        continue;
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Integer[] numbList = new Integer[10000];
        int numberLength = 0;
        for(int i=0; i<storage.length;i++){
            if(storage[i] != null){
                numbList[numberLength]=i;
                numberLength++;
            }
        }
        Resume[] newStorage = new Resume[numberLength];
        for(int k=0; k<newStorage.length;k++){
            newStorage[k] = storage[numbList[k]];
        }
        return newStorage;
    }

    int size() {
        int countSize = 0;
        for(int i=0; i<storage.length;i++) {
            if (storage[i] != null)
                countSize++;
            else
                break;
        }
        return countSize;
    }
}
