package io.vertx.ext.json.schema;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Future;

@VertxGen
public interface AsyncValidator extends Validator {

  /**
   * Return a Future that succeed when the validation succeed, while fail with a {@link ValidationException} when validation fails
   *
   * @param in
   * @return
   */
  Future<Void> validateAsync(Object in);

}
