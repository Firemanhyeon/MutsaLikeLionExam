package ch10.strExam;

public class StringExam2 {
    //문자열을 입력받아서 공백의 개수를 리턴하는 메소드 
    public static int spaceCount(String str) {
        int count=0;
        for(String r : str.split("")) {
            if(r.equals(" ")){
                count++;
            }
        }
        return count;
    }

    //문자열을 입력받아서 알파벳 개수를 리턴하는 메소드
    public static int alphaCount(String str) {
        int count=0;
        String st =str.toLowerCase();
        for(int i=0;i<st.length();i++){
            if((int)st.charAt(i)>=(int)'a'&&(int)st.charAt(i)<=(int)'z'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(spaceCount("test tset ts ttt")); //3
        System.out.println(alphaCount("test tset ts ttt")); //13
    }
}
