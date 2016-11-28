package com.fjodors.imgurmvp.data.remote;

import com.fjodors.imgurmvp.model.ImgurAlbum;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.model.ImgurImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class ImgurSerializer implements JsonDeserializer<ImgurBaseItem> {
    private final Gson gson = new GsonBuilder().create();

    @Override
    public ImgurBaseItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        boolean isAlbum = object.has("images_count") && object.get("images_count").getAsInt() > 0;
        return gson.fromJson(json, isAlbum ? ImgurAlbum.class : ImgurImage.class);
    }
}
