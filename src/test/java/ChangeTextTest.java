import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTextTest extends ChangeText {
    private String str;

    public ChangeTextTest(){
        super();
    }

    @BeforeEach
    void setUp() {
        System.out.println("Test is starting ...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test has been finished.");
    }

    @Test
    void whetherRemoveLetterC() {
        str = "could you check several hotels in the city center?";
        String expectedResult = "kould you khek several hotels in the sity senter?";
        this.setSourceText(str);
        this.removeC();

        Assertions.assertEquals(expectedResult,this.getSourceText());
    }

    @Test
    void whetherRemoveADoubleLetter() {
        str = "everybody knows these words: eel, wood, effort, goose, meet, glass, success";
        String expectedResult = "everybody knows these words: il, wud, efort, guse, mit, glas, suces";
        this.setSourceText(str);
        this.removeADoubleLetter();

        Assertions.assertEquals(expectedResult,this.getSourceText());
    }

    @Test
    void whetherRemoveLetterEAtTheEndOfWord() {
        str = "We are funny people";
        String expectedResult = "W ar funny peopl";
        this.setSourceText(str);
        this.removeEAtTheEndOfWord();

        Assertions.assertEquals(expectedResult,this.getSourceText());
    }

    @Test
    void whetherRemoveArticle() {
        str = "the weather was fine I took an apple and a rod and went to the river";
        String expectedResult = "weather was fine I took apple and rod and went to river";
        this.setSourceText(str);
        this.setSourceStrings();
        this.removeArticle();

        Assertions.assertEquals(expectedResult,this.getSourceText());

    }

    @Test
    void whetherRemoveArticleTheAfterRemovingEAtTheEndOfWord(){
        str = "the weather was fine I took an apple and a rod and went to the river";
        String expectedResult = "weather was fin I took appl and rod and went to river";
        this.setSourceText(str);
        this.setSourceStrings();
        this.removeEAtTheEndOfWord();
        this.removeArticle();

        Assertions.assertEquals(expectedResult,this.getSourceText());
    }
}