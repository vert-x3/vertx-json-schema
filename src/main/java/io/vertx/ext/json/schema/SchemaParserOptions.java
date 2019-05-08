package io.vertx.ext.json.schema;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SchemaParserOptions {

  // TODO should i remove it?

  public SchemaParserOptions() {}

  public SchemaParserOptions(JsonObject obj) {
    SchemaParserOptionsConverter.fromJson(obj, this);
  }

  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    SchemaParserOptionsConverter.toJson(this, obj);
    return obj;
  }

}
