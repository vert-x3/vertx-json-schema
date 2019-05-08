package io.vertx.ext.json.schema;

import io.vertx.codegen.annotations.VertxGen;

public interface MutableStateValidator extends AsyncValidator, SyncValidator {

  //TODO comment
  MutableStateValidator getParent();

  //TODO comment
  void triggerUpdateIsSync();

}
