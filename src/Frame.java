/**
 * 20191426 김성진
 */
public class Frame { // Throw가 아닌 Frame을 객체화 하면 behavior(행위)로 처리 가능
    public int getScore(){return itScore;} // 점수를 반환하는 함수
    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itScore += pins; // 점수 누계
    }
    private int itScore = 0;
}


