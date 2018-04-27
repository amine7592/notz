package eu.fse.notz;

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
            isShownOnTop = shownOnTop;
            return this;
        }

        public NoteBuilder setId(int id) {
            this.id = id;
            return this;
        }
    }
}
