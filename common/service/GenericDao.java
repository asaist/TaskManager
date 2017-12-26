package common.service;

import common.entity.Entity;

import java.io.IOException;
import java.util.List;

public interface GenericDao <T extends Entity> {
    /** Persist the newInstance object into database */
  Integer create(T newInstance);

  /** Retrieve an object that was previously persisted to the database using
   *   the indicated id as primary key
   */
  Entity read(Integer id) throws IOException;

    /** Save changes made to a persistent object.  */
    void update(T transientObject) throws IOException;

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject) throws IOException;

    List<Entity> readAll() throws IOException;

    void checkFile ();
}
