package designPatterns.observer.approach1;

class Demo {
    
    public static void main(String[] args) {
        
        Editor editor =  new Editor();
        editor.eventPublisher.subscribe("open", new LogListener("/path/to/log/file.txt"));
        editor.eventPublisher.subscribe("save", new EmailListener("nava@gmail.com"));

        try {

            editor.openFile("test.txt");
            editor.saveFile();

        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
