/**
 * 20191426 김성진
 */
public class Game { // 게임을 나타내는 객체, Frame을 연결 리스트로 갖기위해 생성
    public int score(){ // 전체 점수를 반환하는 함수
        return itScore;
    }

    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itsThrows[itsCurrentThrow++] = pins; // 투구별 쓰러뜨린 핀의 개수
        itScore += pins; // 전체 점수 누계
    }

    public int scoreForFrame(int frame){ // 프레임별 점수를 계산하여 반환하는 함수
        int score = 0; // 해당 프레임의 점수

        // frame: 반복횟수(알고 싶은 프레임까지의 수), ball: 현재 투구 횟수
        for(int ball = 0; frame > 0 && (ball < itsCurrentThrow); ball+=2, frame--)
            score += itsThrows[ball] + itsThrows[ball + 1]; //  해당 프레임의 점수

        return score;
    }


    private int itScore = 0; // 전체 점수
    private int[] itsThrows = new int[21]; // 경기당 최대 투구 횟수
    private int itsCurrentThrow = 0; // 현재 투구 횟수
}
