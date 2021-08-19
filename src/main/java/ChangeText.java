public class ChangeText {
    private String sourceText;
    private String [] sourceStrings;

    public ChangeText(String sourceText){
        if(!sourceText.isEmpty()) {
            this.sourceText = sourceText;
            sourceStrings = sourceText.split(" ");
        }

        removeC();
        removeADoubleLatter();
        removeEAtTheEndOfWord();
        removeArticle();
    }

    public String getSourceText() {
        return sourceText;
    }

    private void removeC(){
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
        System.out.println(sourceText+"\n");
    }

    private void removeADoubleLatter(){
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
        System.out.println(sourceText+"\n");
    }

    private void removeEAtTheEndOfWord(){
        String[] strings = sourceText.split(" ");
        String newString = "";
        for(String str : strings){
            if(str.length() > 1 && str.charAt(str.length()-1) == 'e'){
                    str = str.substring(0,str.length()-1);
            }
            newString += str + " ";
        }
        sourceText = newString.trim();
        System.out.println(sourceText+"\n");
    }

    private void removeArticle(){
        String[] strings = sourceText.split(" ");
        String newString = "";
        for (int i = 0;i< strings.length;i++) {
              if(sourceStrings[i].equals("an") || sourceStrings[i].equals("a") || sourceStrings[i].equals("the"))
                  continue;
              else newString +=strings[i]+" ";
        }
        sourceText = newString;
        System.out.println(sourceText);
    }
}
