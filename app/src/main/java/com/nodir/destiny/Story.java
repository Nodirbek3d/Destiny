package com.nodir.destiny;

/**
 * Created by nodir on 3/8/2018.
 */

public class Story {
    private String story;
    private boolean isEnd;
    private String button_1_text;
    private String button_2_text;
    private Story nextStoryOnAnswer1;
    private Story nextStoryOnAnswer2;

    public Story(String story, String button_1_text, String button_2_text){
        this.story = story;
        this.button_1_text = button_1_text;
        this.button_2_text = button_2_text;
        isEnd = button_1_text == null;
    }
    public String getStory(){ return story; }
    public boolean isEnd(){ return isEnd; }

    public void setNextStoryOnAnswer1(Story nextStoryOnAnswer1) {
        this.nextStoryOnAnswer1 = nextStoryOnAnswer1;
    }

    public void setNextStoryOnAnswer2(Story nextStoryOnAnswer2) {
        this.nextStoryOnAnswer2 = nextStoryOnAnswer2;
    }

    public String getButton_1_text() {
        return button_1_text;
    }

    public String getButton_2_text() {
        return button_2_text;
    }

    public Story getStoryOn1() {
        return nextStoryOnAnswer1;
    }
    public Story getStoryOn2(){ return nextStoryOnAnswer2; }
}
