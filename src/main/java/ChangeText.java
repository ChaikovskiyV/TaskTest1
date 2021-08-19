public class ChangeText {
    private String sourceText;

    public ChangeText(String sourceText){
        if(!sourceText.isEmpty())
        this.sourceText = sourceText;
        removeC();
        removeADoubleLatter();
        removeEAtTheEndOfWord();
        removeArticle();
    }

    public String getSourceText() {
        return sourceText;
    }

    void removeC(){
        StringBuilder sB = new StringBuilder(sourceText);
        while (sB.indexOf("c") >= 0){
            for (int i = 0, j = i+1; i < sB.length() && j<sB.length(); i++, j++) {
                if(sB.charAt(i) == 'c'){
                    if(sB.charAt(j) == 'e' || sB.charAt(j) == 'i')
                        sB.setCharAt(i,'s');
                    else if(sB.charAt(j) == 'k')
                        sB.deleteCharAt(i);
                    else sB.setCharAt(i,'k');
                }
            }
        }
        sourceText = sB.toString();
    }

    void removeADoubleLatter(){
        StringBuilder sB = new StringBuilder(sourceText);
        for (int i = 0, j = i+1; i < sB.length() && j < sB.length(); i++, j++) {
            if(sB.charAt(i) == sB.charAt(j)){
                if(sB.charAt(i) == 'e') {
                    sB.replace(i, j+1, "i");
                }
                else if(sB.charAt(i) == 'o')
                    sB.replace(i,j+1,"u");
                else sB.deleteCharAt(i);
            }
        }
        sourceText = sB.toString();
    }

    void removeEAtTheEndOfWord(){
        String[] strings = sourceText.split(" ");
        String newString = "";
        for(String str : strings){
            if(str.length() > 1 && str.charAt(str.length()-1) == 'e'){
                    str = str.substring(0,str.length()-1);
            }
            newString += str + " ";
        }
        sourceText = newString.trim();
    }

    void removeArticle(){
        String[] strings = sourceText.split(" ");
        String newString = "";
        for (String str : strings) {
              if(str.equals("an") || str.equals("a") || str.equals("th"))
                  continue;
              else newString +=str+" ";
        }
        sourceText = newString;
    }
}
