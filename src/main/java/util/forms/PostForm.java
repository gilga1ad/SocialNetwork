package util.forms;


import org.hibernate.validator.constraints.NotEmpty;

public class PostForm {

    @NotEmpty
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
