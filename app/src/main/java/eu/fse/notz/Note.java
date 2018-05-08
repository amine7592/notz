package eu.fse.notz;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amine on 12/04/18.
 */

public class Note {

    private String title, description;
    private int id;
    private boolean isShownOnTop;


    public Note(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public static ArrayList<Note> getNotesList(JSONArray notes) {
        ArrayList<Note> list = new ArrayList<>();

        for (int i = 0; i < notes.length(); i++) {

            try {
                JSONObject jsonNote = notes.getJSONObject(i);
                list.add(new Note(jsonNote));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return list;

    }

    public Note(JSONObject jsonNote) {
        try {
            title = jsonNote.getString("title");
            description = jsonNote.getString("description");
            id = jsonNote.getInt("id");

        } catch (JSONException e) {
            Log.e("Note", e.getMessage());
        }

    }

    public Note(NoteBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.isShownOnTop = builder.isShownOnTop;
        this.id = builder.id;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShownOnTop() {
        return isShownOnTop;
    }

    public void setShownOnTop(boolean shownOnTop) {
        isShownOnTop = shownOnTop;
    }


    public static class NoteBuilder {
        private String title, description;
        private int id;
        private boolean isShownOnTop;


        public NoteBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public NoteBuilder setTitle(String title) {
            this.title = title;
            return this;

        }

        public Note build() {
            return new Note(this);
        }

        public NoteBuilder setShownOnTop(boolean shownOnTop) {
            this.isShownOnTop = shownOnTop;
            return this;
        }

        public NoteBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }
}
