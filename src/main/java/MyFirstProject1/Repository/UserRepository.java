package MyFirstProject1.Repository;

import MyFirstProject1.entity.JournalEntry;
import MyFirstProject1.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);

}
