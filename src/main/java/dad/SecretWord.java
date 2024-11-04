package dad;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class SecretWord {

    private final ListProperty<Character> guessedLetters = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final StringProperty word = new SimpleStringProperty();
    private final StringProperty hiddenWord = new SimpleStringProperty();

    public SecretWord(String word) {
        this.word.set(word.toUpperCase());
        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            hidden += (word.charAt(i) == ' ') ? " " : "_";
        }
        this.hiddenWord.set(hidden);
    }

    public int guessLetter(char letter) {
        // ya se acertó esta letra
        if (guessedLetters.contains(letter)) {
            return 0;
        }
        int appeareances = 0;
        for (int i = 0; i < word.get().length(); i++) {
            if (word.get().charAt(i) == letter) {
                appeareances += 1;
            }
        }
        if (appeareances > 0) {
            guessedLetters.add(letter);
        }
        updateHiddenWord();
        return appeareances;
    }

    private void updateHiddenWord() {
        String hidden = "";
        for (int i = 0; i < word.get().length(); i++) {
            if (word.get().charAt(i) == ' ') {
                hidden += " ";
            } else if (guessedLetters.contains(word.get().charAt(i))) {
                hidden += word.get().charAt(i);
            } else {
                hidden += "_";
            }
        }
        this.hiddenWord.set(hidden);
    }

    // getters and setters

    public String getWord() {
        return word.get();
    }

    public StringProperty wordProperty() {
        return word;
    }

    public void setWord(String word) {
        this.word.set(word);
    }

    public String getHiddenWord() {
        return hiddenWord.get();
    }

    public StringProperty hiddenWordProperty() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord.set(hiddenWord);
    }
}
