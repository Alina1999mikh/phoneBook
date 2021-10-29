package sample.exeption.storage;

import sample.Model.subscriber.Subscriber;

public class ExistStorageException extends StorageException {

    public ExistStorageException(Subscriber s) {
        super("\nSubscriber " + s + " is  exist \n");
    }
}