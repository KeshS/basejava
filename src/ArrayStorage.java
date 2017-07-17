

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
                break;
            else if(storage[i].uuid.equals(uuid)){
                value = storage[i];
                break;
            }
        }
        return value;
    }

    void delete(String uuid) {
        for(int i=0; i<storage.length;i++){
            if(storage[i]==null)
                break;
            else if(storage[i].uuid.equals(uuid)){
                storage[i] = null;
                break;
            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int resumeNum=0;
        for(int i=0; i<storage.length;i++){
            if(storage[i] ==null){
                resumeNum=i;
                break;
            }
        }
        Resume[] newStorage = new Resume[resumeNum];
        for(int j=0; j<storage.length;j++){
            if(storage[j] ==null){
                break;
            }
            newStorage[j] = storage[j];
        }
        return newStorage;
    }

    int size() {
        return storage.length;
    }
}
