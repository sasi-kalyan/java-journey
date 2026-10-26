interface SearchEngine{
    void search();
}

interface GeminiAI{
    void generate();
}


class GoogleSearch implements SearchEngine{

    @Override
    public void search() {
        System.out.println("Google Search Engine.");
    }
}

class GoogleGeminiAI implements GeminiAI{

    @Override
    public void generate() {
        System.out.println("Google Gemini AI.");
    }
}

class YouTubeSearch implements SearchEngine{

    @Override
    public void search() {
        System.out.println("YouTube search.");
    }
}

class YouTubeGeminiAI implements GeminiAI{

    @Override
    public void generate() {
        System.out.println("YouTube Gemini AI.");
    }
}

/*
        Abstract Factory: is a creational design pattern, that is enhanced version of factory that is used to create family of related objects
        or dependent objects, the creation process is hidden to the client.
 */

class GoogleSearchGeminiFactory{
    static GoogleSearch googleSearch(){
        return new GoogleSearch();
    }

    static GoogleGeminiAI googleGeminiAI(){
        return new GoogleGeminiAI();
    }
}

class YouTubeSearchGeminiFactory{
    static YouTubeSearch youtubeSearch(){
        return new YouTubeSearch();
    }
    static YouTubeGeminiAI youtubeGeminiAI(){
        return new YouTubeGeminiAI();
    }
}

public class AbstractFactoryDP{
    public static void main(String[] args) {
        GoogleSearch search = GoogleSearchGeminiFactory.googleSearch();
        YouTubeGeminiAI geminiAI = YouTubeSearchGeminiFactory.youtubeGeminiAI();

        search.search();
        geminiAI.generate();
    }
}