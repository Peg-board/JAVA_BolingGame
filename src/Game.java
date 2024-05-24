/**
 * 20191426 김성진
 */
public class Game { // 게임을 나타내는 객체, Frame을 연결 리스트로 갖기위해 생성
    public int score(){ // 점수를 반환하는 함수
        return itScore;
    }

    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itScore += pins; // 점수 누계
    }

    private int itScore = 0;
}
