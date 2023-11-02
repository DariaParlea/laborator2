package org.example.repositories;

import org.example.model.Publisher;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepository {

    private List<Publisher> publishers = new ArrayList<>();

    public Publisher findById(int targetPublisherId) {
        for (Publisher publisher : publishers) {
            if (publisher.getPublisher_id() == targetPublisherId) {
                return publisher;
            }
        }
        return null;
    }

    public List<Publisher> findAll() {
        return publishers;
    }

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public void update(Publisher updatedPublisher) {
        for (Publisher publisher : publishers) {
            if (publisher.getPublisher_id() == updatedPublisher.getPublisher_id()) {
                publisher.setName(updatedPublisher.getName());
                publisher.setAddress(updatedPublisher.getAddress());
                publisher.setFiscal_code(updatedPublisher.getFiscal_code());
                break;
            }
        }
    }

    public void delete(int targetPublisherId) {
        Publisher publisherToRemove = null;
        for (Publisher publisher : publishers) {
            if (publisher.getPublisher_id() == targetPublisherId) {
                publisherToRemove = publisher;
                break;
            }
        }
        if (publisherToRemove != null) {
            publishers.remove(publisherToRemove);
        }
    }
}
