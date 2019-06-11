package io.vertx.ext.json.schema;

import io.vertx.codegen.annotations.VertxGen;

@VertxGen
public interface SyncValidator extends Validator {

  /**
   * Validate the provided value
   *
   * @param in
   * @throws ValidationException if the object is not valid
   * @throws NoSyncValidationException if no sync validation can be provided
   */
  void validateSync(Object in) throws ValidationException, NoSyncValidationException;

}
