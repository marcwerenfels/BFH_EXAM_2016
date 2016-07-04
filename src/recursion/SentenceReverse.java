package recursion;


public class SentenceReverse {

    private String text;

    public SentenceReverse(String text){
        this.text = text;
    }

    public void reverse(){
        if (this.text.length() <= 1){
            return;
        }
        char first = this.text.charAt(0);
        SentenceReverse rest = new SentenceReverse(this.text.substring(1));
        rest.reverse();
        this.text = rest.getText() + first;
    }

    private void reverse(int start, int end){
        if (start >= end){
            return;
        } else {
            reverse(start + 1, end - 1);
            text = text.substring(0, start)
                    + text.charAt(end)
                    + text.substring(start + 1, end)
                    + text.charAt(start)
                    + text.substring(end + 1);
        }
    }

    public String getText(){
        return this.text;
    }

    public static void main(String[] args) {
        SentenceReverse text = new SentenceReverse("Hallo");
        text.reverse();
        System.out.println(text.getText());

    }
}
