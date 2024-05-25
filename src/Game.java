/**
 * 20191426 김성진
 */
public class Game { // 게임을 나타내는 객체, Frame을 연결 리스트로 갖기위해 생성
    public int score(){ // 전체 점수를 반환하는 함수
        return scoreForFrame(getCurrentFrame()-1);
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }

    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itsScorer.addThrow(pins);
        /**itScore += pins; // 전체 점수 누계*/
        adjustCurrentFrame(pins);

    }

    private void adjustCurrentFrame(int pins){
        if(firstThrowInFrame == true){ // 첫번째 투구라면
            if(pins == 10) // 스트라이크
                itsCurrentFrame++; // 다음 프레임
            else
                firstThrowInFrame = false; // 스트라이크가 아니라면 다음 투구는 첫번째가 아니고 두번째 투구이다.
        }else{
            firstThrowInFrame = true; // 두번째 투구 다음은 새로운 프레임에 첫번째 투구이다.
            itsCurrentFrame++; // 다음 프레임
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame); // 최대 프레임 제한, 11: score 함수는 getCurrentFrame에서 1을 뺸다.
    }

    public int scoreForFrame(int theFrame){ // 프레임별 점수를 계산하여 반환하는 함수
        return itsScorer.scoreForFrame(theFrame);
    }

    /**private int itsScore = 0;*/
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();
}
